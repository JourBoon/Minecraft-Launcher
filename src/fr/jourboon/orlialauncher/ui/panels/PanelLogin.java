package fr.jourboon.orlialauncher.ui.panels;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.atomic.AtomicBoolean;

import fr.jourboon.orlialauncher.Main;
import fr.jourboon.orlialauncher.ui.PanelManager;
import fr.jourboon.orlialauncher.ui.panel.Panel;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class PanelLogin extends Panel{
	
	@Override
	public void init(PanelManager panelManager) {
		super.init(panelManager);
		GridPane loginPanel = new GridPane();
		GridPane mainPanel = new GridPane();
		GridPane bottomPanel = new GridPane();
		AtomicBoolean connectWithMojang = new AtomicBoolean(true);
		
		loginPanel.setMaxWidth(500);
		loginPanel.setMinWidth(500);
		loginPanel.setMaxHeight(900);
		loginPanel.setMinHeight(690);
		
		GridPane.setVgrow(loginPanel, Priority.ALWAYS);
		GridPane.setHgrow(loginPanel, Priority.ALWAYS);
		GridPane.setValignment(loginPanel, VPos.CENTER);
		GridPane.setHalignment(loginPanel, HPos.LEFT);
		
		RowConstraints bottomConstraints = new RowConstraints();
		bottomConstraints.setValignment(VPos.BOTTOM);
		bottomConstraints.setMaxHeight(55);
		loginPanel.getRowConstraints().addAll(new RowConstraints(), bottomConstraints);
		loginPanel.add(mainPanel, 0, 0);
		loginPanel.add(bottomPanel, 0, 1);
		
		GridPane.setVgrow(mainPanel, Priority.ALWAYS);
		GridPane.setHgrow(mainPanel, Priority.ALWAYS);
		GridPane.setVgrow(bottomPanel, Priority.ALWAYS);
		GridPane.setHgrow(bottomPanel, Priority.ALWAYS);
		
		mainPanel.setStyle("-fx-background-color: #392848;");
		bottomPanel.setStyle("-fx-background-color: #392848; -fx-opacity: 50%;");
		Label noAccount = new Label("Pas encore inscrit ?");
		Label registerHere = new Label("S'inscrire sur Mojang");
		
		GridPane.setVgrow(noAccount, Priority.ALWAYS);
		GridPane.setHgrow(noAccount, Priority.ALWAYS);
		GridPane.setValignment(noAccount, VPos.TOP);
		GridPane.setHalignment(noAccount, HPos.CENTER);
		noAccount.setStyle("-fx-text-fill: #bcc6e7; -fx-font-size: 14px;");
		
		GridPane.setVgrow(registerHere, Priority.ALWAYS);
		GridPane.setHgrow(registerHere, Priority.ALWAYS);
		GridPane.setValignment(registerHere, VPos.BOTTOM);
		GridPane.setHalignment(registerHere, HPos.CENTER);
		registerHere.setStyle("-fx-text-fill: #69a7ed; -fx-font-size: 14px;");
		registerHere.setUnderline(true);
		registerHere.setTranslateY(-10);
		registerHere.setOnMouseEntered(e->this.layout.setCursor(Cursor.HAND));
		registerHere.setOnMouseExited(e->this.layout.setCursor(Cursor.DEFAULT));
		registerHere.setOnMouseClicked(e->{
			if(connectWithMojang.get()) {
				openUrl("https://www.minecraft.net/fr-fr/login/");
			}
			
		});
		
		bottomPanel.getChildren().addAll(noAccount, registerHere);
		this.layout.getChildren().add(loginPanel);
		
		Label connectLabel = new Label("Se Connecter");
		GridPane.setVgrow(connectLabel, Priority.ALWAYS);
		GridPane.setHgrow(connectLabel, Priority.ALWAYS);
		GridPane.setValignment(connectLabel, VPos.TOP);
		connectLabel.setTranslateY(27);
		connectLabel.setTranslateX(35.5);
		connectLabel.setFont(Font.font("Verdana", FontWeight.THIN, FontPosture.REGULAR, 22F));
		connectLabel.setStyle("-fx-text-fill: #bcc6e7; -fx-font-size: 13px;");
		
		mainPanel.getChildren().addAll(connectLabel);

	}
	
	private void openUrl(String url) {
		try {
			Desktop.getDesktop().browse(new URI(url));
		}catch (IOException | URISyntaxException e) {
			Main.logger.warn(e.getMessage());
		}
	}

}
