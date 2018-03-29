package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Animal;
import model.Zoo;

/**
 * Servlet implementation class editGalleryServlet
 */
@WebServlet("/editZooServlet")
public class editZooServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editZooServlet() {
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
		ZooHelper dao = new ZooHelper();
		AnimalHelper anh = new AnimalHelper();
		
		String act = request.getParameter("doThisToItem");
		String radioSelection = request.getParameter("id");
		if(act == null) {
			//no button has been selected
			getServletContext().getRequestDispatcher("/viewAllZoosServlet").forward(request, response);
		}else if(act.equals("Delete Selected Zoo")){
			if(radioSelection == null) {
				System.out.println("empty");
				getServletContext().getRequestDispatcher("/viewAllZoosServlet").forward(request, response);
			}else {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Zoo itemToDelete = dao.searchForZooById(tempId);
			
			//Zoo henry = new Zoo("jflsgfd");
			
			Zoo retrievedZoo = dao.findZooByName(itemToDelete.getNameOfZoo());
			List<Animal> animalList = anh.findAnimal(retrievedZoo.getId());
			
			for(Animal a : animalList) {
				anh.deleteItem(a);
			}
			//henry.getNameOfZoo()
			dao.deleteZoo(retrievedZoo);
			
			
			
			
			//dao.deleteItemById(itemToDelete);
			getServletContext().getRequestDispatcher("/viewAllZoosServlet").forward(request, response);
			}
		}else if(act.equals("Edit Selected Zoo")) {
			if(radioSelection == null) {
				System.out.println("empty");
				getServletContext().getRequestDispatcher("/viewAllZoosServlet").forward(request, response);
			}else {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Zoo itemToEdit = dao.searchForZooById(tempId);
			request.setAttribute("itemToEdit", itemToEdit);
			getServletContext().getRequestDispatcher("/edit-zoo.jsp").forward(request, response);
			}
		}else if(act.equals("Add New Zoo")) {
			getServletContext().getRequestDispatcher("/addZoo.html").forward(request, response);
		}
	}

}
