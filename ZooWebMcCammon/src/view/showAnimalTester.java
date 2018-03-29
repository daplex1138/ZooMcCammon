package view;

import java.util.List;

import controller.AnimalHelper;
import model.Animal;


public class showAnimalTester {
	
	static AnimalHelper anh = new AnimalHelper();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			List<Animal> allItems = anh.showAllAnimals();
		//List<Animal> allItems = anh.showMammals();
		
			//return super.getName() + "\t" + super.getWeight() + "\t" + super.getDiet() + "\t" + super.isNocturnal() + "\t" + super.isLayEggs() + "\t"+ super.getGender() + "\t" + numOfLegs +  "\t" + isBipedal + "\t" + hasFur;
			System.out.printf("%-8s%-8s%-8s%-16s%-8s%-8s%-8s%-8s%-8s%-8s%-8s%-8s%-8s\n","ID", "Name",  "Weight", "Diet","Noc.", "LayEggs", "Gender", "NumLegs", "Biped" , "HasFur", "HasLeg", "isVen" ,"SkinType");
			//System.out.printf("%-8s%-18s%-18s%-18s%-18s%-18s\n", "-------+",  "-----------------+", "-----------------+","-----------------+", "-----------------+", "-----------------+");
			for(Animal li: allItems) {
				//System.out.println(li.displayAnimal());
			}
			//System.out.println("\n");

		

	}

}
