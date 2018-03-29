package view;

import java.util.List;

import controller.AnimalHelper;
import controller.ZooHelper;
import model.Animal;
import model.Zoo;

public class ZooDeleter {
	static AnimalHelper anh = new AnimalHelper();
	static ZooHelper zhp = new ZooHelper();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Animal an = new Animal();
		Zoo henry = new Zoo("jflsgfd");
		Zoo retrievedZoo = zhp.findZooByName(henry.getNameOfZoo());
		List<Animal> animalList = anh.findAnimal(retrievedZoo.getId());
		
		for(Animal a : animalList) {
			anh.deleteItem(a);
		}
		//henry.getNameOfZoo()
		zhp.deleteZoo(retrievedZoo);
	}

}
