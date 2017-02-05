package br.com.telefonica.processum.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author jadossantos
 */
@Embeddable
public class CargoPK implements Serializable {

    @Column(name = "COD_EMPRESA")
    private BigInteger codEmpresa;
    
    @Column(name = "COD_CARGO")
    private BigInteger codCargo;

    public CargoPK() {
    }

    public CargoPK(BigInteger codEmpresa, BigInteger codCargo) {
        this.codEmpresa = codEmpresa;
        this.codCargo = codCargo;
    }

    public BigInteger getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(BigInteger codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public BigInteger getCodCargo() {
        return codCargo;
    }

    public void setCodCargo(BigInteger codCargo) {
        this.codCargo = codCargo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEmpresa != null ? codEmpresa.hashCode() : 0);
        hash += (codCargo != null ? codCargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CargoPK)) {
            return false;
        }
        CargoPK other = (CargoPK) object;
        if ((this.codEmpresa == null && other.codEmpresa != null) || (this.codEmpresa != null && !this.codEmpresa.equals(other.codEmpresa))) {
            return false;
        }
        if ((this.codCargo == null && other.codCargo != null) || (this.codCargo != null && !this.codCargo.equals(other.codCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telefonica.processum.model.CargoPK[ codEmpresa=" + codEmpresa + ", codCargo=" + codCargo + " ]";
    }
    
}
