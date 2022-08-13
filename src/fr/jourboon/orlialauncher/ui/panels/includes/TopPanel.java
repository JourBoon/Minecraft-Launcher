package fr.jourboon.orlialauncher.ui.panels.includes;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import fr.jourboon.orlialauncher.ui.PanelManager;
import fr.jourboon.orlialauncher.ui.panel.Panel;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class TopPanel extends Panel{

	
	private GridPane topBar;
	
	@Override
	public void init(PanelManager panelManager) {
		super.init(panelManager);
		this.topBar = this.layout;
		this.layout.setStyle("-fx-background-color: rgb(58, 58, 58);");
		GridPane topBarButton = new GridPane();
		this.layout.getChildren().add(topBarButton);
		
		Label title = new Label();
		this.layout.getChildren().add(title);
		title.setFont(Font.font("Verdana", FontWeight.THIN, FontPosture.REGULAR, 22F));
		title.setStyle("-fx-text-fill: white;");
		GridPane.setHalignment(title, HPos.CENTER);
		topBarButton.setMinWidth(100d);
		topBarButton.setMaxWidth(100d);
		GridPane.setHgrow(topBarButton, Priority.ALWAYS);
		GridPane.setVgrow(topBarButton, Priority.ALWAYS);
		GridPane.setHalignment(topBarButton, HPos.RIGHT);
		MaterialDesignIconView close = new MaterialDesignIconView(MaterialDesignIcon.WINDOW_CLOSE);
		MaterialDesignIconView fullScreen = new MaterialDesignIconView(MaterialDesignIcon.WINDOW_MAXIMIZE);
		MaterialDesignIconView hide = new MaterialDesignIconView(MaterialDesignIcon.WINDOW_MINIMIZE);
		GridPane.setVgrow(close, Priority.ALWAYS);
		GridPane.setVgrow(fullScreen, Priority.ALWAYS);
		GridPane.setVgrow(hide, Priority.ALWAYS);
		
		close.setFill(Color.AZURE);
		close.setOpacity(0.80);
		close.setSize("18px");
		close.setOnMouseEntered(e-> close.setOpacity(1.0F));
		close.setOnMouseExited(e-> close.setOpacity(0.70F));
		close.setOnMouseClicked(e->System.exit(0));
		close.setTranslateX(70d);
		
		fullScreen.setFill(Color.AZURE);
		fullScreen.setOpacity(0.80);
		fullScreen.setSize("16px");
		fullScreen.setOnMouseEntered(e-> fullScreen.setOpacity(1.0F));
		fullScreen.setOnMouseExited(e-> fullScreen.setOpacity(0.70F));
		fullScreen.setOnMouseClicked(e->this.panelManager.getStage().setMaximized(!this.panelManager.getStage().isMaximized()));
		fullScreen.setTranslateX(50d);
		
		hide.setFill(Color.AZURE);
		hide.setOpacity(0.80);
		hide.setSize("18px");
		hide.setOnMouseEntered(e-> hide.setOpacity(1.0F));
		hide.setOnMouseExited(e-> hide.setOpacity(0.70F));
		hide.setOnMouseClicked(e->this.panelManager.getStage().setIconified(true));
		hide.setTranslateX(26d);
		
		topBarButton.getChildren().addAll(close, fullScreen, hide);
	}
}
