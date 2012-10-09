package misc;

import java.util.ArrayList;
import java.util.Random;

public class ListOps {
	
	
	public static void print(ArrayList list) {
		for (Object o : list) {
			if (list.indexOf(o)==list.size()-1)
				System.out.print(o);
			else
				System.out.print(o + ", ");
		}
		System.out.println("");
	}
	
	public static Object getRandomElement(ArrayList list) {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(list.size());

		return list.get(randomInt);
	}

}
