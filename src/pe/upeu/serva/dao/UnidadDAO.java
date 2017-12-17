package pe.upeu.serva.dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import pe.upeu.serva.entity.Unidad;
import pe.upeu.serva.util.HibernateUtil;

/**
 *
 * @author hikaru
 */
public class UnidadDAO {
    
    public Unidad buscarUnidad(String nombre) {        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("from Unidad u where u.nombre like '"+nombre+"%'");
        List resultList = q.list();
        Unidad unidad = (Unidad) resultList.get(0);
        session.getTransaction().commit();
        session.close();        
        return unidad;
    }
    
    public Unidad getById(Long user_id) {
        Session session = null;
        Unidad unidad = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
//            unidad = (Unidad)session.get(Unidad.class, user_id);
            unidad = (Unidad)session.load(Unidad.class, user_id);
            Hibernate.initialize(unidad);
        } catch (Exception e) {
           e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return unidad;
    }

    /**Listar Unidad*
    public List<Unidad> listarUnidad() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("from Unidad");
        List<Unidad> lista = q.list();
        session.getTransaction().commit();
        session.close();        
        return lista;
    }*/    
    
//    public Unidad buscarPorId(Long id){
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Unidad unidad = null;
//        try {
//            session.beginTransaction();
//            unidad = (Unidad) session.load(Unidad.class, id);
//            System.out.println(unidad);
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }finally{
//            session.close(); 
//        }
//        return unidad;       
//    }

    
    /**Editar hql*
    public void editarUnidad(Unidad u){
        Session session = HibernateUtil.getSessionFactory().openSession();
        String query = "UPDATE unidad SET simbolo = '"+ u.getSimbolo() +"',nombre='"+u.getNombre()+"' WHERE id = '"+u.getId()+ "'";
        try {
            session.getTransaction().begin();
            session.createSQLQuery(query).executeUpdate();
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException erro){
            session.getTransaction().rollback();
            session.close();
        } 
    }*/
    
    /**hql fallido*
    public void guardarUnidad(Unidad u){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
//        Query q = session.createQuery("from Unidad u where u.simbolo like '"+simbolo+"%'");
        String hql = "INSERT INTO Unidad(simbolo, nombre)"  + 
             "SELECT "+u.getSimbolo()+", "+u.getNombre()+" FROM unidad";
        Query q = session.createQuery(hql);
        q.executeUpdate();
        session.getTransaction().commit();
        session.close();        
    }
    */
    
    /**Buscar unidad por simbolo //Obsoleto por que el simbolo puede cambiar*/
    
    /**buscarUnidad*
    public Unidad buscarUnidad(String nombre) {        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("from Unidad u where u.nombre like '"+nombre+"%'");
        List resultList = q.list();
        Unidad unidad = (Unidad) resultList.get(0);            
        session.getTransaction().commit();
        session.close();        
        return unidad;
    }*/
    
//    public static void main(String[] args) {
//        Object uni = null;
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        Unidad u = new Unidad();
//        u.setSimbolo("q");
//        u.setNombre("Codo");
//        System.out.println("*************");
//        uni = session.save(u);
//        System.out.println(uni);
//        System.out.println(uni.getClass().getSimpleName());
//        System.out.println("*************");
//        session.getTransaction().commit();
//        session.close();               
//    }
       
}
