package br.com.telefonica.processum.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "POC_STATUS_PROCESSO_SCRAPING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StatusProcessoScraping.findAll", query = "SELECT a FROM StatusProcessoScraping a")})
public class StatusProcessoScraping {

	public static final Long A_CARREGAR = 1L;
	
	public static final Long CARREGADO = 2L;
	
	public static final Long PROCESSO_CADASTRADO = 3L;
	
	public StatusProcessoScraping(){}
	
	public StatusProcessoScraping(Long aCodigo){
		this.codigo = aCodigo;	
	}
	
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "COD_STATUS_PROCESSO_SCRAPING")
	private Long	codigo;
	
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DES_STATUS")
	private String	nome;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
