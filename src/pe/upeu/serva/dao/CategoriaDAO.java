/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.upeu.serva.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pe.upeu.serva.entity.Categoria;
import pe.upeu.serva.util.HibernateUtil;

/**
 *
 * @author hikaru
 */
public class CategoriaDAO {
    public Categoria buscarPorNombre(String nombre) {        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("from Categoria c where c.nombre like '"+nombre+"%'");
        List resultList = q.list();
        Categoria categoria = (Categoria) resultList.get(0);            
//        Categoria categoria = (Categoria) session.load(Categoria.class, nombre);
        session.getTransaction().commit();
        session.close();        
        return categoria;
    }
}
