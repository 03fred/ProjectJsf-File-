package br.com.project.controller;

import br.com.project.model.Arquivo;
import br.com.project.model.Caixa;
import br.com.project.service.ArquivoService;
import br.com.project.service.CaixaService;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "caixaController")
public class CaixaController implements Serializable {

    @ManagedProperty("#{arquivoService}")
    ArquivoService arquivoService;
    @ManagedProperty("#{caixaService}")
    CaixaService caixaService;

    private Integer caixaid;
    private Caixa caixa;
    private Arquivo arquivo;
    private String message = "";
    private Map<String, Integer> mapa;
    private int cont = 0;

    @PostConstruct
    public void init() {

        arquivo = new Arquivo();

        List<Caixa> lista = caixaService.listaCaixas();
        mapa = new LinkedHashMap<String, Integer>();

        for (Caixa c : lista) {
         mapa.put(c.getNome_caixa(),c.getCaixa_id());
        }

    }

    public ArquivoService getArquivoService() {
        return arquivoService;
    }

    public void setArquivoService(ArquivoService arquivoService) {
        this.arquivoService = arquivoService;
    }

    public CaixaService getCaixaService() {
        return caixaService;
    }

    public void setCaixaService(CaixaService caixaService) {
        this.caixaService = caixaService;
    }

    public Integer getCaixaid() {
        return caixaid;
    }

    public void setCaixaid(Integer caixaid) {
        this.caixaid = caixaid;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public Arquivo getArquivo() {
        return arquivo;
    }

    public void setArquivo(Arquivo arquivo) {
        this.arquivo = arquivo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Integer> getMapa() {
        return mapa;
    }

    public void setMapa(Map<String, Integer> mapa) {
        this.mapa = mapa;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }


  
}
