package com.kainos.ea;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmployeesDB {
    private static Connection conn;

    public static List<Employee> getEmployees() {
        List<Employee> readEmp = new ArrayList<>();
        try {
            Connection c = getConnection();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT * FROM Employees");

            while (rs.next()) {
                Employee dbEmp = new Employee(rs.getShort("Number"),rs.getString("Name"), rs.getString("Address"), rs.getString("NIN"),rs.getString("BankAccNo"),
                        //Changed getInt for salary to getFloat to match the changes in the Employee class
                        rs.getFloat("salary"), rs.getString("Department"),rs.getFloat("NewGrossPay"));

                System.out.println(dbEmp);
                readEmp.add(dbEmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return readEmp;
    }
    public static List<Employee> getEmployeesByDep() {
        List<Employee> readEmp = new ArrayList<>();
        try {
            Connection c = getConnection();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT `Name`, Department FROM Employees ORDER BY Department");

            while (rs.next()) {
                Employee dbEmp = new Employee(rs.getShort("Number"),rs.getString("Name"), rs.getString("Address"), rs.getString("NIN"),rs.getString("BankAccNo"),
                        //Changed getInt for salary to getFloat to match the changes in the Employee class
                        rs.getFloat("salary"), rs.getString("Department"),rs.getFloat("NewGrossPay"));

                System.out.println(dbEmp);
                readEmp.add(dbEmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return readEmp;
    }


    public static void insertEmployee(Employee employee) {
        try {
            Connection c = getConnection();// Bad practices alert!
            Statement st = c.createStatement();
            st.executeUpdate(
                    "INSERT INTO Employees (`Name`, Address, NIN, BankNum, Salary, Department, GrossPay) " +
                            "VALUES " +
                            "('" + employee.getName() + "', '" + employee.getAddress() + "', '" + employee.getNIN() + "', '" + employee.getBankAccountNo() + "', '" + employee.getSalary() + "', '" + employee.getDepartment() + "', '" + employee.getGrossPay() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static Connection getConnection() {
        String user;
        String password;
        String host;

        if (conn != null) {
            return conn;
        }

        try {

            FileInputStream propsStream =
                    new FileInputStream("employeesdb.properties");

            Properties props = new Properties();
            props.load(propsStream);

            user = props.getProperty("user");
            password = props.getProperty("password");
            host = props.getProperty("host");

            if (user == null || password == null || host == null)
                throw new IllegalArgumentException(
                        "Properties file must exist and must contain "
                                + "user, password, and host properties.");

            conn = DriverManager.getConnection("jdbc:mysql://"
                    + host + "/projectEA_MatthewK?useSSL=false", user, password);
            return conn;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

