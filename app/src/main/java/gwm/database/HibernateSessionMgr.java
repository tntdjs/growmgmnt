package gwm.database;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * 
 * @author tsenausk
 *
 */
public class HibernateSessionMgr {
	private static final Logger LOG = LogManager.getLogger(HibernateSessionMgr.class);

	private SessionFactory sessionFactory;
	private static HibernateSessionMgr INSTANCE;

	protected HibernateSessionMgr() throws Exception {
		// A SessionFactory is set up once for an application!
		// configures settings fromhibernate.cfg.xml
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		try {
			setSessionFactory(new MetadataSources(registry).buildMetadata().buildSessionFactory());
		} catch (Exception e) {
			LOG.error(e);
		}
	}

	/**
	 * 
	 */
	public void closeSessionMgr() {
		if (sessionFactory != null) {			
			sessionFactory.close();
			LOG.info("Hibernate Session Manager Closed.");
		}
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	private void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public static HibernateSessionMgr getInstance() {
		if (null == INSTANCE) {
			try {
				INSTANCE = new HibernateSessionMgr();
			} catch (Exception e) {
				LOG.error(e);
			}
		}
		return INSTANCE;
	}

}
