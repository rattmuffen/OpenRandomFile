package main;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import misc.ArgOps;
import misc.FileOps;
import misc.ListOps;


public class OpenRandomFile {

	
	public static boolean checkExtensions = true;
	public static ArrayList<String> searchDirs;
	public static int delay = 0;
	public static ArrayList<String> allowedExtensions = null;
	public static boolean openFile = true;
	public static boolean allowSubfolders = true;
	public static int numberOfFiles=1;


	public void visitAllDirsAndFiles(File dir, ArrayList<String> files) {
		if (!dir.isDirectory()) {
			if(!checkExtensions || (checkExtensions && FileOps.hasAllowedExtension(dir)))
				files.add(dir.getAbsolutePath());
		} else {
			String[] children = dir.list();
			for (int i=0; i<children.length; i++) {
				visitAllDirsAndFiles(new File(dir, children[i]),files);
			}
		}
	}


	public OpenRandomFile() throws InterruptedException, IOException {
		System.out.print("Selecting random file from: ");
		ListOps.print(searchDirs);

		if (checkExtensions && allowedExtensions != null) {
			System.out.print("Allowed extensions: ");
			ListOps.print(allowedExtensions);
		}


		if (delay>0) {
			System.out.println("Delaying " + delay +" msec...");
			Thread.sleep(delay);
		}
		
		
		ArrayList<String> files = new ArrayList<String>();
		for (String dir : searchDirs) {
			visitAllDirsAndFiles(new File(dir), files);
		}

		System.out.println("Total number of accepted files in dir(s): " + files.size());
		
		if (files.size()>0) {
			for (int i = 0; i < numberOfFiles; i++) {
				File selectedFile = new File((String) ListOps.getRandomElement(files));
				
				System.out.println("Selected file (" + (i+1) + "): " + selectedFile.getAbsolutePath());
		
				if (openFile) {
					Desktop desktop = Desktop.getDesktop();
					desktop.open(selectedFile);
				}
				
				if (i < numberOfFiles - 1 && delay > 0) {
					System.out.println("Delaying " + delay +" msec...");
					Thread.sleep(delay);
				}
			}
		}
	}


	public static void main(String[] args) {
		try {
			ArgOps.parseArguments(args);
			new OpenRandomFile();
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
