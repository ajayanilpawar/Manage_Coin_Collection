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
 * Servlet implementation class FetchToUpdate
 */
@WebServlet("/FetchToUpdate")
public class FetchToUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchToUpdate() {
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
			int coinId=Integer.parseInt(request.getParameter("coinId"));
			CoinDAO coinDAO =new CoinDAO();
			Coin coinToUpdate=coinDAO.getById(coinId);
			System.out.println("========================"+coinToUpdate.getId());
			out.println("<html><head><title>Fetech to Update Coin</title></head><body>");
			out.println("<h1 style='color:green'>Updatecoin</h1>");
			
			if(coinToUpdate != null)
			{//success
				out.println("<form action='UpdateCoin' method='post'>");
				out.println("<table>");
				
				out.println("<tr>");
				out.println("<td><label>CoinId:</label></td>");
				out.println("<td><input type='hidden' name= 'id' value="+coinToUpdate.getId()+"></td>");
				out.println("</tr>");
				
				
				out.println("<tr>");
				out.println("<td><label>Country:</label></td>");
				out.println("<td><input type='text' name='country'value="+coinToUpdate.getCountry()+" required></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td><label>Denomination:</label></td>");
				out.println("<td><input type='text' name='denomination'value="+coinToUpdate.getDenomination()+" required></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td><label>Year of minting:</label></td>");
				out.println("<td><input type='number' name='year_Of_Minting'value="+coinToUpdate.getYearOfMinting()+" required></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td><label>Current value:</label></td>");
				out.println("<td><input type='text' name='curret_Value'value="+coinToUpdate.getCurrentValue()+" required></td>");				
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td><label>Acquired date:</label></td>");
				out.println("<td><input type='date' name='acquired_Date'value="+coinToUpdate.getAcquiredDate()+" required></td>");
				out.println("</tr>");				
				out.println("<tr>");
				out.println("<td><input type='submit' value='update Coin'></td>");
				out.println("<td><a href='index.html'>BACK TO HOME</a></td>");
				out.println("</tr>");
				out.println("</table>");
				out.println("</form>");

			
				
				
			}else
			{
				out.println("<h1 style='colour:red'>Error While fetching to update a coin</h1>");
				}
			}
//					
		 catch (NumberFormatException e) {
			//out.println("<html><head><title>display Coin</title></head><body>");
			out.println("<h1 style='colour:red'>Error While deleting a coin</h1>");
			//out.println("<a href='index.html'>Back To Home</a>");
		out.println("<p>Error:"+e.getMessage()+"</p>");
//			out.println("<a href='/ManageCoinCollection/DisplayAllCoins'>See Coin Collection</a>");
//
//	        out.println("</body></html>");
			e.printStackTrace();
		}
		out.println("<a href='index.html'>Back TO Home</a>");
		out.println("<a href='/ManageCoinCollection/DisplayAllCoins'>See Coin Collection</a>");
		out.println("</body></html>");
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
