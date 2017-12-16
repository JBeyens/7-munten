package model.nationality;

import test.Utility;

// Enum of possible nationalities
public enum NationalitiesEnum 
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
	public static NationalitiesEnum getRandomNationality()
	{
		return values()[Utility.RANDOM.nextInt(values().length)];
	}
}
