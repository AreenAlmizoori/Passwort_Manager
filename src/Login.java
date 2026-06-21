import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Login {

    private Stage stage;

    public Login() {

        stage = new Stage();

        Label lblTitle = new Label("Password Manager Login");

        TextField txtUsername = new TextField();
        txtUsername.setPromptText("Username");

        PasswordField txtPassword = new PasswordField();
        txtPassword.setPromptText("Master Password");

        Button btnLogin = new Button("Login");

        btnLogin.setOnAction(e -> {

            String username = txtUsername.getText();
            String password = txtPassword.getText();

            if(username.isBlank() || password.isBlank()){
                PopUpFx.print("Please enter username and password.");
                return;
            }

            try {

                Path path = Paths.get("src/textFiles/MasterData.txt");

                // Falls Datei nicht existiert, wird sie erstellt
                if(!Files.exists(path)){
                    Files.createFile(path);
                }

                // Registrieren falls Datei leer ist
                if(Files.size(path) == 0){

//                    String hashedPassword =
//                            PasswordHasher.hash(password);
                    String hashedPassword = password.hashCode()+"";

                    //String data = username + ";" + password.hashCode();
                    String data = username + ";" + hashedPassword;


                    Files.writeString(path, data);

                    PopUpFx.print("User successfully created!");

                    stage.close();

                    MainMenu menu = new MainMenu();
                    menu.start(new Stage());

                } else {

                    // Login überprüfen
                    String fileContent =
                            Files.readString(path);

                    String[] parts =
                            fileContent.split(";");

                    String savedUsername = parts[0];
                    String savedHash = parts[1];

                    String enteredHash = password.hashCode()+"";

                    if(username.equals(savedUsername)
                            && enteredHash.equals(savedHash)) {

                        PopUpFx.print("Login successful!");

                        stage.close();

                        MainMenu menu = new MainMenu();
                        menu.start(new Stage());

                    } else {

                        PopUpFx.print("Login failed!");

                    }
                }

            } catch (IOException ex) {

                ex.printStackTrace();
                PopUpFx.print("Error while accessing file.");

            } catch (Exception ex){

                ex.printStackTrace();
                PopUpFx.print("Unexpected error occurred.");

            }

        });

        VBox root = new VBox(10);
        root.setPadding(new Insets(15));

        root.getChildren().addAll(
                lblTitle,
                txtUsername,
                txtPassword,
                btnLogin
        );

        Scene scene = new Scene(root, 300, 200);

        stage.setTitle("Login");
        stage.setScene(scene);
    }

    public void show() {
        stage.show();
    }
}