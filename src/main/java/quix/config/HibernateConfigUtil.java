package quix.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfigUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session openSession() {
        return sessionFactory.openSession();
    }

    public static void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    public static Session getCurrentSession() { return sessionFactory.getCurrentSession(); }

    public static void closeCurrentSession() {
        Session currentSession = sessionFactory.getCurrentSession();
        if (currentSession.isOpen()) {
            currentSession.close();
        }
    }
}
