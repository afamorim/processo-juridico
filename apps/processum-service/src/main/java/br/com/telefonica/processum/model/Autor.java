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
@Table(name = "AUTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autor.findAll", query = "SELECT a FROM Autor a")
    , @NamedQuery(name = "Autor.findByNumProcesso", query = "SELECT a FROM Autor a WHERE a.autorPK.numProcesso = :numProcesso")})
public class Autor implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AutorPK autorPK;
    
    @Column(name = "DTC_INICIO")
    @Temporal(TemporalType.DATE)
    private Date dtcInicio;
    
    @Column(name = "DTC_FIM")
    @Temporal(TemporalType.DATE)
    private Date dtcFim;
    
    @Size(max = 1)
    @Column(name = "STS_MIGRACAO_BENNER")
    private String stsMigracaoBenner;
    
    @JoinColumn(name = "COD_PARTE_PROCESSO", referencedColumnName = "COD_PARTE_PROCESSO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ParteProcesso parteProcesso;
    
    public Autor() {
    }

    public Autor(AutorPK autorPK) {
        this.autorPK = autorPK;
    }

    public Autor(BigInteger codEmpresa, String numProcesso, BigInteger codParteProcesso) {
        this.autorPK = new AutorPK(codEmpresa, numProcesso, codParteProcesso);
    }

    public AutorPK getAutorPK() {
        return autorPK;
    }

    public void setAutorPK(AutorPK autorPK) {
        this.autorPK = autorPK;
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
        hash += (autorPK != null ? autorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Autor)) {
            return false;
        }
        Autor other = (Autor) object;
        if ((this.autorPK == null && other.autorPK != null) || (this.autorPK != null && !this.autorPK.equals(other.autorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telefonica.processum.model.Autor[ autorPK=" + autorPK + " ]";
    }
    
}
