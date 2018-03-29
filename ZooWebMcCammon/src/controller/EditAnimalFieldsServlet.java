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


/**
 * Servlet implementation class editArtworkServlet
 */
@WebServlet("/EditAnimalFieldsServlet")
public class EditAnimalFieldsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAnimalFieldsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AnimalHelper dao = new AnimalHelper();
		String radioSelection = request.getParameter("animalId");
		
		if(radioSelection == null) {
			System.out.println("empty");
			getServletContext().getRequestDispatcher("/viewAllAnimalsServlet").forward(request, response);
			
		}else {
		
		String name = request.getParameter("name");
		double weight = Double.parseDouble(request.getParameter("weight"));
		double length = Double.parseDouble(request.getParameter("length"));
		double height = Double.parseDouble(request.getParameter("height"));
		Integer tempId = Integer.parseInt(request.getParameter("animalId"));
		String diet =  request.getParameter("dietTypes");
		boolean nocturnal = Boolean.parseBoolean(request.getParameter("nocturnal"));
		boolean laysEggs = Boolean.parseBoolean(request.getParameter("laysEggs"));
		String gender = request.getParameter("gender");
		int animalType = Integer.parseInt(request.getParameter("animalType"));
		//int zoo = Integer.parseInt(request.getParameter("zoo")); 
		
		AnimalTypeHelper ath = new AnimalTypeHelper();
		AnimalType foundAnimalType = null;
		
		List<AnimalType> animalTypes = ath.getAll();
		for(AnimalType ant : animalTypes) {
			if (ant.getId() == animalType){
				foundAnimalType = ant;
			}
		}
		 
		Animal itemToUpdate = dao.searchForAnimalById(tempId);
		itemToUpdate.setName(name);
		itemToUpdate.setWeight(weight);
		itemToUpdate.setLength(length);
		itemToUpdate.setHeight(height);
		itemToUpdate.setDiet(diet);
		itemToUpdate.setIsNocturnal(nocturnal);
		itemToUpdate.setLaysEggs(laysEggs);
		itemToUpdate.setGender(gender);
		itemToUpdate.setAnimalType(foundAnimalType);
		//itemToUpdate.setZoo(zoo);
		
		dao.updateAnimal(itemToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllAnimalsServlet").forward(request, response);
		}
	}

}
