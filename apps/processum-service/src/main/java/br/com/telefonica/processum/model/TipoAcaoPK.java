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
public class TipoAcaoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_TIPO_ACAO")
    private BigInteger codTipoAcao;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_PRE_OBJETO_EMPRESA")
    private BigInteger codPreObjetoEmpresa;

    public TipoAcaoPK() {
    }

    public TipoAcaoPK(BigInteger codTipoAcao, BigInteger codPreObjetoEmpresa) {
        this.codTipoAcao = codTipoAcao;
        this.codPreObjetoEmpresa = codPreObjetoEmpresa;
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
        hash += (codTipoAcao != null ? codTipoAcao.hashCode() : 0);
        hash += (codPreObjetoEmpresa != null ? codPreObjetoEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TipoAcaoPK)) {
            return false;
        }
        TipoAcaoPK other = (TipoAcaoPK) object;
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
        return "br.com.vivo.processum.model.TipoAcaoPK[ codTipoAcao=" + codTipoAcao + ", codPreObjetoEmpresa=" + codPreObjetoEmpresa + " ]";
    }
    
}
