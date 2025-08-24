package coin.utiles;
import java.sql.Connection;
import java.sql.DriverManager;
import coin.constatent.DatabaseConstants;

public class ConnectionUtils {
	
static Connection connection;
	public static Connection getConnection()
	{
    try {
		  Class.forName(DatabaseConstants.mySqlDriverClassName);
		    
          connection=DriverManager.getConnection(DatabaseConstants.databaseUrl,DatabaseConstants.databaseUserName
		  ,DatabaseConstants.databasePassword);
			
		}catch(Exception e)
        {
			e.printStackTrace();
			return null;
        }
		return connection;
		
	}
}
