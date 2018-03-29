package view;

import model.Animal;
import model.Mammal;
import model.Reptile;
import model.Zoo;

import java.time.LocalTime;

import controller.AnimalHelper;
import controller.ZooHelper;

public class AddAnimalTester2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Animal animal = null;
		AnimalHelper animalHelper = new AnimalHelper();
		ZooHelper zooHelper = new ZooHelper();
			
		Zoo zoo1 = new Zoo("Bob", "Blank", LocalTime.of(10, 10), LocalTime.of(20, 10));
		zooHelper.insertItem(zoo1);
		
		//Animal animal = new Mammal("cat", 1, 1, 10.5, 36, 2, true, 1, false, 4, true, true, 1);
		//Animal animal = new Mammal("cat", 1, 1, 10, "omnivore", true, "male", false, 4, true, true, /*"mammal",*/ zoo1);
		//animal3 = new Mammal(name, weight, length, height, diet_id, nocturnal, gender_id, lay_eggs, numOfLegs, isBipedal, hasFur, zoo_id)
		//animal2 = new Mammal(name, weight, length, height, diet_id, nocturnal, gender_id, lay_eggs, numOfLegs, isBipedal, hasFur, zoo_id)
		//animalHelper.insertItem(animal);
		//Animal animal2 = new Reptile("snake", 2, 1, 10.5, "omnivore", true, true, "female", false, false, "scales", /*"reptile",*/ zoo1);
		//animalHelper.insertItem(animal2);
		//animal.setDiet(3);
		//animalHelper.update(animal);
	}
}
