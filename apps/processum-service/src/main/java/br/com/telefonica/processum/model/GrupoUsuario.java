package br.com.telefonica.processum.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ifbomfim
 */
@Entity
@Table(name = "GRUPO_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoUsuario.findAll", query = "SELECT g FROM GrupoUsuario g")
    , @NamedQuery(name = "GrupoUsuario.findByCodGrupoUsuario", query = "SELECT g FROM GrupoUsuario g WHERE g.codGrupoUsuario = :codGrupoUsuario")
    , @NamedQuery(name = "GrupoUsuario.findByNomGrupoUsuario", query = "SELECT g FROM GrupoUsuario g WHERE g.nomGrupoUsuario = :nomGrupoUsuario")})
public class GrupoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "COD_GRUPO_USUARIO")
    private BigDecimal codGrupoUsuario;
    
    @Size(max = 60)
    @Column(name = "NOM_GRUPO_USUARIO")
    private String nomGrupoUsuario;
    
    public GrupoUsuario() {
    }

    public GrupoUsuario(BigDecimal codGrupoUsuario) {
        this.codGrupoUsuario = codGrupoUsuario;
    }

    public BigDecimal getCodGrupoUsuario() {
        return codGrupoUsuario;
    }

    public void setCodGrupoUsuario(BigDecimal codGrupoUsuario) {
        this.codGrupoUsuario = codGrupoUsuario;
    }

    public String getNomGrupoUsuario() {
        return nomGrupoUsuario;
    }

    public void setNomGrupoUsuario(String nomGrupoUsuario) {
        this.nomGrupoUsuario = nomGrupoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codGrupoUsuario != null ? codGrupoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoUsuario)) {
            return false;
        }
        GrupoUsuario other = (GrupoUsuario) object;
        if ((this.codGrupoUsuario == null && other.codGrupoUsuario != null) || (this.codGrupoUsuario != null && !this.codGrupoUsuario.equals(other.codGrupoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vivo.processum.entity.GrupoUsuario[ codGrupoUsuario=" + codGrupoUsuario + " ]";
    }
    
}
