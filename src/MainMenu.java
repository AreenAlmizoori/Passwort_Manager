import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainMenu extends Application {

    static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane mainMenu = new BorderPane();
        Scene scene = new Scene(mainMenu, 900, 500);

        //Top Element
        HBox topArea = new HBox();
        Label programName = new Label("Password Manager.");
        topArea.getChildren().add(programName);

        //Left Element
        AnchorPane anchorPaneLeft = new AnchorPane();
        Button addCategory = new Button("+");
        Button removeCategory = new Button("-");


        stage.setTitle("Password Manager");
        stage.setScene(scene);
        stage.show();
    }
}
