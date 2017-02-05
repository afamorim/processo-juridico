package br.com.telefonica.processum.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ifbomfim
 */
@Entity
@Table(name = "NATUREZA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Natureza.findAll", query = "SELECT n FROM Natureza n")
    , @NamedQuery(name = "Natureza.findByCodNatureza", query = "SELECT n FROM Natureza n WHERE n.codNatureza = :codNatureza")
    , @NamedQuery(name = "Natureza.findByDesNatureza", query = "SELECT n FROM Natureza n WHERE n.desNatureza = :desNatureza")})
public class Natureza implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "COD_NATUREZA")
    private BigDecimal codNatureza;

    @Size(max = 40)
    @Column(name = "DES_NATUREZA")
    private String desNatureza;

    @Size(max = 1)
    @Column(name = "STS_VISUALIZA_RELATORIO")
    private String stsVisualizaRelatorio;

    @OneToMany(mappedBy = "natureza", fetch = FetchType.LAZY)
    @JsonBackReference
    private Collection<EspecificacaoNatureza> especificacaoNaturezaCollection;

    public Natureza() {
    }

    public Natureza(BigDecimal codNatureza) {
        this.codNatureza = codNatureza;
    }

    public BigDecimal getCodNatureza() {
        return codNatureza;
    }

    public void setCodNatureza(BigDecimal codNatureza) {
        this.codNatureza = codNatureza;
    }

    public String getDesNatureza() {
        return desNatureza;
    }

    public void setDesNatureza(String desNatureza) {
        this.desNatureza = desNatureza;
    }

    public String getStsVisualizaRelatorio() {
        return stsVisualizaRelatorio;
    }

    public void setStsVisualizaRelatorio(String stsVisualizaRelatorio) {
        this.stsVisualizaRelatorio = stsVisualizaRelatorio;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<EspecificacaoNatureza> getEspecificacaoNaturezaCollection() {
        return especificacaoNaturezaCollection;
    }

    public void setEspecificacaoNaturezaCollection(Collection<EspecificacaoNatureza> especificacaoNaturezaCollection) {
        this.especificacaoNaturezaCollection = especificacaoNaturezaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codNatureza != null ? codNatureza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Natureza)) {
            return false;
        }
        Natureza other = (Natureza) object;
        if ((this.codNatureza == null && other.codNatureza != null) || (this.codNatureza != null && !this.codNatureza.equals(other.codNatureza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vivo.processum.entity.Natureza[ codNatureza=" + codNatureza + " ]";
    }

}
