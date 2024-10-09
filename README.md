# course-library-app-springboot-thymeleaf
A simple Course Library application implementing CRUD operations for entities such as Student, Book, Category, Author, and Publisher. This project demonstrates how to integrate a Thymeleaf frontend with a Spring Boot backend using Spring MVC.

# Prerequisites
Before you begin, ensure you have met the following requirements:

* Java Development Kit (JDK) 8 or higher
* Apache Maven (for building the Spring Boot project)
* Thymeleaf Setup (configured in your IDE)
* Database Server (e.g., MySQL) (if not using H2)
* Postman (optional, for API testing)

# Database Setup
To set up the database, you must first create it using the provided SQL file:

1. Locate the `student_library_management_db` file in the project folder.
2. Run the SQL script in your database management system to create the necessary tables and data.

# Getting Started

1. Clone the Repository
   If you haven't cloned the repository yet, open your terminal and run:
   
   ``` bash
       git clone https://github.com/AbuZanouneh/course-library-app-springboot-thymeleaf.git


2. Navigate to the Project Directory

   ``` bash
       git clone https://github.com/AbuZanouneh/course-library-app-springboot-thymeleaf.git
   
3. Add or replace the following lines in the src/main/resources/application.properties file with your MySQL credentials:

    ``` java
        # MySQL Database Configuration
        spring.application.name=employee-management
        spring.datasource.url=jdbc:mysql://localhost:3306/student_library_management_db?useSSL=false&serverTimezone=UTC
        spring.datasource.username=your_mysql_username
        spring.datasource.password=your_mysql_password
        # spring.jpa.hibernate.ddl-auto=update
        spring.jpa.show-sql=true

4. Running the Application
   
You can access it at the following -- URL: http://localhost:8080/index.html

# Technologies Used
  * Backend:
     * Spring Boot
     * Spring MVC
     * Spring Data JPA
     * Maven
     * MySQL (Optional)
  * Frontend:
     * Thymeleaf
     * Bootstrap 
  * Others:
     * Git (Optional)
     * Postman (Optional)

## Feel free to explore the application!
