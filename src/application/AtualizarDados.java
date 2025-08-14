package application;

import db.DB;

import java.sql.*;

public class AtualizarDados {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement st = null;


        try {
            conn = DB.getConnection();
            st = conn.prepareStatement(
                    "UPDATE seller "
                            + "SET BaseSalary = BaseSalary + ? "
                            + "WHERE "
                            + "(DepartmentId = ?)"
            );

            st.setDouble(1, 200);
            st.setInt(2, 4);

            int rowsAffected = st.executeUpdate();
            System.out.println("Done! Rows affected: " + rowsAffected);


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
