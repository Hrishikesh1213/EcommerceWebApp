package com.dbmsproject.EcommerceWebApp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ATC_BN_Processer
 */
@WebServlet("/ATC_BN_Processer")
public class ATC_BN_Processer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ATC_BN_Processer() {
        
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
		
		HttpSession session= request.getSession();
		String submitType=request.getParameter("submit");
		
		if(submitType.equals("add_to_cart") ){
			
			int cID = Integer.parseInt(session.getAttribute("cID").toString());
			int pID = Integer.parseInt(request.getParameter("pID").toString());
			int sID = Integer.parseInt(request.getParameter("sID").toString());

			int price = new ProductRepo().getProductPricing(pID,sID);
			
			int quantity = Integer.parseInt(request.getParameter("quantity").toString());
			System.out.println("cID: "+cID+" pID: "+pID+" sID: "+sID+" quantity: "+quantity+" price: "+price );
			
			CartRepo cr = new CartRepo();
			cr.insertIntoCart( new Cart(pID, cID, sID, price, quantity) );
			request.getRequestDispatcher("index.jsp").forward(request, response);

		}
		else if(submitType.equals("buy_now")){
			session.setAttribute("buy_from", "BUY_NOW");
			
			int cID = Integer.parseInt(session.getAttribute("cID").toString());
			int pID = Integer.parseInt(request.getParameter("pID").toString());
			int sID = Integer.parseInt(request.getParameter("sID").toString());
			int price = new ProductRepo().getProductPricing(pID,sID);
			int quantity = Integer.parseInt(request.getParameter("quantity").toString());

			
			session.setAttribute("pID", pID);
			session.setAttribute("sID", sID);
			session.setAttribute("price", price);
			session.setAttribute("quantity", quantity);
			
			request.getRequestDispatcher("delivery_address.jsp").forward(request, response);
		}
		else if(submitType.equals("buy_now_from_cart")){
			session.setAttribute("buy_from", "BUY_FROM_CART");
			request.getRequestDispatcher("delivery_address.jsp").forward(request, response);
		}
		else if(submitType.equals("product_details")){
			request.getRequestDispatcher("product.jsp").forward(request, response);
		}
		else if(submitType.equals("delete_from_cart")){
			
			int cID = Integer.parseInt(session.getAttribute("cID").toString());
			int pID = Integer.parseInt(request.getParameter("pID").toString());
			int sID = Integer.parseInt(request.getParameter("sID").toString());
			CartRepo cr = new CartRepo();
			
			if(cr.deleteFromCart(cID, pID, sID) == 0) {
				System.out.println("Deleting failed");
			}
			else {
				System.out.println("Delete successful");
			}
			request.getRequestDispatcher("mycart.jsp").forward(request, response);
		}
		else if(submitType.equals("post_the_review")){
			
			int cID = Integer.parseInt(session.getAttribute("cID").toString());
			int pID = Integer.parseInt(request.getParameter("pID").toString());
			int sID = Integer.parseInt(request.getParameter("sID").toString());
			int rating = Integer.parseInt(request.getParameter("rating").toString());
			String review = request.getParameter("review").toString();
			
			ReviewRepo rr = new ReviewRepo();
			
			if(rr.insertIntoReview(new Review(pID, cID, sID, rating, review )) == 0) {
				System.out.println("insert review failed");
			}
			else {
				System.out.println("insert review successful");
			}
			request.getRequestDispatcher("product.jsp").forward(request, response);
		}
		
		
		
		
	}

}
