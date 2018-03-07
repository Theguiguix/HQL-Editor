package front;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class Explorateur extends Stage{
	
	private static volatile Explorateur instance = null;
	
	public Explorateur() {
		super();
		Scene scene = new Scene(null);

        setTitle("Explorateur"); 
        setScene(scene); 
        sizeToScene(); 
        show(); 
		
	}
	
	public static Explorateur getInstance() {
		if(Explorateur.instance == null) {
			synchronized (Explorateur.class) {
				Explorateur.instance = new Explorateur();
			}
		}
		return Explorateur.instance;
	}		
}
