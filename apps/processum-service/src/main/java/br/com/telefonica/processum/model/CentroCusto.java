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
@Table(name = "CENTRO_CUSTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CentroCusto.findAll", query = "SELECT c FROM CentroCusto c")
    , @NamedQuery(name = "CentroCusto.findBySigCentroCusto", query = "SELECT c FROM CentroCusto c WHERE c.sigCentroCusto = :sigCentroCusto")
    , @NamedQuery(name = "CentroCusto.findByDesCentroCusto", query = "SELECT c FROM CentroCusto c WHERE c.desCentroCusto = :desCentroCusto")})
public class CentroCusto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Size(max = 20)
    @Column(name = "SIG_CENTRO_CUSTO")
    private String sigCentroCusto;
    
    @Size(max = 50)
    @Column(name = "DES_CENTRO_CUSTO")
    private String desCentroCusto;
    
    @Size(max = 1)
    @Column(name = "STS_ATIVO")
    private String stsAtivo;
    
    @Size(max = 1)
    @Column(name = "STS_DEPARTAMENTO")
    private String stsDepartamento;
    
    public CentroCusto() {
    }

    public CentroCusto(String sigCentroCusto) {
        this.sigCentroCusto = sigCentroCusto;
    }

    public String getSigCentroCusto() {
        return sigCentroCusto;
    }

    public void setSigCentroCusto(String sigCentroCusto) {
        this.sigCentroCusto = sigCentroCusto;
    }

    public String getDesCentroCusto() {
        return desCentroCusto;
    }

    public void setDesCentroCusto(String desCentroCusto) {
        this.desCentroCusto = desCentroCusto;
    }

    public String getStsAtivo() {
        return stsAtivo;
    }

    public void setStsAtivo(String stsAtivo) {
        this.stsAtivo = stsAtivo;
    }

    public String getStsDepartamento() {
        return stsDepartamento;
    }

    public void setStsDepartamento(String stsDepartamento) {
        this.stsDepartamento = stsDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sigCentroCusto != null ? sigCentroCusto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CentroCusto)) {
            return false;
        }
        CentroCusto other = (CentroCusto) object;
        if ((this.sigCentroCusto == null && other.sigCentroCusto != null) || (this.sigCentroCusto != null && !this.sigCentroCusto.equals(other.sigCentroCusto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telefonica.processum.model.CentroCusto[ sigCentroCusto=" + sigCentroCusto + " ]";
    }
    
}
