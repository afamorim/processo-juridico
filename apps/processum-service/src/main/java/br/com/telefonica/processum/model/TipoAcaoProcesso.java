package br.com.telefonica.processum.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ifbomfim
 */
@Entity
@Table(name = "TIPO_ACAO_PROCESSO")
@NamedQueries({
    @NamedQuery(name = "TipoAcaoProcesso.findAll", query = "SELECT t FROM TipoAcaoProcesso t")
    , @NamedQuery(name = "TipoAcaoProcesso.findByCodTipoAcaoProcesso", query = "SELECT t FROM TipoAcaoProcesso t WHERE t.codTipoAcaoProcesso = :codTipoAcaoProcesso")
    , @NamedQuery(name = "TipoAcaoProcesso.findByNomTipoAcaoProcesso", query = "SELECT t FROM TipoAcaoProcesso t WHERE t.nomTipoAcaoProcesso = :nomTipoAcaoProcesso")})
public class TipoAcaoProcesso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_TIPO_ACAO_PROCESSO")
    private BigDecimal codTipoAcaoProcesso;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NOM_TIPO_ACAO_PROCESSO")
    private String nomTipoAcaoProcesso;
    
    @Size(max = 1)
    @Column(name = "STS_MIGRACAO_BENNER")
    private String stsMigracaoBenner;
    
    @JoinColumn(name = "COD_MODULO", referencedColumnName = "COD_MODULO")
    @ManyToOne(optional = false)
    private Modulo modulo;

    public TipoAcaoProcesso() {
    }

    public TipoAcaoProcesso(BigDecimal codTipoAcaoProcesso) {
        this.codTipoAcaoProcesso = codTipoAcaoProcesso;
    }

    public TipoAcaoProcesso(BigDecimal codTipoAcaoProcesso, String nomTipoAcaoProcesso) {
        this.codTipoAcaoProcesso = codTipoAcaoProcesso;
        this.nomTipoAcaoProcesso = nomTipoAcaoProcesso;
    }

    public BigDecimal getCodTipoAcaoProcesso() {
        return codTipoAcaoProcesso;
    }

    public void setCodTipoAcaoProcesso(BigDecimal codTipoAcaoProcesso) {
        this.codTipoAcaoProcesso = codTipoAcaoProcesso;
    }

    public String getNomTipoAcaoProcesso() {
        return nomTipoAcaoProcesso;
    }

    public void setNomTipoAcaoProcesso(String nomTipoAcaoProcesso) {
        this.nomTipoAcaoProcesso = nomTipoAcaoProcesso;
    }

    public String getStsMigracaoBenner() {
        return stsMigracaoBenner;
    }

    public void setStsMigracaoBenner(String stsMigracaoBenner) {
        this.stsMigracaoBenner = stsMigracaoBenner;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipoAcaoProcesso != null ? codTipoAcaoProcesso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TipoAcaoProcesso)) {
            return false;
        }
        TipoAcaoProcesso other = (TipoAcaoProcesso) object;
        if ((this.codTipoAcaoProcesso == null && other.codTipoAcaoProcesso != null) || (this.codTipoAcaoProcesso != null && !this.codTipoAcaoProcesso.equals(other.codTipoAcaoProcesso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vivo.processum.model.TipoAcaoProcesso[ codTipoAcaoProcesso=" + codTipoAcaoProcesso + " ]";
    }
    
}
