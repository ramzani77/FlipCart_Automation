# 🛒 Flipkart Automation Project

## 📦 Overview
This project is an automation testing suite for Flipkart's web application using **Selenium WebDriver** with **Java**. The main goal of this project is to validate product search functionalities, including filters, sorting, and data extraction.

## 🚀 Features
- Search for products on Flipkart.
- Filter results based on ratings and discounts.
- Extract and display product titles and discount percentages.
- Comprehensive test cases structured using **TestNG**.

## 💻 Technologies Used
- **Java**: The primary programming language for writing test scripts.
- **Selenium WebDriver**: For automating web application testing.
- **TestNG**: A testing framework for running and managing test cases.
- **Maven**: Dependency management.

## 📂 Project Structure
FlipCart_Automation/ │ ├── src/ │ ├── main/ │ │ └── java/ │ │ └── demo/ │ │ ├── wrappers/ │ │ │ └── Wrappers.java │ │ └── TestCases.java │ └── test/ │ └── java/ │ └── demo/ │ └── TestCasesTest.java │ ├── pom.xml └── README.md


## 🛠️ Getting Started

### Prerequisites
- Java JDK
- Maven
- IntelliJ IDEA or any Java IDE

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/ramzani77/FlipCart_Automation.git

🎯 Test Cases
The following test cases are included in this project:

TestCase01: Go to www.flipkart.com, search for "Washing Machine," sort by popularity, and print the count of items with a rating less than or equal to 4 stars.

TestCase02: Search for "iPhone," print the titles and discount percentages of items with more than 17% discount.

TestCase03: Search for "Coffee Mug," filter by 4 stars and above, and print the titles and image URLs of the 5 items with the highest number of reviews.

📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

🤝 Contributing

Contributions are welcome! Please submit a pull request or open an issue for discussion.

📞 Contact

For inquiries, please contact Your Name or open an issue in this repository.

🌟 Acknowledgements

Selenium Documentation
TestNG Documentation

