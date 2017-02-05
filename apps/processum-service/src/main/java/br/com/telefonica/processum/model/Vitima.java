package br.com.telefonica.processum.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jadossantos
 */
@Entity
@Table(name = "VITIMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vitima.findAll", query = "SELECT v FROM Vitima v")
    , @NamedQuery(name = "Vitima.findByNumProcesso", query = "SELECT v FROM Vitima v WHERE v.vitimaPK.numProcesso = :numProcesso")})
public class Vitima implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    
    protected VitimaPK vitimaPK;
    @Column(name = "DTC_INICIO")
    @Temporal(TemporalType.DATE)
    private Date dtcInicio;
    
    @Column(name = "DTC_FIM")
    @Temporal(TemporalType.DATE)
    private Date dtcFim;
    
    @JoinColumn(name = "COD_PARTE_PROCESSO", referencedColumnName = "COD_PARTE_PROCESSO", insertable = false, updatable = false)
    @ManyToOne
    private ParteProcesso parteProcesso;
    
    @JoinColumns({
        @JoinColumn(name = "NUM_PROCESSO", referencedColumnName = "NUM_PROCESSO", insertable = false, updatable = false)
        , @JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false)})
    @ManyToOne
    private Processo processo;

    public Vitima() {
    }

    public Vitima(VitimaPK vitimaPK) {
        this.vitimaPK = vitimaPK;
    }

    public Vitima(BigInteger codEmpresa, String numProcesso, BigInteger codParteProcesso) {
        this.vitimaPK = new VitimaPK(codEmpresa, numProcesso, codParteProcesso);
    }

    public VitimaPK getVitimaPK() {
        return vitimaPK;
    }

    public void setVitimaPK(VitimaPK vitimaPK) {
        this.vitimaPK = vitimaPK;
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

    public ParteProcesso getParteProcesso() {
        return parteProcesso;
    }

    public void setParteProcesso(ParteProcesso parteProcesso) {
        this.parteProcesso = parteProcesso;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vitimaPK != null ? vitimaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Vitima)) {
            return false;
        }
        Vitima other = (Vitima) object;
        if ((this.vitimaPK == null && other.vitimaPK != null) || (this.vitimaPK != null && !this.vitimaPK.equals(other.vitimaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telefonica.processum.model.Vitima[ vitimaPK=" + vitimaPK + " ]";
    }
    
}
