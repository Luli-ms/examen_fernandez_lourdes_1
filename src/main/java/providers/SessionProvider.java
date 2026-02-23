package utils.providers;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionProvider {
    private static SessionFactory sessionFactory;

    private SessionProvider() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration config = new Configuration().configure();
            config.setCredentials(System.getenv("DB_USER"), System.getenv("DB_PASS"));
            sessionFactory = config.buildSessionFactory();
        }
        return sessionFactory;
    }
}
