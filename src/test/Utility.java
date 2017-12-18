package test;

import java.util.Random;

public final class Utility {
	public static final Random RANDOM = new Random();

	
	public static boolean stringCompare(String string1, String string2) 
	{
		return string1.trim().toLowerCase().equals(string2.trim().toLowerCase());
	}
}
