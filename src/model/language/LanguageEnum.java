package model.language;

public enum LanguageEnum {
	DUTCH("Hallo, mijn naam is ", " en mijn vermogen is "),
	ENGLISH("Hi, my name is ", " and my wealth is "),
	FRENCH("Bonjour, je m'appelle ", " et ma puissance est "),
	GERMAN("Hi, mein Name ist ", " und mein Vermögen ist "),
	NORWEGIAN("Hei, jeg heter ", " og rikdom er "),
	UNKNOWN("Pika, Pika pikapi ", " pika pikachu ");

	private final String myNameIs;
	private final String andMyWealthIs;
	
	private LanguageEnum(String myNameIs, String andMyWealthIs) {
		this.myNameIs = myNameIs;
		this.andMyWealthIs = andMyWealthIs;
	}

	public String toString(String name, String wealth){
		return myNameIs + name + andMyWealthIs + wealth;
	}
}