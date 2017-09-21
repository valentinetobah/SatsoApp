/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.satso;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import za.co.satso.dao.SatsoDao;
import za.co.satso.pojo.Product;

/**
 *
 * @author tobah
 */

@Path("satso")
public class Service {

    
    /**
     *Rest endpoint expects a String path parameter. The String parameter 
     * passed is used to do a Product partial search. 
     * A String is returned as Json. 
     * 
     * @param value
     * @return 
     */
    @GET
    @Path("product/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getProduct(@PathParam("value") String value) {
        //Retrieving the list of Products
        List<Product> list = SatsoDao.getProductList();
        
        List<Product> products = new ArrayList<>();
        String json;
        
        //Condition to make sure path parameter String value is not null. 
        if (value != null) {
           
            //Searching the Product list for Product names that match the supplied
            //path parameter String value.
            for (Product product : list) {
                if (product.getName().toLowerCase().contains(value.toLowerCase())) {
                    products.add(product);
                }
            }
            //Converting the matching Products to a String and returning the String.
            json = new Gson().toJson(products);
            return json;
        }
        return null;
    }
    

    /**
     *Rest endpoint to save customer details. Consumes a Json Object which 
     * is contains Customer details.
     * 
     * @param object
     * @return 
     */
    @POST
    @Path("customer")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addCustomer(JsonObject object) {
        
        //method is called to save the customer details and the response 
        //returned is assigned to a string  which in turn returned as a Json .
        String json = new Gson().toJson(SatsoDao.saveCustomer(object));
        return json;
    }
}
