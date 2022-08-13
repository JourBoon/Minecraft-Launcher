package fr.jourboon.orlialauncher;

import fr.jourboon.orlialauncher.ui.PanelManager;
import fr.jourboon.orlialauncher.ui.panels.PanelLogin;
import javafx.stage.Stage;

public class OrliaLauncher {
	
	private PanelManager panelManager;
	
	public void init(Stage stage) {
		this.panelManager = new PanelManager(this, stage);
		this.panelManager.init();
		this.panelManager.showPanel(new PanelLogin());
		
	}
}
