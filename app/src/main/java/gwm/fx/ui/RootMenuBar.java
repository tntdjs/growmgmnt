package gwm.fx.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class RootMenuBar extends MenuBar {
	private Menu menuFile = new Menu("File");
	private Menu menuHelp = new Menu("Help");

	public RootMenuBar() {
		MenuItem miAbout = new MenuItem("About");
		miAbout.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				FXDialogs.showInformation("About - Grow with Management ",
						"Grow with Management\nVersion 1.0\nCopyright (c) 2019, Todd M. Senauskas and/or its affiliates.\nAll rights reserved.");
			}
		});
		menuHelp.getItems().addAll(miAbout);
		getMenus().addAll(menuFile, menuHelp); 
	}

	public Menu getMenuFile() {
		return menuFile;
	}

	public void setMenuFile(Menu menuFile) {
		this.menuFile = menuFile;
	}

	public Menu getMenuHelp() {
		return menuHelp;
	}

	public void setMenuHelp(Menu menuHelp) {
		this.menuHelp = menuHelp;
	}
	
}
