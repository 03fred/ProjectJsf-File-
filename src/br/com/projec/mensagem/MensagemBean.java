package br.com.projec.mensagem;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ViewScoped
@ManagedBean
public class MensagemBean  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public void cadastradoSucesso() {
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("SUCESSO", " Arquivo adicionado!"));
	}
	
	
	
}
