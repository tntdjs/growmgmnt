package gwm;

public class AppMgr {
	private static AppMgr INSTANCE;
	
	public AppMgr() {

	}
	
	public static AppMgr getInstance() {
		if (null == INSTANCE) {
			INSTANCE = new AppMgr();
		}
		return INSTANCE;
	}


}
