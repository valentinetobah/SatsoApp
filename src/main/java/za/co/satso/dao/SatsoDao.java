/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.satso.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.DatatypeConverter;
import javax.json.JsonObject;

import za.co.satso.pojo.Customer;
import za.co.satso.pojo.Product;

/**
 *
 * @author tobah
 */
public class SatsoDao {

    /**
     *This method Creates a Product ArrayList containing a list of Product objects
     *
     * @return List
     */
    public static List<Product> getProductList() {

        ArrayList<Product> list = new ArrayList<>();

        //Creating Products
        Product product1 = new Product(1, "Call of Duty 1");
        Product product2 = new Product(2, "Call of Duty 2");
        Product product3 = new Product(3, "Final Fantasy XVI");
        Product product4 = new Product(5, "Final Fantasy X");
        Product product5 = new Product(6, "XCOM");
        Product product6 = new Product(7, "Borderland 2");
        Product product7 = new Product(8, "Red Dead Redemption 2");
        Product product8 = new Product(9, "Uncharted: The Lost Legacy");

        //Populating the ArrayList with Product objects
        list.add(product1);
        list.add(product2);
        list.add(product3);
        list.add(product4);
        list.add(product5);
        list.add(product6);
        list.add(product7);
        list.add(product8);

        return list;
    }

    /**
     * This method expects a Json object containing customer details as
     * parameter and returns a Map containing status and message
     *
     * @param object
     * @return Map
     */
    public static Map saveCustomer(JsonObject object) {

        //Creating an onject of the customer class
        Customer customer = new Customer();

        //Setting the customer details by retrieving information from 
        //the Json object received 
        customer.setName(object.getString("name"));
        customer.setSurname(object.getString("surname"));

        String date = object.getString("dateOfBirth");

        Calendar cal = DatatypeConverter.parseDateTime(date);
        Date dob = cal.getTime();

        customer.setDateOfBirth(dob);
        customer.setEmail(object.getString("email"));
        customer.setContactNumber(object.getString("contactNumber"));
        customer.setHomeAddress(object.getString("homeAddress").replaceAll("\n", " "));
        customer.setProductID(object.getInt("productID"));

        //Creating a map key value pair of String String
        HashMap<String, String> map;

        /**
         * Conditions to check if customer surname received is equal to a
         * specific string and returns a map containing the appropriate message
         * and status
         */
        if (customer.getSurname().equalsIgnoreCase("tobah")) {

            map = new HashMap<>();

            map.put("status", "Failed");
            map.put("messsage", "Customer information was not saved");

            return map;

        } else {

            map = new HashMap<>();

            map.put("status", "Successful");
            map.put("messsage", "Customer information has been saved");

            return map;

        }

    }

}
