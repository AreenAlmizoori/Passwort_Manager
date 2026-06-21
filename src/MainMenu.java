import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
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
        mainMenu.setCenter(centerArea);

        //Sizes of center elements
        centerArea.setPrefSize(400, 470);
        mainCategory.setPrefSize(400, 30);


        //Event Handler for Main Category
        mainCategory.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //default Main Category
                Category mainCat = new Category();
                borderpaneRightElement(mainMenu, 0, mainCat);
            }
        });


        stage.setTitle("Main Menu");
        stage.setScene(scene);
        stage.show();
    }

    public void borderpaneRightElement(BorderPane mainMenu, int categoryNumber, Category category) {
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
        entryOptions.setPrefSize(120, 20);
        viewEntries.setPrefSize(50, 30);

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
        Path filePath = Paths.get("src/textFiles/PasswordEntries0.txt"); //Path for Data
        List<String> data = new ArrayList<>(); //List for all entries

        //adding entries
        addEntry.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try{
                    String entry = ""; //string of an entry to be added to the data list
                    Entry newEntry = new Entry(); //Entry object for the entry

                    entry += Entry.getEntryID() + ","; //adding the entry id to the string

                    //adding the application/website given by the user to the entry-string and Entry object
                    String application = PopUpFx.readLine("Enter the name of the website/app.");
                    entry += application + ",";
                    newEntry.setApplication(application);

                    //adding the username given by the user to the entry-string and Entry object
                    String username = PopUpFx.readLine("Enter your username.");
                    entry += username + ",";
                    newEntry.setUsername(username);

                    //adding the password given by the user to the entry-string and Entry object
                    String password = PopUpFx.readLine("Enter your password.");
                    entry += password;
                    newEntry.setPassword(password);


                    data.add(entry);
                    category.addEntry(newEntry);
                    Files.write(filePath, data); //writing data into the text file for all entries
                } catch (IOException e) {
                    System.out.println("Error by writing into file. " + e.getMessage());
                }
            }
        });

        viewEntries.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //New Stage + Scene for View Window
                VBox view = new VBox();
                ScrollPane viewingEntries = new ScrollPane(view);
                viewingEntries.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

                Stage viewStage = new Stage();
                viewStage.setScene(new Scene(viewingEntries, 500, 600));
                viewStage.setTitle("View Entries");



                int labelsCreated = 0; //amount of Label objects for entries created
                int categoryEntries = category.getContents().size(); //amount of entries in the category
                List<Entry> contents = category.getContents(); //List of entries in the category

                //in cases where the category has no entries, a separate window will be shown informing the user
                if(categoryEntries == 0){
                    Label noEntries = new Label("You currently have no entries.");
                    view.getChildren().add(noEntries);
                    viewStage.setMaxHeight(100);
                    viewStage.setMaxWidth(200);
                }

                //if the category has entries, then the entries will be displayed to the user
                while(labelsCreated < categoryEntries){
                    Label newLabel = new Label("Entry " + (contents.get(labelsCreated).getId()));
                    Label websiteOrApp = new Label("Website/Application: " + contents.get(labelsCreated).getApplication());
                    Label username = new Label("Username: " + contents.get(labelsCreated).getUsername());
                    Label password = new Label("Password: " + contents.get(labelsCreated).getPassword());
                    Label space = new Label(" "); //space to separate the entries from one another

                    viewStage.setMaxHeight(600);
                    viewStage.setMaxWidth(500);

                    view.getChildren().addAll(newLabel, websiteOrApp, username, password, space);
                    labelsCreated++;
                }

                viewStage.show();
            }
        });

        //removing entries
        removeEntry.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //creates new window for removing entries
                FlowPane removeEntryView = new FlowPane(Orientation.VERTICAL);
                Stage removeEntryStage = new Stage();
                removeEntryStage.setScene(new Scene(removeEntryView, 600, 200));
                removeEntryStage.setTitle("Remove Entries");

                Label instructions = new Label("Please enter the number of the password entry you want to delete (i.e. 1)");
                Label instructions2 = new Label("If you are unsure about which entries you already have saved, you can click on the view button in the main menu.");
                TextField deleteEntry = new TextField();
                Button delete = new Button("Delete"); //Button to delete the given entry


                //Action for delete Button
                delete.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        String deleteEntryText = deleteEntry.getText(); //input from user that says which entry to delete

                        try{
                            int entryID = Integer.parseInt(deleteEntryText.trim()); //input from user as an Integer
                            boolean foundEntry = false; //true, if the entry given by the user is found
                            List<String> lines = Files.readAllLines(filePath);
                            int index = 0; //gives the position of the current string in the list

                            //goes through the whole list, unless the given entry by the user is found
                            while(index < lines.size()){
                                String line = lines.get(index); //current String un list
                                int foundEntryID = Integer.parseInt(line.charAt(0)+""); //first char of line is always the entryID

                                //ends loop if entry given by user is found
                                if(foundEntryID == entryID){
                                    foundEntry = true;
                                    break;
                                }
                                index++;
                            }

                            int deleteLinePosition = 0; //position of entry that needs to be removed


                            //if an entry is found, it is removed from both the Category object and the text file
                            if(foundEntry){
                                List<String> newFile = new ArrayList<>(); //new file to rewrite old file disincluding the entry that needs to be deleted

                                while(deleteLinePosition < lines.size()){
                                    String line = lines.get(deleteLinePosition); //current entry in text file
                                    String[] entryAttributes = line.split(","); //splits entry from text file to the respective attributes for an Entry object

                                    //Entry object representing the current entry
                                    Entry currentEntry = new Entry(entryAttributes[1], entryAttributes[2], entryAttributes[3], Integer.parseInt(entryAttributes[0]));
                                    int currentLineID = Integer.parseInt(line.charAt(0)+""); //ID of current entry in text file


                                    if(currentLineID != entryID){
                                        //if the current entry isn't the one that should be deleted, then it should be written into the new text file
                                        newFile.add(line);
                                    }else{
                                        //if the current entry is the one that should be deleted, then it is removed from the category and not written into the new file
                                        category.removeEntry(currentEntry);
                                    }
                                    deleteLinePosition++;
                                }

                                Files.write(filePath, newFile); //new file overwriting the old file, disincluding the entry that the user wants to delete
                            }else{
                                //if the given entry by the user doesn't exist, then an error window will inform the user
                                FlowPane error = new FlowPane();
                                Stage errorStage = new Stage();
                                errorStage.setScene(new Scene(error, 200, 50));

                                Label entryNotFound = new Label("No entry with this ID was found.");
                                error.getChildren().addAll(entryNotFound);

                                errorStage.show();
                            }

                        } catch (NumberFormatException e) {
                            //if the user doesn't enter a number, then an error window will be shown, informing the user to enter a number
                            FlowPane exception = new FlowPane();
                            Stage exceptionStage = new Stage();
                            exceptionStage.setScene(new Scene(exception, 300, 50));
                            exceptionStage.setTitle("Error");

                            Label errorText = new Label("Invalid input. Please make sure to type a number.");
                            exception.getChildren().addAll(errorText);

                            exceptionStage.show();
                        }catch (IOException e){
                            //if an IOException occurs, then the following text will be printed into the console
                            System.out.println("Error from reading/writing text. " + e.getMessage());
                        }
                    }
                });

                removeEntryView.getChildren().addAll(instructions, instructions2, deleteEntry, delete);
                removeEntryStage.show();
            }
        });
    }
}
