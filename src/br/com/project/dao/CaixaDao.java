/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.project.dao;

import Util.HibernateUtil;
import br.com.project.model.Caixa;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

@ApplicationScoped
@ManagedBean
public class CaixaDao implements Serializable {

    public List<Caixa> listaTodos() {
        List lista = null;
        Session session = HibernateUtil.
                getSessionFactory().openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            lista = session.createQuery("from Caixa")
                    .list();
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

    public Caixa buscaid(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        Caixa caixa;
        try {
            t = session.beginTransaction();
            Query query = session.createQuery("from Caixa where id = :id");
            query.setParameter("id", id);
            caixa = (Caixa) query.uniqueResult();
            t.commit();
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
        return caixa;

    }
    
    
     public List<Caixa> listaPorCaixa(Caixa caixa) {

        List lista = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;

        try {
            t = session.beginTransaction();
            Query query = session.createQuery("from Caixa where caixa_id = :caixaid");
            query.setParameter("caixaid", caixa.getCaixa_id());
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
