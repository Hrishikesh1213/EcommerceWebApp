package com.dbmsproject.EcommerceWebApp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DA_Processer
 */
@WebServlet("/DA_Processer")
public class DA_Processer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DA_Processer() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session= request.getSession();
		int cID = Integer.parseInt(session.getAttribute("cID").toString());
		String submitType=request.getParameter("submit");
		
		if(submitType.equals("select_address") ){
			
			String pk = request.getParameter("address");
			String add_name = pk.split("~")[1];
			String add_phno = pk.split("~")[2];
			String add_addr_type = pk.split("~")[3];
			
			session.setAttribute("addr_name", add_name);
			session.setAttribute("addr_phno", add_phno);
			session.setAttribute("addr_addr_type", add_addr_type);
			System.out.println(pk);
			System.out.println(session.getAttribute("addr_name"));

			request.getRequestDispatcher("payment_options.jsp").forward(request, response);

		}
		else if(submitType.equals("add_address")){
			
			AddressRepo ar = new AddressRepo();
			
			String name = request.getParameter("name").toString();
			String phno = request.getParameter("phno").toString();
			String pin = request.getParameter("pin").toString();
			String hno = request.getParameter("hno").toString();
			String colony = request.getParameter("colony").toString();
			String landmark = request.getParameter("landmark").toString();
			String city = request.getParameter("city").toString();
			String state = request.getParameter("state").toString();
			String country = request.getParameter("country").toString();
			String addr_type = request.getParameter("addr_type").toString();
			
			Address a = new Address(cID, name, phno, pin, hno, colony, landmark, city, state, country, addr_type);
			
			int status = ar.insertIntoAddress(a);
			if(status > 0) {
				System.out.println("Address added successfully");
			}
			else {
				System.out.println("Address addition Failed");
			}
			

			request.getRequestDispatcher("delivery_address.jsp").forward(request, response);
		}
		else if(submitType.equals("select_card")){
			
			String cardID = request.getParameter("cardid");

			session.setAttribute("cardID", cardID);
			System.out.println(cardID);

			request.getRequestDispatcher("order_confirmation.jsp").forward(request, response);
			
		}
		else if(submitType.equals("add_card")){
			
			CardRepo cr = new CardRepo();
			
			String cardNo = request.getParameter("cardno").toString();
			String pin = request.getParameter("pin").toString();
			int status = cr.insertIntoCard(new Cards(0,cID, cardNo, pin));
			
			if(status > 0) {
				System.out.println("Card added successfully");
			}
			else {
				System.out.println("Card addition failed");
			}
			request.getRequestDispatcher("payment_options.jsp").forward(request, response);

		}
		else if(submitType.equals("select_payment_type")){
						
			String paymenttype = request.getParameter("paymenttype").toString();
			session.setAttribute("transtype", paymenttype);

			request.getRequestDispatcher("order_confirmation.jsp").forward(request, response);

		}
		else if(submitType.equals("add_new_payment_type")){
		
			PaymentsTypeRepo ptr = new PaymentsTypeRepo();
			
			String paymenttype = request.getParameter("paymenttype").toString();
			int status = ptr.insertNewPaymentType(new PaymentsType(cID, paymenttype));
			
			if(status > 0) {
				System.out.println("Card added successfully");
			}
			else {
				System.out.println("Card addition failed");
			}
			request.getRequestDispatcher("payment_options.jsp").forward(request, response);
		
		}

		
	}

}
