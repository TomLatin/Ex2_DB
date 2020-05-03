import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Q2 {

    public static void updateQueue(int idPatient)
    {
        String url="jdbc:mysql://localhost/hmo?useSSL=false";
        String user = "root";
        String password = "1234";
        try
        {
            // Connect to the DB
            Connection con = DriverManager.getConnection(url, user, password);
            //call the stored procedure
            CallableStatement statement = con.prepareCall("{call updating_actual_time("+idPatient+")}");
            statement.execute();
            statement.close();
        }
        catch (SQLException e) //If the connection failed
        {
            System.out.println("Connection failed");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        updateQueue(1);
    }

}
