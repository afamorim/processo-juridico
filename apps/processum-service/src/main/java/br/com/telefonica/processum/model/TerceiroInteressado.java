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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jadossantos
 */
@Entity
@Table(name = "TERCEIRO_INTERESSADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TerceiroInteressado.findAll", query = "SELECT t FROM TerceiroInteressado t")
    , @NamedQuery(name = "TerceiroInteressado.findByNumProcesso", query = "SELECT t FROM TerceiroInteressado t WHERE t.terceiroInteressadoPK.numProcesso = :numProcesso")})
public class TerceiroInteressado implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected TerceiroInteressadoPK terceiroInteressadoPK;
    
    @Column(name = "DTC_INICIO")
    @Temporal(TemporalType.DATE)
    private Date dtcInicio;
    
    @Column(name = "DTC_FIM")
    @Temporal(TemporalType.DATE)
    private Date dtcFim;
    
    @JoinColumn(name = "COD_PARTE_PROCESSO", referencedColumnName = "COD_PARTE_PROCESSO", insertable = false, updatable = false)
    @ManyToOne
    private ParteProcesso parteProcesso;
    
    public TerceiroInteressado() {
    }

    public TerceiroInteressado(TerceiroInteressadoPK terceiroInteressadoPK) {
        this.terceiroInteressadoPK = terceiroInteressadoPK;
    }

    public TerceiroInteressado(BigInteger codEmpresa, String numProcesso, BigInteger codParteProcesso) {
        this.terceiroInteressadoPK = new TerceiroInteressadoPK(codEmpresa, numProcesso, codParteProcesso);
    }

    public TerceiroInteressadoPK getTerceiroInteressadoPK() {
        return terceiroInteressadoPK;
    }

    public void setTerceiroInteressadoPK(TerceiroInteressadoPK terceiroInteressadoPK) {
        this.terceiroInteressadoPK = terceiroInteressadoPK;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (terceiroInteressadoPK != null ? terceiroInteressadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TerceiroInteressado)) {
            return false;
        }
        TerceiroInteressado other = (TerceiroInteressado) object;
        if ((this.terceiroInteressadoPK == null && other.terceiroInteressadoPK != null) || (this.terceiroInteressadoPK != null && !this.terceiroInteressadoPK.equals(other.terceiroInteressadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telefonica.processum.model.TerceiroInteressado[ terceiroInteressadoPK=" + terceiroInteressadoPK + " ]";
    }
    
}
