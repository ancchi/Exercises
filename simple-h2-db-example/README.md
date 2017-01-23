# JDBC training application 

This is a simple Java application for training purposes.

## Goals
  
The application has intentionally no build system around. 
The main exercise consists of implementing the TodoListItemDao class. 
Besides that the trainee should be encouraged to play around with the java.sql.* JDBC API.  

## Getting started

1. Import the application in to IntellJ Idea
2. Ensure that the '/libs' folder is added to the classpath
3. Run the main method TodoListApp.java. This will initialize a H2 database with a table 'todo_list' and two entries.
4. The database file is put in the '/work' directory

## Supporting reads for the trainee

- https://docs.oracle.com/javase/tutorial/jdbc/basics/
- http://stackoverflow.com/questions/19154202/data-access-object-dao-in-java
- https://de.wikipedia.org/wiki/Data_Access_Object
- http://www.h2database.com/html/main.html

## Further exercises
- Extend the TodoListItemDao with a method for retrieving only completed tasks
- Extend the DB schema with a 'task_type' table and create a 1:n relation between todo list items and task types

## TODO
- add failing unit tests to verify results of the TodoListItemDao implementation
