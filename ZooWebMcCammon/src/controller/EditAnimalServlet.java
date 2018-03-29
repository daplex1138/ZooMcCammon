package controller;

import java.io.IOException;
//import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Animal;

/**
 * Servlet implementation class editGalleryServlet
 */
@WebServlet("/EditAnimalServlet")
public class EditAnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAnimalServlet() {
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
		AnimalHelper anh = new AnimalHelper();
		Animal animal = new Animal();
		
		String act = request.getParameter("doThisToItem");
		String radioSelection = request.getParameter("animalId");
		if(act == null) {
			//no button has been selected
			getServletContext().getRequestDispatcher("/viewAllAnimalsServlet").forward(request, response);
		}else if(act.equals("Delete Selected Animal")){
			if(radioSelection == null) {
				System.out.println("empty");
				getServletContext().getRequestDispatcher("/viewAllAnimalsServlet").forward(request, response);
			}else {
			Integer tempId = Integer.parseInt(request.getParameter("animalId"));
						
			animal = anh.searchForAnimalById(tempId);
			anh.deleteById(animal);
			
			//dao.deleteItemById(itemToDelete);
			getServletContext().getRequestDispatcher("/viewAllAnimalsServlet").forward(request, response);
			}
		}else if(act.equals("Edit Selected Animal")) {
			if(radioSelection == null) {
				System.out.println("empty");
				getServletContext().getRequestDispatcher("/viewAllAnimalsServlet").forward(request, response);
			}else {
			Integer tempId = Integer.parseInt(request.getParameter("animalId"));
			Animal itemToEdit = anh.searchForAnimalById(tempId);
			request.setAttribute("itemToEdit", itemToEdit);
			getServletContext().getRequestDispatcher("/buildAnimalDDlsServletFields").forward(request, response);
			}
		}else if(act.equals("Add New Animal")) {
			getServletContext().getRequestDispatcher("/buildAnimalDDlsServlet").forward(request, response);
		}
	}

}
