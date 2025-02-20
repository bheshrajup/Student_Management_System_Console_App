# Student Management System Console App

## Overview
The **Student Management System Console App** is a Java-based application that helps to manage student data efficiently. This console application allows users to **add**, **view**, and **list** student information in a simple yet effective manner. It connects to a MySQL database for persistent data storage and ensures smooth interaction with the system through the command line interface (CLI).

This system is designed to be lightweight and intuitive, making it ideal for educational purposes, learning Java, and understanding basic CRUD (Create, Read, Update, Delete) operations in Java and MySQL.

## Features
- **Add Student**: Users can add new student records to the system with essential details.
- **View All Students**: Displays a list of all registered students in a tabular format.
- **Search & Display**: Option to view student details by searching with unique identifiers (like student ID).
- **Clear Structure**: The app uses a clean and well-organized folder structure to separate models, views, services, and data access objects (DAO).
- **MySQL Integration**: Student data is stored persistently in a MySQL database, providing a solid foundation for real-world applications.

## Technologies Used
- **Java**: The core programming language for building the console app.
- **MySQL**: Database used for storing student records.
- **Maven**: Build automation tool used to manage project dependencies.
- **JDBC**: Java Database Connectivity for interacting with the MySQL database.

## Getting Started

### Prerequisites
Before you begin, ensure that you have the following installed:
- **Java 8 or above** (for compiling and running the project)
- **MySQL Database** (to store and retrieve student data)
- **Maven** (for dependency management and project build)

### Setup

1. **Clone the repository**:
   ```bash
   git clone https://github.com/bheshrajup/Student_Management_System_Console_App.git
   cd Student_Management_System_ConsoleApp
2. **Set up the MySQL database**:
Create a MySQL database and set up the necessary tables (as defined in StudentManagementSystem.sql)
3. **Modify the database credentials**:
   Update the DBConnection.java file with your MySQL username, password, and database URL
4. **Build and Run the Application**:
    If using Maven:
    ```bash
   mvn clean install
    mvn exec:java
Alternatively, compile and run using your favorite IDE.

5. **Folder Structure**:
    ```bash
   Student_Management_System_ConsoleApp/
    │── src/
    │   ├── main/
    │   │   ├── java/
    │   │   │   ├── models/          # Student.java
    │   │   │   ├── utils/           # DBConnection.java
    │   │   │   ├── dao/             # StudentDAO.java
    │   │   │   ├── services/        # StudentService.java
    │   │   │   ├── views/           # ConsoleUI.java
    │   │   │   ├── main/            # Main.java
    │   ├── resources/               # (Optional config files)
    │── pom.xml                      # Maven project file
    │── .gitignore                    # Ignore unnecessary files
    │── README.md                     # Project documentation

6. **Contributing**:
   Contributions are welcome! Please fork the repository, create a new branch for your feature or bugfix, and submit a pull request.


7. **License**:
   This project is open-source and available under the [MIT License](https://opensource.org/license/mit).

