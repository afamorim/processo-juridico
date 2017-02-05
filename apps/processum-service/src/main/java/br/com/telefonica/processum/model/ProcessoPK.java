package br.com.telefonica.processum.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

/**
 *
 * @author jadossantos
 */
@Embeddable
public class ProcessoPK implements Serializable {

    @Size(max = 20)
    @Column(name = "NUM_PROCESSO")
    private String numProcesso;
    
    @Column(name = "COD_EMPRESA")
    private BigInteger codEmpresa;

    public ProcessoPK() {
    }

    public ProcessoPK(String numProcesso, BigInteger codEmpresa) {
        this.numProcesso = numProcesso;
        this.codEmpresa = codEmpresa;
    }

    public String getNumProcesso() {
        return numProcesso;
    }

    public void setNumProcesso(String numProcesso) {
        this.numProcesso = numProcesso;
    }

    public BigInteger getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(BigInteger codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numProcesso != null ? numProcesso.hashCode() : 0);
        hash += (codEmpresa != null ? codEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ProcessoPK)) {
            return false;
        }
        ProcessoPK other = (ProcessoPK) object;
        if ((this.numProcesso == null && other.numProcesso != null) || (this.numProcesso != null && !this.numProcesso.equals(other.numProcesso))) {
            return false;
        }
        if ((this.codEmpresa == null && other.codEmpresa != null) || (this.codEmpresa != null && !this.codEmpresa.equals(other.codEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telefonica.processum.model.ProcessoPK[ numProcesso=" + numProcesso + ", codEmpresa=" + codEmpresa + " ]";
    }
    
}
