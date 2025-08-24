package coin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coin.dao.CoinDAO;

/**
 * Servlet implementation class DeleteCoinServlet
 */
@WebServlet("/DeleteCoinServlet")
public class DeleteCoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
	try {
		int coinId=Integer.parseInt(request.getParameter("coinId"));
		CoinDAO coindao =new CoinDAO();
		if(coindao.deleteCoin(coinId)>0)
		{
			//response.sendRedirect("/ManageCoinCollection/DisplayAllCoins");
			out.println("<html><head><title>Deleting Coin</title></head><body>");
			out.println("<h1 style='color:green'>coin Delete Successfully</h1>");
			//out.println("<p>COIN ID:"+coin.getId()+"</p>");
			out.println("<a href='index.html'>Add Another Coin</a>");
			out.println("<a href='/ManageCoinCollection/DisplayAllCoins'>See Coin Collection</a>");
			out.println("</body></html>");
			
		}else
		{
			out.println("<html><head><title>display Coin</title></head><body>");
			out.println("<h1 style='colour:red'>Error While deleting a coin</h1>");
			out.println("<a href='index.html'>Back To Home</a>");
			out.println("<a href='/ManageCoinCollection/DisplayAllCoins'>See Coin Collection</a>");		}
	} catch (NumberFormatException e) {
		out.println("<html><head><title>display Coin</title></head><body>");
		out.println("<h1 style='colour:red'>Error While deleting a coin</h1>");
		out.println("<a href='index.html'>Back To Home</a>");
		out.println("<p>Error:"+e.getMessage()+"</p>");
		out.println("<a href='/ManageCoinCollection/DisplayAllCoins'>See Coin Collection</a>");

        out.println("</body></html>");
		e.printStackTrace();
	}
	
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

}
