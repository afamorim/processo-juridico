package br.com.telefonica.processum.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ESPECIFICACAO_NATUREZA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EspecificacaoNatureza.findAll", query = "SELECT e FROM EspecificacaoNatureza e")
    , @NamedQuery(name = "EspecificacaoNatureza.findByCodEspecificacaoNatureza", query = "SELECT e FROM EspecificacaoNatureza e WHERE e.especificacaoNaturezaPK.codEspecificacaoNatureza = :codEspecificacaoNatureza")
    , @NamedQuery(name = "EspecificacaoNatureza.findByCodNatureza", query = "SELECT e FROM EspecificacaoNatureza e WHERE e.especificacaoNaturezaPK.codNatureza = :codNatureza")
    , @NamedQuery(name = "EspecificacaoNatureza.findByDesEspecificacaoNatureza", query = "SELECT e FROM EspecificacaoNatureza e WHERE e.desEspecificacaoNatureza = :desEspecificacaoNatureza")})
public class EspecificacaoNatureza implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected EspecificacaoNaturezaPK especificacaoNaturezaPK;
    
    @Size(max = 40)
    @Column(name = "DES_ESPECIFICACAO_NATUREZA")
    private String desEspecificacaoNatureza;
    
    @Size(max = 1)
    @Column(name = "STS_VISUALIZA_RELATORIO")
    private String stsVisualizaRelatorio;
    
    @JoinColumn(name = "SIG_ESCRITORIO_CONTRATADO", referencedColumnName = "SIG_ESCRITORIO_CONTRATADO")
    @ManyToOne
    private EscritorioContratado sigEscritorioContratado;
    
    @JoinColumn(name = "COD_NATUREZA", referencedColumnName = "COD_NATUREZA", insertable = false, updatable = false)
    @ManyToOne
    @JsonManagedReference
    private Natureza natureza;
    
    public EspecificacaoNatureza() {
    }

    public EspecificacaoNatureza(EspecificacaoNaturezaPK especificacaoNaturezaPK) {
        this.especificacaoNaturezaPK = especificacaoNaturezaPK;
    }

    public EspecificacaoNatureza(BigInteger codEspecificacaoNatureza, BigInteger codNatureza) {
        this.especificacaoNaturezaPK = new EspecificacaoNaturezaPK(codEspecificacaoNatureza, codNatureza);
    }

    public EspecificacaoNaturezaPK getEspecificacaoNaturezaPK() {
        return especificacaoNaturezaPK;
    }

    public void setEspecificacaoNaturezaPK(EspecificacaoNaturezaPK especificacaoNaturezaPK) {
        this.especificacaoNaturezaPK = especificacaoNaturezaPK;
    }

    public String getDesEspecificacaoNatureza() {
        return desEspecificacaoNatureza;
    }

    public void setDesEspecificacaoNatureza(String desEspecificacaoNatureza) {
        this.desEspecificacaoNatureza = desEspecificacaoNatureza;
    }

    public String getStsVisualizaRelatorio() {
        return stsVisualizaRelatorio;
    }

    public void setStsVisualizaRelatorio(String stsVisualizaRelatorio) {
        this.stsVisualizaRelatorio = stsVisualizaRelatorio;
    }

    public EscritorioContratado getSigEscritorioContratado() {
        return sigEscritorioContratado;
    }

    public void setSigEscritorioContratado(EscritorioContratado sigEscritorioContratado) {
        this.sigEscritorioContratado = sigEscritorioContratado;
    }

    public Natureza getNatureza() {
        return natureza;
    }

    public void setNatureza(Natureza natureza) {
        this.natureza = natureza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (especificacaoNaturezaPK != null ? especificacaoNaturezaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EspecificacaoNatureza)) {
            return false;
        }
        EspecificacaoNatureza other = (EspecificacaoNatureza) object;
        if ((this.especificacaoNaturezaPK == null && other.especificacaoNaturezaPK != null) || (this.especificacaoNaturezaPK != null && !this.especificacaoNaturezaPK.equals(other.especificacaoNaturezaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vivo.processum.entity.EspecificacaoNatureza[ especificacaoNaturezaPK=" + especificacaoNaturezaPK + " ]";
    }

}
