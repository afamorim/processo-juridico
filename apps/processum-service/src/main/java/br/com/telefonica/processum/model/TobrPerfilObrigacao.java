package br.com.telefonica.processum.model;

import java.io.Serializable;
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
@Table(name = "TOBR_PERFIL_OBRIGACAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TobrPerfilObrigacao.findAll", query = "SELECT t FROM TobrPerfilObrigacao t")
    , @NamedQuery(name = "TobrPerfilObrigacao.findByIdPerfilObrigacao", query = "SELECT t FROM TobrPerfilObrigacao t WHERE t.idPerfilObrigacao = :idPerfilObrigacao")
    , @NamedQuery(name = "TobrPerfilObrigacao.findByNoPerfilObrigacao", query = "SELECT t FROM TobrPerfilObrigacao t WHERE t.noPerfilObrigacao = :noPerfilObrigacao")})
public class TobrPerfilObrigacao implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERFIL_OBRIGACAO")
    private Long idPerfilObrigacao;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NO_PERFIL_OBRIGACAO")
    private String noPerfilObrigacao;
    
    public TobrPerfilObrigacao() {
    }

    public TobrPerfilObrigacao(Long idPerfilObrigacao) {
        this.idPerfilObrigacao = idPerfilObrigacao;
    }

    public TobrPerfilObrigacao(Long idPerfilObrigacao, String noPerfilObrigacao) {
        this.idPerfilObrigacao = idPerfilObrigacao;
        this.noPerfilObrigacao = noPerfilObrigacao;
    }

    public Long getIdPerfilObrigacao() {
        return idPerfilObrigacao;
    }

    public void setIdPerfilObrigacao(Long idPerfilObrigacao) {
        this.idPerfilObrigacao = idPerfilObrigacao;
    }

    public String getNoPerfilObrigacao() {
        return noPerfilObrigacao;
    }

    public void setNoPerfilObrigacao(String noPerfilObrigacao) {
        this.noPerfilObrigacao = noPerfilObrigacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerfilObrigacao != null ? idPerfilObrigacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TobrPerfilObrigacao)) {
            return false;
        }
        TobrPerfilObrigacao other = (TobrPerfilObrigacao) object;
        if ((this.idPerfilObrigacao == null && other.idPerfilObrigacao != null) || (this.idPerfilObrigacao != null && !this.idPerfilObrigacao.equals(other.idPerfilObrigacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telefonica.processum.model.TobrPerfilObrigacao[ idPerfilObrigacao=" + idPerfilObrigacao + " ]";
    }
    
}
