package front;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class MyMenuBar extends MenuBar{
	
	public MyMenuBar(int width) {
		
		Menu menuFichier = new Menu("Fichier");
		MenuItem fichierNouveau = new MenuItem("Nouveau");
		
		MenuItem fichierOuvrir = new MenuItem("Ouvrir");
		fichierOuvrir.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				FileChooser filechooser = new FileChooser();
				filechooser.setTitle("Ouvrir");
				filechooser.getExtensionFilters().addAll(
						new ExtensionFilter("Fichier text","*.txt"),
						new ExtensionFilter("Fichier HQL","*.hql"),
						new ExtensionFilter("Fichier SQL","*.sql"));
				File selectedFile = filechooser.showOpenDialog(getScene().getWindow());
			}
		});
		
		MenuItem fichierEnregistrer = new MenuItem("Enregistrer sous");
		
		
		MenuItem fichierQuitter = new MenuItem("Quitter");
		fichierQuitter.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				getScene().getWindow().hide();
			}
		});;
		menuFichier.getItems().addAll(fichierNouveau,fichierOuvrir,fichierEnregistrer,new SeparatorMenuItem(),fichierQuitter);
		
		this.getMenus().addAll(menuFichier);
		this.setWidth(width);
	}
}
