import java.sql.*;

public class EmployeePayrollService {
    public static void main(String[] args) {

        String query = "SELECT * FROM employee_payroll WHERE start BETWEEN ? AND ?";

        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/employee_payroll_db", "root", "Shiva@123");
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setDate(1, Date.valueOf("2023-01-01"));
            ps.setDate(2, Date.valueOf("2024-12-31"));

            ResultSet rs = ps.executeQuery();

            System.out.println("Employees in Date Range:");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}