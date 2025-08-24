package coin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coin.constatent.GenericConstants;
import coin.dao.CoinDAO;
import coin.model.Coin;

/**
 * Servlet implementation class UpdateCoin
 */
@WebServlet("/UpdateCoin")
public class UpdateCoin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCoin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//responce HTML type ka hona chahiye
				PrintWriter out=response.getWriter();

				try { 
					response.setContentType("text/html");
				//input/output stream created
				//Coin coin=new Coin();                                //request ki javaobject and javaobject ki request ke sath mapping//
				
					int id=Integer.parseInt(request.getParameter("id"));
				String country=request.getParameter("country");
				String denomination=request.getParameter("denomination");
				int yearOfMinting=Integer.parseInt(request.getParameter("yearOfMinting"));		
				BigDecimal currentValue=new BigDecimal(request.getParameter("curretValue"));
				Date acquiredDate=new Date();
				
			
				      acquiredDate=  new SimpleDateFormat(GenericConstants.requiredDateFormat)     //check exception
							.parse(request.getParameter("acquiredDate"));
			    	
				
				Coin coin=new Coin(id,country, denomination, yearOfMinting, currentValue, acquiredDate);
				CoinDAO coinDAO=new CoinDAO();
				if(coinDAO.updateCoin(coin) > 0)
				{
					out.println("<html><head><title>Updating Coin</title></head><body>");
					out.println("<h1 style='color:green'>coin Updated Successfully</h1>");
					//out.println("<p>COIN ID:"+coin.getId()+"</p>");
					out.println("<p>COIN COUNTRY:"+coin.getCountry()+"</p>");
					out.println("<p>COIN DENOMINATION:"+coin.getDenomination()+"</p>");
					out.println("<p> YEAR OF MINTING : " + coin.getYearOfMinting() + "</p>");

					out.println("<p>COIN CURRENT VALUE:"+coin.getCurrentValue()+"</p>");
					out.println("<p>COIN ACQUIRED DATE:"+coin.getAcquiredDate()+"</p>");
					out.println("<a href='index.html'>Back To Home</a>");
					out.println("<a href='/ManageCoinCollection/DisplayAllCoins'>See Coin Collection</a>");

					out.println("</body></html>");
					

					
					
				}else
				{
					out.println("<html><head><title>updating  Coin</title></head><body>");
					out.println("<h1 style='colour:red'>Coin Not  updated Successfully</h1>");
					out.println("<a href='index.html'>Back To Home</a>");
					out.println("</body></html>");
					
				}
				}
				catch(ParseException| NumberFormatException exceptionObj)
			    {
					out.println(exceptionObj);
				out.println("<html><head><title>updating Coin</title></head><body>");
				out.println("<h1 style='colour:red'>Error While updating the coin</h1>");
				out.println("<a href='index.html'>Back to Home</a>");
				out.println("<p>COIN error:"+exceptionObj.getMessage()+"</p>");
		        out.println("</body></html>");
		        out.println("-------------------");
			    }
				
			}

	

}
