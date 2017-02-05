package br.com.telefonica.processum.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ifbomfim
 */
@Entity
@Table(name = "MUNICIPIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m")
    , @NamedQuery(name = "Municipio.findBySigMunicipio", query = "SELECT m FROM Municipio m WHERE m.municipioPK.sigMunicipio = :sigMunicipio")
    , @NamedQuery(name = "Municipio.findByNomMunicipio", query = "SELECT m FROM Municipio m WHERE m.nomMunicipio = :nomMunicipio")
    , @NamedQuery(name = "Municipio.findBySigEstado", query = "SELECT m FROM Municipio m WHERE m.municipioPK.sigEstado = :sigEstado")})
public class Municipio implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    @JsonUnwrapped
    protected MunicipioPK municipioPK;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOM_MUNICIPIO")
    private String nomMunicipio;

    @Size(max = 1)
    @Column(name = "STS_ATIVO")
    private String stsAtivo;

    @Size(max = 1)
    @Column(name = "STS_ATIVO_PROCURACAO")
    private String stsAtivoProcuracao;

    @Size(max = 1)
    @Column(name = "STS_MIGRACAO_BENNER")
    private String stsMigracaoBenner;

    @JoinColumn(name = "SIG_ESTADO", referencedColumnName = "SIG_ESTADO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estado estado;

    public Municipio() {
    }

    public Municipio(MunicipioPK municipioPK) {
        this.municipioPK = municipioPK;
    }

    public Municipio(MunicipioPK municipioPK, String nomMunicipio) {
        this.municipioPK = municipioPK;
        this.nomMunicipio = nomMunicipio;
    }

    public Municipio(String sigMunicipio, String sigEstado) {
        this.municipioPK = new MunicipioPK(sigMunicipio, sigEstado);
    }

    public MunicipioPK getMunicipioPK() {
        return municipioPK;
    }

    public void setMunicipioPK(MunicipioPK municipioPK) {
        this.municipioPK = municipioPK;
    }

    public String getNomMunicipio() {
        return nomMunicipio;
    }

    public void setNomMunicipio(String nomMunicipio) {
        this.nomMunicipio = nomMunicipio;
    }

    public String getStsAtivo() {
        return stsAtivo;
    }

    public void setStsAtivo(String stsAtivo) {
        this.stsAtivo = stsAtivo;
    }

    public String getStsAtivoProcuracao() {
        return stsAtivoProcuracao;
    }

    public void setStsAtivoProcuracao(String stsAtivoProcuracao) {
        this.stsAtivoProcuracao = stsAtivoProcuracao;
    }

    public String getStsMigracaoBenner() {
        return stsMigracaoBenner;
    }

    public void setStsMigracaoBenner(String stsMigracaoBenner) {
        this.stsMigracaoBenner = stsMigracaoBenner;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (municipioPK != null ? municipioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        return !((this.municipioPK == null && other.municipioPK != null) || (this.municipioPK != null && !this.municipioPK.equals(other.municipioPK)));
    }

}
