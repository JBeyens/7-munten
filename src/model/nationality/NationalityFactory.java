package model.nationality;

public class NationalityFactory {
	public static Nationality getNationality(String nationality) {

		Nationality n = null;

		switch (nationality) {
		case "België":
			n = new Belg();
			break;

		case "Duitsland":
			n = new Duitsland();
			break;

		case "Frankrijk":
			n = new Frankrijk();
			break;
		}

		return n;
	}

}
