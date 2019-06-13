package gwm;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import gwm.fx.ui.FXDialogs;
import gwm.fx.ui.IFXController;
import gwm.util.SystemPropertyMgr;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * 
 * @author tsenausk
 *
 */
public class AppMain extends Application {
	private static final Logger LOG = LogManager.getLogger(AppMain.class);
	private static AppMain INSTANCE;
	private RootMenu rootMenu = new RootMenu();

	/**
	 * Application Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new AppMain();
		launch(args);
	}

	/**
	 * Get Singleton instance
	 * 
	 * @return
	 */
	public static AppMain getInstance() {
		return INSTANCE;
	}

	@Override
	public void start(Stage primaryStage) {
		LOG.info("Grow with Management application startup...");
		BorderPane root = new BorderPane();
		
		try (AbstractApplicationContext appContext = new ClassPathXmlApplicationContext("spring-config.xml")) {

			ResourceBundle i18nBundle = ResourceBundle.getBundle("i18n/translations",
					new Locale(SystemPropertyMgr.getInstance().getString("locale.language"),
							SystemPropertyMgr.getInstance().getString("locale.country")));

			FXMLLoader loader = new FXMLLoader(AppMain.class.getClassLoader().getResource("fxml/FXRootScene.fxml"), i18nBundle);
			Parent rootController = loader.load();
			
			root.setCenter(rootController);		
			MenuBar menuBar = ((IFXController)loader.getController()).getMenu();	
			root.setTop(menuBar);			

			primaryStage.getIcons().add(new Image("images/app-icon.png"));
			primaryStage.setTitle("Grow with Management");
//			primaryStage.setHeight(new Double(midiDefMgr.getMidiControllerDef().getAppHeight()));
//			primaryStage.setWidth(new Double(midiDefMgr.getMidiControllerDef().getAppWidth()));

			rootMenu.SCENE = new Scene(root);
			primaryStage.setScene(rootMenu.SCENE);
			primaryStage.setOnCloseRequest(event -> {
				CloseApplication();
			});

			primaryStage.show();
			INSTANCE = this;
			
		} catch (Exception ex) {
			LOG.fatal("Error in main()", ex);
		}

	}

	public void restart() {
		try {
			start(new Stage());
		} catch (Exception ex) {
			LOG.fatal(null, ex);
			throw new RuntimeException("Failed to start another Modena window", ex);
		}
	}

	public void CloseApplication() {
		if (FXDialogs.showConfirm("Grow with Management", "Exit, are you sure?", FXDialogs.YES, FXDialogs.NO).equals(FXDialogs.YES)) {
			LOG.info("Application Exited Safely");
			System.exit(0);
		}
	}

	public Scene getScene() {
		return rootMenu.SCENE;
	}

}
