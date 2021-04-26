package com.dbmsproject.EcommerceWebApp;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/OrderProcessor")
public class OrderProcesser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public OrderProcesser() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String buyfrom = session.getAttribute("buy_from").toString();				System.out.println("buyfrom: "+buyfrom);
		int cID = Integer.parseInt(session.getAttribute("cID").toString());			System.out.println("cID: "+cID);
		
		String addr_name = session.getAttribute("addr_name").toString();				System.out.println("addr_name: "+addr_name);
		String addr_phno = session.getAttribute("addr_phno").toString();				System.out.println("addr_phno: "+addr_phno);
		String addr_addr_type = session.getAttribute("addr_addr_type").toString();	System.out.println("addr_addr_type: "+addr_addr_type);
		
		/*
		String pk = request.getParameter("address");			System.out.println("pk: "+pk);
		String addr_name = pk.split("~")[1];					System.out.println("addr_name: "+addr_name);
		String addr_phno = pk.split("~")[2];					System.out.println("addr_phno: "+addr_phno);
		String addr_addr_type = pk.split("~")[3];				System.out.println("addr_addr_type: "+addr_addr_type);
		*/
		String transtype = session.getAttribute("transtype").toString();			System.out.println("transtype: "+transtype);

		
		if(buyfrom.equals("BUY_NOW")) {
						
			int pID = Integer.parseInt(session.getAttribute("pID").toString());
			int sID = Integer.parseInt(session.getAttribute("sID").toString());
			int price = Integer.parseInt(session.getAttribute("price").toString());
			int quantity = Integer.parseInt(session.getAttribute("quantity").toString());
			
			ConfirmRepo cr = new ConfirmRepo();
			AddressRepo ar = new AddressRepo();
			
			Address a = ar.getMySpecficAddress(cID, addr_name, addr_phno, addr_addr_type);
			
			cr.callBuyThis(cID, pID, sID, quantity, addr_phno, a.toString(), transtype);

			
		}
		else if(buyfrom.equals("BUY_FROM_CART")){
			
			ConfirmRepo cr = new ConfirmRepo();
			AddressRepo ar = new AddressRepo();
			
			Address a = ar.getMySpecficAddress(cID, addr_name, addr_phno, addr_addr_type);
			
			cr.callCheckout(cID, addr_phno, a.toString(), transtype);
			
		}
		
		request.getRequestDispatcher("thankyou.jsp").forward(request, response);

		
	}

}
