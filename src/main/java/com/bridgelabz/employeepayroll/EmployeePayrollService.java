package com.bridgelabz.employeepayroll;
import java.sql.*;

public class EmployeePayrollService {
    public static void main(String[] args) {

        String query = "UPDATE employee_payroll SET salary = ? WHERE name = ?";

        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/employee_payroll_db", "root", "Shiva@123");
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setDouble(1, 300000);
            ps.setString(2, "Terisa");

            int rows = ps.executeUpdate();
            System.out.println("Rows Updated: " + rows);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}