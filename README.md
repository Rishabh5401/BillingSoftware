# BillingSoftware

<img width="850" height="521" alt="image" src="https://github.com/user-attachments/assets/0746361d-8509-408a-aea5-6b5e9fa2e17a" />

*BillingSoftware – Java Swing based billing system with Admin, Employee, and Customer Modules.*

---

## Table of Contents
1. [Project Overview](#project-overview)
2. [Modules](#modules)
3. [Features](#features)
4. [Screenshots](#screenshots)
5. [Prerequisites](#prerequisites)
6. [Installation & Setup](#installation--setup)
7. [Configuration](#configuration)
8. [How to Run](#how-to-run)
9. [Project Structure](#project-structure)
10. [Workflow](#workflow)
11. [Future Enhancements](#future-enhancements)
12. [Technologies Used](#technologies-used)
13. [Contributing](#contributing)
14. [License](#license)

---

## Project Overview
**BillingSoftware** is a desktop-based billing system built using **Java (Swing)** and **Maven**, with **MySQL** as the backend database.  
It is designed for small shops and businesses to manage employees, products, and billing efficiently with minimal manual effort.  

The software is modular, providing separate functionality for **Admin**, **Employee**, and **Customer** operations.

---

## Modules

### 1. Admin Module
- Manage employees (Add/Edit/Delete/View)
- Manage product/item listings with images and prices
- View all billing transactions
- Access control and user management

### 2. Employee Module
- Employee login with credentials
- Generate bills for customers
- Automatic item fetching from the database
- Support for multiple payment methods
- Automatic calculation of total, discounts, and amount to return
- Fetch existing customer details using phone number

### 3. Customer Module
- Stores customer details (Name, Phone, etc.)
- Tracks previous purchases
- Used by Employee module to autofill existing customer details during billing

---

## Features
- User-friendly GUI with **AbsoluteLayout**
- Automatic fetching of items and prices from MySQL database
- Customer verification using phone number
- Automatic calculations (total price, taxes, discounts, and return amount)
- Supports multiple payment methods
- Generates invoice/bill slip
- Validation for all user input and database entries
- Optimized for faster billing and management
- Modular design allows future expansion

---

## Screenshots
### Login Screen
<img width="1204" height="723" alt="image" src="https://github.com/user-attachments/assets/769084fd-37bc-457e-8264-48a226ce167a" />


### Admin Dashboard
<img width="1155" height="652" alt="image" src="https://github.com/user-attachments/assets/adc802e3-2c4d-4f6c-8c1a-d6636d61536b" />


### Register Employee
<img width="1067" height="711" alt="image" src="https://github.com/user-attachments/assets/9acb68ca-f33f-4094-a931-9c5b1e356f8e" />



### Employee DashBoard
<img width="1187" height="706" alt="image" src="https://github.com/user-attachments/assets/4769c460-6b60-43b4-b207-5ac6ad098fc8" />


### My Profile(Employee)
<img width="1064" height="780" alt="image" src="https://github.com/user-attachments/assets/2ff9acf6-8c93-4c05-8ea5-61ecd6c96125" />


### Employee Billing Screen
<img width="1140" height="685" alt="image" src="https://github.com/user-attachments/assets/13eea333-5536-418f-a3d8-9ccea55277e4" />



### Customer Lookup
<img width="1204" height="811" alt="image" src="https://github.com/user-attachments/assets/72d652a9-31b4-4c84-a667-662ba3c4651a" />


### Invoice Generation
<img width="1273" height="792" alt="image" src="https://github.com/user-attachments/assets/ea4df371-b362-49ec-948e-3cf92c636533" />




---

## Prerequisites
- Java 21 or later
- Maven 3.x
- MySQL (or compatible relational database)
- NetBeans IDE (optional, recommended for development)

---

## Installation & Setup
1. **Clone the repository:**

```bash
git clone https://github.com/Rishabh5401/BillingSoftware.git
cd BillingSoftware
```
---
2. **Add the required local library:**
```bash
BillingSoftware/lib/AbsoluteLayout.jar
mvn clean package
```

---
## Configuration
-Update config.properties with your database credentials:
```bash
db.url=jdbc:mysql://localhost:3306/your_database
db.username=root
db.password=your_password
```
## How to Run
```bash
java -jar target/BillingSoftware-1.0-SNAPSHOT-jar-with-dependencies.jar
```

The application will launch with the GUI interface.
---

## Project Structure
```bash
BillingSoftware/
├── lib/                        # Local JAR libraries (AbsoluteLayout.jar)
├── src/
│   ├── main/java/com/rishabh/billingsoftware/
│   │   ├── BillingSoftware.java
│   │   ├── StartProject.java
│   │   ├── login.java
│   │   └── ... (other Java classes)
│   └── main/resources/
│       └── config.properties
├── target/                      # Maven build folder
├── .gitignore
├── pom.xml
└── README.md
```
---
## Workflow

- Admin Login: Admin manages employees and items.

- Employee Login: Employee logs in and starts billing.

- Billing Process:

- Select items for customer

- Automatic item details and price fetched from database

- Enter or fetch customer details using phone number

- Calculate total and return cash automatically

- Choose payment method

- Generate invoice/bill slip

- Database Updates: Billing details, customer info, and inventory are automatically updated.

---
## Future Enhancements

- More input validations for Admin, Employee, and Customer

- Support additional payment methods (Card, UPI, Digital Wallet)

- Multi-language support

- Reports and analytics for sales and inventory

- Integration with printers for invoice slips

- Better GUI optimization and modular design

---

## Technologies Used

- Java 21

- Swing (GUI)

- MySQL

- Maven

- NetBeans IDE

---

## Contributing
-Feel free to fork the repository and submit pull requests.
-Please ensure your contributions follow the existing code structure and conventions.
---

## License
-This project is for educational purposes. Free to use and modify.
