# CSYE 6225 Cloud Computing and Network Structures Repository Fall 2017

A Repository for the Fall 2017 Course of CSYE 6225 Cloud computing and Network Structures. This repository will be used to develop a workflow using various Integration and Deployment tools such as Travis CI.
This will also be used to ensure students develop a workflow for development around github. This would allow for better collaboration in the future.

Team Members

Ajay Vishwanathan  vishwanathan.a@husky.neu.edu

Amit Patil         patil.a@husky.neu.edu

Ali Amar Asgar     asgar.a@husky.neu.edu

Pawan Patidar      patidar.p@husky.neu.edu

# Application Build Instructions  
# Locally 
To locally build this application on an IDE and deploy it on a container:
The application is built on the spring framework using the Spring Boot project in order to reduce the various dependencies that need to be added to the project explicitly. The REST endpoints are being tested in this application. Using the Gradle build we ensure that the necessary libraries and dependencies are added to the application. 
1. First build the war files to ensure that there are no problems in terms of dependencies.
2. Use Apache Tomcat, a server container to deploy this application.
3. Ensure that the war Artifact is added to the deploy tab.

# Globally
1. Amazon Route 53 has been configureed for public hosting zone with all necessary security parameters.
2. The Domain name provided by Namecheap.me is to have custom NameServers configured as provided by the publicly hosted zones in Amazon route 53.

# JMeter Test
Jmeter tests have been written in order to check the accessiblility of REST endpoints and ensure that the security of the systtem is not being compromised. Over 100 auto generated usernames and passwords have been written to test the capabilities of the code.

# Travis CI Build and Unit Test
Travis Continuous Integration has been setup with this repository to trigger continuous builds and ensure that the code does not break. Email notifications/triggers have been set  for each member of the team. 
Unit test have been written to test the functionality of the program and integrated with travis.yml in order to ensure that the build maintains the same quality.

----------------------------------------------------------------------------------------------------------------------------
# Make Unauthenticated HTTP Request

Execute following command on your bash shell
``` bash
$ curl http://localhost:8080
```

## Expected Response:
```
{"message":"you are not logged in!!!"}
```

# Authenticate for HTTP Request

Execute following command on your bash shell
``` bash
$ curl -u user:password http://localhost:8080
```

where *user* is the username and *password* is the password.

## Expected Response:
 ```
 {"message":"you are logged in. current time is Tue Sep 19 20:03:49 EDT 2017"}
 ```
