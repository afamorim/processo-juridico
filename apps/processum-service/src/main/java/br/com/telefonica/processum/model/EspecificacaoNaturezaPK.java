package br.com.telefonica.processum.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author ifbomfim
 */
@Embeddable
public class EspecificacaoNaturezaPK implements Serializable {

    @Column(name = "COD_ESPECIFICACAO_NATUREZA")
    private BigInteger codEspecificacaoNatureza;
    @Column(name = "COD_NATUREZA")
    private BigInteger codNatureza;

    public EspecificacaoNaturezaPK() {
    }

    public EspecificacaoNaturezaPK(BigInteger codEspecificacaoNatureza, BigInteger codNatureza) {
        this.codEspecificacaoNatureza = codEspecificacaoNatureza;
        this.codNatureza = codNatureza;
    }

    public BigInteger getCodEspecificacaoNatureza() {
        return codEspecificacaoNatureza;
    }

    public void setCodEspecificacaoNatureza(BigInteger codEspecificacaoNatureza) {
        this.codEspecificacaoNatureza = codEspecificacaoNatureza;
    }

    public BigInteger getCodNatureza() {
        return codNatureza;
    }

    public void setCodNatureza(BigInteger codNatureza) {
        this.codNatureza = codNatureza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEspecificacaoNatureza != null ? codEspecificacaoNatureza.hashCode() : 0);
        hash += (codNatureza != null ? codNatureza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EspecificacaoNaturezaPK)) {
            return false;
        }
        EspecificacaoNaturezaPK other = (EspecificacaoNaturezaPK) object;
        if ((this.codEspecificacaoNatureza == null && other.codEspecificacaoNatureza != null) || (this.codEspecificacaoNatureza != null && !this.codEspecificacaoNatureza.equals(other.codEspecificacaoNatureza))) {
            return false;
        }
        if ((this.codNatureza == null && other.codNatureza != null) || (this.codNatureza != null && !this.codNatureza.equals(other.codNatureza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vivo.processum.entity.EspecificacaoNaturezaPK[ codEspecificacaoNatureza=" + codEspecificacaoNatureza + ", codNatureza=" + codNatureza + " ]";
    }
    
}
