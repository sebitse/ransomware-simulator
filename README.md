# Ransomware Simulator

**Ransomware Simulator** is a Java-based educational project designed to simulate the encryption and decryption of files and directories using various cryptographic algorithms. The project demonstrates key concepts in file encryption and directory traversal, and is intended solely for learning purposes.

## Table of Contents
- [Features](#features)
- [Requirements](#requirements)
- [Installation](#installation)
- [Usage](#usage)
- [Key Classes](#key-classes)
- [Encryption Algorithms](#encryption-algorithms)
- [Limitations](#limitations)
- [License](#license)

---

## Features
- **File Encryption/Decryption**: Encrypt or decrypt individual files using AES or RSA algorithms.
- **Directory Encryption/Decryption**: Recursively encrypt or decrypt entire directories and their sub-directories.
- **Command-Line Interaction**: The project uses a command-line interface (CLI) for user interactions, making it easy to operate.
- **Observer Pattern**: Displays the progress of file encryption and decryption using a custom observer mechanism.
- **Single Responsibility Design**: Each class in the project adheres to the Single Responsibility Principle, making the code modular and easy to maintain.

## Requirements
To run this project, you need the following:
- **Java JDK 8 or higher**
- A Java-compatible IDE (optional)
- Maven
  
## Installation
1. **Clone the Repository**:
   Clone the project from the repository using the following command:
   ```
   git clone https://github.com/sebitse/ransomware-simulator.git
   ```
2. **Compile the Project**
   ```
   mvn clean install
   ```
3. **Run the Application**
   ```
   java -jar target/ransomware-1.0-SNAPSHOT.jar
   ```
## Usage
   Once the application starts, follow the on-screen prompts to encrypt or decrypt files or directories. Here's how you can use the ransomware simulator:
   1. Select Operation (1-Encrypt/2-Decrypt)
   2. Choose Encryption Algorithm
   3. Repeat or Exit
   4. 
## Key Classes
  **RansomwareSimulatorApp**
    The main entry point of the application. It handles user input and delegates the file and directory encryption/decryption to the appropriate processor.

  **DirectoryProcessor**
    Responsible for processing files and directories. If a directory is selected, it recursively encrypts or decrypts all files inside the directory and its subdirectories.

  **CommandFactory**
    Generates appropriate EncryptCommand or DecryptCommand instances based on the user's input (operation type and algorithm).

  **ObservableFileProcessor**
    Handles the actual encryption or decryption of files and notifies observers of progress

## Encryption Algorithms
  **AES (Advanced Encryption Standard)**
    - AES is a symmetric encryption algorithm
    - I use a 256-bit AES key by default for encrypting files.
  **RSA (Rivest-Shamir-Adleman)**
    - RSA is an asymmetric encryption algorithm
    - I use a 2048-bit RSA key pair

## Limitations
  - **Educational Use Only** "Be careful not to choke on your aspirations." -Darth Vader (Rogue One)
  - **Basic Error Handling**
  - **Limited Encryption Algorithms**

## License
  This project is licensed under the MIT License.
