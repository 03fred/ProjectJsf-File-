/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.project.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "documento")
public class Documento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doc_id")
    private Integer doc_id;
    
    @Column(name = "doc_nome")
    private String docNome;
    
    @Column(name = "doc_conteudo")
    private String docConteudo;

    public Integer getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(Integer doc_id) {
        this.doc_id = doc_id;
    }

  
    public String getDocNome() {
        return docNome;
    }

    public void setDocNome(String docNome) {
        this.docNome = docNome;
    }

    public String getDocConteudo() {
        return docConteudo;
    }

    public void setDocConteudo(String docConteudo) {
        this.docConteudo = docConteudo;
    }
    
    
    }