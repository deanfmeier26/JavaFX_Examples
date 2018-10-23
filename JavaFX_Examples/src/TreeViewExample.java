import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TreeViewExample extends Application {

	Stage window;
	TreeView<String> tree;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Tree View Example");
		
		TreeItem<String> root, dean, zack;
		
		// Root
		root = new TreeItem<>();
		root.setExpanded(true);
		
		// Dean
		dean = makeBranch("Dean", root);
		makeBranch("YouTube", dean);
		makeBranch("Steam", dean);
		makeBranch("Codepen", dean);
		
		
		// Zack
		zack = makeBranch("Zack", root);
		makeBranch("YouTube", zack);
		makeBranch("Warframe", zack);
		makeBranch("Steam", zack);
		
		// Create Tree
		tree = new TreeView<>(root);
		tree.setShowRoot(false);
		tree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
			if (newValue != null) {
				System.out.println(newValue.getValue());
			}
		});		
		
		
		// Layout
		StackPane layout = new StackPane();
		layout.getChildren().add(tree);
		Scene scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();
	}
	
	// Create branches
	public TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
		TreeItem<String> item =  new TreeItem<>(title);
		item.setExpanded(true);
		parent.getChildren().add(item);
		
		return item;
	}
	
	
	
	
	
	

}
