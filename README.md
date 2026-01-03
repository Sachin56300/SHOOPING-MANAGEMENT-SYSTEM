Java Shopping Management System Design Overview

🛍️ Shopping Management System
This project is a Java-based desktop application designed to manage inventory, process customer orders, and handle billing using JDBC and MySQL.

🏗️ 1. Object-Oriented Programming (OOP) Architecture
The project is built on the core pillars of OOP to ensure the code is modular and scalable:

Encapsulation: Used to protect sensitive data (like product prices and customer IDs) by using private fields and public getters and setters.

Inheritance: Created a base class User which is extended by Admin and Customer classes to share common attributes like name and login credentials.

Abstraction: Utilized interfaces or abstract classes for "Payment" methods (e.g., CreditCardPayment, CashPayment) to hide implementation details.

Polymorphism: Method overriding is used to calculate different discount logic for regular vs. premium customers.

🗄️ 2. Database Design & JDBC
The system uses a relational database to maintain data persistence.

Database: MySQL / PostgreSQL.

Tables: Products, Users, Orders, and Order_Items.

JDBC (Java Database Connectivity):

Driver Manager: To establish a connection between Java and the SQL database.

Statements & PreparedStatements: Used to execute SQL queries safely (preventing SQL injection).

ResultSet: To iterate through and display data fetched from the database into the UI.

🚀 3. Key Features
Admin Module: Add, update, and delete products from the inventory.

Customer Module: Search for products, add to cart, and checkout.

Real-time Inventory: Automatically decrements stock levels when an order is placed.

Bill Generation: Calculates totals, taxes, and generates a final receipt.

🛠️ How to Run the Project
Clone the Repository: git clone https://github.com/yourusername/shopping-system.git

Setup Database: Import the provided .sql file into your local MySQL server.

Configure JDBC: Update the DBConnection.java file with your database username and password.

Compile & Run: Run the Main.java file from your IDE (IntelliJ, Eclipse, or NetBeans).

📈 Future Enhancements
Integration with a GUI (JavaFX or Swing).

Adding a Web-based interface using Spring Boot.

Implementing PDF export for billing receipts.

The Shopping Management System (SMS) is designed as a robust, console- or GUI-based application developed using Java, leveraging Object-Oriented Programming (OOP) principles to ensure modularity, maintainability, and scalability. The system’s primary goal is to efficiently manage product inventory, track sales transactions, and generate basic operational reports for a retail environment.

![2](https://github.com/user-attachments/assets/d63d49af-e826-438c-9281-3f89a2eb1819)



Architectural Approach

![5](https://github.com/user-attachments/assets/5e04667d-c927-4d20-9a2a-484047b38a47)


The system employs a simplified three-tier architecture to separate concerns, making the codebase easier to understand and debug:

Presentation Layer: This is the user interface, typically a command-line interface (CLI) for simplicity in a foundational Java project, or potentially a Swing/JavaFX GUI. It handles user input (e.g., "Add new product," "Process sale") and displays results.

Business Logic Layer: This is the heart of the system. It contains the core logic and manages the business rules. This layer decides how data is manipulated (e.g., updating inventory after a sale, calculating discounts).

Data Access Layer (DAL): This layer is responsible for persistence. It abstracts the storage mechanism—whether it's simple file I/O (like reading/writing CSV or serialized object files) or interacting with a relational database (like MySQL or PostgreSQL).


![3](https://github.com/user-attachments/assets/9ddc6922-b00b-434a-90bc-3decc08ea520)

Key Java Components and Classes

The system design relies on several core classes, each fulfilling a specific role:

Product (Model Class): A fundamental data structure class. It represents an item in the store and uses Java concepts like encapsulation (private fields with public getters/setters) to protect data integrity. Key fields include productID (unique identifier), name, price, and description.

![6](https://github.com/user-attachments/assets/9824938c-39e1-4861-b420-3b4a73021149)


InventoryManager (Business Logic): This is a key service class responsible for managing stock levels. Its methods include addProduct(Product product, int quantity), removeProduct(String productID), and crucially, updateStock(String productID, int quantityChange). It interacts directly with the DAL to retrieve and save inventory data.

SalesManager (Business Logic): Handles all transaction processing. When a customer makes a purchase, this class manages the workflow: creating an Order object, calculating the total price (including tax or discounts), decrementing stock via the InventoryManager, and logging the transaction to the DAL.

DataStore or DatabaseConnector (DAL): A utility class dedicated to reading and writing data. It hides the complexities of the persistence mechanism. Methods like loadAllProducts() and saveTransaction(Order order) ensure that data is persistent across application restarts.


![4](https://github.com/user-attachments/assets/555e14af-b5bb-43bc-96a1-e775d056e436)

Core System Functionality

The main loop of the SMS allows a user to perform critical operations:

Inventory Management: Easily add new products or update the stock of existing ones. The system enforces business rules, preventing a product's stock level from dropping below zero during a sale.

Transaction Processing: The SalesManager facilitates creating a shopping cart, adding items, calculating the final bill, and generating a receipt. Error handling ensures that if a transaction fails (e.g., insufficient stock), the inventory is rolled back to its previous state.

![7](https://github.com/user-attachments/assets/449ff36d-e878-4984-b934-6dfeab058b27)


Reporting: Basic reports, such as “Current Stock Value,” “Low Stock Alerts,” and “Daily Sales Summary,” can be generated by iterating through the stored transaction and inventory records.

By separating the system into these clear, cohesive components, the Java application maintains a clean structure, making it straightforward to implement advanced features like user authentication or graphical interfaces in future iterations.
