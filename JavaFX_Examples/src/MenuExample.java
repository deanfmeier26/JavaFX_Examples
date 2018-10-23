import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuExample extends Application {

	Stage window;
	BorderPane layout;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Making Menus Example");
		
		// File Menu
		Menu fileMenu = new Menu("File");
		
		// File Menu Items
		MenuItem newFile = new MenuItem("New...");
		newFile.setOnAction(e -> System.out.println("Created a new file..."));
		fileMenu.getItems().add(newFile);
		
		fileMenu.getItems().add(new MenuItem("Open..."));
		fileMenu.getItems().add(new MenuItem("Save..."));
		fileMenu.getItems().add(new SeparatorMenuItem());
		fileMenu.getItems().add(new MenuItem("Settings..."));
		fileMenu.getItems().add(new SeparatorMenuItem());
		fileMenu.getItems().add(new MenuItem("Exit..."));
		
		// Edit Menu
		Menu editMenu = new Menu("_Edit");
		
		// Edit Menu Items
		MenuItem undoTyping = new MenuItem("Undo Typing");
		undoTyping.setOnAction(e -> System.out.println("Undo Previously Typed Text..."));
		editMenu.getItems().add(undoTyping);
		undoTyping.setDisable(true);
		
		editMenu.getItems().add(new MenuItem("Cut"));
		editMenu.getItems().add(new MenuItem("Copy"));
		editMenu.getItems().add(new MenuItem("Paste"));
		
		
		// Main Menu Bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, editMenu);
		
		
		layout = new BorderPane();
		layout.setTop(menuBar);
		Scene scene =  new Scene(layout, 400, 300);
		window.setScene(scene);
		window.show();
	}

}
