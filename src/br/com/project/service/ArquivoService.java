
package br.com.project.service;

import br.com.project.dao.ArquivoDao;
import br.com.project.model.Arquivo;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ApplicationScoped
@ManagedBean
public class ArquivoService implements Serializable{
      @ManagedProperty("#{arquivoDao}")
      ArquivoDao arquivoDao;
    
      
      public void cadastrar(Arquivo arquivo){
       arquivoDao.insert(arquivo);
    }

      
      public void Atualizar(Arquivo arquivo){
          
          arquivoDao.atualiza(arquivo);
      }
      
      
      public List<Arquivo> listaParteNome(String parteNome){
          
         return arquivoDao.listaParteNome(parteNome);
      }
      
      
      
    public ArquivoDao getArquivoDao() {
        return arquivoDao;
    }

    public void setArquivoDao(ArquivoDao arquivoDao) {
        this.arquivoDao = arquivoDao;
    }
      
      
}
