package br.com.telefonica.processum.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jadossantos
 */
@Embeddable
public class EspecificTipoAcaoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_ESPECIFIC_TIPO_ACAO")
    private BigInteger codEspecificTipoAcao;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_TIPO_ACAO")
    private BigInteger codTipoAcao;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_PRE_OBJETO_EMPRESA")
    private BigInteger codPreObjetoEmpresa;

    public EspecificTipoAcaoPK() {
    }

    public EspecificTipoAcaoPK(BigInteger codEspecificTipoAcao, BigInteger codTipoAcao, BigInteger codPreObjetoEmpresa) {
        this.codEspecificTipoAcao = codEspecificTipoAcao;
        this.codTipoAcao = codTipoAcao;
        this.codPreObjetoEmpresa = codPreObjetoEmpresa;
    }

    public BigInteger getCodEspecificTipoAcao() {
        return codEspecificTipoAcao;
    }

    public void setCodEspecificTipoAcao(BigInteger codEspecificTipoAcao) {
        this.codEspecificTipoAcao = codEspecificTipoAcao;
    }

    public BigInteger getCodTipoAcao() {
        return codTipoAcao;
    }

    public void setCodTipoAcao(BigInteger codTipoAcao) {
        this.codTipoAcao = codTipoAcao;
    }

    public BigInteger getCodPreObjetoEmpresa() {
        return codPreObjetoEmpresa;
    }

    public void setCodPreObjetoEmpresa(BigInteger codPreObjetoEmpresa) {
        this.codPreObjetoEmpresa = codPreObjetoEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEspecificTipoAcao != null ? codEspecificTipoAcao.hashCode() : 0);
        hash += (codTipoAcao != null ? codTipoAcao.hashCode() : 0);
        hash += (codPreObjetoEmpresa != null ? codPreObjetoEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EspecificTipoAcaoPK)) {
            return false;
        }
        EspecificTipoAcaoPK other = (EspecificTipoAcaoPK) object;
        if ((this.codEspecificTipoAcao == null && other.codEspecificTipoAcao != null) || (this.codEspecificTipoAcao != null && !this.codEspecificTipoAcao.equals(other.codEspecificTipoAcao))) {
            return false;
        }
        if ((this.codTipoAcao == null && other.codTipoAcao != null) || (this.codTipoAcao != null && !this.codTipoAcao.equals(other.codTipoAcao))) {
            return false;
        }
        if ((this.codPreObjetoEmpresa == null && other.codPreObjetoEmpresa != null) || (this.codPreObjetoEmpresa != null && !this.codPreObjetoEmpresa.equals(other.codPreObjetoEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telefonica.processum.model.EspecificTipoAcaoPK[ codEspecificTipoAcao=" + codEspecificTipoAcao + ", codTipoAcao=" + codTipoAcao + ", codPreObjetoEmpresa=" + codPreObjetoEmpresa + " ]";
    }

}
