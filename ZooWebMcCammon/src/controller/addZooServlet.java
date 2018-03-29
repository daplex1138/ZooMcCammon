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
 * Servlet implementation class addItemServlet
 */
@WebServlet("/addZooServlet")
public class addZooServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addZooServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String zooKeeper = request.getParameter("zooKeeper");
		String nameOfZoo = request.getParameter("nameOfZoo");
		LocalTime openTime = LocalTime.parse(request.getParameter("openTime"));
		LocalTime closeTime = LocalTime.parse(request.getParameter("closeTime"));
		//String openTime = request.getParameter("openTime");
		//String closeTime = request.getParameter("closeTime");
		//int openTime = Integer.parseInt("openTime");
		//LocalTime openTimeParsed = LocalTime.of(openTime, 00);
		
		//int closeTime = Integer.parseInt("closeTime");
		//LocalTime closeTimeParsed = LocalTime.of(closeTime, 00);
		//double value = Double.parseDouble(request.getParameter("value"));
		Zoo li = new Zoo(zooKeeper, nameOfZoo, openTime, closeTime);
		ZooHelper dao = new ZooHelper();
		dao.insertItem(li);
		
		getServletContext().getRequestDispatcher("/addZoo.html").forward(request, response);
			
	}

}
