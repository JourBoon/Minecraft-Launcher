package fr.jourboon.orlialauncher.ui;

import fr.arinonia.arilibfx.AriLibFX;
import fr.jourboon.orlialauncher.ui.panel.IPanel;
import fr.arinonia.arilibfx.ui.utils.ResizeHelper;
import fr.jourboon.orlialauncher.OrliaLauncher;
import fr.jourboon.orlialauncher.ui.panels.includes.TopPanel;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PanelManager {

	
	private final OrliaLauncher orliaLauncher;
	private final Stage stage;
	private GridPane layout;
	private TopPanel topPanel = new TopPanel();
	private GridPane centerPanel = new GridPane();
	
	public PanelManager(OrliaLauncher orliaLauncher, Stage stage) {
		this.orliaLauncher = orliaLauncher;
		this.stage = stage;
	}
	
	public void init() {
		this.stage.setTitle("Orlia Launcher");
		this.stage.setMinWidth(1280);
		this.stage.setWidth(1280);
		this.stage.setMinHeight(720);
		this.stage.setHeight(720);
		this.stage.initStyle(StageStyle.UNDECORATED);
		this.stage.centerOnScreen();
		this.stage.show();
		
		this.layout = new GridPane();
		this.layout.setStyle(AriLibFX.setResponsiveBackground("https://orliamc.fr/app/webroot/jourboon/launcherassets/backgroundlauncher.png"));
		this.stage.setScene(new Scene(this.layout));
		
		RowConstraints topPanelConstraints = new RowConstraints();
		topPanelConstraints.setValignment(VPos.TOP);
		topPanelConstraints.setMinHeight(25);
		topPanelConstraints.setMaxHeight(25);
		this.layout.getRowConstraints().addAll(topPanelConstraints, new RowConstraints());
		this.layout.add(this.topPanel.getLayout(), 0, 0);
		this.topPanel.init(this);
		
		this.layout.add(this.centerPanel, 0, 1);
		GridPane.setVgrow(centerPanel, Priority.ALWAYS);
		GridPane.setHgrow(centerPanel, Priority.ALWAYS);
		ResizeHelper.addResizeListener(this.stage);
		
	}
	
	public void showPanel(IPanel panel) {
		this.centerPanel.getChildren().clear();
		this.centerPanel.getChildren().add(panel.getLayout());
		panel.init(this);
		panel.onShow();
	}
	
	public Stage getStage() {
		return stage;
	}
	
	public OrliaLauncher getOrliaLauncher() {
		return orliaLauncher;
	}
	
	public TopPanel getTopPanel() {
		return topPanel;
	}
	
}
