package values;

public enum DefaultProperties {
	stringPath("resources/config.properties"),
	usd("1.31774"),
	gbp("0.84306"),
	sek("8.7332"),
	nok("8.0157"),
	chf("1.2357");
	
	private final String name;
	
	DefaultProperties(String name){
		this.name = name;
	}
	
	public String getValue(){
		return name;
	}
	
	@Override
	public String toString(){
		return this.name();
	}
}
