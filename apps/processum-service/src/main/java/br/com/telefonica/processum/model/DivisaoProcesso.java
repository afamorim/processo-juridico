package br.com.telefonica.processum.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author ifbomfim
 */
@Entity
@Table(name = "DIVISAO_PROCESSO")
@NamedQueries({
    @NamedQuery(name = "DivisaoProcesso.findAll", query = "SELECT d FROM DivisaoProcesso d")
    , @NamedQuery(name = "DivisaoProcesso.findByCodDivisaoProcesso", query = "SELECT d FROM DivisaoProcesso d WHERE d.codDivisaoProcesso = :codDivisaoProcesso")
    , @NamedQuery(name = "DivisaoProcesso.findByNomDivisao", query = "SELECT d FROM DivisaoProcesso d WHERE d.nomDivisao = :nomDivisao")
    , @NamedQuery(name = "DivisaoProcesso.findBySigDivisao", query = "SELECT d FROM DivisaoProcesso d WHERE d.sigDivisao = :sigDivisao")})
public class DivisaoProcesso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "COD_DIVISAO_PROCESSO")
    private BigDecimal codDivisaoProcesso;
    
    @Size(max = 50)
    @Column(name = "NOM_DIVISAO")
    private String nomDivisao;
    
    @Size(max = 6)
    @Column(name = "SIG_DIVISAO")
    private String sigDivisao;
    
    @Column(name = "STS_TIPO_PROVISAO_AUTOMATICA")
    private BigInteger stsTipoProvisaoAutomatica;
    
    @Size(max = 1)
    @Column(name = "STS_ATIVO_DIVISAO")
    private String stsAtivoDivisao;

    public DivisaoProcesso() {
    }

    public DivisaoProcesso(BigDecimal codDivisaoProcesso) {
        this.codDivisaoProcesso = codDivisaoProcesso;
    }

    public BigDecimal getCodDivisaoProcesso() {
        return codDivisaoProcesso;
    }

    public void setCodDivisaoProcesso(BigDecimal codDivisaoProcesso) {
        this.codDivisaoProcesso = codDivisaoProcesso;
    }

    public String getNomDivisao() {
        return nomDivisao;
    }

    public void setNomDivisao(String nomDivisao) {
        this.nomDivisao = nomDivisao;
    }

    public String getSigDivisao() {
        return sigDivisao;
    }

    public void setSigDivisao(String sigDivisao) {
        this.sigDivisao = sigDivisao;
    }

    public BigInteger getStsTipoProvisaoAutomatica() {
        return stsTipoProvisaoAutomatica;
    }

    public void setStsTipoProvisaoAutomatica(BigInteger stsTipoProvisaoAutomatica) {
        this.stsTipoProvisaoAutomatica = stsTipoProvisaoAutomatica;
    }

    public String getStsAtivoDivisao() {
        return stsAtivoDivisao;
    }

    public void setStsAtivoDivisao(String stsAtivoDivisao) {
        this.stsAtivoDivisao = stsAtivoDivisao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDivisaoProcesso != null ? codDivisaoProcesso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DivisaoProcesso)) {
            return false;
        }
        DivisaoProcesso other = (DivisaoProcesso) object;
        if ((this.codDivisaoProcesso == null && other.codDivisaoProcesso != null) || (this.codDivisaoProcesso != null && !this.codDivisaoProcesso.equals(other.codDivisaoProcesso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vivo.processum.model.DivisaoProcesso[ codDivisaoProcesso=" + codDivisaoProcesso + " ]";
    }

}
