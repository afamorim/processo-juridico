package br.com.telefonica.processum.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jadossantos
 */
@Entity
@Table(name = "TIPO_PROVISAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoProvisao.findAll", query = "SELECT t FROM TipoProvisao t")
    , @NamedQuery(name = "TipoProvisao.findByCodTipoProvisao", query = "SELECT t FROM TipoProvisao t WHERE t.codTipoProvisao = :codTipoProvisao")
    , @NamedQuery(name = "TipoProvisao.findByStrNomeTipoProvisao", query = "SELECT t FROM TipoProvisao t WHERE t.strNomeTipoProvisao = :strNomeTipoProvisao")})
public class TipoProvisao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_TIPO_PROVISAO")
    private BigDecimal codTipoProvisao;
    
    @Size(max = 50)
    @Column(name = "STR_NOME_TIPO_PROVISAO")
    private String strNomeTipoProvisao;
    
    public TipoProvisao() {
    }

    public TipoProvisao(BigDecimal codTipoProvisao) {
        this.codTipoProvisao = codTipoProvisao;
    }

    public BigDecimal getCodTipoProvisao() {
        return codTipoProvisao;
    }

    public void setCodTipoProvisao(BigDecimal codTipoProvisao) {
        this.codTipoProvisao = codTipoProvisao;
    }

    public String getStrNomeTipoProvisao() {
        return strNomeTipoProvisao;
    }

    public void setStrNomeTipoProvisao(String strNomeTipoProvisao) {
        this.strNomeTipoProvisao = strNomeTipoProvisao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipoProvisao != null ? codTipoProvisao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TipoProvisao)) {
            return false;
        }
        TipoProvisao other = (TipoProvisao) object;
        if ((this.codTipoProvisao == null && other.codTipoProvisao != null) || (this.codTipoProvisao != null && !this.codTipoProvisao.equals(other.codTipoProvisao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telefonica.processum.model.TipoProvisao[ codTipoProvisao=" + codTipoProvisao + " ]";
    }
    
}
