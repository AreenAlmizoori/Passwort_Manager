import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
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
        Label categoryOptions = new Label("Category Options:");
        Button addCategory = new Button("+");
        Button removeCategory = new Button("-");
        anchorPaneLeft.getChildren().addAll(addCategory, removeCategory, categoryOptions);
        mainMenu.setLeft(anchorPaneLeft);

        //Button und Label placement and width (for anchorPaneLeft)
        categoryOptions.setLayoutX(0);
        categoryOptions.setLayoutY(30);
        addCategory.setLayoutX(0);
        addCategory.setLayoutY(50);
        removeCategory.setLayoutX(40);
        removeCategory.setLayoutY(50);
        addCategory.setPrefWidth(30);
        removeCategory.setPrefWidth(30);

        //Button Tooltip (for anchorPaneLeft)
        Tooltip addCatTooltip = new Tooltip("Click this to create a new Category");
        Tooltip remCatTooltip = new Tooltip("Click this to remove a Category");
        addCategory.setTooltip(addCatTooltip);
        removeCategory.setTooltip(remCatTooltip);

        //Right Element
        AnchorPane anchorPaneRight = new AnchorPane();
        Label entryOptions = new Label("Entry Options:");
        Button addEntry = new Button("+");
        Button removeEntry = new Button("-");
        anchorPaneRight.getChildren().addAll(addEntry, removeEntry, entryOptions);
        mainMenu.setRight(anchorPaneRight);

        //Button und Label placement and width (for anchorPaneRight)
        entryOptions.setLayoutX(690);
        entryOptions.setLayoutY(30);
        addEntry.setLayoutX(690);
        addEntry.setLayoutY(50);
        removeEntry.setLayoutX(730);
        removeEntry.setLayoutY(50);
        addEntry.setPrefWidth(30);
        removeEntry.setPrefWidth(30);

        //Button Tooltip (for anchorPaneRight)
        Tooltip addEntTooltip = new Tooltip("Click this to create a new Entry");
        Tooltip remEntTooltip = new Tooltip("Click this to remove an Entry");
        addEntry.setTooltip(addEntTooltip);
        removeEntry.setTooltip(remEntTooltip);

        stage.setTitle("Password Manager");
        stage.setScene(scene);
        stage.show();
    }
}
