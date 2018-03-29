package controller;

import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Zoo;


/**
 * Servlet implementation class editArtworkServlet
 */
@WebServlet("/EditZooFieldsServlet")
public class EditZooFieldsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditZooFieldsServlet() {
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
		String radioSelection = request.getParameter("id");
		
		if(radioSelection == null) {
			System.out.println("empty");
			getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
			
		}else {
		
		String zooKeeper = request.getParameter("zooKeeper");
		String zooName = request.getParameter("nameOfZoo");
		LocalTime openTime = LocalTime.parse(request.getParameter("openTime"));
		LocalTime closeTime = LocalTime.parse(request.getParameter("closeTime"));
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Zoo itemToUpdate = dao.searchForZooById(tempId);
		itemToUpdate.setZooKeeper(zooKeeper);
		itemToUpdate.setNameOfZoo(zooName);
		itemToUpdate.setOpenTime(openTime);
		itemToUpdate.setCloseTime(closeTime);
		
		dao.updateZoo(itemToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllZoosServlet").forward(request, response);
		}
	}

}
