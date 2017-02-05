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
@Table(name = "SOLVENCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solvencia.findAll", query = "SELECT s FROM Solvencia s")
    , @NamedQuery(name = "Solvencia.findByCodSolvencia", query = "SELECT s FROM Solvencia s WHERE s.codSolvencia = :codSolvencia")
    , @NamedQuery(name = "Solvencia.findByNomSolvencia", query = "SELECT s FROM Solvencia s WHERE s.nomSolvencia = :nomSolvencia")})
public class Solvencia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_SOLVENCIA")
    private BigDecimal codSolvencia;
    
    @Size(max = 50)
    @Column(name = "NOM_SOLVENCIA")
    private String nomSolvencia;

    public Solvencia() {
    }

    public Solvencia(BigDecimal codSolvencia) {
        this.codSolvencia = codSolvencia;
    }

    public BigDecimal getCodSolvencia() {
        return codSolvencia;
    }

    public void setCodSolvencia(BigDecimal codSolvencia) {
        this.codSolvencia = codSolvencia;
    }

    public String getNomSolvencia() {
        return nomSolvencia;
    }

    public void setNomSolvencia(String nomSolvencia) {
        this.nomSolvencia = nomSolvencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSolvencia != null ? codSolvencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Solvencia)) {
            return false;
        }
        Solvencia other = (Solvencia) object;
        if ((this.codSolvencia == null && other.codSolvencia != null) || (this.codSolvencia != null && !this.codSolvencia.equals(other.codSolvencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telefonica.processum.model.Solvencia[ codSolvencia=" + codSolvencia + " ]";
    }
    
}
