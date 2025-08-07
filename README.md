# Banking System in Java

A console-based Java application that simulates basic banking operations such as account creation, deposit, withdrawal, balance checking, and fund transfer. The project is developed using Object-Oriented Programming (OOP) principles to manage accounts and transactions effectively.

## 💡 Overview

This banking system is designed for beginners who want to understand how real-world banking functionality can be implemented in Java using classes and objects.

## 🚀 Features

- Account Creation
- Deposit Money
- Withdraw Money
- Check Account Balance
- Transfer Funds Between Accounts
- Input validation and basic exception handling
- Console-based interactive interface

## 🧠 Object-Oriented Design

- **Account Class** – stores account number, holder name, balance
- **Bank Class** – manages list of accounts and transactions
- **Main Class** – handles user input and interaction

## 📦 Technologies Used

- Java (Core Java)
- OOP (Encapsulation, Classes, Objects)
- Scanner class for input
- Collections (ArrayList or HashMap)
- Exception Handling

## 🧱 Project Structure

```
/src
  ├── model/
  │   └── Account.java         # Represents bank account details
  ├── service/
  │   └── Bank.java            # Business logic for transactions
  └── Main.java                # Entry point for user interface
```

## 🛠️ How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/java-banking-system.git
   ```
2. Compile the Java files:
   ```bash
   javac src/**/*.java
   ```
3. Run the application:
   ```bash
   java src/Main
   ```

## 📸 Sample Output

```
Welcome to Java Bank!
1. Create Account
2. Deposit Money
3. Withdraw Money
4. Transfer Funds
5. Check Balance
6. Exit
Enter your choice:
```

## 🔐 Sample Functional Flow

- User creates an account with name and initial deposit.
- User deposits or withdraws using account number.
- Fund transfers occur between two existing accounts.
- Balance can be checked anytime by entering account number.

## 📚 Future Enhancements

- Add persistent storage using files or databases
- Add user authentication (PIN or password)
- Transaction history tracking
- GUI using Swing or JavaFX

## 🤝 Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

---

> 🏦 Built by Aman Saifi as a part of Java OOPs practice and learning.
