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
 * @author ifbomfim
 */
@Entity
@Table(name = "PRE_OBJETO_EMPRESA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreObjetoEmpresa.findAll", query = "SELECT p FROM PreObjetoEmpresa p")
    , @NamedQuery(name = "PreObjetoEmpresa.findByCodPreObjetoEmpresa", query = "SELECT p FROM PreObjetoEmpresa p WHERE p.codPreObjetoEmpresa = :codPreObjetoEmpresa")
    , @NamedQuery(name = "PreObjetoEmpresa.findByNomPreObjetoEmpresa", query = "SELECT p FROM PreObjetoEmpresa p WHERE p.nomPreObjetoEmpresa = :nomPreObjetoEmpresa")})
public class PreObjetoEmpresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_PRE_OBJETO_EMPRESA")
    private BigDecimal codPreObjetoEmpresa;
    
    @Size(max = 50)
    @Column(name = "NOM_PRE_OBJETO_EMPRESA")
    private String nomPreObjetoEmpresa;

    public PreObjetoEmpresa() {
    }

    public PreObjetoEmpresa(BigDecimal codPreObjetoEmpresa) {
        this.codPreObjetoEmpresa = codPreObjetoEmpresa;
    }

    public BigDecimal getCodPreObjetoEmpresa() {
        return codPreObjetoEmpresa;
    }

    public void setCodPreObjetoEmpresa(BigDecimal codPreObjetoEmpresa) {
        this.codPreObjetoEmpresa = codPreObjetoEmpresa;
    }

    public String getNomPreObjetoEmpresa() {
        return nomPreObjetoEmpresa;
    }

    public void setNomPreObjetoEmpresa(String nomPreObjetoEmpresa) {
        this.nomPreObjetoEmpresa = nomPreObjetoEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPreObjetoEmpresa != null ? codPreObjetoEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PreObjetoEmpresa)) {
            return false;
        }
        PreObjetoEmpresa other = (PreObjetoEmpresa) object;
        if ((this.codPreObjetoEmpresa == null && other.codPreObjetoEmpresa != null) || (this.codPreObjetoEmpresa != null && !this.codPreObjetoEmpresa.equals(other.codPreObjetoEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vivo.processum.model.PreObjetoEmpresa[ codPreObjetoEmpresa=" + codPreObjetoEmpresa + " ]";
    }

}
