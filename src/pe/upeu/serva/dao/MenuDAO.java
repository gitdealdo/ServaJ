/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.upeu.serva.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import pe.upeu.serva.entity.Menu;
import pe.upeu.serva.entity.Recetamenu;
import pe.upeu.serva.util.HibernateUtil;

/**
 *
 * @author hikaru
 */
public class MenuDAO {

    public Menu getById(Long id) {
        Session session = null;
        Menu menu = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            menu = (Menu)session.load(Menu.class, id);
            Hibernate.initialize(menu);
        } catch (Exception e) {
           e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return menu;
    }
    
    public List listarPorFecha(String fecha) {        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("from Menu m where m.fecha like '%"+fecha+"%'");
        List list = q.list();
        session.getTransaction().commit();
        session.close();        
        return list;
    }
    
    public Map MenuDetalle(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Menu menu = null;
        Map m = new HashMap();
        try {
            session.beginTransaction();
            menu = (Menu)session.load(Menu.class, id);
            Hibernate.initialize(menu);
            m.put("tipo", menu.getTipoMenu());
            m.put("fecha", menu.getFecha());
            List lis = new ArrayList();
            Set recetas = menu.getRecetamenus();
            for (Object obj : recetas) {
                Recetamenu r = (Recetamenu) obj;
                Map m2 = new HashMap();
                m2.put("receta", r.getReceta().getNombre());
                m2.put("porcion", r.getPorcion());
                m2.put("costo", r.getCosto());
                lis.add(m2);                
            }
            m.put("recetas", lis);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            session.close(); 
        }
        return m;        
    }
}
