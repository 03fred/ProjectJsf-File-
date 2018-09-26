package br.com.project.controller;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.projec.mensagem.MensagemBean;
import br.com.project.documento.PdfService;
import br.com.project.model.Arquivo;
import br.com.project.model.Caixa;
import br.com.project.model.Documento;
import br.com.project.service.ArquivoService;
import br.com.project.service.CaixaService;
import br.com.project.service.DocService;

@ViewScoped
@ManagedBean(name = "arquivoController")
public class ArquivoController implements Serializable {

    @ManagedProperty("#{pdfService}")
    PdfService pdfService;
    @ManagedProperty("#{arquivoService}")
    ArquivoService arquivoService;
    @ManagedProperty("#{docService}")
    DocService docService;
    @ManagedProperty("#{caixaService}")
    CaixaService caixaService;
    @ManagedProperty("#{mensagemBean}")
    private MensagemBean mensagemBean;
    private Documento doc;
    private String docNome;
    private Arquivo arquivoUpdate;
    private Integer caixaid;
    private String documento;
    private Caixa caixa;
    private String nomePesquisa;
    private List<Arquivo> listaArquivosPesquisa;
    private Arquivo arquivo;
    private String message = "";
    private Map<String, Integer> mapa;
    private int cont = 0;

    @PostConstruct
    public void init() {

        doc = new Documento();
        arquivo = new Arquivo();

        List<Caixa> lista = caixaService.listaCaixas();
        mapa = new LinkedHashMap<String, Integer>();

        for (Caixa c : lista) {
            mapa.put(c.getNome_caixa(), c.getCaixa_id());
        }

    }

    public void atualizar() {
         caixa = caixaService.buscaId(caixaid);
        arquivoUpdate.setCaixa(caixa);
        arquivoService.Atualizar(arquivoUpdate);
    }

    public void montarDocumento(){
        
        documento =  documento + " " +arquivoUpdate.getTexto();
    }
    
    public void salvarDocumento(){
        
        doc.setDocConteudo(documento);
        docService.insert(doc);
    }
    
    public void finalizarPdf(){
        pdfService.gerarPdf(documento);
    }
    public void listaParteNome() {

        listaArquivosPesquisa = arquivoService.listaParteNome(nomePesquisa);

    }

    public String getNomePesquisa() {
        return nomePesquisa;
    }

    public void setNomePesquisa(String nomePesquisa) {
        this.nomePesquisa = nomePesquisa;
    }

    
    public void formUpdate(Arquivo arquivo) {
        arquivoUpdate = arquivo;
    }

    public void cadastra() {

        caixa = caixaService.buscaId(caixaid);
        arquivo.setCaixa(caixa);
        arquivoService.cadastrar(arquivo);
        arquivo = new Arquivo();
        mensagemBean.cadastradoSucesso();

    }

    public Integer getCaixaid() {
        return caixaid;
    }

    public Map<String, Integer> getMapa() {
        return mapa;
    }

    public MensagemBean getMensagemBean() {
		return mensagemBean;
	}

	public void setMensagemBean(MensagemBean mensagemBean) {
		this.mensagemBean = mensagemBean;
	}

	public void setMapa(Map<String, Integer> mapa) {
        this.mapa = mapa;
    }

    public void setCaixaid(Integer caixaid) {
        this.caixaid = caixaid;
    }

    public List<Arquivo> getListaArquivosPesquisa() {
        return listaArquivosPesquisa;
    }

    public void setListaArquivosPesquisa(List<Arquivo> listaArquivosPesquisa) {
        this.listaArquivosPesquisa = listaArquivosPesquisa;
    }

    
   

	public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public ArquivoService getArquivoService() {
        return arquivoService;
    }

    public void setArquivoService(ArquivoService arquivoService) {
        this.arquivoService = arquivoService;
    }

    public PdfService getPdfService() {
        return pdfService;
    }

    public void setPdfService(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    

    public DocService getDocService() {
        return docService;
    }

    public void setDocService(DocService docService) {
        this.docService = docService;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public CaixaService getCaixaService() {
        return caixaService;
    }

    public void setCaixaService(CaixaService caixaService) {
        this.caixaService = caixaService;
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

    public Documento getDoc() {
        return doc;
    }

    public void setDoc(Documento doc) {
        this.doc = doc;
    }

    public Arquivo getArquivoUpdate() {
        return arquivoUpdate;
    }

    public void setArquivoUpdate(Arquivo arquivoUpdate) {
        this.arquivoUpdate = arquivoUpdate;
    }

    public String getDocNome() {
        return docNome;
    }

    public void setDocNome(String docNome) {
        this.docNome = docNome;
    }

}
