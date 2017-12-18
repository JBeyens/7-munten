package model.nationality;

import test.Utility;

// Enum of possible nationalities
public enum Nationalities 
{
	AMERICAN, 
	BELGIAN, 
	ENGLISHMAN, 
	NORWEGIAN, 
	SWISS;
	
	/**
	 * Pick a random vlaue of the Nationalities enum.
	 * @return a random Nationality
	 **/
	public static Nationalities getRandomNationality()
	{
		return values()[Utility.RANDOM.nextInt(values().length)];
	}
}
