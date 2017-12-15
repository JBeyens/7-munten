package model.nationality;

public class NationalityFactory {
	public static Nationality getNationality(String nationality) {

		Nationality n = null;

		switch (nationality) {
		case "Belgium":
			n = new Belgian();
			break;

		case "Germany":
			n = new German();
			break;

		case "France":
			n = new Frenchman();
			break;
		}

		return n;
	}

}
