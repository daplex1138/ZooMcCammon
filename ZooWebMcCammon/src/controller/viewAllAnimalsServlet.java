package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Animal;

/**
 * Servlet implementation class viewAllItemsServlet
 */
@WebServlet("/viewAllAnimalsServlet")
public class viewAllAnimalsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllAnimalsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//AnimalHelper dao =new AnimalHelper();
		//request.setAttribute("allItems", dao.showAllAnimals());
		//if(dao.showAllAnimals().isEmpty()) {
		//	request.setAttribute("allItems", "empty");
		//}
		
		List<Animal> animals = new ArrayList<Animal>();
		AnimalHelper dao = new AnimalHelper();
		animals = dao.showAllAnimals();      
        request.setAttribute("allItems", animals);
		getServletContext().getRequestDispatcher("/animal-list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
