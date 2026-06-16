import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Login{

    private Stage stage;

    public Login() {

        stage = new Stage();

        Label lblTitle = new Label("Password Manager Login");

        TextField txtUsername = new TextField();
        txtUsername.setPromptText("Benutzername");

        PasswordField txtPassword = new PasswordField();
        txtPassword.setPromptText("Master Passwort");

        Button btnLogin = new Button("Login");

        btnLogin.setOnAction(e -> {
        

            String username = txtUsername.getText();
            String password = txtPassword.getText();

            // Vorläufige Testdaten
            if(username.equals("admin") &&
               password.equals("1234")) {

                stage.close();

                try {
                    MainMenu menu = new MainMenu();
                    menu.start(new Stage());
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }

            } else {
                PopUpFx.print("Login fehlgeschlagen!");
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
