package br.com.telefonica.processum.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ifbomfim
 */
@Embeddable
public class JuizoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_JUIZO")
    private BigInteger codJuizo;
    @Column(name = "COD_COMARCA")
    private BigInteger codComarca;

    public JuizoPK() {
    }

    public JuizoPK(BigInteger codJuizo, BigInteger codComarca) {
        this.codJuizo = codJuizo;
        this.codComarca = codComarca;
    }

    public BigInteger getCodJuizo() {
        return codJuizo;
    }

    public void setCodJuizo(BigInteger codJuizo) {
        this.codJuizo = codJuizo;
    }

    public BigInteger getCodComarca() {
        return codComarca;
    }

    public void setCodComarca(BigInteger codComarca) {
        this.codComarca = codComarca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codJuizo != null ? codJuizo.hashCode() : 0);
        hash += (codComarca != null ? codComarca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof JuizoPK)) {
            return false;
        }
        JuizoPK other = (JuizoPK) object;
        if ((this.codJuizo == null && other.codJuizo != null) || (this.codJuizo != null && !this.codJuizo.equals(other.codJuizo))) {
            return false;
        }
        if ((this.codComarca == null && other.codComarca != null) || (this.codComarca != null && !this.codComarca.equals(other.codComarca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vivo.processum.entity.JuizoPK[ codJuizo=" + codJuizo + ", codComarca=" + codComarca + " ]";
    }
    
}
