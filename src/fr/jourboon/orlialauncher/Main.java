package fr.jourboon.orlialauncher;

import javax.swing.JOptionPane;

import fr.arinonia.arilibfx.utils.AriLogger;
import javafx.application.Application;

public class Main {

	public static AriLogger logger;
	
	public static void main(String[] args) {
	
		logger = new AriLogger("Orlia");
		try {
			Class.forName("javafx.application.Application");
			Application.launch(FxApplication.class, args);
		}catch (ClassNotFoundException e) {
			logger.warn("JavaFX not found.. oh fuck");
			JOptionPane.showMessageDialog(null, "Une erreur avec Java a été detéctée.\n" + e.getMessage() + " Not Found", "Erreur Java", JOptionPane.ERROR_MESSAGE);
		}
	}

}
