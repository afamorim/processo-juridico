package br.com.telefonica.processum.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jadossantos
 */
@Entity
@Table(name = "REU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reu.findAll", query = "SELECT r FROM Reu r")
    , @NamedQuery(name = "Reu.findByNumProcesso", query = "SELECT r FROM Reu r WHERE r.reuPK.numProcesso = :numProcesso")})
public class Reu implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReuPK reuPK;
    
    @Column(name = "DTC_INICIO")
    @Temporal(TemporalType.DATE)
    private Date dtcInicio;
    
    @Column(name = "DTC_FIM")
    @Temporal(TemporalType.DATE)
    private Date dtcFim;
    
    @Size(max = 1)
    @Column(name = "STS_SOLVENCIA")
    private String stsSolvencia;
    
    @Size(max = 1)
    @Column(name = "STS_MIGRACAO_BENNER")
    private String stsMigracaoBenner;
    
    @JoinColumn(name = "COD_PARTE_PROCESSO", referencedColumnName = "COD_PARTE_PROCESSO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ParteProcesso parteProcesso;
    
    public Reu() {
    }

    public Reu(ReuPK reuPK) {
        this.reuPK = reuPK;
    }

    public Reu(BigInteger codEmpresa, String numProcesso, BigInteger codParteProcesso) {
        this.reuPK = new ReuPK(codEmpresa, numProcesso, codParteProcesso);
    }

    public ReuPK getReuPK() {
        return reuPK;
    }

    public void setReuPK(ReuPK reuPK) {
        this.reuPK = reuPK;
    }

    public Date getDtcInicio() {
        return dtcInicio;
    }

    public void setDtcInicio(Date dtcInicio) {
        this.dtcInicio = dtcInicio;
    }

    public Date getDtcFim() {
        return dtcFim;
    }

    public void setDtcFim(Date dtcFim) {
        this.dtcFim = dtcFim;
    }

    public String getStsSolvencia() {
        return stsSolvencia;
    }

    public void setStsSolvencia(String stsSolvencia) {
        this.stsSolvencia = stsSolvencia;
    }

    public String getStsMigracaoBenner() {
        return stsMigracaoBenner;
    }

    public void setStsMigracaoBenner(String stsMigracaoBenner) {
        this.stsMigracaoBenner = stsMigracaoBenner;
    }

    public ParteProcesso getParteProcesso() {
        return parteProcesso;
    }

    public void setParteProcesso(ParteProcesso parteProcesso) {
        this.parteProcesso = parteProcesso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reuPK != null ? reuPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reu)) {
            return false;
        }
        Reu other = (Reu) object;
        if ((this.reuPK == null && other.reuPK != null) || (this.reuPK != null && !this.reuPK.equals(other.reuPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telefonica.processum.model.Reu[ reuPK=" + reuPK + " ]";
    }
    
}
