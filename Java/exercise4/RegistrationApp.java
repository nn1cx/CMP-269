import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class RegistrationApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        Label studentName = new Label("Student Name:");
        TextField studentNameField = new TextField();
        
        Label courseName = new Label("Course Name:");
        TextField courseNameField = new TextField();

        Label result = new Label("");

        Button registerButton = new Button("Register");
        registerButton.setOnAction(e -> result.setText("Registration Successful for " + studentNameField.getText() + " in " + courseNameField.getText() + "!"));

        grid.add(studentName, 0, 0);
        grid.add(studentNameField, 1, 0);
        grid.add(courseName, 0, 1);
        grid.add(courseNameField, 1, 1);
        grid.add(registerButton, 0, 2);
        grid.add(result, 0, 3);

        Scene scene = new Scene(grid, 400, 250);
        primaryStage.setTitle("Lehman Course Registration");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
