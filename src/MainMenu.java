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

        //BorderPane Elements
        //Top Element
        HBox topArea = new HBox();
        Label programName = new Label("Password Manager.");
        topArea.getChildren().add(programName);
        mainMenu.setTop(topArea);

        //Left Element
        AnchorPane anchorPaneLeft = new AnchorPane();
        Button addCategory = new Button("+");
        Button removeCategory = new Button("-");
        anchorPaneLeft.getChildren().addAll(addCategory, removeCategory);
        mainMenu.setLeft(anchorPaneLeft);

        //Button placement and width
        addCategory.setLayoutX(0);
        addCategory.setLayoutY(50);
        removeCategory.setLayoutX(40);
        removeCategory.setLayoutY(50);
        addCategory.setPrefWidth(30);
        removeCategory.setPrefWidth(30);




        stage.setTitle("Password Manager");
        stage.setScene(scene);
        stage.show();
    }
}
