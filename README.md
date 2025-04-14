# Employee Management System

A Java EE web application for managing employees with full CRUD functionality, using PrimeFaces, Payara Server, and MySQL.

Features
- List all employees
- Add new employees
- Edit existing employees
- Delete employees with confirmation
- Input validation
- Responsive UI with PrimeFaces

Technologies
- Java EE
- PrimeFaces 10.0 (or latest)
- Payara Server 5 (or latest)
- MySQL 8.0 (or latest)
- NetBeans IDE

Setup Instructions

1. Database Setup:
   - Create a MySQL database named `employeedb`
   - Run the `employee_schema.sql` script to create the table and sample data

2. Application Setup:
   - Clone this repository
   - Open in NetBeans as a Java Web Application
   - Add required libraries (PrimeFaces, MySQL Connector/J)
   - Configure Payara Server as the deployment server
   - Deploy the application

3. Access the Application:
   - After deployment, access at: `http://localhost:5080/EmployeeApp`
