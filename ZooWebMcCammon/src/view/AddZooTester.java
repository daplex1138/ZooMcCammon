package view;

import java.time.LocalTime;
import java.util.Scanner;

import controller.ZooHelper;
//import model.Mammal;
//import model.Reptile;
import model.Zoo;

public class AddZooTester {

	static String inputName;
	static String inputWeight;
	static String inputLength;
	static String inputHeight;
	static String inputDiet;
	static String inputNocturnal;
	static String inputLayEggs;
	static String inputGender;
	static String inputNumOfLegs;
	static String inputHasTail;
	static String inputBipedal;
	static String inputHasFur;
	//private static boolean isBool;
	
	static ZooHelper zooh = new ZooHelper();
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int inputAnimal = 0;
		String zooName = null;

		Scanner in = new Scanner(System.in);
		System.out.println("Name of Zoo");
		zooName = in.nextLine();
		
		//this is temp controlling getting more
		/*do {
			System.out.println("Which kind of Animal to add to Zoo?, (1) for Mammal (2) for Reptile");
			if (in.hasNextInt(1) || in.hasNextInt(2)) {
				inputAnimal = in.nextInt();
				isBool = true;
			} else {
				isBool = false;
				in.next();
			}
		} while (!(isBool));*/

		LocalTime openTime = LocalTime.of(7, 00);
		LocalTime closeTime = LocalTime.of(10, 00);
		String zooKeeper = "Patrick";
		//Zoo HenryDoorleyZoo = new Zoo(zooName, openTime, closeTime);
		
		
		Zoo toAdd = new Zoo(zooKeeper, zooName, openTime,  closeTime);
		System.out.println(toAdd.displayZoo());
		zooh.insertItem(toAdd);



		/*
		 * System.out.println("name"); inputName = in.nextLine();
		 * System.out.println("weight"); inputWeight = in.nextLine(); double
		 * inputWeightDouble = Double.parseDouble(inputWeight);
		 * System.out.println("length"); inputLength = in.nextLine(); double
		 * inputLengthDouble = Double.parseDouble(inputLength);
		 * System.out.println("height"); inputHeight = in.nextLine(); double
		 * inputHeightDouble = Double.parseDouble(inputHeight);
		 * System.out.println("diet"); inputDiet = in.nextLine();
		 * System.out.println("nocturnal"); inputNocturnal = in.nextLine(); boolean
		 * inputNocturnalBool = Boolean.parseBoolean(inputNocturnal);
		 * System.out.println("layeggs"); inputLayEggs = in.nextLine(); boolean
		 * inputLayEggsBool = Boolean.parseBoolean(inputLayEggs);
		 * System.out.println("gender"); inputGender = in.nextLine();
		 * System.out.println("number of Legs"); inputNumOfLegs = in.nextLine(); int
		 * inputNumOfLegsInt = Integer.parseInt(inputNumOfLegs);
		 * System.out.println("has tail"); inputHasTail = in.nextLine(); boolean
		 * inputHasTailBool = Boolean.parseBoolean(inputHasTail);
		 * System.out.println("is bipdeal"); inputBipedal = in.nextLine(); boolean
		 * inputBipedalBool = Boolean.parseBoolean(inputBipedal);
		 * System.out.println("has fur"); inputHasFur = in.nextLine(); boolean
		 * inputHasFurBool = Boolean.parseBoolean(inputHasFur);
		 */

		// System.out.println(inputAnimal);
		/*if (inputAnimal == 2) {

			Reptile snake = new Reptile("Harry", 1.0, 2.0, 3.0, "grass", true, true, "male", false, true, "scales");
			Reptile snake2 = new Reptile("Sam", 1.0, 2.0, 3.0, "grass", true, true, "female", false, true, "scales");
			HenryDoorleyZoo.addToZooManifest(snake);
			HenryDoorleyZoo.addToZooManifest(snake2);
			System.out.println(HenryDoorleyZoo.displayZoo());
			System.out.printf("%-8s%-8s%-8s%-8s%-8s%-8s%-8s%-8s%-8s%-8s%-8s\n", "Name", "Weight", "Length", "Height",
					"Diet", "Is Noc.", "LayEggs", "Gender", "HasLegs", "Is Ven.", "Type of Skin");

			HenryDoorleyZoo.displayManifest();
		} else {
			Mammal monkey = new Mammal("Mimo", 2.0, 3.0, 6.0, "bananas", false, false, "male", 2, true, true, true);
			Mammal monkey2 = new Mammal("Momo", 3.0, 4.0, 6.0, "bananas", false, false, "female", 2, true, true, true);
			HenryDoorleyZoo.addToZooManifest(monkey);
			HenryDoorleyZoo.addToZooManifest(monkey2);
			System.out.println(HenryDoorleyZoo.displayZoo());
			System.out.printf("%-8s%-8s%-8s%-8s%-8s%-8s%-8s%-8s%-8s%-8s%-8s%-8s\n", "Name", "Weight", "Length",
					"Height", "Diet", "Is Noc.", "LayEggs", "Gender", "# legs", "Has Tail", "Is Bip.", "Has Fur");
			HenryDoorleyZoo.displayManifest();
		}*/
		in.close();
		
		


	}

}