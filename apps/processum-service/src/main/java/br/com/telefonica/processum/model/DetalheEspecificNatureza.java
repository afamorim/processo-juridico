package br.com.telefonica.processum.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "DETALHE_ESPECIFIC_NATUREZA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalheEspecificNatureza.findAll", query = "SELECT d FROM DetalheEspecificNatureza d")
    , @NamedQuery(name = "DetalheEspecificNatureza.findByCodNatureza", query = "SELECT d FROM DetalheEspecificNatureza d WHERE d.detalheEspecificNaturezaPK.codNatureza = :codNatureza")
    , @NamedQuery(name = "DetalheEspecificNatureza.findByCodEspecificacaoNatureza", query = "SELECT d FROM DetalheEspecificNatureza d WHERE d.detalheEspecificNaturezaPK.codEspecificacaoNatureza = :codEspecificacaoNatureza")
    , @NamedQuery(name = "DetalheEspecificNatureza.findByCodDetalheEspecificNatureza", query = "SELECT d FROM DetalheEspecificNatureza d WHERE d.detalheEspecificNaturezaPK.codDetalheEspecificNatureza = :codDetalheEspecificNatureza")
    , @NamedQuery(name = "DetalheEspecificNatureza.findByNomDetalheEspecificNatureza", query = "SELECT d FROM DetalheEspecificNatureza d WHERE d.nomDetalheEspecificNatureza = :nomDetalheEspecificNatureza")})
public class DetalheEspecificNatureza implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected DetalheEspecificNaturezaPK detalheEspecificNaturezaPK;

    @Size(max = 60)
    @Column(name = "NOM_DETALHE_ESPECIFIC_NATUREZA")
    private String nomDetalheEspecificNatureza;

    @Size(max = 1)
    @Column(name = "STS_VISUALIZA_RELATORIO")
    private String stsVisualizaRelatorio;

    @Size(max = 1)
    @Column(name = "STS_EXIGE_OBJETO")
    private String stsExigeObjeto;

    @JoinColumns({
        @JoinColumn(name = "COD_ESPECIFICACAO_NATUREZA", referencedColumnName = "COD_ESPECIFICACAO_NATUREZA", insertable = false, updatable = false)
        , @JoinColumn(name = "COD_NATUREZA", referencedColumnName = "COD_NATUREZA", insertable = false, updatable = false)})
    @ManyToOne
    @JsonManagedReference
    private EspecificacaoNatureza especificacaoNatureza;

    public DetalheEspecificNatureza() {
    }

    public DetalheEspecificNatureza(DetalheEspecificNaturezaPK detalheEspecificNaturezaPK) {
        this.detalheEspecificNaturezaPK = detalheEspecificNaturezaPK;
    }

    public DetalheEspecificNatureza(BigInteger codNatureza, BigInteger codEspecificacaoNatureza, BigInteger codDetalheEspecificNatureza) {
        this.detalheEspecificNaturezaPK = new DetalheEspecificNaturezaPK(codNatureza, codEspecificacaoNatureza, codDetalheEspecificNatureza);
    }

    public DetalheEspecificNaturezaPK getDetalheEspecificNaturezaPK() {
        return detalheEspecificNaturezaPK;
    }

    public void setDetalheEspecificNaturezaPK(DetalheEspecificNaturezaPK detalheEspecificNaturezaPK) {
        this.detalheEspecificNaturezaPK = detalheEspecificNaturezaPK;
    }

    public String getNomDetalheEspecificNatureza() {
        return nomDetalheEspecificNatureza;
    }

    public void setNomDetalheEspecificNatureza(String nomDetalheEspecificNatureza) {
        this.nomDetalheEspecificNatureza = nomDetalheEspecificNatureza;
    }

    public String getStsVisualizaRelatorio() {
        return stsVisualizaRelatorio;
    }

    public void setStsVisualizaRelatorio(String stsVisualizaRelatorio) {
        this.stsVisualizaRelatorio = stsVisualizaRelatorio;
    }

    public String getStsExigeObjeto() {
        return stsExigeObjeto;
    }

    public void setStsExigeObjeto(String stsExigeObjeto) {
        this.stsExigeObjeto = stsExigeObjeto;
    }

    public EspecificacaoNatureza getEspecificacaoNatureza() {
        return especificacaoNatureza;
    }

    public void setEspecificacaoNatureza(EspecificacaoNatureza especificacaoNatureza) {
        this.especificacaoNatureza = especificacaoNatureza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalheEspecificNaturezaPK != null ? detalheEspecificNaturezaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DetalheEspecificNatureza)) {
            return false;
        }
        DetalheEspecificNatureza other = (DetalheEspecificNatureza) object;
        if ((this.detalheEspecificNaturezaPK == null && other.detalheEspecificNaturezaPK != null) || (this.detalheEspecificNaturezaPK != null && !this.detalheEspecificNaturezaPK.equals(other.detalheEspecificNaturezaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vivo.processum.entity.DetalheEspecificNatureza[ detalheEspecificNaturezaPK=" + detalheEspecificNaturezaPK + " ]";
    }

}
