package ca.bcit.comp1510.lab7;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * PasswordValidator Takes user's password and validates it.
 * 
 * @author Nirajan Manandhar
 * @version 1.0
 */
public class PasswordValidator extends Application {
    
    /**
     * Holds the TextField with the first password.
     */
    private TextField password;
    
    /**
     * Holds the TextField witht the second password.
     */
    private TextField password2;
    
    /**
     * Holds the result for the result.
     */
    private Label result;

    /**
     * Start method.
     * @param primaryStage a stage
     * @throws Exception unused
     */
    public void start(Stage primaryStage) throws Exception {
 
        final int appWidth = 230;
        final int appHeight = 100;
        final int width = 120;

        GridPane grid = new GridPane();

        Label inputLabel = new Label("Enter Password: ");
        GridPane.setHalignment(inputLabel, HPos.LEFT);

        Label inputLabel2 = new Label("Confirm Password: ");
        GridPane.setHalignment(inputLabel2, HPos.LEFT);

        password = new TextField();
        password.setPrefWidth(width);

        password2 = new TextField();
        password2.setPrefWidth(width);

        result = new Label("---");
        GridPane.setHalignment(result, HPos.CENTER);

        Button submit = new Button("Submit");
        GridPane.setHalignment(submit, HPos.CENTER);
        submit.setOnAction(this::validatePassword);

        grid.add(inputLabel, 0, 0);
        grid.add(password, 1, 0);
        grid.add(inputLabel2, 0, 1);
        grid.add(password2, 1, 1);
        grid.add(submit, 0, 2);
        grid.add(result, 1, 2);

        Scene scene = new Scene(grid, appWidth, appHeight);
        primaryStage.setTitle("Password Validator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Event handler for the submit button.
     * 
     * @param event
     *            invokes this method
     */
    public void validatePassword(ActionEvent event) {

        String first = password.getText();
        String second = password2.getText();

        if (first.equals(second)) {
            result.setText("VALID");
        } else {
            result.setText("INVALID");
        }
    }

    /**
     * Runs the program.
     * 
     * @param args
     *            unused.
     */
    public static void main(String[] args) {
        launch(args);
    }

}
