package br.com.telefonica.processum.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author jadossantos
 */
@Entity
@Table(name = "AREA_PARECER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AreaParecer.findAll", query = "SELECT a FROM AreaParecer a")
    , @NamedQuery(name = "AreaParecer.findByCodAreaParecer", query = "SELECT a FROM AreaParecer a WHERE a.codAreaParecer = :codAreaParecer")
    , @NamedQuery(name = "AreaParecer.findByNomAreaParecer", query = "SELECT a FROM AreaParecer a WHERE a.nomAreaParecer = :nomAreaParecer")})
public class AreaParecer implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_AREA_PARECER")
    private BigDecimal codAreaParecer;
    
    @Size(max = 60)
    @Column(name = "NOM_AREA_PARECER")
    private String nomAreaParecer;
    
    @Size(max = 1)
    @Column(name = "STS_EXISTE_CHANCELA")
    private String stsExisteChancela;
    
    public AreaParecer() {
    }

    public AreaParecer(BigDecimal codAreaParecer) {
        this.codAreaParecer = codAreaParecer;
    }

    public BigDecimal getCodAreaParecer() {
        return codAreaParecer;
    }

    public void setCodAreaParecer(BigDecimal codAreaParecer) {
        this.codAreaParecer = codAreaParecer;
    }

    public String getNomAreaParecer() {
        return nomAreaParecer;
    }

    public void setNomAreaParecer(String nomAreaParecer) {
        this.nomAreaParecer = nomAreaParecer;
    }

    public String getStsExisteChancela() {
        return stsExisteChancela;
    }

    public void setStsExisteChancela(String stsExisteChancela) {
        this.stsExisteChancela = stsExisteChancela;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAreaParecer != null ? codAreaParecer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof AreaParecer)) {
            return false;
        }
        AreaParecer other = (AreaParecer) object;
        if ((this.codAreaParecer == null && other.codAreaParecer != null) || (this.codAreaParecer != null && !this.codAreaParecer.equals(other.codAreaParecer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telefonica.processum.model.AreaParecer[ codAreaParecer=" + codAreaParecer + " ]";
    }
    
}
