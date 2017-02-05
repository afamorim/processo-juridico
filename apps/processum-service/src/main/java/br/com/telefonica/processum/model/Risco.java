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
 * @author jadossantos
 */
@Entity
@Table(name = "RISCO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Risco.findAll", query = "SELECT r FROM Risco r")
    , @NamedQuery(name = "Risco.findByCodRisco", query = "SELECT r FROM Risco r WHERE r.codRisco = :codRisco")
    , @NamedQuery(name = "Risco.findByNomRisco", query = "SELECT r FROM Risco r WHERE r.nomRisco = :nomRisco")})
public class Risco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "COD_RISCO")
    private BigDecimal codRisco;
    
    @Size(max = 30)
    @Column(name = "NOM_RISCO")
    private String nomRisco;
    
    public Risco() {
    }

    public Risco(BigDecimal codRisco) {
        this.codRisco = codRisco;
    }

    public BigDecimal getCodRisco() {
        return codRisco;
    }

    public void setCodRisco(BigDecimal codRisco) {
        this.codRisco = codRisco;
    }

    public String getNomRisco() {
        return nomRisco;
    }

    public void setNomRisco(String nomRisco) {
        this.nomRisco = nomRisco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codRisco != null ? codRisco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Risco)) {
            return false;
        }
        Risco other = (Risco) object;
        if ((this.codRisco == null && other.codRisco != null) || (this.codRisco != null && !this.codRisco.equals(other.codRisco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telefonica.processum.model.Risco[ codRisco=" + codRisco + " ]";
    }
    
}
