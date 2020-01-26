import main.EventEntity;
import main.HibernateUtil;
import org.apache.log4j.BasicConfigurator;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Main {
   /*  private static final SessionFactory ourSessionFactory;

   static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }
*/
    /*public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }
    }

    */

    public Main(){
        createAndStoreEvent("Evento", new Date());
        listEvents();
        HibernateUtil.getSessionFactory().close();
    }

    public static void main(String[] args) {
        BasicConfigurator.configure();
        new Main();
    }
    private int createAndStoreEvent(String title, Date date){

        Session session= HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        EventEntity evento=new EventEntity();
        evento.setTitle(title);
        evento.setDate(new Timestamp(date.getTime()));
        session.save(evento);
        session.getTransaction().commit();
        return  evento.getId();
    }

    private List<EventEntity> listEvents(){

        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<EventEntity> resultados=(List<EventEntity>) session.createQuery("from EventEntity ").list();
        return  resultados;

    }
}