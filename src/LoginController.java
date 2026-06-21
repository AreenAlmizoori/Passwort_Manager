import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label statusLabel;

    private UserManager userManager = new UserManager();

    @FXML
    public void onLogin() {

        String user = usernameField.getText();
        String pass = passwordField.getText();

        if (userManager.login(user, pass)) {
            statusLabel.setText("Login erfolgreich");
        } else {
            statusLabel.setText("Falsche Daten");
        }
    }

    @FXML
    public void onRegister() {

        String user = usernameField.getText();
        String pass = passwordField.getText();

        userManager.saveUser(new User(user, pass));

        statusLabel.setText("User erstellt");
    }
}