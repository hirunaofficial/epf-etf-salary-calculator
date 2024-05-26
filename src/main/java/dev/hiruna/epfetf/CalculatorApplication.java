package dev.hiruna.epfetf;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculatorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Load the FXML file for the main view
        FXMLLoader fxmlLoader = new FXMLLoader(CalculatorApplication.class.getResource("calculator-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        // Set the title of the application window
        stage.setTitle("EPF ETF Calculator (Salary Calculator)");

        // Set the icon of the application window
        stage.getIcons().add(new Image(CalculatorApplication.class.getResourceAsStream("icon.png")));

        // Disable resizing of the application window
        stage.setResizable(false);

        // Set the scene and show the stage
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
