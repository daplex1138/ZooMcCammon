package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AnimalType;
import model.DietType;
import model.Gender;
import model.SkinType;
import model.Zoo;

/**
 * Servlet implementation class buildAnimalDDlsServlet
 */
@WebServlet("/buildAnimalDDlsServlet")
public class buildAnimalDDlsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buildAnimalDDlsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// The sections below grab the possible values from various look-up tables so they can be used
		// to build the necessary lookup tables for creating animals.
		List<Zoo> zoos = new ArrayList<Zoo>();
		ZooHelper zooHelp = new ZooHelper();
		zoos = zooHelp.showAllZoos();      
        request.setAttribute("allZoos", zoos);	
		
		List<AnimalType> animalTypes = new ArrayList<AnimalType>();
		AnimalTypeHelper animalTypeHelper = new AnimalTypeHelper();
		animalTypes = animalTypeHelper.getAll();      
        request.setAttribute("animalTypes", animalTypes);
        
		List<DietType> dietTypes = new ArrayList<DietType>();
		DietHelper dietTypeHelper = new DietHelper();
		dietTypes = dietTypeHelper.getAll();      
        request.setAttribute("dietTypes", dietTypes);
        
		List<Gender> genders = new ArrayList<Gender>();
		GenderHelper genderHelper = new GenderHelper();
		genders = genderHelper.getAll();      
        request.setAttribute("genders", genders);
        
		List<SkinType> skinTypes = new ArrayList<SkinType>();
		SkinTypeHelper skinTypeHelper = new SkinTypeHelper();
		skinTypes = skinTypeHelper.getAll();      
        request.setAttribute("skinTypes", skinTypes);
                     
        getServletContext().getRequestDispatcher("/addAnimal.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
