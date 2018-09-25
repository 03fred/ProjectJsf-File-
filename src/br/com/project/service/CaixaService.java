
package br.com.project.service;

import br.com.project.dao.CaixaDao;
import br.com.project.model.Caixa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;


@ApplicationScoped
@ManagedBean
public class CaixaService implements Serializable{
    @ManagedProperty("#{caixaDao}")
    CaixaDao caixaDao;
    private List<Caixa> listaCaixas = new ArrayList<Caixa>();
    
    public List<Caixa> listaCaixas(){
        return caixaDao.listaTodos();
    }
    
     public List<Caixa> listaPorCaixa(Caixa caixa){
        return caixaDao.listaPorCaixa(caixa);
    }

    public Caixa buscaId(Integer id){
        return caixaDao.buscaid(id);
    }

    public CaixaDao getCaixaDao() {
        return caixaDao;
    }

    public void setCaixaDao(CaixaDao caixaDao) {
        this.caixaDao = caixaDao;
    }

    public List<Caixa> getListaCaixas() {
        return listaCaixas;
    }

    public void setListaCaixas(List<Caixa> listaCaixas) {
        this.listaCaixas = listaCaixas;
    }
    
}
