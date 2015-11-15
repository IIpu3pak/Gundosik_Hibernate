package sevices;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SessionFactoryObserver;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Locale;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static ServiceRegistry serviceRegistry;

    private static SessionFactory buildSessionFactory() {

        try {
            Locale.setDefault(Locale.ENGLISH);
            Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

            final ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();

            cfg.setSessionFactoryObserver(new SessionFactoryObserver() {
                @Override
                public void sessionFactoryCreated(SessionFactory factory) {

                }

                @Override
                public void sessionFactoryClosed(SessionFactory factory) {
                    ((StandardServiceRegistryImpl)serviceRegistry).destroy();
                }
            });

            return cfg.buildSessionFactory(serviceRegistry);

        }catch(Throwable ex){
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }

    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static Session openSession(){
        return sessionFactory.getCurrentSession();
    }


}
