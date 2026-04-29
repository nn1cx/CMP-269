import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatApp extends Application {

    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int PORT = 59001;

    private String username;
    private TextArea chatLog = new TextArea();
    private PrintWriter writer;
    private TextField message = new TextField();
    private Label userName = new Label("User:");
    private Socket socket;

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        //setting the title
        Label title = new Label("Lehman Multi-Platform Chat System");
        root.setTop(title);
        BorderPane.setAlignment(title, Pos.CENTER);

        //setting the text area as uneditable
        Label chatRoomLabel = new Label("Chat Room");
        chatLog.setPrefSize(400, 500);
        chatLog.setEditable(false);
        chatLog.setWrapText(true);

        VBox chatArea = new VBox(chatRoomLabel, chatLog);
        chatArea.setPadding(new Insets(10, 10, 10, 10));
        root.setCenter(chatArea);

        //creating HBox for text input at the bottom
        userName.setPadding(new Insets(0, 10, 10, 10));

        message.setPrefWidth(390);
        HBox messageArea = new HBox(message);
        messageArea.setPadding(new Insets(0, 10, 10, 0));

        Button sendButton = new Button("Send");
        sendButton.setOnAction(e -> sendMessage());
        message.setOnAction(e -> sendMessage());

        HBox chatBox = new HBox(userName, messageArea, sendButton);
        root.setBottom(chatBox);

        username = askForUsername();
        userName.setText(username + ":");

        connectToServer();

        //creates the window and makes it visible
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Lehman Multi-Platform Chat System");
        primaryStage.show();

        primaryStage.setOnCloseRequest(e -> shutdown());
    }

    private void shutdown() {
        try {
            if (writer != null) {
                writer.println("QUIT"); // Notify server before disconnecting
            }
            if (socket != null && !socket.isClosed()) {
                socket.close(); // Closing socket ends the reader loop in connectToServer()
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            Platform.exit();
        }
    }

    private String askForUsername() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Set Your Username");
        dialog.setHeaderText("SERVER: Enter your username:");
        dialog.setContentText("Username:");
        return dialog.showAndWait().orElse("Anonymous");
    }


    private void connectToServer() {
        new Thread(() -> {
            try {
                socket = new Socket(SERVER_ADDRESS, PORT);
                writer = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // Send username to server
                reader.readLine(); // read "Enter your username:" prompt
                writer.println(username);

                // Listen for incoming messages
                String message;
                while ((message = reader.readLine()) != null) {
                    String finalMessage = message;
                    Platform.runLater(() -> chatLog.appendText(finalMessage + "\n"));
                }

            } catch (IOException e) {
                Platform.runLater(() -> chatLog.appendText("Could not connect to server.\n"));
            }
        }).start();
    }

    private void sendMessage() {
        String userMessage = message.getText().trim();
        if (!userMessage.isEmpty() && writer != null) {
            if (userMessage.equalsIgnoreCase("QUIT")) {
                shutdown();
                return;
            }
            writer.println(userMessage);
            message.clear();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
