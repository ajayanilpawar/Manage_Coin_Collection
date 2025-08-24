package coin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coin.dao.CoinDAO;
import coin.model.Coin;

/**
 * Servlet implementation class DisplayAllCoins
 */
@WebServlet("/DisplayAllCoins")
public class DisplayAllCoins extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllCoins() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		try {
			//Retrive all coins from database
			CoinDAO coindao=new CoinDAO();
			List<Coin> allCoins=coindao.getAllCoins();
			
			//HTML responce
			out.println("<html><head><title>Display Coins</title></head><body>");
			out.println("<h1>coin Added Successfully</h1>");
			out.println(" <table border='2'>");			
			out.println("<thead><tr><th>COIN ID</th><th>COUNTRY</th><th>DENOMINATION</th><th>YEAR OF MINTING</th><th>CURRENT VALUE</th>"
					+ "<th>ACQUIRED DATE</th><th>UPDATE</th><th>REMOVE</th></tr></thead> ");
			
			for (Coin coin : allCoins) {
				
			
			out.println("<tr>");
			out.println(" <td>"+coin.getId()+"</td>");
			out.println(" <td>"+coin.getCountry()+"</td>");
			out.println(" <td>"+coin.getDenomination()+"</td>");
			out.println("<td>"+coin.getYearOfMinting()+"</td> ");
			out.println("<td>"+coin.getCurrentValue()+"</td> ");
			out.println("<td>"+coin.getAcquiredDate()+"</td> ");
			out.println("<td><a href='FetchToUpdate?coinId="+coin.getId()+"'>EDIT</a></td>");
			out.println("<td><a href='DeleteCoinServlet?coinId="+coin.getId()+"'>DELETE</a></td>");
				
			out.println("</tr>");
			}
			
			out.println("</table> ");
			out.println("<br><br>");

			out.println("<a href='index.html'>Back To Home</a>");
			out.println("</body></html>");

			
			
			
			
		}catch (Exception e) {
			out.println("<html><head><title>Adding Coin</title></head><body>");
			out.println("<h1 style='colour:red'>Error While Adding coin</h1>");
			out.println("<a href='index.html'>Back To Home</a>");
			out.println("<p>Error:"+e.getMessage()+"</p>");
	        out.println("</body></html>");
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
