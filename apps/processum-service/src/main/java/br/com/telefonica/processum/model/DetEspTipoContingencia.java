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
@Table(name = "DET_ESP_TIPO_CONTINGENCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetEspTipoContingencia.findAll", query = "SELECT d FROM DetEspTipoContingencia d")
    , @NamedQuery(name = "DetEspTipoContingencia.findByCodDetEspTipoContingencia", query = "SELECT d FROM DetEspTipoContingencia d WHERE d.codDetEspTipoContingencia = :codDetEspTipoContingencia")
    , @NamedQuery(name = "DetEspTipoContingencia.findByNome", query = "SELECT d FROM DetEspTipoContingencia d WHERE d.nome = :nome")})
public class DetEspTipoContingencia implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_DET_ESP_TIPO_CONTINGENCIA")
    private BigDecimal codDetEspTipoContingencia;
    
    @Size(max = 200)
    @Column(name = "NOME")
    private String nome;
    
    @JoinColumn(name = "COD_ESPECIF_TIPO_CONTINGENCIA", referencedColumnName = "COD_ESPECIF_TIPO_CONTINGENCIA")
    @ManyToOne(optional = false)
    private EspecifTipoContingencia codEspecifTipoContingencia;
    
    public DetEspTipoContingencia() {
    }

    public DetEspTipoContingencia(BigDecimal codDetEspTipoContingencia) {
        this.codDetEspTipoContingencia = codDetEspTipoContingencia;
    }

    public BigDecimal getCodDetEspTipoContingencia() {
        return codDetEspTipoContingencia;
    }

    public void setCodDetEspTipoContingencia(BigDecimal codDetEspTipoContingencia) {
        this.codDetEspTipoContingencia = codDetEspTipoContingencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EspecifTipoContingencia getCodEspecifTipoContingencia() {
        return codEspecifTipoContingencia;
    }

    public void setCodEspecifTipoContingencia(EspecifTipoContingencia codEspecifTipoContingencia) {
        this.codEspecifTipoContingencia = codEspecifTipoContingencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDetEspTipoContingencia != null ? codDetEspTipoContingencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DetEspTipoContingencia)) {
            return false;
        }
        DetEspTipoContingencia other = (DetEspTipoContingencia) object;
        if ((this.codDetEspTipoContingencia == null && other.codDetEspTipoContingencia != null) || (this.codDetEspTipoContingencia != null && !this.codDetEspTipoContingencia.equals(other.codDetEspTipoContingencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telefonica.processum.model.DetEspTipoContingencia[ codDetEspTipoContingencia=" + codDetEspTipoContingencia + " ]";
    }
    
}
