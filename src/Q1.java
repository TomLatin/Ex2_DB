import java.sql.*;

public class Q1 {
    public static void main(String[] args) {
        String doctorID="1";
        String url="jdbc:mysql://localhost/hmo?useSSL=false";
        String user = "root";
        String password = "1234";
        String query="select patients.patient_id,patient_name,appointment_time from patients join appointment on appointment.doctor_id="+doctorID+" and patients.patient_id=appointment.patient_id and appointment.appointment_time>now(); ";

        {
            try
            {
                // Connect to the DB
                Connection con = DriverManager.getConnection (url, user, password);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                int numOfColumns=rs.getMetaData().getColumnCount();
                while (rs.next()) //promotion rs
                {
                  //Print all the doctor's patients
                    for (int i = 1; i <=numOfColumns ; i++) {
                        System.out.print(rs.getString(i)+" ");

                    }
                    System.out.println();
                }
            }
            catch (SQLException e) //If the connection failed
            {
                System.out.println("Connection failed");
                e.printStackTrace();
            }
        }
    }

}
