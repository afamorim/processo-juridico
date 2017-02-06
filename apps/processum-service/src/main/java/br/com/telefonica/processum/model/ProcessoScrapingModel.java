package br.com.telefonica.processum.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "POC_PROCESSO_SCRAPING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcessoScrapingModel.findAll", query = "SELECT a FROM ProcessoScrapingModel a")})
public class ProcessoScrapingModel {

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "DES_NUM_PROCESSO")
	private String	numeroProcesso;
	
	@ManyToOne(optional = false)
	@JoinColumns({
		@JoinColumn(name = "COD_STATUS_PROCESSO_SCRAPING", referencedColumnName = "COD_STATUS_PROCESSO_SCRAPING")})
	private StatusProcessoScraping	statusProcessoScraping;
	
	@Basic(optional = false)
	@Size(min = 1, max = 200)
	@Column(name = "DES_CANAL")
	private String	classe;
	
	@Basic(optional = false)
	@Size(min = 1, max = 200)
	@Column(name = "DES_AREA")
	private String	area;
	
	@Basic(optional = false)
	@Size(min = 1, max = 200)
	@Column(name = "DES_ASSUNTO")
	private String	assunto;
	
	@Basic(optional = false)
	@Size(min = 1, max = 200)
	@Column(name = "DES__OUTROS_ASSUNTOS")
	private String	outrosAssuntos;
	
	@Basic(optional = false)
	@Size(min = 1, max = 200)
	@Column(name = "DES_DISTRIBUICAO")
	private String	distribuicao;
	
	@Basic(optional = false)
	@Size(min = 1, max = 200)
	@Column(name = "DES_CONTROLE")
	private String	controle;
	
	@Basic(optional = false)
	@Size(min = 1, max = 200)
	@Column(name = "DES_JUIZ")
	private String	juiz;
	
	@Basic(optional = false)
	@Size(min = 1, max = 200)
	@Column(name = "DES_VALOR_ACAO")
	private String	valorAcao;
	
	@Basic(optional = false)
	@Size(min = 1, max = 200)
	@Column(name = "DES_ADVOGADO")
	private String	advogado;
	
	@Basic(optional = false)
	@Size(min = 1, max = 200)
	@Column(name = "DES_REQUERENTE")
	private String	requerente;
	
	@Basic(optional = false)
	@Size(min = 1, max = 200)
	@Column(name = "DES_REQUERIDO")
	private String	requerido;
	
	@Basic(optional = false)
	@Size(min = 1, max = 200)
	@Column(name = "DESC_DATA_INCLUSAO")
	private String	strDataInclusao;

	public String getNumeroProcesso() {
		return numeroProcesso;
	}
	public void setNumeroProcesso(String numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getValorAcao() {
		return valorAcao;
	}
	public void setValorAcao(String valorAcao) {
		this.valorAcao = valorAcao;
	}
	public String getAdvogado() {
		return advogado;
	}
	public void setAdvogado(String advogado) {
		this.advogado = advogado;
	}
	public String getRequerente() {
		return requerente;
	}
	public void setRequerente(String requerente) {
		this.requerente = requerente;
	}
	public String getRequerido() {
		return requerido;
	}
	public void setRequerido(String requerido) {
		this.requerido = requerido;
	}
	public String getJuiz() {
		return juiz;
	}
	public void setJuiz(String juiz) {
		this.juiz = juiz;
	}
	public String getControle() {
		return controle;
	}
	public void setControle(String controle) {
		this.controle = controle;
	}
	public String getDistribuicao() {
		return distribuicao;
	}
	public void setDistribuicao(String distribuicao) {
		this.distribuicao = distribuicao;
	}
	public String getOutrosAssuntos() {
		return outrosAssuntos;
	}
	public void setOutrosAssuntos(String outrosAssuntos) {
		this.outrosAssuntos = outrosAssuntos;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public StatusProcessoScraping getStatusProcessoScraping() {
		return statusProcessoScraping;
	}
	public void setStatusProcessoScraping(StatusProcessoScraping statusProcessoScraping) {
		this.statusProcessoScraping = statusProcessoScraping;
	}
	public String getStrDataInclusao() {
		return strDataInclusao;
	}
	public void setStrDataInclusao(String strDataInclusao) {
		this.strDataInclusao = strDataInclusao;
	}
	@Override
	public String toString() {
		return "ProcessoTJSPModel [numeroProcesso=" + numeroProcesso + ", classe=" + classe + ", area=" + area
				+ ", assunto=" + assunto + ", outrosAssuntos=" + outrosAssuntos + ", distribuicao=" + distribuicao
				+ ", controle=" + controle + ", juiz=" + juiz + ", valorAcao=" + valorAcao + ", advogado=" + advogado
				+ ", requerente=" + requerente + ", requerido=" + requerido + "]";
	}
	
}