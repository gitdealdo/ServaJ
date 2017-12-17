/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.upeu.serva.report;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Session;
import org.hibernate.jdbc.ReturningWork;
import pe.upeu.serva.util.HibernateUtil;

/**
 *
 * @author hikaru
 */
public class Reporte {

    public static void main(String[] args) {
        Reporte reporte = new Reporte();
        reporte.generarReporte(5);
    }
    
    public void generarReporte(int menu_id){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.getTransaction().commit();
          
        Connection connection = session.doReturningWork(new ReturningWork<Connection>() {
            @Override
            public Connection execute(Connection conn) throws SQLException {
                return conn;
            }
        });
        
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObject("Report.jasper");
//            JasperReport reporte = (JasperReport) JRLoader.loadObject("D:/javadev/ServA/src/pe/upeu/serva/report/Report.jasper");
            Map parametro = new HashMap();
            parametro.put("menu_id", menu_id);
            JasperPrint j = JasperFillManager.fillReport(reporte, parametro, connection);
            JasperViewer jv = new JasperViewer(j, false);
            jv.setTitle("Reporte de productos");
            jv.setVisible(true);            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            Connection close = session.close();
        }
        /*
        // Different ways to get the Connection object using Session
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        // Way1 - using doWork method
        session.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                // do your work using connection
            }
            
        });
        
        // Way2 - using doReturningWork method
        Connection connection = session.doReturningWork(new ReturningWork<Connection>() {
            @Override
            public Connection execute(Connection conn) throws SQLException {
                return conn;
            }
        });
        
        // Way3 - using Session Impl
        SessionImpl sessionImpl = (SessionImpl) session;
        connection = sessionImpl.connection();
        // do your work using connection
        
        // Way4 - using connection provider
        SessionFactoryImplementor sessionFactoryImplementation = (SessionFactoryImplementor) session.getSessionFactory();
        ConnectionProvider connectionProvider = sessionFactoryImplementation.getConnectionProvider();
        try {
            connection = connectionProvider.getConnection();
            // do your work using connection
        } catch (SQLException e) {
            e.printStackTrace();
        }  */  
    }
}
