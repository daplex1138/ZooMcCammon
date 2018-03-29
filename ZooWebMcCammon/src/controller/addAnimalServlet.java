package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Animal;
import model.AnimalType;
import model.Zoo;

/**
 * Servlet implementation class addItemServlet
 */
@WebServlet("/addAnimalServlet")
public class addAnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addAnimalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Animal animal = new Animal();
		//AnimalHelper anh = new AnimalHelper();
		Zoo foundZoo = new Zoo();
		ZooHelper zooHelper = new ZooHelper();
		AnimalTypeHelper ath = new AnimalTypeHelper();
		
		String name = request.getParameter("name");
		double weight = Double.parseDouble(request.getParameter("weight"));
		double length = Double.parseDouble(request.getParameter("length"));
		double height = Double.parseDouble(request.getParameter("height"));
		String dietType = request.getParameter("dietTypes");
		boolean nocturnal = Boolean.parseBoolean(request.getParameter("nocturnal"));
		boolean layseggs = Boolean.parseBoolean(request.getParameter("laysEggs"));
		String gender = request.getParameter("gender");
		int zoo = Integer.parseInt(request.getParameter("zoo"));
		int animalType = Integer.parseInt(request.getParameter("animalType"));
		
		foundZoo = zooHelper.searchForZooById(zoo);
		//foundAnimalType = ath.getAll();
		AnimalType foundAnimalType = null;
		
		List<AnimalType> animalTypes = ath.getAll();
		for(AnimalType ant : animalTypes) {
			if (ant.getId() == animalType){
				foundAnimalType = ant;
			}
		}
		
		//AnimalType found = foundAnimalType;
		
		
		Animal li = new Animal(name, foundAnimalType, gender, weight, length, height, dietType, nocturnal, layseggs, foundZoo);
		AnimalHelper anh = new AnimalHelper();
		anh.insertItem(li);
		
		getServletContext().getRequestDispatcher("/buildAnimalDDlsServlet.html").forward(request, response);
			
	}

}
