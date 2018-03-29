package view;

import java.util.List;

import controller.AnimalHelper;
import model.Animal;

public class UpdateAnimalTester {
	static AnimalHelper anh = new AnimalHelper();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		updateAnimal();

	}

	private static void updateAnimal() {
		// TODO Auto-generated method stub

		List<Animal> foundItems;

		foundItems = anh.findAnimal(11);

		for (Animal a : foundItems) {
			System.out.println("ID: " + a.getId());
		}

		Animal toEdit = anh.searchForAnimalById(28);

		toEdit.setGender("female");
		anh.updateAnimal(toEdit);

	}

}
