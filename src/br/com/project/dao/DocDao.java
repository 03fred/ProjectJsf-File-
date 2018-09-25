
package br.com.project.dao;

import Util.HibernateUtil;
import br.com.project.model.Documento;
import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.hibernate.Session;
import org.hibernate.Transaction;
@ApplicationScoped
@ManagedBean
public class DocDao implements Serializable{
    
    
       public void insert(Documento doc) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;

        try {           
            t = session.beginTransaction();
            session.persist(doc);
            session.merge(doc);

            t.commit();

        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }
      
}
