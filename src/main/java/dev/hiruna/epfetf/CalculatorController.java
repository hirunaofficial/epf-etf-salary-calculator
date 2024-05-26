package dev.hiruna.epfetf;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import java.awt.Desktop;
import java.io.IOException;
import java.text.DecimalFormat;
import java.net.URI;
import java.net.URISyntaxException;

public class CalculatorController {

    @FXML
    private Label txtEMP1;

    @FXML
    private Label txtEMP2;

    @FXML
    private Label txtEMP3;

    @FXML
    private Label txtEMP4;

    @FXML
    private Label txtEMP5;

    @FXML
    private Label txtEMP6;

    @FXML
    private TextField txtSalery;

    @FXML
    void openURL(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://hiruna.dev/"));
    }

    @FXML
    void salaryCalculate(ActionEvent event) {
        try {
            // Convert the text from the salary TextField to a double
            double salary = parseSalary(txtSalery.getText());

            // Validate the salary input
            if (salary < 0 || salary > 10000000) {
                throw new NumberFormatException();
            }

            // Employee Contribution
            double employeeEPF = salary * 8 / 100;

            // Employer Contribution
            double employerEPF = salary * 12 / 100;
            double employerETF = salary * 3 / 100;
            double employerTotal = employerEPF + employerETF;

            // Calculate total EPF contributions
            double totalEPF = employeeEPF + employerEPF;

            // Calculate total EPF and ETF contributions
            double totalEPFETF = employerTotal + employeeEPF;

            // Calculate net salary
            double netSalary = salary * 92 / 100;

            // Create a DecimalFormat object for formatting numbers
            DecimalFormat decimalFormat = new DecimalFormat("###,###.00");

            // Format the numbers in the result strings
            String tempEMP1 = "Employee Contribution:\nEPF (8%): " + formatNumberWithSpaces(decimalFormat.format(employeeEPF));
            String tempEMP2 = "Employer Contribution:\nEPF (12%): " + formatNumberWithSpaces(decimalFormat.format(employerEPF)) + "\nETF (3%): " + formatNumberWithSpaces(decimalFormat.format(employerETF));
            String tempEMP3 = "Total Employer Contribution (15%): " + formatNumberWithSpaces(decimalFormat.format(employerTotal));
            String tempEMP4 = "Total EPF (8% + 12% = 20%): " + formatNumberWithSpaces(decimalFormat.format(totalEPF));
            String tempEMP5 = "Total EPF+ETF (23%): " + formatNumberWithSpaces(decimalFormat.format(totalEPFETF));
            String tempEMP6 = "Net Salary (92%): " + formatNumberWithSpaces(decimalFormat.format(netSalary));


            // Show success message
            showAlert(Alert.AlertType.INFORMATION, "Success", "Calculation successful.");

            // Update UI with calculated results
            setLabelWithFade(txtEMP1, tempEMP1);
            setLabelWithFade(txtEMP2, tempEMP2);
            setLabelWithFade(txtEMP3, tempEMP3);
            setLabelWithFade(txtEMP4, tempEMP4);
            setLabelWithFade(txtEMP5, tempEMP5);
            setLabelWithFade(txtEMP6, tempEMP6);

        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please enter a valid number between 0 and 10,000,000 for salary.");
        }
    }

    private double parseSalary(String salaryString) throws NumberFormatException {
        // Remove commas from the input string
        String cleanedSalaryString = salaryString.replaceAll(",", "");
        return Double.parseDouble(cleanedSalaryString);
    }

    // Method to add spaces to numbers every three digits
    private String formatNumberWithSpaces(String number) {
        return number.replaceAll("(?<=\\d)(?=(\\d{3})+(?!\\d))", " ");
    }

    private void setLabelWithFade(Label label, String text) {
        label.setText(text);

        // Create a fade transition
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), label);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}