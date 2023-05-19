# ExpenseTrackingAPI
API for Expense Tracking System to allow users to track their expenses for different types of categories.

# How i managed my database via sql scripts
➜ (1) write a sql scripts with your ERD structure </br>

➜ (2) copy the sql script file into the root of your postgres docker container using the following command </br>
```cmd
 ➜ docker cp [sql-script-location] [container-name]:/  
```
➜ (3) open the bash into your docker container to execute the sql script agains the database using the following command </br>
```cmd
 ➜ docker container exec -it [container-name] bash  
```
this will open the bash inside the container and now we can use `psql` against the database using the following command
```psql 
 ➜ psql -U [the-user-we-used-to-login-to-container] --file [sql-script-name]
```