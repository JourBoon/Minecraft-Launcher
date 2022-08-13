package fr.jourboon.orlialauncher.ui.panel;

import fr.jourboon.orlialauncher.ui.PanelManager;
import javafx.scene.layout.GridPane;

public interface IPanel {

	
	void init(PanelManager panelManager);
	GridPane getLayout();
	void onShow();
}
