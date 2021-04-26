package com.dbmsproject.EcommerceWebApp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginRegister")
public class LoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginRegister() {
        
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			ClientDAO cd=new ClientDAOImpl();
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			String submitType=request.getParameter("submit");
			Client c=cd.getClient(email, password);
			//System.out.println(email+"*******"+password);
			
			String emailid1=c.getcEmail();
			//System.out.println("*********"+emailid1);
			
			if(submitType.equals("login") && c.getcEmail()!=null && c.getcPassword()!=null){
				
				HttpSession session= request.getSession();
				session.setAttribute("cID", c.getcID());
				System.out.println("loginregister got cID = "+c.getcID());
				session.setAttribute("email", emailid1);
				System.out.println("loginregister got email = "+emailid1);
				session.setAttribute("name", c.getcFirst_name());
				session.setAttribute("password", c.getcPassword());
				
				//response.sendRedirect("appointment.jsp");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else if(submitType.equals("register")){
				
				String pwd1 = (String)request.getParameter("password");
				String pwd2 = (String)request.getParameter("password1");
				
				if(pwd1.equals(pwd2)) {
					
					c.setcID(0);
					c.setcEmail((String)request.getParameter("email"));
					c.setcFirst_name(request.getParameter("fname"));
					c.setcLast_name(request.getParameter("lname"));
					c.setcPassword(request.getParameter("password"));
					
					
					cd.insertClient(c);
					
					request.setAttribute("successMessage","Registration done,please login to continue..");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				else {
					request.setAttribute("Message","passwords are not matching");
					request.getRequestDispatcher("register.jsp").forward(request, response);
				}
			}
			else{
				request.setAttribute("Message", "Data not found,Create your Account!!!");
				request.getRequestDispatcher("login.jsp").forward(request,response);
			}
			}
			catch(Exception e){
				System.out.print(e);
			}
		
	}

}
