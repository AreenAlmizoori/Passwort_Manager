import javafx.application.Application;
import javafx.stage.Stage;

public class StartApp extends Application {

    @Override
    public void start(Stage primaryStage) {

        LoginWindow login = new LoginWindow();
        login.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
