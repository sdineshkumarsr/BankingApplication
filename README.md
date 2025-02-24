Banking Application



A simple yet robust Banking Application designed using Core Java , Swing , AWT , and MySQL . This application allows users to perform essential banking operations such as creating accounts, depositing money, withdrawing cash, checking balances, generating mini-statements, and more.

**Features**
1) Account Creation 
  Users can create a new bank account by providing necessary details.
2) Login with Card and PIN
  Secure login system where users authenticate themselves using their card number and PIN.
3) Transaction Management
  Perform various banking transactions:
    Deposit : Add funds to the account.
    Withdraw : Withdraw cash from the account.
    Check Balance : View the current account balance.
    Mini Statement : Generate a summary of recent transactions.
    Fast Withdrawal : Quickly withdraw predefined amounts (e.g., $50, $100).
    Pin Change : Update the account PIN securely.
4) User-Friendly Interface
  The application features a clean and intuitive GUI built using Swing and AWT .
5) Database Integration
  All user data and transactions are stored securely in a MySQL database.
**Technologies Used**
  Core Java : For backend logic and application structure.
  Swing & AWT : For designing the graphical user interface (GUI).
  MySQL : For storing user accounts, transaction history, and other data.
  JDBC : For connecting the Java application to the MySQL database.


///////// MY SQL CODE//////////

CREATE DATABASE MBBANK;

CREATE TABLE IF NOT EXISTS REGISTRATION (form_no VARCHAR(30),f_name VARCHAR(30),l_name VARCHAR(30),father_name VARCHAR(30), DOB VARCHAR(30), gender VARCHAR(30), 
											mail VARCHAR(60), address VARCHAR(100), marriage VARCHAR(30), city VARCHAR(30), state VARCHAR(30), pincode VARCHAR(30));

CREATE TABLE IF NOT EXISTS REGISTRATIONTWO (form_no VARCHAR(30),religion VARCHAR(30),category VARCHAR(30),education VARCHAR(30),occupation VARCHAR(30), pan VARCHAR(30), aadhar VARCHAR(30));

CREATE TABLE IF NOT EXISTS REGISTRATIONTHREE(form_no VARCHAR(30), ac_type varchar(50), card_no VARCHAR(20), pin VARCHAR(5), features VARCHAR(150));

CREATE TABLE IF NOT EXISTS LOGIN(form_no VARCHAR(30), card_no VARCHAR(20), pin VARCHAR(5));

CREATE TABLE IF NOT EXISTS bank(pin VARCHAR(5),date VARCHAR(50), type VARCHAR(50), amount int);
