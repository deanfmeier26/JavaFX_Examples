import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage; 

public class ChoiceBoxExample extends Application {

	Stage window;
	Scene scene;
	Button button;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Choicebox Example");
		button = new Button("Click Me");
		
		// Choicebox
		ChoiceBox<String> choices = new ChoiceBox<>();
		
		// getItems returns the ObservableList object which you can add items to
		choices.getItems().add("Apples");
		choices.getItems().add("Bananas");
		choices.getItems().addAll("Oranges", "Pears");
		choices.setValue("Apples");
		
		// Listen for selection changes
		choices.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> System.out.println(oldValue + " to " + newValue) );
		
		
		
		// button.setOnAction(e -> getChoice(choices));
		
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20,20,20,20));
		layout.getChildren().addAll(choices, button);
		
		scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();
	}
	
	/*
	private void getChoice(ChoiceBox<String> choice) {
		String food = choice.getValue();
		System.out.println(food + "\n");
	}*/
	
	
	
	
	
	
	
	
	
	
	
}
