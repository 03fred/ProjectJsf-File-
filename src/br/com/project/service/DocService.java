
package br.com.project.service;

import br.com.project.dao.DocDao;
import br.com.project.model.Documento;
import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ApplicationScoped
@ManagedBean
public class DocService implements Serializable{
    @ManagedProperty("#{docDao}")
    DocDao docDao;
     
      public void insert(Documento doc){
       docDao.insert(doc);
    }


    public DocDao getDocDao() {
        return docDao;
    }

    public void setDocDao(DocDao docDao) {
        this.docDao = docDao;
    }
    
    
}
