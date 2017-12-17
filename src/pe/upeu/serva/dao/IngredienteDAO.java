/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.upeu.serva.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pe.upeu.serva.util.HibernateUtil;

/**
 *
 * @author hikaru
 */
public class IngredienteDAO {
    
    public List listarPorReceta(String receta) {        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("from Ingrediente ing where ing.receta like '"+receta+"%'");
        List list = q.list();
        session.getTransaction().commit();
        session.close();        
        return list;
    }
}
