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
import java.util.Set;

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

        //default Main Category
        Category mainCat = new Category();

        //Event Handlers
        List<String> data = new ArrayList<>(); //List for all entries
        addEntry.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try{
                    String entry = "";
                    Entry newEntry = new Entry();

                    String application = PopUpFx.readLine("Enter the name of the website/app.");
                    entry += application + ",";
                    newEntry.setApplication(application);

                    String username = PopUpFx.readLine("Enter your username.");
                    entry += username + ",";
                    newEntry.setUsername(username);

                    String password = PopUpFx.readLine("Enter your password.");
                    entry += password;
                    newEntry.setPassword(password);


                    data.add(entry);
                    mainCat.addEntry(newEntry);
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
                VBox view = new VBox();
                ScrollPane viewingEntries = new ScrollPane(view);
                viewingEntries.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
                Stage viewStage = new Stage();
                viewStage.setScene(new Scene(viewingEntries, 500, 600));



                int labelsCreated = 0;
                int categoryEntries = mainCat.getContents().size(); //amount of entries in the category
                List<Entry> contents = mainCat.getContents(); //List of entries in the category
                while(labelsCreated < categoryEntries){
                    Label newLabel = new Label("Entry " + (labelsCreated+1));
                    Label websiteOrApp = new Label("Website/Application: " + contents.get(labelsCreated).getApplication());
                    Label username = new Label("Username: " + contents.get(labelsCreated).getUsername());
                    Label password = new Label("Password: " + contents.get(labelsCreated).getPassword());
                    Label space = new Label(" ");

                    view.getChildren().addAll(newLabel, websiteOrApp, username, password, space);
                    labelsCreated++;
                }
                viewStage.show();
            }
        });



        stage.setTitle("Password Manager");
        stage.setScene(scene);
        stage.show();
    }
}
