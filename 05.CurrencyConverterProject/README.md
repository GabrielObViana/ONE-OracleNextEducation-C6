<h1>Currency Exchange App</h1>

A simple application to convert currencies using the ExchangeRate API.

## How to Use

### 1. Create an Account

Before using the Currency Exchange App, you need to create an account on the ExchangeRate API website.

1. Visit [ExchangeRate-API](https://www.exchangerate-api.com) and sign up for an account.
2. Once you've signed up, you'll receive an API token that you'll need to use with the Currency Exchange App.

### 2. Install Java 17

Ensure that you have Java 17 installed on your system.

- Download and install Java 17 from the official website: [Java Downloads](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).

### 3. Download the Currency Exchange App

Clone the repository or download the source code to your local machine.

----------------------------------------------------------------------------------------------------------------------------------------------------------
git clone https://github.com/yourusername/currency-exchange-app.git
cd currency-exchange-app
----------------------------------------------------------------------------------------------------------------------------------------------------------

### 4. Build the App

Open a terminal or command prompt, navigate to the root directory of the Currency Exchange App, and run the following Maven command to build the application:

----------------------------------------------------------------------------------------------------------------------------------------------------------
mvn clean package
----------------------------------------------------------------------------------------------------------------------------------------------------------

### 5. Run the App

After successfully building the application, navigate to the target directory where the JAR file is located. The JAR file will be named something like currency-exchange-1.0-SNAPSHOT-jar-with-dependencies.jar. Run the following command to execute the application:

----------------------------------------------------------------------------------------------------------------------------------------------------------
java -jar target/currency-exchange-1.0-SNAPSHOT-jar-with-dependencies.jar "https://v6.exchangerate-api.com/v6/your-api-token"
-----------------------------------------------------------------------------------------------------------------------------------------------------------
- Note: Replace "https://v6.exchangerate-api.com/v6/your-api-token" with the actual API URL provided by the ExchangeRate API website and "your-api-token" with your actual API token.

### 6. Follow the On-Screen Instructions

The application will prompt you to input the base currency, target currency, and amount to convert. Follow the instructions provided by the application to perform the currency exchange.

### Example
----------------------------------------------------------------------------------------------------------------------------------------------------------
Enter base currency (e.g., USD): USD
Enter target currency (e.g., EUR): EUR
Enter amount to convert: 100
----------------------------------------------------------------------------------------------------------------------------------------------------------

### Contributing
1.  Fork the repository
2.	Create your feature branch (git checkout -b feature/AmazingFeature)
3.	Commit your changes (git commit -m 'Add some AmazingFeature')
4.	Push to the branch (git push origin feature/AmazingFeature)
5.	Open a pull request

### Acknowledgments
[ExchangeRate-API](https://www.exchangerate-api.com/) for providing the currency exchange rates.
