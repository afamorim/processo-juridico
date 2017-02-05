package br.com.telefonica.processum.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jadossantos
 */
@Embeddable
public class ReuPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_EMPRESA")
    private BigInteger codEmpresa;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NUM_PROCESSO")
    private String numProcesso;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_PARTE_PROCESSO")
    private BigInteger codParteProcesso;

    public ReuPK() {
    }

    public ReuPK(BigInteger codEmpresa, String numProcesso, BigInteger codParteProcesso) {
        this.codEmpresa = codEmpresa;
        this.numProcesso = numProcesso;
        this.codParteProcesso = codParteProcesso;
    }

    public BigInteger getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(BigInteger codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public String getNumProcesso() {
        return numProcesso;
    }

    public void setNumProcesso(String numProcesso) {
        this.numProcesso = numProcesso;
    }

    public BigInteger getCodParteProcesso() {
        return codParteProcesso;
    }

    public void setCodParteProcesso(BigInteger codParteProcesso) {
        this.codParteProcesso = codParteProcesso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEmpresa != null ? codEmpresa.hashCode() : 0);
        hash += (numProcesso != null ? numProcesso.hashCode() : 0);
        hash += (codParteProcesso != null ? codParteProcesso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ReuPK)) {
            return false;
        }
        ReuPK other = (ReuPK) object;
        if ((this.codEmpresa == null && other.codEmpresa != null) || (this.codEmpresa != null && !this.codEmpresa.equals(other.codEmpresa))) {
            return false;
        }
        if ((this.numProcesso == null && other.numProcesso != null) || (this.numProcesso != null && !this.numProcesso.equals(other.numProcesso))) {
            return false;
        }
        if ((this.codParteProcesso == null && other.codParteProcesso != null) || (this.codParteProcesso != null && !this.codParteProcesso.equals(other.codParteProcesso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telefonica.processum.model.ReuPK[ codEmpresa=" + codEmpresa + ", numProcesso=" + numProcesso + ", codParteProcesso=" + codParteProcesso + " ]";
    }
    
}
