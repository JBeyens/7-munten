package test;

import java.util.HashSet;
import java.util.LinkedList;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import model.Coin;
import model.Person;
import model.nationality.NationalitiesEnum;
import model.nationality.Nationality;
import model.nationality.NationalityFactory;
import model.properties.CoinLoader;

public class TestClass {
	private static Logger logger = Logger.getLogger("Log");
	private static NationalityFactory nationalityFactory;
	private static LinkedList<Person> people;
	

	public static void main(String[] args) {
		configureLogger();
		loadNationalityFactory();
		loadPeople();
		changeNationalityForSamePerson();
	}

	private static void configureLogger() {
		// Configure log4j settings:
		DOMConfigurator.configure("log4j.xml");
		
		// Set log4j level to log
		logger.setLevel(Level.ALL);
	}
	
	private static void loadNationalityFactory() {		
		logger.info("Loading the coins...");
		HashSet<Coin> coinCollection = CoinLoader.getInstance().getCoins();
		logger.info("Loading the nationalities...");
		nationalityFactory = new NationalityFactory(coinCollection);
	}
	
	private static void loadPeople() {
		people = new LinkedList<>();
		double wealthInDefaultCoin = 100;
		logger.info("\n\nLoading the people... \nEach person will be given a wealth of " + wealthInDefaultCoin + " default coins.");
		Coin defaultCoin = CoinLoader.getInstance().getDefaultCoin();
		logger.debug("The default coin is named '" + defaultCoin.getName() + "' and has a value of '" + defaultCoin.getValuePerDefaultCoin() + "'.");
		for (int i = 1; i <= 10; i++) {
			Person person = new Person(Names.getRandomName().toString(), nationalityFactory.getRandomNationality());
			person.setAmountInGivenCoin(100, defaultCoin);
			logger.info(i + ". " + person.toString());
			people.add(person);
		}
	}

	private static void changeNationalityForSamePerson() {
		Person person = people.get(Utility.RANDOM.nextInt(people.size()));
		logger.info("\n\nChanging nationality for 1 random person:" + person.getName());
		logger.info("His current introduction: " + person.toString());
		
		for (NationalitiesEnum nationality : NationalitiesEnum.values()) {
			logger.info("Chosen nationality: " + nationality.toString());
			Nationality newNationality = nationalityFactory.getNationality(nationality);
			person.setNationality(newNationality);
			logger.info(person.toString());
		}
		
	}
}
