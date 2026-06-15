import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class MainMenu extends Application {

    static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane mainMenu = new BorderPane();
        Scene scene = new Scene(mainMenu);


        //BorderPane Top Element
        VBox topArea = new VBox();
        Label programName = new Label("Password Manager");
        Line horizontalLine = new Line(0, 10, 900, 10);
        topArea.getChildren().addAll(programName, horizontalLine);
        topArea.setPrefSize(900, 30);
        programName.setPadding(new Insets(0,0,10,0));
        mainMenu.setTop(topArea);


        //BorderPane Left Element
        AnchorPane leftArea = new AnchorPane();
        Label categoryOptions = new Label("Category Options");
        Button addCategory = new Button("+");
        Button removeCategory = new Button("-");
        Line leftVerticalLine = new Line(200,0,200,470);
        leftArea.setPrefSize(200,470);
        leftArea.getChildren().addAll(categoryOptions, addCategory, removeCategory, leftVerticalLine);
        mainMenu.setLeft(leftArea);

        //Sizes of left elements
        addCategory.setPrefSize(30, 30);
        removeCategory.setPrefSize(30, 30);
        categoryOptions.setPrefSize(120,20);

        //Positions of left elements
        categoryOptions.setLayoutX(5);
        categoryOptions.setLayoutY(0);
        addCategory.setLayoutX(5);
        addCategory.setLayoutY(20);
        removeCategory.setLayoutX(45);
        removeCategory.setLayoutY(20);

        //Tooltips for left elements
        Tooltip addCatTooltip = new Tooltip("Click this to add a new category");
        Tooltip remCatTooltip = new Tooltip("Click this to remove a category");
        addCategory.setTooltip(addCatTooltip);
        removeCategory.setTooltip(remCatTooltip);


        //BorderPane Center Element
        VBox centerArea = new VBox();
        Button mainCategory = new Button("Main");
        centerArea.getChildren().addAll(mainCategory);
        //centerArea.setPadding(new Insets(0, 20, 0,0));
        mainMenu.setCenter(centerArea);

        //Sizes of center elements
        centerArea.setPrefSize(400, 470);
        mainCategory.setPrefSize(400, 30);


        //BorderPane Right Element
        AnchorPane rightArea = new AnchorPane();
        Label entryOptions = new Label("Entry Options");
        Button addEntry = new Button("+");
        Button removeEntry = new Button("-");
        Button viewEntries = new Button("View");
        Line rightVerticalLine = new Line(0, 0, 0, 470);
        rightArea.setPrefSize(300, 470);
        rightArea.getChildren().addAll(entryOptions, addEntry, removeEntry, viewEntries, rightVerticalLine);
        mainMenu.setRight(rightArea);

        //Sizes of right elements
        addEntry.setPrefSize(30, 30);
        removeEntry.setPrefSize(30, 30);
        entryOptions.setPrefSize(120,20);
        viewEntries.setPrefSize(50,30);

        //Positions of right elements
        entryOptions.setLayoutX(5);
        entryOptions.setLayoutY(0);
        addEntry.setLayoutX(5);
        addEntry.setLayoutY(20);
        removeEntry.setLayoutX(45);
        removeEntry.setLayoutY(20);
        viewEntries.setLayoutX(85);
        viewEntries.setLayoutY(20);

        //Tooltips for right elements
        Tooltip addEntryTooltip = new Tooltip("Click this to add a new entry");
        Tooltip remEntryTooltip = new Tooltip("Click this to remove an entry");
        Tooltip viewEntriesTooltip = new Tooltip("Click this to view your entries");
        addEntry.setTooltip(addEntryTooltip);
        removeEntry.setTooltip(remEntryTooltip);
        viewEntries.setTooltip(viewEntriesTooltip);

        //Event Handlers
        List<String> data = new ArrayList<>(); //List for all entries
        addEntry.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try{
                    String entry = "";
                    String application = PopUpFx.readLine("Enter the name of the website/app.");
                    entry += application + ",";
                    String username = PopUpFx.readLine("Enter your username.");
                    entry += username + ",";
                    String password = PopUpFx.readLine("Enter your password.");
                    entry += password;
                    data.add(entry);
                    Files.write(Paths.get("src/textFiles/PasswordEntries.txt"), data, StandardOpenOption.APPEND);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        });
        viewEntries.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //New Stage + Scene
                ScrollPane viewingEntries = new ScrollPane();
                viewingEntries.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
                Stage viewStage = new Stage();
                viewStage.setScene(new Scene(viewingEntries, 500, 600));
                viewStage.show();

                //
            }
        });

//        //BorderPane Elements
//        //Top Element
//        HBox topArea = new HBox();
//        Label programName = new Label("Password Manager.");
//        topArea.getChildren().add(programName);
//        mainMenu.setTop(topArea);
//        topArea.setPrefHeight(30);
//
//        //Left Element
//        AnchorPane anchorPaneLeft = new AnchorPane();
//        Label categoryOptions = new Label("Category Options:");
//        Button addCategory = new Button("+");
//        Button removeCategory = new Button("-");
//        anchorPaneLeft.getChildren().addAll(addCategory, removeCategory, categoryOptions);
//        mainMenu.setLeft(anchorPaneLeft);
//
//
//        //Button und Label placement and width (for anchorPaneLeft)
//        categoryOptions.setLayoutX(0);
//        categoryOptions.setLayoutY(20);
//        addCategory.setLayoutX(0);
//        addCategory.setLayoutY(40);
//        removeCategory.setLayoutX(40);
//        removeCategory.setLayoutY(40);
//        addCategory.setPrefWidth(30);
//        removeCategory.setPrefWidth(30);
//
//        //Button Tooltip (for anchorPaneLeft)
//        Tooltip addCatTooltip = new Tooltip("Click this to create a new Category");
//        Tooltip remCatTooltip = new Tooltip("Click this to remove a Category");
//        addCategory.setTooltip(addCatTooltip);
//        removeCategory.setTooltip(remCatTooltip);
//
//        //Right Element
//        AnchorPane anchorPaneRight = new AnchorPane();
//        Label entryOptions = new Label("Entry Options:");
//        Button addEntry = new Button("+");
//        Button removeEntry = new Button("-");
//        anchorPaneRight.getChildren().addAll(addEntry, entryOptions, removeEntry);
//        mainMenu.setRight(anchorPaneRight);
//
//        //Button und Label placement and width (for anchorPaneRight)
//        entryOptions.setLayoutX(430);
//        entryOptions.setLayoutY(20);
//        addEntry.setLayoutX(430);
//        addEntry.setLayoutY(40);
//        removeEntry.setLayoutX(430);
//        removeEntry.setLayoutY(40);
//        addEntry.setPrefWidth(30);
//        removeEntry.setPrefWidth(30);
//
//        //Button Tooltip (for anchorPaneRight)
//        Tooltip addEntTooltip = new Tooltip("Click this to create a new Entry");
//        Tooltip remEntTooltip = new Tooltip("Click this to remove an Entry");
//        addEntry.setTooltip(addEntTooltip);
//        removeEntry.setTooltip(remEntTooltip);
//
//        //Center Element
//        VBox categories = new VBox();
//        Button mainCategory = new Button("Main");
//        categories.getChildren().add(mainCategory);
//        mainMenu.setCenter(categories);
//        categories.setPadding(new Insets(20,10,0,10));


        stage.setTitle("Password Manager");
        stage.setScene(scene);
        stage.show();
    }
}
