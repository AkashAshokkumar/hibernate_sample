package learn.annotation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
	public static void main( String[] args )
    {
    	
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory fact = cfg.buildSessionFactory();
        Session sess = fact.openSession();
        Transaction tx = sess.beginTransaction();
        
        Person p1 = new Person();
        
        Bike b1 = new Bike(101, "Duke", 70000, p1);
        Bike b2 = new Bike(102, "R15", 80000, p1);
        
        List<Bike> bikelist = new ArrayList<>();
        bikelist.add(b1);
        bikelist.add(b2);
        
        p1.setId(1);
        p1.setName("Akash");
        p1.setBikeList(bikelist);

        
        sess.persist(p1);
        sess.persist(b1);
        sess.persist(b2);
        
        tx.commit();
        
    }
}
