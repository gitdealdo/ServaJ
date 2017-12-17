package pe.upeu.serva.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pe.upeu.serva.util.HibernateUtil;

/**
 *
 * @author hikaru
 */
public class DAO {
    
    public List listar(Object o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("from "+o.getClass().getSimpleName());
        List lista = q.list();
        session.getTransaction().commit();
        session.close();        
        return lista;
    }
    
    public void actualizar(Object o){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            session.close();        
        }        
    }
        
    public Object registrar(Object o){
        Object obj = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            obj = session.save(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            session.close();        
        }        
        return obj;
    }
    
    public void eliminar(Object o){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            session.close();        
        }   
    }
}
