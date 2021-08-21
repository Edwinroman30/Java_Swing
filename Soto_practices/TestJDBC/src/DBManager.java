
import java.sql.*;

public class DBManager {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/itla";
        String username = "root";
        String password = "";
        Connection con = null;
        Statement stmnt = null;
        ResultSet rs = null;
        PreparedStatement pstmnt = null;
        
        try {
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Conectado");

            String query = "INSERT INTO notas (NOMBRE, MATRICULA, NOTA) "
                    + "VALUES(?, ?, ?)";

            pstmnt = con.prepareStatement(query);
            pstmnt.setString(1, "Cedric");
            pstmnt.setString(2, "2020-0983");
            pstmnt.setInt(3, 99);

            pstmnt.executeUpdate();

            stmnt = con.createStatement();
            //   stmnt.executeUpdate(query);
            query = "SELECT ID, NOMBRE, MATRICULA, NOTA FROM notas";
            rs = stmnt.executeQuery(query);

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID")
                        + " NOMBRE: " + rs.getString("NOMBRE")
                        + " MATRICULA: " + rs.getString("MATRICULA")
                        + " NOTA: " + rs.getInt("NOTA")
                );
            }

        } catch (SQLException ex) {
            System.out.println("Error!");
        }

    }
}
