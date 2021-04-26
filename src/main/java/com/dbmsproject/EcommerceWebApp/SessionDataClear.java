package com.dbmsproject.EcommerceWebApp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionDataClear
 */
@WebServlet("/SessionDataClear")
public class SessionDataClear extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionDataClear() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("email") != null){
			session.removeAttribute("email");
			session.invalidate();
			System.out.println("jumbare jujumbare");

			response.sendRedirect("index.jsp");
		}
		else {
			System.out.println("its good but not good");
		}
		//request.setAttribute("successMessage","Logged out Successfully");
		

		//request.getRequestDispatcher("login.jsp").forward(request, response);

	}

}
