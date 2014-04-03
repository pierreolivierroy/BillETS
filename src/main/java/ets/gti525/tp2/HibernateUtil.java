package ets.gti525.tp2;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
    	Configuration cfg = new Configuration().configure("hibernate.cfg.xml");    
    	cfg.setProperty("hibernate.temp.use_jdbc_metadata_defaults", "false");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();                   
        return cfg.buildSessionFactory(standardServiceRegistry);
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
