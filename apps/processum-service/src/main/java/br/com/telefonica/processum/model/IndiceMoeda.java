package br.com.telefonica.processum.model;

import java.io.Serializable;
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
@Table(name = "INDICE_MOEDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IndiceMoeda.findAll", query = "SELECT i FROM IndiceMoeda i")
    , @NamedQuery(name = "IndiceMoeda.findBySigIndiceMoeda", query = "SELECT i FROM IndiceMoeda i WHERE i.sigIndiceMoeda = :sigIndiceMoeda")
    , @NamedQuery(name = "IndiceMoeda.findByNomIndiceMoeda", query = "SELECT i FROM IndiceMoeda i WHERE i.nomIndiceMoeda = :nomIndiceMoeda")})
public class IndiceMoeda implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Size(max = 5)
    @Column(name = "SIG_INDICE_MOEDA")
    private String sigIndiceMoeda;
    
    @Size(max = 30)
    @Column(name = "NOM_INDICE_MOEDA")
    private String nomIndiceMoeda;
    
    public IndiceMoeda() {
    }

    public IndiceMoeda(String sigIndiceMoeda) {
        this.sigIndiceMoeda = sigIndiceMoeda;
    }

    public String getSigIndiceMoeda() {
        return sigIndiceMoeda;
    }

    public void setSigIndiceMoeda(String sigIndiceMoeda) {
        this.sigIndiceMoeda = sigIndiceMoeda;
    }

    public String getNomIndiceMoeda() {
        return nomIndiceMoeda;
    }

    public void setNomIndiceMoeda(String nomIndiceMoeda) {
        this.nomIndiceMoeda = nomIndiceMoeda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sigIndiceMoeda != null ? sigIndiceMoeda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof IndiceMoeda)) {
            return false;
        }
        IndiceMoeda other = (IndiceMoeda) object;
        if ((this.sigIndiceMoeda == null && other.sigIndiceMoeda != null) || (this.sigIndiceMoeda != null && !this.sigIndiceMoeda.equals(other.sigIndiceMoeda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telefonica.processum.model.IndiceMoeda[ sigIndiceMoeda=" + sigIndiceMoeda + " ]";
    }
    
}
