Project : SATSA Java Test

Author  : Valentine Tobah

Date    : 13/09/2017




                         PROJECT DESCRIPTION


The Maven web application contains the following files

-index.html :  This is an HTML page that displays a form for user input 
	       collection. All the input fields are mapped and are  
	       controlled by an AngularJs file called app.js.
	   
-app.js     :  This AngularJS file is resposible for collecting all   
	       user inpout, verifies the inputs formats and patterns.
	       This file makes An Http GET to retrieve and display all
	       the products that match the String value entered into
               the Product input field in form.
	       This file makes sure all the input fields have values
	       are of the right format when the form is submitted.
	       when the inputs are meet all the required criteria,
	       they are been sent to the back-end via Http POST method
	       and the related response received is displayed in the 
	       HTML page.

-Service.java : This is the Rest endpoint file which has two endpoints, 
	        A GET method which is requires a string path parameter 
		which is used to do a query for products matching the 
		string value passsed and the results are returned.
		A POST method that receives a Json object containing 
		customer details. The customer details are saved and a 
		response messsage is returned.

-SatsoDao.java : This Java class has a method called getProdetuctList() 
		 that is responsible for creating and returning 
		 an ArrayList of Poducts. And another method called 
	         saveCustomer() which is used to retrieve the customer 
	         details from the Json object and setting the variables
		 of the Customer class. And returns a Map containing a 
		 key value pair response which is converted to a string.

-Product.java : This a POJO  class used to store and retrieve product 
		details. This class has two Product properties variable
		i.e id and name.

Customer.java : This a also a POJO class used to store and retrieve 
		Customer details. This class has the following 
		property variables; title, name, surname, dateOfBirth,
		contactNumber, email, homeAddress, poductID.
