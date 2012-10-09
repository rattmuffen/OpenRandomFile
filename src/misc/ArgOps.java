package misc;

import java.util.ArrayList;
import java.util.StringTokenizer;

import main.OpenRandomFile;

public class ArgOps {

	
	public static String[] validArguments = {};
	
	public static String[] allowedTrueArg = {"Yes","Y","True","T","1"};
	public static String[] allowedFalseArg = {"No","N","False","F","0"};
	
	
	public static ArrayList<String> createList(String val) {
		return createList(val,false);
	}
	
	
	public static ArrayList<String> createList(String val, boolean useFolderDelimeter) {
		String delimeter = ",";
		if (useFolderDelimeter)
			delimeter ="|";
		
		
		ArrayList<String> list = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(val, delimeter);
		
		while(st.hasMoreElements()) 
			list.add(st.nextToken().trim());
		
		return list;
	}
	
	
	public static boolean allowOption(String val) throws IllegalArgumentException{
		for (int i = 0; i < allowedTrueArg.length; i++) {
			if (val.equalsIgnoreCase(allowedTrueArg[i]))
				return true;
			else if (val.equalsIgnoreCase(allowedFalseArg[i]))
				return false;
		}
		
		throw new IllegalArgumentException("Illegal true/false argument.");
	}
	
	
	public static void parseArguments(String[] args) throws IllegalArgumentException {
		OpenRandomFile.searchDirs = new ArrayList<String>();
		OpenRandomFile.searchDirs.add(System.getProperty("user.dir"));
		
		for (int i = 0; i < args.length; i++) {

			if (args[i].contains("=") && args[i].split("=").length == 2) {
				
				String arg = args[i].split("=")[0].substring(1);
				String val = args[i].split("=")[1];


				if (arg.equalsIgnoreCase("dir")) {
					OpenRandomFile.searchDirs = ArgOps.createList(val,true);
				} else if (arg.equalsIgnoreCase("delay"))
					OpenRandomFile.delay = Integer.parseInt(val);
				else if (arg.equalsIgnoreCase("ext")) 
					OpenRandomFile.allowedExtensions = ArgOps.createList(val);
				else if (arg.equalsIgnoreCase("open"))
					OpenRandomFile.openFile = ArgOps.allowOption(val);
				else if (arg.equalsIgnoreCase("subfolder"))
					OpenRandomFile.allowSubfolders = ArgOps.allowOption(val);	
				else if (arg.equalsIgnoreCase("numberOfFiles"))
					OpenRandomFile.numberOfFiles = Integer.parseInt(val);	



				else 
					throw new IllegalArgumentException(arg + " is not a valid argument.");

			} else {
				throw new IllegalArgumentException("The argument '" + args[i] + "' has not been given a value.");
			}
		}
	}

}
