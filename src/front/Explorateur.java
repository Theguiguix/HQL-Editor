package front;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Explorateur extends TableView<Object>{
	
	private static volatile Explorateur instance = null;
	
	public static Explorateur getInstance() {
		if(Explorateur.instance == null) {
			synchronized (Explorateur.class) {
				Explorateur.instance = new Explorateur();
			}
		}
		return Explorateur.instance;
	}
	
	public Explorateur() {
		super();
		TableColumn TableQuad = new TableColumn<>("Quadrigramme");
		TableQuad.prefWidthProperty().bind(this.widthProperty().multiply(0.1));
		TableColumn TableName = new TableColumn<>("Table");
		TableName.prefWidthProperty().bind(this.widthProperty().multiply(0.45));
		TableColumn TableDesc = new TableColumn<>("Description");
		TableDesc.prefWidthProperty().bind(this.widthProperty().multiply(0.45));
		this.getColumns().addAll(TableQuad,TableName,TableDesc);
		
	}
}
