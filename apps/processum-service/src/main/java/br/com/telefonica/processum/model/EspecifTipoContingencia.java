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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jadossantos
 */
@Entity
@Table(name = "ESPECIF_TIPO_CONTINGENCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EspecifTipoContingencia.findAll", query = "SELECT e FROM EspecifTipoContingencia e")
    , @NamedQuery(name = "EspecifTipoContingencia.findByCodEspecifTipoContingencia", query = "SELECT e FROM EspecifTipoContingencia e WHERE e.codEspecifTipoContingencia = :codEspecifTipoContingencia")
    , @NamedQuery(name = "EspecifTipoContingencia.findByNome", query = "SELECT e FROM EspecifTipoContingencia e WHERE e.nome = :nome")})
public class EspecifTipoContingencia implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_ESPECIF_TIPO_CONTINGENCIA")
    private BigDecimal codEspecifTipoContingencia;
    
    @Size(max = 200)
    @Column(name = "NOME")
    private String nome;
    
    @JoinColumn(name = "COD_TIPO_CONTINGENCIA", referencedColumnName = "COD_TIPO_CONTINGENCIA")
    @ManyToOne(optional = false)
    private TipoContingencia codTipoContingencia;
    
    public EspecifTipoContingencia() {
    }

    public EspecifTipoContingencia(BigDecimal codEspecifTipoContingencia) {
        this.codEspecifTipoContingencia = codEspecifTipoContingencia;
    }

    public BigDecimal getCodEspecifTipoContingencia() {
        return codEspecifTipoContingencia;
    }

    public void setCodEspecifTipoContingencia(BigDecimal codEspecifTipoContingencia) {
        this.codEspecifTipoContingencia = codEspecifTipoContingencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoContingencia getCodTipoContingencia() {
        return codTipoContingencia;
    }

    public void setCodTipoContingencia(TipoContingencia codTipoContingencia) {
        this.codTipoContingencia = codTipoContingencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEspecifTipoContingencia != null ? codEspecifTipoContingencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EspecifTipoContingencia)) {
            return false;
        }
        EspecifTipoContingencia other = (EspecifTipoContingencia) object;
        if ((this.codEspecifTipoContingencia == null && other.codEspecifTipoContingencia != null) || (this.codEspecifTipoContingencia != null && !this.codEspecifTipoContingencia.equals(other.codEspecifTipoContingencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telefonica.processum.model.EspecifTipoContingencia[ codEspecifTipoContingencia=" + codEspecifTipoContingencia + " ]";
    }
    
}
