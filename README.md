#Solution Assignment

	Basic API Path  = http://localhost:9090/assignment or http://127.0.0.1:9090/assignment
	
	User Name : admin
	Password : admin
	
	or
	
	User Name : user
	Password : user
	-----------------------------------------------------------------------------------------

	#NOTE: To test all API use anypoint platform:  
  
	"https://anypoint.mulesoft.com/mocking/api/v1/links/df7fcdd5-7e1e-4af4-aa31-48b64624e9a6/assignment" 
  
	-----------------------------------------------------------------------------------------
  
	#To Access Database use:
  
	"http://localhost:9090/h2-console" or "http://127.0.0.1:9090/h2-console" 
	
	User Name : test
	Password : test
  
	-----------------------------------------------------------------------------------------
  
	UserDTO :
		{
			id (integer, optional),
         	name (string, optional),
         	password (string, optional),
         	status (string, optional) = ['ACTIVATED', 'DEACTIVATED']
      }
         	
         	
	-----------------------------------------------------------------------------------------
         	
	Sample :
     {
          "id": 0,
          "name": "string",
          "password": "string",
          "status": "ACTIVATED"
     }



-----------------------------------------------------------------------------------------


To get existing User Details with user id as path variable

	#GET  http://localhost:9090/assignment/user/{userid}

id: Userid

Response :

	{
	 "id":3,	
    "name": "Your Name",
    "password": "Your Encrypted Password",
    "status": "ACTIVATED or DEACTIVATED"
	}

To edit existing User Details with user id as path variable and user details as Request Body 

	#PUT  http://localhost:9090/assignment/user/{userid}

Request Body:

Path Variable:    

id: User id

	{
	"userid" : userid
    "name": "Type Updated Name",    
    "password": "Type Updated Password",    
    "status": "ACTIVATED or DEACTIVATED"
	}

Response :

	{
	 "id":3,	
    "name": "Your Name",    
    "password": "Your Encrypted Password",    
    "status": "ACTIVATED or DEACTIVATED"
	}



To edit existing User Details with user details as Request Body 

	#POST  http://localhost:9090/assignment/user

Request Body:

	{
	"userid" : userid
    "name": "Type Your Name",    
    "password": "Type Your Password",    
    "status": "ACTIVATED or DEACTIVATED"
	}


Response :

	{
	 "id":3,	
    "name": "Your Name",    
    "password": "Your Encrypted Password",    
    "status": "ACTIVATED or DEACTIVATED"
	}

To get existing User Details with user id as path variable

	#DELETE  http://localhost:9090/assignment/user/{id}

id: User id

Success Response :

User with id {id} Deleted Successfully

Failure Response :

User with id {id} Not Found















#Spring Basic Security:
[To access API you need to provide Spring Basic Authentication with following details]


Admin login User Name= admin

Admin Password= admin

User login User Name= user

User Password= user

# service layer method Secured 

Using @secured annotation with role specified which method to call 

#//For in db database : H2

#Database schema creation for H2 data.sql

	#Database Schema for User Table:
	
	create TABLE IF NOT EXISTS User
	(
	id integer not null auto_increment,
	name varchar(255),
	password varchar(255),
	status varchar(255),
	primary key (id)
	);
	


#host= http://localhost or http://127.0.0.1
#port= 9090

H2 console URL=/h2-console

H2 console PATH= http://localhost:9090/h2-console

datasource.url=jdbc:h2:mem:assignment

spring.datasource.username=test

spring.datasource.password=test

database name=assignment

cache hazelcast native_client_address= http://127.0.0.1:5701   or   http://localhost:5701

cache hazelcast native_client_group= dev

cache hazelcast native_client_password= dev-pass




# ERROR CODES

	INVALID_CREDENTIALS("E101", "Invalid Credentials"),
	USER_NOT_FOUND("E102", "User not found"),
	DUPLICATE_USER_NAME("E103", "User name already exists"),
	DEFAULT("E104", "Something went wrong");




# RAML 

RESTful API Modeling Language (better known as RAML) is a YAML-based modeling language to describe RESTful APIs. 
It provides a structured and clear format to describe the API.
RESTful (REpresentational State Transfer) APIs also known as RESTful web services  are formal languages designed to provide a structured description of a RESTful web API capable of being consumed by both human and machine. They utilize HTTP requests to GET, PUT, POST, and DELETE data.










































