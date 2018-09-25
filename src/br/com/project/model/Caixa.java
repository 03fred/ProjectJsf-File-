
package br.com.project.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="caixa")
public class Caixa implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int caixa_id;
       
    @Column(name = "nome_caixa")
    private String nome_caixa;

    public int getCaixa_id() {
        return caixa_id;
    }

    public void setCaixa_id(int caixa_id) {
        this.caixa_id = caixa_id;
    }

    public String getNome_caixa() {
        return nome_caixa;
    }

    public void setNome_caixa(String nome_caixa) {
        this.nome_caixa = nome_caixa;
    }

   
}
