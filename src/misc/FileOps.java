package misc;

import java.io.File;

import main.OpenRandomFile;

public class FileOps {

	
	
	
	public static String getExtension(File f) {
		int lastPointPos = f.getName().lastIndexOf(".");

		if (lastPointPos == -1)
			return "";

		return f.getName().substring(lastPointPos + 1,f.getName().length());
	}

	public static boolean hasAllowedExtension(File file) {
		for (String ext : OpenRandomFile.allowedExtensions) {
			if (ext.equalsIgnoreCase(getExtension(file)))
				return true;
		}
		return false;
	}
}
