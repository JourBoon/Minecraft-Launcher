package fr.jourboon.orlialauncher;

import javafx.application.Application;
import javafx.stage.Stage;

public class FxApplication extends Application{

	@Override
	public void start(Stage stage) {
		new OrliaLauncher().init(stage);
	}

}
