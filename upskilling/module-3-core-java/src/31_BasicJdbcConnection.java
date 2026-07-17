import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class BasicJdbcConnection {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/school";
        String user = "root";
        String password = "password";
        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT id, name FROM students")) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name"));
            }
        }
    }
}

