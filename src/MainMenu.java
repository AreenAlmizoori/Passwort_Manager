import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
        topArea.setPrefSize(900, 30);

        //Left Element
        AnchorPane anchorPaneLeft = new AnchorPane();
        Label categoryOptions = new Label("Category Options:");
        Button addCategory = new Button("+");
        Button removeCategory = new Button("-");
        anchorPaneLeft.getChildren().addAll(addCategory, removeCategory, categoryOptions);
        mainMenu.setLeft(anchorPaneLeft);

        //Button und Label placement and width (for anchorPaneLeft)
        categoryOptions.setLayoutX(0);
        categoryOptions.setLayoutY(20);
        addCategory.setLayoutX(0);
        addCategory.setLayoutY(40);
        removeCategory.setLayoutX(40);
        removeCategory.setLayoutY(40);
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
        entryOptions.setLayoutX(680);
        entryOptions.setLayoutY(20);
        addEntry.setLayoutX(680);
        addEntry.setLayoutY(40);
        removeEntry.setLayoutX(720);
        removeEntry.setLayoutY(40);
        addEntry.setPrefWidth(30);
        removeEntry.setPrefWidth(30);

        //Button Tooltip (for anchorPaneRight)
        Tooltip addEntTooltip = new Tooltip("Click this to create a new Entry");
        Tooltip remEntTooltip = new Tooltip("Click this to remove an Entry");
        addEntry.setTooltip(addEntTooltip);
        removeEntry.setTooltip(remEntTooltip);

        //Center Element
        VBox categories = new VBox();
        Button mainCategory = new Button("Main");
        categories.getChildren().add(mainCategory);
        mainMenu.setCenter(categories);
        categories.setPadding(new Insets(20,10,0,10));


        stage.setTitle("Password Manager");
        stage.setScene(scene);
        stage.show();
    }
}
