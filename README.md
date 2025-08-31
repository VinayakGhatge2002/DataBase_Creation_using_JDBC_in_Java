# Course Management System (Java + MySQL)

##  Project Purpose
The main purpose of this project is to understand how **Java can interact with databases using JDBC**.  
As a fresher, I wanted to build a small console-based application where I can perform **basic operations like creating a table, inserting records, updating details, retrieving data, and deleting records** from a database.  

This project helped me learn the **practical use of JDBC** in real-time applications and how data is managed at the backend.  

---

##  What the Project Does
This is a **menu-driven application** where a user can:
1. Create a `course` table if it does not exist.  
2. Insert multiple course details (ID, Name, Fees, Duration).  
3. Modify course duration using the course ID.  
4. Retrieve and display all courses in a formatted way.  
5. Delete a course by ID.  
6. Exit the application.  

So basically, it is a simple **Course Management System** using Java and MySQL.

---

##  How I Built It
- First, I installed **MySQL** and created a database named `gqt`.  
- Then I wrote a **Java program using JDBC API** to connect Java with MySQL.  
- I used **PreparedStatement** and **Statement** classes to perform database operations.  
- I also made the program **menu-driven** using loops and switch-case so that users can perform any operation easily.  
- Finally, I tested the program by inserting, updating, retrieving, and deleting some sample courses.  

---

##  How It Works
When we run the program, it shows a menu like this:
<br>
========= COURSE MENU =========

1.Create Course Table

2.Insert Courses

3.Modify Course Duration

4.Retrieve All Courses

5.Delete Course

6.Exit

===============================

Enter your choice:

---

- If the user selects 1, a new table is created in MySQL (if not already exists).  
- If the user selects 2, the program asks for course details and inserts them into the table.  
- If the user selects 3, the user can change the duration of a course.  
- If the user selects 4, all records are displayed in a proper format.  
- If the user selects 5, a course can be deleted using its ID.  
- Option **6** exits the program.  

This way, the program works like a **small database management system** for courses.

---

##  Technologies Used
- **Java**  
- **JDBC API**  
- **MySQL Database**
  
##  Sample Output
Driver loaded !!!

connection done!!!

Table 'course' Created!!!

======= Course Table Data =======

101   Java             5000.00   3 Months

102   Python           4500.00   2 Months

103   WebDevelopment   7000.00   4 Months

=================================

---

##  What I Learned
- How to **connect Java with MySQL** using JDBC.  
- How to perform **CRUD operations** (Create, Read, Update, Delete).  
- How to use **PreparedStatement and ResultSet**.  
- Importance of handling **exceptions** and closing database connections.  
- How to build a **menu-driven console application** in Java.  

---

##  Conclusion
This project is a small step towards understanding how backend systems work in real applications.  
It gave me confidence in using **databases with Java** and helped me strengthen my **Core Java and JDBC knowledge**.  




