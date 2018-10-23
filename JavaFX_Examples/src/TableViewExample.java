import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableViewExample extends Application {

	Stage window;
	TableView<Product> table;
	TextField nameInput, priceInput, amountInput;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Table ViewExample");
		
		// Name Column
		TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setMinWidth(200);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		// Price Column
		TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
		priceColumn.setMinWidth(100);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		// Price Column
		TableColumn<Product, Integer> amountColumn = new TableColumn<>("Amount");
		amountColumn.setMinWidth(100);
		amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
		
		// Name Input
		nameInput = new TextField();
		nameInput.setPromptText("Name");
		nameInput.setMinWidth(100);
		
		// Price Input
		priceInput = new TextField();
		priceInput.setPromptText("Price");
		
		// Amount Input
		amountInput = new TextField();
		amountInput.setPromptText("Amount");
		
		// Buttons
		Button addButton = new Button("Add");
		addButton.setOnAction(e -> addButtonClicked());
		Button deleteButton = new Button("Delete");
		deleteButton.setOnAction(e -> deleteButtonClicked());
		
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(10, 10, 10, 10));
		hBox.setSpacing(10);
		hBox.getChildren().addAll(nameInput, priceInput, amountInput, addButton, deleteButton);
		
		
		table = new TableView<>();
		table.setItems(getProduct());
		table.getColumns().addAll(nameColumn, priceColumn, amountColumn);
		
		
		VBox vBox = new VBox();
		vBox.getChildren().addAll(table, hBox);
		
		Scene scene = new Scene(vBox);
		window.setScene(scene);
		window.show();
	}
	
	// Add Button Clicked
	public void addButtonClicked() {
		Product product = new Product();
		product.setName(nameInput.getText());
		product.setPrice(Double.parseDouble(priceInput.getText()));
		product.setAmount(Integer.parseInt(amountInput.getText()));
		table.getItems().add(product);
		nameInput.clear();
		priceInput.clear();
		amountInput.clear();
	}
	
	// Delete Button Clicked
	public void deleteButtonClicked() {
		ObservableList<Product> productSelected, allProducts;
		allProducts = table.getItems();
		productSelected = table.getSelectionModel().getSelectedItems();
		
		productSelected.forEach(allProducts::remove);
	}
	
	
	
	public ObservableList<Product> getProduct() {
		ObservableList<Product> products = FXCollections.observableArrayList();
		products.add(new Product("Laptop", 859.00, 20));
		products.add(new Product("Monitor", 324.99, 32));
		products.add(new Product("Desktop", 1140.45, 10));
		products.add(new Product("Mouse", 39.99, 50));
		products.add(new Product("Keyboard", 70.00, 64));
		return products;
	}
	
	
	
	

}
