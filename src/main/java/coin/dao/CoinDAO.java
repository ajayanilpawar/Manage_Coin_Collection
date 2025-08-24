package coin.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import coin.model.Coin;
import coin.utiles.ConnectionUtils;

public class CoinDAO {
	
	public static void main(String[] args) {
	
		System.out.println(new CoinDAO().addCoin(new Coin("india","INR\u20b9",1879,new BigDecimal(10000),new java.util.Date())));
		System.out.println(new CoinDAO().getAllCoins());
		 
	}
	
	//get All coins
	public List<Coin>getAllCoins()
	{
		List<Coin> coins=new ArrayList<Coin>();//java-8 type inference
		
		try (Connection connection =ConnectionUtils.getConnection()){
			
			String selectQuery="select * from coin_collection";
			PreparedStatement statement= connection.prepareStatement(selectQuery);
			ResultSet resultSet=statement.executeQuery(selectQuery);
			
			while (resultSet.next())
			{
				//Coin coin=new coin();
				//coin.setid(resultSet.getint("id"));
				//------------------------------------------Second option-----------------------------------
				Coin coin=new Coin(resultSet.getInt("id"),//resultSet.getInt(0) 0 is the index and id is the name;
						resultSet.getString("country"),
						resultSet.getString("denomination"),
						resultSet.getInt("year_0f_minting"),
						resultSet.getBigDecimal("current_value"),
						resultSet.getDate("acquired_date"));
				coins.add(coin);
			}
		} catch (SQLException e) {
               e.printStackTrace();//Handle properly in real time
		}
		return coins;
	}
	
	
	//get by id
		public Coin getById(int coinId)
		{
			Coin coin=new Coin();
			String selectQuery="select * from coin_collection where id=?";

			try (Connection connection =ConnectionUtils.getConnection();

				PreparedStatement statement= connection.prepareStatement(selectQuery)){
				statement.setInt(1, coinId);
				
				ResultSet resultSet=statement.executeQuery();
				while (resultSet.next())
				{
					coin.setId(resultSet.getInt("id"));
					coin.setCountry(resultSet.getString("country"));
					coin.setDenomination(resultSet.getString("denomination"));
					coin.setYearOfMinting(resultSet.getInt("year_0f_minting"));
					coin.setCurrentValue(resultSet.getBigDecimal("current_value"));
					coin.setAcquiredDate(resultSet.getDate("acquired_date"));
			
				}
			} catch (SQLException e) {
	               e.printStackTrace();//Handle properly in real time
	               coin=null;
			}
			return coin;
		}
//add Coin in the database
	public int addCoin(Coin coin)
	{ // boolean successFlag=false;
		try (Connection connection =ConnectionUtils.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement("insert into coin_collection(country,"
					+ "denomination,year_0f_minting,current_value,acquired_date)values"+ "(?,?,?,?,?)")){
				
				preparedStatement.setString(1, coin.getCountry());//java object to relational
				preparedStatement.setString(2, coin.getDenomination());
				preparedStatement.setInt(3, coin.getYearOfMinting());
				preparedStatement.setBigDecimal(4, coin.getCurrentValue());
				preparedStatement.setDate(5, new Date(coin.getAcquiredDate().getTime()));
				//System.out.println("Rows affected:"+preparedStatement.executeUpdate());
				//successFlag=true;//on sucessful completion of query execution  
				return preparedStatement.executeUpdate();

		}
		catch (SQLException e) {
            e.printStackTrace();//Handle properly in real time
          //  successFlag= false;
            return 0;//no deta acquired in row 
		}
		//return successFlag;
	}
	
	
	
	//update
	public int updateCoin(Coin coin)
	{
		int updatedRows=0;
		String updateQuery = "update coin_collection set country=?,denomination=?,year_0f_minting=?,current_value=?,acquired_date=? where id=?";

		try (Connection connection =ConnectionUtils.getConnection();
				PreparedStatement preparedStatement= connection.prepareStatement(updateQuery))
						{
			//java object to relational
			System.out.println("coin Id : Update DAO Method ==> " +coin.getId());

					preparedStatement.setString(1, coin.getCountry());//java object to relational
					preparedStatement.setString(2, coin.getDenomination());
					preparedStatement.setInt(3, coin.getYearOfMinting());
					preparedStatement.setBigDecimal(4, coin.getCurrentValue());
					preparedStatement.setDate(5, new Date(coin.getAcquiredDate().getTime()));
					//preparedStatement.setInt(6, coin.getId());

					//System.out.println("Rows affected:"+preparedStatement.executeUpdate());
					//successFlag=true;//on sucessful completion of query execution  
					updatedRows=  preparedStatement.executeUpdate();
					System.out.println("-------------  updated Row : " + updatedRows);

			}
			catch (SQLException e) {
	            e.printStackTrace();//Handle properly in real time
	          //  successFlag= false;
	            return 0;//no deta acquired in row 
			}
		return updatedRows;
		
	}
	
	
	//delete
	public int deleteCoin(int coinId)
	{
		int updatedRows=0;
		
		try (Connection connection =ConnectionUtils.getConnection();
				PreparedStatement preparedStatement= connection.prepareStatement("delete from coin_collection where id=?"))
						{
					
					preparedStatement.setInt(1, coinId);
//on successful completion of query execution
					updatedRows=  preparedStatement.executeUpdate();

			}
			catch (SQLException e) {
	            e.printStackTrace();//handle properly in real time app
	            return 0;//no deta acquired in row 
			}
		return updatedRows;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
