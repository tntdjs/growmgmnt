package gwm;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class AppMain {
	private static final Logger LOG = LogManager.getRootLogger();
	
	/**
     * Application Main
     * @param args
     */
	public static void main(String[] args) {
		new AppMain();
	}
	
	public AppMain() {
		LOG.info("Grow with Management application startup...");
		
		
	}
    
}
