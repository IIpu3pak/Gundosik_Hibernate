package domain;

import org.hibernate.SessionFactory;
import sevices.HibernateUtil;

public class Main {

    public static void main(String[] args) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        if(sf == null){
            throw new RuntimeException();
        }

        System.out.println("get session factory " + sf.getSessionFactoryOptions().toString());
    }
}
