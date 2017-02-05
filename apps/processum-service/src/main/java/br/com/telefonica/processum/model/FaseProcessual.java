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
@Table(name = "FASE_PROCESSUAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FaseProcessual.findAll", query = "SELECT f FROM FaseProcessual f")
    , @NamedQuery(name = "FaseProcessual.findByCodFaseProcessual", query = "SELECT f FROM FaseProcessual f WHERE f.codFaseProcessual = :codFaseProcessual")
    , @NamedQuery(name = "FaseProcessual.findByNomFaseProcessual", query = "SELECT f FROM FaseProcessual f WHERE f.nomFaseProcessual = :nomFaseProcessual")})
public class FaseProcessual implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "COD_FASE_PROCESSUAL")
    private BigDecimal codFaseProcessual;
    
    @Size(max = 40)
    @Column(name = "NOM_FASE_PROCESSUAL")
    private String nomFaseProcessual;

    public FaseProcessual() {
    }

    public FaseProcessual(BigDecimal codFaseProcessual) {
        this.codFaseProcessual = codFaseProcessual;
    }

    public BigDecimal getCodFaseProcessual() {
        return codFaseProcessual;
    }

    public void setCodFaseProcessual(BigDecimal codFaseProcessual) {
        this.codFaseProcessual = codFaseProcessual;
    }

    public String getNomFaseProcessual() {
        return nomFaseProcessual;
    }

    public void setNomFaseProcessual(String nomFaseProcessual) {
        this.nomFaseProcessual = nomFaseProcessual;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFaseProcessual != null ? codFaseProcessual.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof FaseProcessual)) {
            return false;
        }
        FaseProcessual other = (FaseProcessual) object;
        if ((this.codFaseProcessual == null && other.codFaseProcessual != null) || (this.codFaseProcessual != null && !this.codFaseProcessual.equals(other.codFaseProcessual))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telefonica.processum.model.FaseProcessual[ codFaseProcessual=" + codFaseProcessual + " ]";
    }
    
}
