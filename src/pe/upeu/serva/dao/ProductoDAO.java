/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.upeu.serva.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import pe.upeu.serva.entity.Producto;
import pe.upeu.serva.util.HibernateUtil;

/**
 *
 * @author hikaru
 */
public class ProductoDAO {
    
    public Map buscarProducto(String nombre){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("from Producto p where p.nombre like '%"+nombre+"%'");
        List resultList = q.list();
        Producto producto = (Producto) resultList.get(0);
        Map m = new HashMap();
        m.put("producto", producto);
        m.put("prodNombre", producto.getNombre());
        m.put("unidad", producto.getUnidad().getSimbolo());
        m.put("costo", producto.getCosto());
        session.getTransaction().commit();
        session.close();   
        return m;
    }
    
    public List filtrarProducto(String nombre) {        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("from Producto p where p.nombre like '%"+nombre+"%'");
        List list = q.list();
        session.getTransaction().commit();
        session.close();        
        return list;
    }
    
//    public Producto buscarProducto(String nombre){
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        Query q = session.createQuery("from Producto p where p.nombre like '"+nombre+"%'");
//        List resultList = q.list();
//        Producto producto = (Producto) resultList.get(0); 
//        session.getTransaction().commit();
//        session.close();   
//        return producto;
//    }
        
//    public List buscarProductoPorReceta(String receta_id){
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        Query q = session.createQuery("from Producto p where p.receta like '"+receta_id+"%'");
//        List resultList = q.list();
//        session.getTransaction().commit();
//        session.close();   
//        return resultList;
//    }
}
