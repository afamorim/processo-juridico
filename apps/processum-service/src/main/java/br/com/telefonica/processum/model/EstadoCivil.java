package br.com.telefonica.processum.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ifbomfim
 */
@Entity
@Table(name = "ESTADO_CIVIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoCivil.findAll", query = "SELECT e FROM EstadoCivil e")
    , @NamedQuery(name = "EstadoCivil.findByCodEstadoCivil", query = "SELECT e FROM EstadoCivil e WHERE e.codEstadoCivil = :codEstadoCivil")
    , @NamedQuery(name = "EstadoCivil.findByDesEstadoCivil", query = "SELECT e FROM EstadoCivil e WHERE e.desEstadoCivil = :desEstadoCivil")})
public class EstadoCivil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "COD_ESTADO_CIVIL")
    private BigDecimal codEstadoCivil;
    
    @Size(max = 30)
    @Column(name = "DES_ESTADO_CIVIL")
    private String desEstadoCivil;

    public EstadoCivil() {
    }

    public EstadoCivil(BigDecimal codEstadoCivil) {
        this.codEstadoCivil = codEstadoCivil;
    }

    public BigDecimal getCodEstadoCivil() {
        return codEstadoCivil;
    }

    public void setCodEstadoCivil(BigDecimal codEstadoCivil) {
        this.codEstadoCivil = codEstadoCivil;
    }

    public String getDesEstadoCivil() {
        return desEstadoCivil;
    }

    public void setDesEstadoCivil(String desEstadoCivil) {
        this.desEstadoCivil = desEstadoCivil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEstadoCivil != null ? codEstadoCivil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EstadoCivil)) {
            return false;
        }
        EstadoCivil other = (EstadoCivil) object;
        if ((this.codEstadoCivil == null && other.codEstadoCivil != null) || (this.codEstadoCivil != null && !this.codEstadoCivil.equals(other.codEstadoCivil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vivo.processum.entity.EstadoCivil[ codEstadoCivil=" + codEstadoCivil + " ]";
    }

}
