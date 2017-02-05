package br.com.telefonica.processum.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jadossantos
 */
@Entity
@Table(name = "CARGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c")
    , @NamedQuery(name = "Cargo.findByCodEmpresa", query = "SELECT c FROM Cargo c WHERE c.cargoPK.codEmpresa = :codEmpresa")
    , @NamedQuery(name = "Cargo.findByCodCargo", query = "SELECT c FROM Cargo c WHERE c.cargoPK.codCargo = :codCargo")
    , @NamedQuery(name = "Cargo.findByNomCargo", query = "SELECT c FROM Cargo c WHERE c.nomCargo = :nomCargo")})
public class Cargo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected CargoPK cargoPK;
    
    @Size(max = 50)
    @Column(name = "NOM_CARGO")
    private String nomCargo;
    
    @JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false)
    @ManyToOne
    private Empresa empresa;
    
    public Cargo() {
    }

    public Cargo(CargoPK cargoPK) {
        this.cargoPK = cargoPK;
    }

    public Cargo(BigInteger codEmpresa, BigInteger codCargo) {
        this.cargoPK = new CargoPK(codEmpresa, codCargo);
    }

    public CargoPK getCargoPK() {
        return cargoPK;
    }

    public void setCargoPK(CargoPK cargoPK) {
        this.cargoPK = cargoPK;
    }

    public String getNomCargo() {
        return nomCargo;
    }

    public void setNomCargo(String nomCargo) {
        this.nomCargo = nomCargo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cargoPK != null ? cargoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.cargoPK == null && other.cargoPK != null) || (this.cargoPK != null && !this.cargoPK.equals(other.cargoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telefonica.processum.model.Cargo[ cargoPK=" + cargoPK + " ]";
    }
    
}
