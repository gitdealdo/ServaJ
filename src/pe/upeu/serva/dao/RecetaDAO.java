/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.upeu.serva.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import pe.upeu.serva.entity.Ingrediente;
import pe.upeu.serva.entity.Receta;
import pe.upeu.serva.util.HibernateUtil;

/**
 *
 * @author hikaru
 */
public class RecetaDAO {       
    
    public Receta buscarRecetaPorNombre(String nombre){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("from Receta r where r.nombre like '%"+nombre+"%'");
        List resultList = q.list();
        Receta rec = (Receta) resultList.get(0);
//        Map m = new HashMap();
//        m.put("receta", rec);
//        m.put("nombre", rec.getNombre());
//        m.put("prodNombre", producto.getNombre());
//        m.put("unidad", producto.getUnidad().getSimbolo());
        session.getTransaction().commit();
        session.close();   
        return rec;
    }
    
    public Receta buscarReceta(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Receta receta = null;
        try {
            session.beginTransaction();
            receta = (Receta) session.load(Receta.class, id);
            Hibernate.initialize(receta);
//            System.out.println(receta); //Esto tambien inicializa
//            Set ingredientes = receta.getIngredientes();
//            System.out.println("*****");
//            for (Object obj : ingredientes) {
//                Ingredienteold ing = (Ingredienteold) obj;
//                System.out.println(ing.getId()+" Prod: "+ing.getProducto().getNombre());
//            }
//            System.out.println("*****");
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            session.close(); 
        }
        return receta;        
    }
    
    public Map editar(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
//        Receta receta = null;
        Map m = new HashMap();
        try {
            session.beginTransaction();
            Receta receta = (Receta) session.load(Receta.class, id);
//            Hibernate.initialize(receta);
            System.out.println(receta); //Esto tambien inicializa            
            m.put("porcion", receta.getPorcion());
            m.put("nombre", receta.getNombre());
            m.put("prep", receta.getPreparacion());
            m.put("desc", receta.getDescripcion());
            List lis = new ArrayList();
            Set ingredientes = receta.getIngredientes();
            for (Object obj : ingredientes) {
                Ingrediente ing = (Ingrediente) obj;
                Map m2 = new HashMap();
                m2.put("idIng", ing.getId());
                m2.put("producto", ing.getProducto());
                m2.put("prodNombre", ing.getProducto().getNombre());
                m2.put("cantidad", ing.getCantidad());
                m2.put("unidad", ing.getProducto().getUnidad().getSimbolo());
                m2.put("costo", ing.getCosto());
                lis.add(m2);                
            }
            m.put("ingredientes", lis);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            session.close(); 
        }
        return m;        
    }
    
    public List listarRecetaPorNombre(String nombre) {        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("from Receta r where r.nombre like '"+nombre+"%'");
        List list = q.list();
        session.getTransaction().commit();
        session.close();        
        return list;
    }


}
