import java.util.Scanner;

public class Item {
	private String gender;
	private String race;
	private String parentalLevelEducation;
	private String lunch;
	private String testPreparation;
	private String mathScore;
	private String readScore;
	private String writeScore;

	private static int totalItems;

	public Item(String gender, String race, String parentalLevelEducation, String lunch, String testPreparation,
			String mathScore, String readScore, String writeScore) {
		this.gender = gender;
		this.race = race;
		this.parentalLevelEducation = parentalLevelEducation;
		this.lunch = lunch;
		this.testPreparation = testPreparation;
		this.mathScore = mathScore;
		this.readScore = readScore;
		this.writeScore = writeScore;
	}

	public Item(Scanner scanner) {
		if (totalItems == 875) {
			System.out.println("parando");
		}
		gender = scanner.next().replaceAll("\"", "");
		race = scanner.next().replaceAll("\"", "");
		parentalLevelEducation = scanner.next().replaceAll("\"", "");
		lunch = scanner.next().replaceAll("\"", "");
		testPreparation = scanner.next().replaceAll("\"", "");
		mathScore = scanner.next().replaceAll("\"", "");
		readScore = scanner.next().replaceAll("\"", "");
		writeScore = scanner.next().replaceAll("\"", "");
		totalItems++;
	}

	public Item(String[] tokens) {
		gender = tokens[0];
		race = tokens[1];
		parentalLevelEducation = tokens[2];
		lunch = tokens[3];
		testPreparation = tokens[4];
		mathScore = tokens[5];
		readScore = tokens[6];
		writeScore = tokens[7];
		totalItems++;
	}

	public String getTestPreparation() {
		return testPreparation;
	}

	public String getGender() {
		return gender;
	}

	public String getRace() {
		return race;
	}

	public String getParentalLevelEducation() {
		return parentalLevelEducation;
	}

	public String getLunch() {
		return lunch;
	}

	public String getMathScore() {
		return mathScore;
	}

	public String getReadScore() {
		return readScore;
	}

	public String getWriteScore() {
		return writeScore;
	}

	public static int getTotalItems() {
		return totalItems;
	}
}