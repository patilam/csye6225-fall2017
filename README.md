# CSYE 6225 Cloud Computing and Network Structures Repository Fall 2017

A Repository for the Fall 2017 Course of CSYE 6225 Cloud computing and Network Structures. This repository will be used to develop a workflow using various Integration and Deployment tools such as Travis CI.
This will also be used to ensure students develop a workflow for development around github. This would allow for better collaboration in the future.

Team Members

Ajay Vishwanathan  vishwanathan.a@husky.neu.edu

Amit Patil         patil.a@husky.neu.edu

Ali Amar Asgar     asgar.a@husky.neu.edu

# Make Unauthenticated HTTP Request
# Ali Asgar
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
