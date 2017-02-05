package br.com.telefonica.processum.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "TIPO_CONTINGENCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoContingencia.findAll", query = "SELECT t FROM TipoContingencia t")
    , @NamedQuery(name = "TipoContingencia.findByCodTipoContingencia", query = "SELECT t FROM TipoContingencia t WHERE t.codTipoContingencia = :codTipoContingencia")
    , @NamedQuery(name = "TipoContingencia.findByNome", query = "SELECT t FROM TipoContingencia t WHERE t.nome = :nome")})
public class TipoContingencia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_TIPO_CONTINGENCIA")
    private BigDecimal codTipoContingencia;
    
    @Size(max = 200)
    @Column(name = "NOME")
    private String nome;
    
    public TipoContingencia() {
    }

    public TipoContingencia(BigDecimal codTipoContingencia) {
        this.codTipoContingencia = codTipoContingencia;
    }

    public BigDecimal getCodTipoContingencia() {
        return codTipoContingencia;
    }

    public void setCodTipoContingencia(BigDecimal codTipoContingencia) {
        this.codTipoContingencia = codTipoContingencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipoContingencia != null ? codTipoContingencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TipoContingencia)) {
            return false;
        }
        TipoContingencia other = (TipoContingencia) object;
        if ((this.codTipoContingencia == null && other.codTipoContingencia != null) || (this.codTipoContingencia != null && !this.codTipoContingencia.equals(other.codTipoContingencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telefonica.processum.model.TipoContingencia[ codTipoContingencia=" + codTipoContingencia + " ]";
    }
    
}
