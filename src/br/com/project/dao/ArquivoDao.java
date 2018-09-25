
package br.com.project.dao;

import Util.HibernateUtil;
import br.com.project.model.Arquivo;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
@ManagedBean
@ApplicationScoped
public class ArquivoDao implements Serializable
{
    
      public void insert(Arquivo arquivo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;

        try {
            
            t = session.beginTransaction();
            session.persist(arquivo);
            session.merge(arquivo);

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
      
       public void atualiza(Arquivo arquivo) {
        Session session = HibernateUtil
                .getSessionFactory().openSession();
        Transaction t = null;

        try {
            t = session.beginTransaction();
            session.merge(arquivo);
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
       
       
    public List<Arquivo> listaParteNome(String parteNome) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        List<Arquivo> lista;

        try {
            t = session.beginTransaction();
            Query query = session.createQuery("from Arquivo where lower(titulo) like :titulo");
            query.setParameter("titulo", String.format("%%%s%%", parteNome.toLowerCase()));
            lista = query.list();
            t.commit();
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
            throw e;
        } finally {
            session.close();
        }

        return lista;
    }

}
