# csye6225-fall2017
=======
# Make Unauthenticated HTTP Request
Amit Patil
Ali Asgar
Ajay Vishwanathan
Pawan Patidar

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
>>>>>>> 2ec0e99ed8939649f32402b8ad08bfdf9a8d20c6
