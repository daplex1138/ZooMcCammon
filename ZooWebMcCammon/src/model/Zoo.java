package model;

import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="zoo")
public class Zoo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	// private String zooManifest;
	@Column(name="zoo_keeper")
	private String zooKeeper;
	@Column(name="name_of_zoo")
	private String nameOfZoo;
	@Column(name="open_time")
	private LocalTime openTime;
	@Column(name="close_time")
	private LocalTime closeTime;
	//private List<Animal> zooManifestList = new ArrayList<Animal>();
	
	

	public Zoo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Zoo(String nameOfZoo) {
		super();
		this.nameOfZoo = nameOfZoo;
	}

	public Zoo(String zooKeeper, String nameOfZoo, LocalTime openTime, LocalTime closeTime) {
		super();
		this.zooKeeper = zooKeeper;
		this.nameOfZoo = nameOfZoo;
		this.openTime = openTime;
		this.closeTime = closeTime;
	}
	
	public Zoo(String nameOfZoo, LocalTime openTime, LocalTime closeTime, Animal a) {
		super();
		this.nameOfZoo = nameOfZoo;
		this.openTime = openTime;
		this.closeTime = closeTime;
		//this.addToZooManifest(a);
	}
	
	public int getId() {
		return id;
	}

	public String getNameOfZoo() {
		return nameOfZoo;
	}

	public void setNameOfZoo(String nameOfZoo) {
		this.nameOfZoo = nameOfZoo;
	}

	public LocalTime getOpenTime() {
		return openTime;
	}

	public void setOpenTime(LocalTime openTime) {
		this.openTime = openTime;
	}

	public LocalTime getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(LocalTime closeTime) {
		this.closeTime = closeTime;
	}

	public String getZooKeeper() {
		return zooKeeper;
	}

	public void setZooKeeper(String zooKeeper) {
		this.zooKeeper = zooKeeper;
	}

/*	public void addToZooManifest(Animal p) {
		this.zooManifestList.add(p);
	}*/
	
	public String displayZoo() {
		return this.getNameOfZoo() + ", Open: " + this.getOpenTime() + " to " + this.getCloseTime();
	}

	/*public void displayManifest() {

		//Animal eachAnimal = (Animal) zooManifestList.get(0);
		for (Animal eachAnimal : zooManifestList) {
			if (eachAnimal instanceof Mammal) {
				Mammal mammal = (Mammal) eachAnimal;
				System.out.println("" + mammal.getName() +"\t" + mammal.getWeight() + "\t" + mammal.getLength() + "\t" + mammal.getHeight() + "\t" +  mammal.getDiet() + "\t" + mammal.isNocturnal() + "\t" + mammal.isLayEggs() + "\t" + mammal.getGender() + "\t" + mammal.getNumOfLegs() + "\t" + "mammal.isHasTail()" + "\t" + mammal.isBipedal() + "\t"+ mammal.isHasFur());
			
			} else if (eachAnimal instanceof Reptile) {
				Reptile reptile = (Reptile) eachAnimal;
				System.out.println("" + reptile.getName() +"\t" + reptile.getWeight() + "\t" + reptile.getLength() + "\t" + reptile.getHeight() + "\t" + reptile.getDiet() + "\t" + reptile.isNocturnal() + "\t" + reptile.isLayEggs() + "\t" + reptile.getGender() + "\t" + reptile.isHasLegs() + "\t" + reptile.isVenomous() + "\t" + reptile.getSkinType());
			}
		}

		//return null;
	}
*/
}
