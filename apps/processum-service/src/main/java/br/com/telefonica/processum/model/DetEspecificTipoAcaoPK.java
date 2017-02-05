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
public class DetEspecificTipoAcaoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_TIPO_ACAO")
    private BigInteger codTipoAcao;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_ESPECIFIC_TIPO_ACAO")
    private BigInteger codEspecificTipoAcao;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_DET_ESPECIFIC_TIPO_ACAO")
    private BigInteger codDetEspecificTipoAcao;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_PRE_OBJETO_EMPRESA")
    private BigInteger codPreObjetoEmpresa;

    public DetEspecificTipoAcaoPK() {
    }

    public DetEspecificTipoAcaoPK(BigInteger codTipoAcao, BigInteger codEspecificTipoAcao, BigInteger codDetEspecificTipoAcao, BigInteger codPreObjetoEmpresa) {
        this.codTipoAcao = codTipoAcao;
        this.codEspecificTipoAcao = codEspecificTipoAcao;
        this.codDetEspecificTipoAcao = codDetEspecificTipoAcao;
        this.codPreObjetoEmpresa = codPreObjetoEmpresa;
    }

    public BigInteger getCodTipoAcao() {
        return codTipoAcao;
    }

    public void setCodTipoAcao(BigInteger codTipoAcao) {
        this.codTipoAcao = codTipoAcao;
    }

    public BigInteger getCodEspecificTipoAcao() {
        return codEspecificTipoAcao;
    }

    public void setCodEspecificTipoAcao(BigInteger codEspecificTipoAcao) {
        this.codEspecificTipoAcao = codEspecificTipoAcao;
    }

    public BigInteger getCodDetEspecificTipoAcao() {
        return codDetEspecificTipoAcao;
    }

    public void setCodDetEspecificTipoAcao(BigInteger codDetEspecificTipoAcao) {
        this.codDetEspecificTipoAcao = codDetEspecificTipoAcao;
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
        hash += (codTipoAcao != null ? codTipoAcao.hashCode() : 0);
        hash += (codEspecificTipoAcao != null ? codEspecificTipoAcao.hashCode() : 0);
        hash += (codDetEspecificTipoAcao != null ? codDetEspecificTipoAcao.hashCode() : 0);
        hash += (codPreObjetoEmpresa != null ? codPreObjetoEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DetEspecificTipoAcaoPK)) {
            return false;
        }
        DetEspecificTipoAcaoPK other = (DetEspecificTipoAcaoPK) object;
        if ((this.codTipoAcao == null && other.codTipoAcao != null) || (this.codTipoAcao != null && !this.codTipoAcao.equals(other.codTipoAcao))) {
            return false;
        }
        if ((this.codEspecificTipoAcao == null && other.codEspecificTipoAcao != null) || (this.codEspecificTipoAcao != null && !this.codEspecificTipoAcao.equals(other.codEspecificTipoAcao))) {
            return false;
        }
        if ((this.codDetEspecificTipoAcao == null && other.codDetEspecificTipoAcao != null) || (this.codDetEspecificTipoAcao != null && !this.codDetEspecificTipoAcao.equals(other.codDetEspecificTipoAcao))) {
            return false;
        }
        if ((this.codPreObjetoEmpresa == null && other.codPreObjetoEmpresa != null) || (this.codPreObjetoEmpresa != null && !this.codPreObjetoEmpresa.equals(other.codPreObjetoEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telefonica.processum.model.DetEspecificTipoAcaoPK[ codTipoAcao=" + codTipoAcao + ", codEspecificTipoAcao=" + codEspecificTipoAcao + ", codDetEspecificTipoAcao=" + codDetEspecificTipoAcao + ", codPreObjetoEmpresa=" + codPreObjetoEmpresa + " ]";
    }
    
}
