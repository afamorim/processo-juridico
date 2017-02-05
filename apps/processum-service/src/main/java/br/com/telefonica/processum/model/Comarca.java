package br.com.telefonica.processum.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "COMARCA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comarca.findAll", query = "SELECT c FROM Comarca c")
    , @NamedQuery(name = "Comarca.findByCodComarca", query = "SELECT c FROM Comarca c WHERE c.codComarca = :codComarca")
    , @NamedQuery(name = "Comarca.findByNomComarca", query = "SELECT c FROM Comarca c WHERE c.nomComarca = :nomComarca")})
public class Comarca implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_COMARCA")
    private BigDecimal codComarca;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOM_COMARCA")
    private String nomComarca;
    
    @Size(max = 1)
    @Column(name = "STS_ATIVO")
    private String stsAtivo;
    
    @Size(max = 1)
    @Column(name = "STS_ATIVO_PROCURACAO")
    private String stsAtivoProcuracao;
    
    @Column(name = "STS_RECENTE")
    private Short stsRecente;
    
    @Size(max = 1)
    @Column(name = "STS_MIGRACAO_BENNER")
    private String stsMigracaoBenner;
    
    @JoinColumns({
        @JoinColumn(name = "SIG_MUNICIPIO", referencedColumnName = "SIG_MUNICIPIO")
        , @JoinColumn(name = "SIG_ESTADO", referencedColumnName = "SIG_ESTADO")})
    @ManyToOne(optional = false)
    private Municipio municipio;

    public Comarca() {
    }

    public Comarca(BigDecimal codComarca) {
        this.codComarca = codComarca;
    }

    public Comarca(BigDecimal codComarca, String nomComarca) {
        this.codComarca = codComarca;
        this.nomComarca = nomComarca;
    }

    public BigDecimal getCodComarca() {
        return codComarca;
    }

    public void setCodComarca(BigDecimal codComarca) {
        this.codComarca = codComarca;
    }

    public String getNomComarca() {
        return nomComarca;
    }

    public void setNomComarca(String nomComarca) {
        this.nomComarca = nomComarca;
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

    public Short getStsRecente() {
        return stsRecente;
    }

    public void setStsRecente(Short stsRecente) {
        this.stsRecente = stsRecente;
    }

    public String getStsMigracaoBenner() {
        return stsMigracaoBenner;
    }

    public void setStsMigracaoBenner(String stsMigracaoBenner) {
        this.stsMigracaoBenner = stsMigracaoBenner;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codComarca != null ? codComarca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Comarca)) {
            return false;
        }
        Comarca other = (Comarca) object;
        if ((this.codComarca == null && other.codComarca != null) || (this.codComarca != null && !this.codComarca.equals(other.codComarca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vivo.processum.entity.Comarca[ codComarca=" + codComarca + " ]";
    }

}
