package main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class HibernateUtil {

    private static SessionFactory sessionFactory;


    static {

        try{

            sessionFactory=new Configuration().configure(new File("src/hibernate.cfg.xml")).buildSessionFactory();


        }catch (Throwable ex){
            System.err.println("Fallo " + ex.getMessage());
            throw  new ExceptionInInitializerError(ex);
        }

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        HibernateUtil.sessionFactory = sessionFactory;
    }
}
