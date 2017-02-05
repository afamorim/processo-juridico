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
public class FuncionarioPK implements Serializable {

    @Column(name = "COD_EMPRESA")
    private BigInteger codEmpresa;
    
    @Column(name = "COD_FUNCIONARIO")
    private BigInteger codFuncionario;

    public FuncionarioPK() {
    }

    public FuncionarioPK(BigInteger codEmpresa, BigInteger codFuncionario) {
        this.codEmpresa = codEmpresa;
        this.codFuncionario = codFuncionario;
    }

    public BigInteger getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(BigInteger codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public BigInteger getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(BigInteger codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEmpresa != null ? codEmpresa.hashCode() : 0);
        hash += (codFuncionario != null ? codFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof FuncionarioPK)) {
            return false;
        }
        FuncionarioPK other = (FuncionarioPK) object;
        if ((this.codEmpresa == null && other.codEmpresa != null) || (this.codEmpresa != null && !this.codEmpresa.equals(other.codEmpresa))) {
            return false;
        }
        if ((this.codFuncionario == null && other.codFuncionario != null) || (this.codFuncionario != null && !this.codFuncionario.equals(other.codFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telefonica.processum.model.FuncionarioPK[ codEmpresa=" + codEmpresa + ", codFuncionario=" + codFuncionario + " ]";
    }
    
}
