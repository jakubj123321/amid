package com.example.formularz;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class formularzyk extends Application {

    private TextField firstNameField, lastNameField, addressField, cityField, phoneField, emailField;
    private Button submitButton, resetButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Prosty Formularz");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 20, 20, 20));


        Label firstNameLabel = new Label("Imię:");
        firstNameField = new TextField();
        grid.add(firstNameLabel, 0, 0);
        grid.add(firstNameField, 1, 0);


        Label lastNameLabel = new Label("Nazwisko:");
        lastNameField = new TextField();
        grid.add(lastNameLabel, 0, 1);
        grid.add(lastNameField, 1, 1);


        Label addressLabel = new Label("Adres:");
        addressField = new TextField();
        grid.add(addressLabel, 0, 2);
        grid.add(addressField, 1, 2);


        Label cityLabel = new Label("Miejscowość:");
        cityField = new TextField();
        grid.add(cityLabel, 0, 3);
        grid.add(cityField, 1, 3);


        Label phoneLabel = new Label("Telefon:");
        phoneField = new TextField();
        grid.add(phoneLabel, 0, 4);
        grid.add(phoneField, 1, 4);


        Label emailLabel = new Label("Email:");
        emailField = new TextField();
        grid.add(emailLabel, 0, 5);
        grid.add(emailField, 1, 5);

        submitButton = new Button("Zatwierdź");
        submitButton.setDisable(true);
        submitButton.setOnAction(e -> handleSubmit());
        resetButton = new Button("Reset");
        resetButton.setOnAction(e -> handleReset());
        grid.add(submitButton, 0, 6);
        grid.add(resetButton, 1, 6);


        enableSubmitButtonOnValidInput();

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void enableSubmitButtonOnValidInput() {
        submitButton.disableProperty().bind(
                firstNameField.textProperty().isEmpty()
                        .or(lastNameField.textProperty().isEmpty())
                        .or(addressField.textProperty().isEmpty())
                        .or(cityField.textProperty().isEmpty())
                        .or(phoneField.textProperty().isEmpty())
                        .or(emailField.textProperty().isEmpty())
        );
    }

    private void handleSubmit() {
        System.out.println("Formularz został zatwierdzony!");
    }

    private void handleReset() {

        firstNameField.clear();
        lastNameField.clear();
        addressField.clear();
        cityField.clear();
        phoneField.clear();
        emailField.clear();
    }
}
