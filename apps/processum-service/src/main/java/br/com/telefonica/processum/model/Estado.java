package br.com.telefonica.processum.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ifbomfim
 */
@Entity
@Table(name = "ESTADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e")
    , @NamedQuery(name = "Estado.findBySigEstado", query = "SELECT e FROM Estado e WHERE e.sigEstado = :sigEstado")
    , @NamedQuery(name = "Estado.findByNomEstado", query = "SELECT e FROM Estado e WHERE e.nomEstado = :nomEstado")})
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Size(max = 2)
    @Column(name = "SIG_ESTADO")
    private String sigEstado;
    
    @Size(max = 30)
    @Column(name = "NOM_ESTADO")
    private String nomEstado;
    
    @Size(max = 1)
    @Column(name = "STS_ATIVO")
    private String stsAtivo;
    
    @Size(max = 1)
    @Column(name = "STS_ATIVO_PROCURACAO")
    private String stsAtivoProcuracao;
    
    @Size(max = 1)
    @Column(name = "STS_MIGRACAO_BENNER")
    private String stsMigracaoBenner;
    
    public Estado() {
    }

    public Estado(String sigEstado) {
        this.sigEstado = sigEstado;
    }

    public String getSigEstado() {
        return sigEstado;
    }

    public void setSigEstado(String sigEstado) {
        this.sigEstado = sigEstado;
    }

    public String getNomEstado() {
        return nomEstado;
    }

    public void setNomEstado(String nomEstado) {
        this.nomEstado = nomEstado;
    }

    public String getStsAtivo() {
        return stsAtivo;
    }

    public void setStsAtivo(String stsAtivo) {
        this.stsAtivo = stsAtivo;
    }

    public String getStsAtivoProcuracao() {
        return stsAtivoProcuracao;
    }

    public void setStsAtivoProcuracao(String stsAtivoProcuracao) {
        this.stsAtivoProcuracao = stsAtivoProcuracao;
    }

    public String getStsMigracaoBenner() {
        return stsMigracaoBenner;
    }

    public void setStsMigracaoBenner(String stsMigracaoBenner) {
        this.stsMigracaoBenner = stsMigracaoBenner;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sigEstado != null ? sigEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.sigEstado == null && other.sigEstado != null) || (this.sigEstado != null && !this.sigEstado.equals(other.sigEstado))) {
            return false;
        }
        return true;
  }
 
}
