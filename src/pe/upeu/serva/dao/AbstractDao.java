/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.upeu.serva.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pe.upeu.serva.util.HibernateUtil;

/**
 *
 * @author hikaru
 */
public abstract class AbstractDao {
    private Session session;
    private Transaction tx;

//    public AbstractDao() {
//        HibernateUtil.buildIfNeeded();
//    }
//
//    protected void saveOrUpdate(Object obj) {
//        try {
//            startOperation();
//            session.saveOrUpdate(obj);
//            tx.commit();
//        } catch (HibernateException e) {
//            handleException(e);
//        } finally {
//            HibernateUtil.close(session);
//        }
//    }
//
//    protected void delete(Object obj) {
//        try {
//            startOperation();
//            session.delete(obj);
//            tx.commit();
//        } catch (HibernateException e) {
//            handleException(e);
//        } finally {
//            HibernateUtil.close(session);
//        }
//    }
//
//    protected Object find(Class clazz, Long id) {
//        Object obj = null;
//        try {
//            startOperation();
//            obj = session.load(clazz, id);
//            tx.commit();
//        } catch (HibernateException e) {
//            handleException(e);
//        } finally {
////            HibernateUtil.close(session);
//        }
//        return obj;
//    }
//
//    protected List findAll(Class clazz) {
//        List objects = null;
//        try {
//            startOperation();
//            Query query = session.createQuery("from " + clazz.getName());
//            objects = query.list();
//            tx.commit();
//        } catch (HibernateException e) {
//            handleException(e);
//        } finally {
//            HibernateUtil.close(session);
//        }
//        return objects;
//    }
//
//    protected void handleException(HibernateException e) throws DataAccessLayerException {
//        HibernateUtil.rollback(tx);
//        throw new DataAccessLayerException(e);
//    }
//
//    protected void startOperation() throws HibernateException {
//        session = HibernateUtil.openSession();
//        tx = session.beginTransaction();
//    }
}
