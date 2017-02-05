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
public class LotacaoPK implements Serializable {

    @Column(name = "COD_EMPRESA")
    private BigInteger codEmpresa;
    
    @Column(name = "COD_LOTACAO")
    private BigInteger codLotacao;

    public LotacaoPK() {
    }

    public LotacaoPK(BigInteger codEmpresa, BigInteger codLotacao) {
        this.codEmpresa = codEmpresa;
        this.codLotacao = codLotacao;
    }

    public BigInteger getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(BigInteger codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public BigInteger getCodLotacao() {
        return codLotacao;
    }

    public void setCodLotacao(BigInteger codLotacao) {
        this.codLotacao = codLotacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEmpresa != null ? codEmpresa.hashCode() : 0);
        hash += (codLotacao != null ? codLotacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof LotacaoPK)) {
            return false;
        }
        LotacaoPK other = (LotacaoPK) object;
        if ((this.codEmpresa == null && other.codEmpresa != null) || (this.codEmpresa != null && !this.codEmpresa.equals(other.codEmpresa))) {
            return false;
        }
        if ((this.codLotacao == null && other.codLotacao != null) || (this.codLotacao != null && !this.codLotacao.equals(other.codLotacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telefonica.processum.model.LotacaoPK[ codEmpresa=" + codEmpresa + ", codLotacao=" + codLotacao + " ]";
    }
    
}
