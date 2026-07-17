import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class TransactionHandlingJdbc {
    public static void transfer(int fromId, int toId, double amount) throws Exception {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "password")) {
            con.setAutoCommit(false);
            try (PreparedStatement debit = con.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE id = ?");
                 PreparedStatement credit = con.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id = ?")) {
                debit.setDouble(1, amount);
                debit.setInt(2, fromId);
                credit.setDouble(1, amount);
                credit.setInt(2, toId);
                debit.executeUpdate();
                credit.executeUpdate();
                con.commit();
            } catch (Exception ex) {
                con.rollback();
                throw ex;
            }
        }
    }
}

