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
public class DetalheEspecificNaturezaPK implements Serializable {

    @Column(name = "COD_NATUREZA")
    private BigInteger codNatureza;
    @Column(name = "COD_ESPECIFICACAO_NATUREZA")
    private BigInteger codEspecificacaoNatureza;
    @Column(name = "COD_DETALHE_ESPECIFIC_NATUREZA")
    private BigInteger codDetalheEspecificNatureza;

    public DetalheEspecificNaturezaPK() {
    }

    public DetalheEspecificNaturezaPK(BigInteger codNatureza, BigInteger codEspecificacaoNatureza, BigInteger codDetalheEspecificNatureza) {
        this.codNatureza = codNatureza;
        this.codEspecificacaoNatureza = codEspecificacaoNatureza;
        this.codDetalheEspecificNatureza = codDetalheEspecificNatureza;
    }

    public BigInteger getCodNatureza() {
        return codNatureza;
    }

    public void setCodNatureza(BigInteger codNatureza) {
        this.codNatureza = codNatureza;
    }

    public BigInteger getCodEspecificacaoNatureza() {
        return codEspecificacaoNatureza;
    }

    public void setCodEspecificacaoNatureza(BigInteger codEspecificacaoNatureza) {
        this.codEspecificacaoNatureza = codEspecificacaoNatureza;
    }

    public BigInteger getCodDetalheEspecificNatureza() {
        return codDetalheEspecificNatureza;
    }

    public void setCodDetalheEspecificNatureza(BigInteger codDetalheEspecificNatureza) {
        this.codDetalheEspecificNatureza = codDetalheEspecificNatureza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codNatureza != null ? codNatureza.hashCode() : 0);
        hash += (codEspecificacaoNatureza != null ? codEspecificacaoNatureza.hashCode() : 0);
        hash += (codDetalheEspecificNatureza != null ? codDetalheEspecificNatureza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DetalheEspecificNaturezaPK)) {
            return false;
        }
        DetalheEspecificNaturezaPK other = (DetalheEspecificNaturezaPK) object;
        if ((this.codNatureza == null && other.codNatureza != null) || (this.codNatureza != null && !this.codNatureza.equals(other.codNatureza))) {
            return false;
        }
        if ((this.codEspecificacaoNatureza == null && other.codEspecificacaoNatureza != null) || (this.codEspecificacaoNatureza != null && !this.codEspecificacaoNatureza.equals(other.codEspecificacaoNatureza))) {
            return false;
        }
        if ((this.codDetalheEspecificNatureza == null && other.codDetalheEspecificNatureza != null) || (this.codDetalheEspecificNatureza != null && !this.codDetalheEspecificNatureza.equals(other.codDetalheEspecificNatureza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vivo.processum.entity.DetalheEspecificNaturezaPK[ codNatureza=" + codNatureza + ", codEspecificacaoNatureza=" + codEspecificacaoNatureza + ", codDetalheEspecificNatureza=" + codDetalheEspecificNatureza + " ]";
    }
    
}
