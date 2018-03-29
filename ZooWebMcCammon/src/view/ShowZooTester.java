package view;

import java.util.List;

import controller.ZooHelper;
import model.Zoo;

public class ShowZooTester {
	static ZooHelper zhp = new ZooHelper();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Zoo> allItems = zhp.showAllZoos();
		//System.out.printf("%-8s%-18s%-18s%-18s%-18s%-18s\n", "id",  "title", "Artist","Media", "Year", "Value");
		//System.out.printf("%-8s%-18s%-18s%-18s%-18s%-18s\n", "-------+",  "-----------------+", "-----------------+","-----------------+", "-----------------+", "-----------------+");
		for(Zoo li: allItems) {
			System.out.println(li.displayZoo());
		}
		//System.out.println("\n");
	}

}
