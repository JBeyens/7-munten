package test;

public enum Names {
	Blade,	 
	Blaze,	 
	Bodhi,	 
	Booker,
	Boomer,	 
	Bowie,	 
	Cassius,	 
	Colt,
	Cosmo,	 
	Danger,	 
	Dexter,	 
	Dmitri,
	Drake,	 
	Elvis,	 
	Felix,	 
	Fox,
	Frankie,	 
	Gunner,	 
	Guthrie,	 
	Harley,
	Hopper,	 
	Huck,	 
	Jagger,	 
	Jett,
	Journey,	 
	King,	 
	Lazarus,	 
	Leopold,
	Magnus,	 
	Maverick,	 
	Mccoy,	 
	Milo,
	Mingus,	 
	Moses,	 
	Neo,	 
	Nico,
	Otis,	 
	Otto,	 
	Oz,	 
	Rebel,
	Remington,	 
	Rory,	 
	Saint,	 
	Thelonius,
	Viggo,
	Waldo,	 
	Wilder,	 
	Wolf,
	Wylie,	 
	Zane,	 
	Zebedee,	
	Zeke,
	Zen,	 
	Zephyr,	 
	Zeppelin,	 
	Zevon,
	Ziv;
	
	/**
	 * Pick a random value of the names enum.
	 * @return a random name
	 **/
	public static Names getRandomName()
	{
		return values()[Utility.RANDOM.nextInt(values().length)];
	}
}
