package com.dbmsproject.EcommerceWebApp;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class SellerProcesser
 */
@WebServlet("/SellerProcesser")
@MultipartConfig
public class SellerProcesser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerProcesser() {
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
		
		HttpSession session = request.getSession();
		
		int sID = Integer.parseInt(session.getAttribute("sID").toString());

		String category = request.getParameter("category");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		
		Part potoPart = request.getPart("image");
		InputStream is = potoPart.getInputStream();
		
		//String image = request.getParameter("image");
		
		int price = Integer.parseInt(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		
		int status = new SellerRepo().insertIntoProduct ( category,  name,  description,  is,  sID,  price,  quantity);
		
		request.getRequestDispatcher("sellerdashboard.jsp").forward(request, response);

	}

}
