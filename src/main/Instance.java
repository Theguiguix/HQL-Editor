package main;

import front.Explorateur;
import front.MyMenuBar;
import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class Instance extends Application{
	
	private static TextArea editor;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage stage) {
		// set property of window
		stage.setTitle("HQL editor");
		stage.setMaximized(true);
		
		// create & fill vbox
		editor = new TextArea();
		HBox hbox = new HBox(5,editor);
		hbox.getChildren().add(Explorateur.getInstance());
		
		// set property of HBox
		HBox.setHgrow(editor, Priority.ALWAYS);
		HBox.setHgrow(Explorateur.getInstance(), Priority.ALWAYS);
		hbox.setPadding(new Insets(0,10,10,10));
		
		// create, fill & set property of Vbox
		VBox vbox = new VBox(5,new MyMenuBar(600));
		vbox.getChildren().add(hbox);
		VBox.setVgrow(hbox, Priority.ALWAYS);
		
		// instantiate main scene
		StackPane rootPane = new StackPane(vbox);
		Scene scene = new Scene(rootPane);
        stage.setScene(scene);
        
        stage.show();
    }
	
	public static TextArea getTextArea() {
		return editor;
	}
}
