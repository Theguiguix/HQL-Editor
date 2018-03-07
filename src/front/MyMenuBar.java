package front;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import main.Instance;

public class MyMenuBar extends MenuBar{
	
	public MyMenuBar(int width) {
		
		Menu menuFichier = new Menu("Fichier");
		MenuItem fichierNouveau = new MenuItem("Nouveau");
		
		// setting-up button open file in tool bar
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
				BufferedReader reader = null;
				try {
					reader = new BufferedReader(new FileReader(selectedFile));
					String line;
					while((line = reader.readLine()) != null) {
						main.Instance.getTextArea().appendText(line + "\n");
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		//setting-up save button in tool bar
		MenuItem fichierEnregistrer = new MenuItem("Enregistrer sous");
		fichierEnregistrer.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				FileChooser filechooser = new FileChooser();
				filechooser.setTitle("Enregistrer sous");
				filechooser.getExtensionFilters().addAll(
						new ExtensionFilter("Fichier text","*.txt"),
						new ExtensionFilter("Fichier HQL","*.hql"),
						new ExtensionFilter("Fichier SQL","*.sql"));
				File selectedFile = filechooser.showSaveDialog(getScene().getWindow());
				BufferedWriter writer = null;
				if(selectedFile != null) {
					ObservableList<CharSequence> paragraph = Instance.getTextArea().getParagraphs();
				    Iterator<CharSequence>  iter = paragraph.iterator();
				    
					try {
						writer = new BufferedWriter(new FileWriter(selectedFile));
						while(iter.hasNext()) {
							writer.append(iter.next());
							writer.newLine();
						}
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
							writer.flush();
							writer.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		
		// setting-up Quit button from tool bar
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
