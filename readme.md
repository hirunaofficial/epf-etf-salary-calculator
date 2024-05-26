# EPF ETF Salary Calculator

A JavaFX application to calculate Employee Provident Fund (EPF) and Employee Trust Fund (ETF) contributions based on the provided salary. This application is designed to help employees and employers quickly determine their respective contributions and the net salary after deductions.

## Features

- **Salary Calculation**: Input a salary and calculate the following:
    - Employee EPF Contribution
    - Employer EPF Contribution
    - Employer ETF Contribution
    - Total Employer Contribution
    - Total EPF Contributions
    - Total EPF + ETF Contributions
    - Net Salary


- **Interactive UI**: Utilizes JavaFX for a user-friendly graphical interface with real-time feedback and fade transitions for updated values.


- **Validation**: Ensures the salary input is a valid number between 0 and 10,000,000.


- **Responsive Feedback**: Provides success and error messages based on user input.

![Calculator Screenshot](https://telegra.ph/file/ba167b59b260a3c1e306b.png)

## Getting Started

### Prerequisites
- Java 11 or higher
- JavaFX SDK

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/hirunaofficial/EPF-ETF-Salary-Calculator
    ```

2. Navigate to the project directory:
    ```sh
    cd EPF-ETF-Salary-Calculator
    ```

3. Open the project in your favorite IDE and ensure JavaFX is set up correctly.

### Running the Application

1. Build and run the `CalculatorApplication` class.
2. The application window will open, allowing you to enter a salary and calculate the contributions.

## Usage

1. Enter your salary in the input field.
2. Click the "Calculate" button.
3. View the detailed breakdown of contributions and net salary.

## Code Structure

- **CalculatorApplication**: Main class to launch the JavaFX application.
- **CalculatorController**: Controller class handling the business logic for salary calculation and UI updates.
- **calculator-view.fxml**: FXML file defining the layout of the application.

## License

This project is licensed under the MIT License. See the LICENSE file for details.

## Author

GD Hiruna - [hiruna.dev](https://hiruna.dev)

---

Feel free to reach out if you have any questions or need further assistance!
