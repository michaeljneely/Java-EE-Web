package src;
/*
CT5106 Assignment 3
Author: Michael Neely 13100590
 */

//Imports
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//Data Access Object Class
public class CustomerDAO {
    
    //Connection Strings
    private static final String DATABASE_URL = "jdbc:mysql://danu6.it.nuigalway.ie:3306/mydb2474";
    private static final String USERNAME = "mydb2474a";
    private static final String PASSWORD = "mydb2474a";
    
    //Get All Customer from DB, return as Array List of Customer Objects
    public List<Customer> getCustomers(){
        List <Customer> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
            //Set up and execture query
            con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customers ORDER BY customerNumber");
            while(rs.next()){
                //Instantiate new Customer object and set attributes
                Customer c = new Customer();
                c.setCustomerNumber(rs.getInt(1));
                c.setCustomerName(rs.getString(2));
                c.setContactFirstName(rs.getString(3));
                c.setContactLastName(rs.getString(4));
                c.setPhone(rs.getString(5));
                c.setAddressLine1(rs.getString(6));
                c.setAddressLine2(rs.getString(7));
                c.setCity(rs.getString(8));
                c.setState(rs.getString(9));
                c.setPostalCode(rs.getString(10));
                c.setCountry(rs.getString(11));
                c.setSalesRepEmployeeNumber(rs.getInt(12));
                c.setCreditLimit(rs.getDouble(13));
                //Add Customer to list
                list.add(c);
            }
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }finally{
            try{
                //cleanup
                if(stmt != null) stmt.close();
                if(con != null) con.close();
                
            }catch(SQLException ex){
                Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
}