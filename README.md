# Banking System

A desktop banking application developed using Java Swing and MySQL. It provides basic banking operations through a user-friendly graphical interface.

## Features

- User Registration
- User Login
- Deposit Money
- Withdraw Money
- Check Balance
- View Transaction History
- Logout
- MySQL Database Integration
- JDBC Connectivity

## Technologies Used

- Java
- Java Swing
- MySQL
- JDBC
- SQL

## Project Structure

```
BankingSystem/
│
├── src/
│   ├── LoginForm.java
│   ├── RegisterForm.java
│   ├── Dashboard.java
│   ├── DepositForm.java
│   ├── WithdrawForm.java
│   ├── BalancePage.java
│   ├── TransactionPage.java
│   ├── DatabaseConnection.java
│   └── User.java
│
├── lib/
│   └── mysql-connector-j-9.7.0.jar
│
└── bankdb.sql
```

## Database Setup

1. Install MySQL Server and MySQL Workbench.
2. Open MySQL Workbench.
3. Execute the `bankdb.sql` file.
4. Update the MySQL username and password in `DatabaseConnection.java`.

## Configure JDBC

1. Download MySQL Connector/J.
2. Place `mysql-connector-j-9.7.0.jar` inside the `lib` folder.
3. Add the JAR to your project's classpath.

## Run the Project

1. Open the project in Visual Studio Code.
2. Install the **Extension Pack for Java**.
3. Compile the Java files.
4. Run `LoginForm.java`.

## Default Login

```
Username: admin
Password: 1234
```

## Future Enhancements

- Money Transfer
- Change Password
- Forgot Password
- Interest Calculator
- Account Number Generation
- Password Hashing
- Admin Dashboard
- PDF Bank Statement
- Email Notifications

## Author

Developed as a Java Mini Project using Java Swing, JDBC, and MySQL.
