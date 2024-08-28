# Product_Search_and_Filtering_on_amazon
test cases for "Product Search and Filtering" on an eCommerce website
Here's a README template for your GitHub repository that describes the automation project using Katalon Studio and Groovy for scraping smartphone data from Amazon, storing it in an Excel file, and emailing it to a specified email address:

---

# Amazon Smartphone Data Automation

This project automates the process of retrieving smartphone data from Amazon, saving the data to an Excel file, and emailing the file to a specified recipient. The automation is implemented using **Katalon Studio** and **Groovy**.

## Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup Instructions](#setup-instructions)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Project Overview

The aim of this project is to automate the collection of smartphone data from Amazon. The script fetches data such as product names, prices, ratings, and other specifications, and stores this information in an Excel file. After data collection, the script sends the Excel file to a specified email address.

## Features

- **Web Scraping**: Automatically scrapes smartphone data from Amazon.
- **Data Storage**: Saves the scraped data into an Excel file.
- **Email Integration**: Sends the generated Excel file to a desired email address.
- **Error Handling**: Robust error handling to manage unexpected issues during scraping or file processing.

## Technologies Used

- **Katalon Studio**: An automation tool used for recording and scripting the automation tasks.
- **Groovy**: A scripting language used in Katalon Studio for writing the automation script.
- **Apache POI**: A Java API used for handling Excel files within the Groovy scripts.
- **JavaMail API**: Used for sending emails with attachments.

## Setup Instructions

1. **Install Katalon Studio**: Download and install [Katalon Studio](https://www.katalon.com/) on your machine.

2. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/amazon-smartphone-data-automation.git
   cd amazon-smartphone-data-automation
   ```

3. **Import the Project in Katalon Studio**:
   - Open Katalon Studio.
   - Go to `File` > `Open Project` and select the cloned repository folder.

4. **Configure Email Settings**:
   - Update the email configuration in the `SendEmail.groovy` script file with your SMTP settings and desired recipient email address.

5. **Install Dependencies**:
   - Ensure that the necessary dependencies (e.g., Apache POI for Excel handling, JavaMail API) are correctly configured in Katalon Studio.

## Usage

1. **Run the Test Suite**: Open the test suite in Katalon Studio that is responsible for scraping the data and sending the email.
   
2. **Monitor the Execution**: Observe the automation running. Katalon Studio will navigate through Amazon, collect the smartphone data, store it in an Excel file, and then email the file to the specified address.

3. **Check Your Email**: Once the automation is complete, check the specified email address for the Excel file containing the smartphone data.

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your improvements. Ensure your code follows the project's coding standards and is well-documented.

