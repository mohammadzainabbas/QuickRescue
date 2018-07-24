package quickrescue.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DatabaseManager {
	public static SessionFactory sessionFactory;

	public static void setup() {
		if (sessionFactory == null) {

			StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
			try {
				sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

			} catch (Exception ex) {
				ex.printStackTrace();
				StandardServiceRegistryBuilder.destroy(registry);
			}
		}
	}

	public  static void exit() {
		try {
			sessionFactory.close();
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public DatabaseManager() {
	}

	public static Session getSession() {
		return DatabaseManager.sessionFactory.openSession();
	}

}
