import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class QuickSortCSV {

	public static void main(String[] args) throws FileNotFoundException {
		// A lista de objetos do tipo Item está vazia
		List<Item> items = new ArrayList<>();

		Scanner scanner = new Scanner(new File("/home/flaviofilho/Documentos/WorkspaceJava/StudentsPerformance.csv"));
		scanner.nextLine();
		while (scanner.hasNext()) {
			// A lista preenchida com obj do tipo Item a cada leitura
			items.add(new Item(scanner.nextLine().split(",")));
		}
		scanner.close();

		// Chamada da função para escolha de execução passando "items" como argumento
		switchOption(items);
	}

	public static void switchOption(List<Item> items) {
		Map<String, List<Item>> groupedItems = groupItemsByPEducation(items);
		Map<String, List<Item>> lunchItems = groupItemsByLunchType(items);
		Map<String, List<Item>> courseItems = groupItemsByCourse(items);

		String select;
		String option;
		String option01;
		String option02;
		String option03;
		String option04;
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to run? (yes/no) \n");
		select = sc.nextLine();

		if (select.equalsIgnoreCase("yes")) {
			System.out.println("\nSelect one option: \n");
			System.out.println("a - Data of Math Score");
			System.out.println("b - Data of Read Score");
			System.out.println("c - Data of Write Score");
			System.out.println("d - Sort by group: race/ethnicity");
			System.out.println("e - Sort by educational level");
			System.out.println("f - Sort by lunch type");
			System.out.println("g - Sort by coursed: (y/n)");

			option = sc.nextLine();

			switch (option) {
				case "a":
					System.out.println("----------------------------");
					System.out.println("\n  Math Scores Ordained: \n");
					System.out.println("----------------------------");
					String math = "Math Score";
					identifyScore(math, items);
					break;
				case "b":
					System.out.println("----------------------------");
					System.out.println("\n  Read Scores Ordained: \n");
					System.out.println("----------------------------");
					String read = "Read Score";
					identifyScore(read, items);
					break;
				case "c":
					System.out.println("----------------------------");
					System.out.println("\n  Write Scores Ordained: \n");
					System.out.println("----------------------------");
					String write = "Write Score";
					identifyScore(write, items);
					break;
				case "d":
					System.out.println("----------------------------------------");
					System.out.println("\n  Sort group by: race/ethnicity: \n");
					System.out.println("----------------------------------------");
					System.out.println("a - Group A\n");
					System.out.println("b - Group B\n");
					System.out.println("c - Group C\n");
					System.out.println("d - Group D\n");
					System.out.println("e - Group E\n");
					System.out.println("----------------------------");
					System.out.println("Option: ");
					option01 = sc.nextLine();

					switch (option01) {
						case "a":
							listItemsByGroup(items, "group A");
							break;
						case "b":
							listItemsByGroup(items, "group B");
							break;
						case "c":
							listItemsByGroup(items, "group C");
							break;
						case "d":
							listItemsByGroup(items, "group D");
							break;
						case "e":
							listItemsByGroup(items, "group E");
							break;
						default:
							System.out.println("Invalid option.");
							break;
					}
					break;
				case "e":
					System.out.println("----------------------------------------");
					System.out.println("\n  Sort group by: parental education: \n");
					System.out.println("----------------------------------------");
					System.out.println("a - Associates's degree\n");
					System.out.println("b - Bachelor's degree\n");
					System.out.println("c - High school\n");
					System.out.println("d - Master's degree\n");
					System.out.println("e - Some college\n");
					System.out.println("f - Some high school\n");
					System.out.println("----------------------------");
					System.out.println("Option: ");
					option02 = sc.nextLine();
					List<Item> itemsForEducation;

					switch (option02) {
						case "a":
							itemsForEducation = groupedItems.get("associate's degree");
							printItems(itemsForEducation);
							break;
						case "b":
							itemsForEducation = groupedItems.get("bachelor's degree");
							printItems(itemsForEducation);
							break;
						case "c":
							itemsForEducation = groupedItems.get("high school");
							printItems(itemsForEducation);
							break;
						case "d":
							itemsForEducation = groupedItems.get("master's degree");
							printItems(itemsForEducation);
							break;
						case "e":
							itemsForEducation = groupedItems.get("some college");
							printItems(itemsForEducation);
							break;
						case "f":
							itemsForEducation = groupedItems.get("some high school");
							printItems(itemsForEducation);
							break;
						default:
							System.out.println("Opção inválida.");
					}
					break;
				case "f":
					System.out.println("----------------------------------------");
					System.out.println("\n  Sort group by: parental education: \n");
					System.out.println("----------------------------------------");
					System.out.println("a - Standard\n");
					System.out.println("b - Free/ Reduced\n");
					option03 = sc.nextLine();
					List<Item> itemsForLunch;

					switch (option03) {
						case "a":
							itemsForLunch = lunchItems.get("standard");
							printItems(itemsForLunch);
							break;
						case "b":
							itemsForLunch = lunchItems.get("free/reduced");
							printItems(itemsForLunch);
							break;
					}
				case "g":
					System.out.println("----------------------------------------");
					System.out.println("\n  Sort group by: parental education: \n");
					System.out.println("----------------------------------------");
					System.out.println("a - Completed\n");
					System.out.println("a - None\n");
					option04 = sc.nextLine();
					sc.close();
					List<Item> itemsForCourse;

					switch (option04) {
						case "a":
							itemsForCourse = courseItems.get("completed");
							printItems(itemsForCourse);
							break;
						case "b":
							itemsForCourse = courseItems.get("none");
							printItems(itemsForCourse);
							break;
					}
				default:
					System.out.println("Invalid option.");
			}
		} else {
			System.out.println("Execution canceled.");
		}
	}

	public static void identifyScore(String score, List<Item> items) {
		StringBuilder output = new StringBuilder();
		StringBuilder output2 = new StringBuilder();
		output.append("\n----------------------------\n");
		output.append("Higest Score and Index: \n");
		output.append("----------------------------\n");

		output2.append("\n----------------------------\n");
		output2.append("Lowest Score and Index: \n");
		output2.append("----------------------------\n");

		switch (score) {
			case "Math Score":
				int[] mathScores = new int[items.size()]; // Um array para armazenar os Math Scores
				for (int i = 0; i < items.size(); i++) {
					Item item = items.get(i);
					mathScores[i] = Integer.parseInt(item.getMathScore().replaceAll("\"", "").trim());
				}
				quickSort(mathScores, 0, mathScores.length - 1);
				printResults(mathScores);

				System.out.println(output.toString());
				binarySearchAndPrint(mathScores, mathScores[mathScores.length - 1]);

				System.out.println(output2.toString());
				binarySearchAndPrint(mathScores, mathScores[0]);
				break;
			case "Read Score":
				int[] readScores = new int[items.size()]; // Um array para armazenar os Read Scores
				for (int i = 0; i < items.size(); i++) {
					Item item = items.get(i);
					readScores[i] = Integer.parseInt(item.getReadScore().replaceAll("\"", "").trim());
				}
				quickSort(readScores, 0, readScores.length - 1);
				printResults(readScores);

				System.out.println(output.toString());
				binarySearchAndPrint(readScores, readScores[readScores.length - 1]);

				System.out.println(output2.toString());
				binarySearchAndPrint(readScores, readScores[0]);
				break;
			case "Write Score":
				int[] writeScores = new int[items.size()]; // Um array para armazenar os Write Scores
				for (int i = 0; i < items.size(); i++) {
					Item item = items.get(i);
					writeScores[i] = Integer.parseInt(item.getWriteScore().replaceAll("\"", "").trim());
				}
				quickSort(writeScores, 0, writeScores.length - 1);
				printResults(writeScores);

				System.out.println(output.toString());
				binarySearchAndPrint(writeScores, writeScores[writeScores.length - 1]);

				System.out.println(output2.toString());
				binarySearchAndPrint(writeScores, writeScores[0]);
				break;
		}
	}

	public static void quickSort(int[] array, int low, int high) {
		if (low < high) {
			int partitionIndex = partition(array, low, high);

			quickSort(array, low, partitionIndex - 1);
			quickSort(array, partitionIndex + 1, high);
		}
	}

	public static int partition(int[] array, int low, int high) {
		int pivot = array[high];
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (array[j] < pivot) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}

		int temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;

		return i + 1;
	}

	public static void printResults(int[] scores) {
		int count = 1;
		for (int score : scores) {
			System.out.println("Score " + count + ":");
			System.out.println(" ----");
			System.out.println("| " + score + " |");
			System.out.println(" ----");
			count++;
		}
	}

	public static void binarySearchAndPrint(int[] array, int item) {
		int low = 0;
		int high = array.length - 1;
		boolean found = false;

		while (low <= high) {
			int middle = (low + high) / 2;
			int kick = array[middle];

			if (kick == item) {
				found = true;
				System.out.println("Score " + item + " encontrado no índice: ");
				System.out.println(" ----");
				System.out.println("| " + middle + " |");
				System.out.println(" ----");

				int index = middle - 1;
				while (index >= 0 && array[index] == item) {
					System.out.println("Score " + item + " encontrado no índice: ");
					System.out.println(" ----");
					System.out.println("| " + index + " |");
					System.out.println(" ----");
					index--;
				}

				index = middle + 1;
				while (index < array.length && array[index] == item) {
					System.out.println("Score " + item + " encontrado no índice: ");
					System.out.println(" ----");
					System.out.println("| " + index + " |");
					System.out.println(" ----");
					index++;
				}
				break;
			} else if (kick > item) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}
	}

	public static void listItemsByGroup(List<Item> items, String grupoDesejado) {
		System.out.println("\n-----------------------------\n");
		System.out.println("Items by " + grupoDesejado + ":");
		System.out.println("\n-----------------------------");

		for (Item item : items) {
			String grupoItem = item.getRace().replaceAll("\"", "").trim();
			if (grupoItem.equalsIgnoreCase(grupoDesejado)) {
				System.out.println("Race: " + item.getRace());
				System.out.println("Gender: " + item.getGender());
				System.out.println("Parental Level of Education: " + item.getParentalLevelEducation());
				System.out.println("Lunch: " + item.getLunch());
				System.out.println("Test Preparation Course: " + item.getTestPreparation());
				System.out.println("Math Score: " + item.getMathScore());
				System.out.println("Read Score: " + item.getReadScore());
				System.out.println("Write Score: " + item.getWriteScore());
				System.out.println("-----------------------------");
			}
		}
	}

	public static Map<String, List<Item>> groupItemsByPEducation(List<Item> items) {
		Map<String, List<Item>> groupedItems = new HashMap<>();

		for (Item item : items) {
			String educationLevel = item.getParentalLevelEducation().replaceAll("\"", "").trim();
			groupedItems.putIfAbsent(educationLevel, new ArrayList<>());
			groupedItems.get(educationLevel).add(item);
		}
		return groupedItems;
	}

	public static Map<String, List<Item>> groupItemsByLunchType(List<Item> items) {
		Map<String, List<Item>> lunchItems = new HashMap<>();

		for (Item item : items) {
			String lunchType = item.getLunch().replaceAll("\"", "").trim();
			lunchItems.putIfAbsent(lunchType, new ArrayList<>());
			lunchItems.get(lunchType).add(item);
		}
		return lunchItems;
	}

	public static Map<String, List<Item>> groupItemsByCourse(List<Item> items) {
		Map<String, List<Item>> courseItems = new HashMap<>();

		for (Item item : items) {
			String courseType = item.getTestPreparation().replaceAll("\"", "").trim();
			courseItems.putIfAbsent(courseType, new ArrayList<>());
			courseItems.get(courseType).add(item);
		}
		return courseItems;
	}

	public static void printItems(List<Item> items) {
		for (Item item : items) {
			System.out.println("Parental Level of Education: " + item.getParentalLevelEducation());
			System.out.println("Gender: " + item.getGender());
			System.out.println("Lunch: " + item.getLunch());
			System.out.println("Test Preparation Course: " + item.getTestPreparation());
			System.out.println("Math Score: " + item.getMathScore());
			System.out.println("Read Score: " + item.getReadScore());
			System.out.println("Write Score: " + item.getWriteScore());
			System.out.println("-----------------------------");
		}
	}
}