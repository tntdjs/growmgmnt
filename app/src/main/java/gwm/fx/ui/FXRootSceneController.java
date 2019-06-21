package gwm.fx.ui;

import java.net.URL;
import java.util.ResourceBundle;

import gwm.AppMain;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class FXRootSceneController implements Initializable, IFXController {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}

	private void CloseApplication() {
		AppMain.getInstance().CloseApplication();
	}
	
	@Override
	public MenuBar getMenu() {
		RootMenuBar rootMenuBar = new RootMenuBar();
		MenuItem miExit = new MenuItem("Exit");
		miExit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				CloseApplication();
			}
		});
		rootMenuBar.getMenuFile().getItems().addAll(miExit);
		
		return rootMenuBar;
	}
	
}
