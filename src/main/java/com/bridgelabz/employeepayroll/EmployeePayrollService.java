package com.bridgelabz.employeepayroll;
import java.sql.*;

public class EmployeePayrollService {
    public static void main(String[] args) {

        String query = "SELECT COUNT(*), SUM(salary), AVG(salary), MIN(salary), MAX(salary) FROM employee_payroll";

        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/employee_payroll_db", "root", "Shiva@123");
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            if (rs.next()) {
                System.out.println("Count: " + rs.getInt(1));
                System.out.println("Sum: ₹" + rs.getDouble(2));
                System.out.println("Avg: ₹" + rs.getDouble(3));
                System.out.println("Min: ₹" + rs.getDouble(4));
                System.out.println("Max: ₹" + rs.getDouble(5));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}