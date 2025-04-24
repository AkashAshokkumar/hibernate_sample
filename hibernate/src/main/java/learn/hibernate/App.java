package learn.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        Configuration con = new Configuration();
        con.configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();
        Session sess = sf.openSession();
        sess.beginTransaction();
        
        Employee emp = new Employee("Swetha", 22000, "Manager", "Testing");
        sess.persist(emp);
        
        sess.getTransaction().commit();
    }
}
