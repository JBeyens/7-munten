package model.nationality;

import java.util.Random;

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
		Random random = new Random();
		return values()[random.nextInt(values().length)];
	}
}
