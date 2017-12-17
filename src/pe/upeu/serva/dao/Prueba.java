/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.upeu.serva.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import pe.upeu.serva.entity.Ingrediente;
import pe.upeu.serva.entity.Recetamenu;
import pe.upeu.serva.util.HibernateUtil;



/**
 *
 * @author hikaru
 */
public class Prueba {
    public static void main(String[] args) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("from Recetamenu r where r.menu = 7");
        List list = q.list();
        Double total = 0.00;
        for (Object obj : list) {
            Recetamenu rm = (Recetamenu) obj;
            Integer porcion = rm.getPorcion();
            double costo = rm.getReceta().getCosto()* porcion;
            total += costo;
            System.out.println(total);
            System.out.println(rm.getReceta().getNombre()+" Porción "
                    +rm.getPorcion()+" Costo:"+costo);
            Integer recetaporcion = rm.getReceta().getPorcion();
            System.out.println("===================");
            Set ingedientes = rm.getReceta().getIngredientes();
            for (Object obj2 : ingedientes) {
                Ingrediente ing = (Ingrediente) obj2;
                String producto = ing.getProducto().getNombre();
                Double cantidad = ing.getCantidad();
                Integer recpor = recetaporcion;
                double realcant = cantidad * porcion;
                System.out.println(">>>: "+producto+" >:"
                        + ""+realcant/recpor+
                        " "+ing.getProducto().getUnidad().getSimbolo());
            }
            
            System.out.println("TOTAL: "+total);
        }
        session.getTransaction().commit();
        session.close();
    }
}
// Quitar unidad de ingredientes