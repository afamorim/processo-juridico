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
@Table(name = "REDI_PERFIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RediPerfil.findAll", query = "SELECT r FROM RediPerfil r")
    , @NamedQuery(name = "RediPerfil.findBySeqPerfil", query = "SELECT r FROM RediPerfil r WHERE r.seqPerfil = :seqPerfil")
    , @NamedQuery(name = "RediPerfil.findByStrDescricao", query = "SELECT r FROM RediPerfil r WHERE r.strDescricao = :strDescricao")})
public class RediPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEQ_PERFIL")
    private Long seqPerfil;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "STR_DESCRICAO")
    private String strDescricao;
    
    public RediPerfil() {
    }

    public RediPerfil(Long seqPerfil) {
        this.seqPerfil = seqPerfil;
    }

    public RediPerfil(Long seqPerfil, String strDescricao) {
        this.seqPerfil = seqPerfil;
        this.strDescricao = strDescricao;
    }

    public Long getSeqPerfil() {
        return seqPerfil;
    }

    public void setSeqPerfil(Long seqPerfil) {
        this.seqPerfil = seqPerfil;
    }

    public String getStrDescricao() {
        return strDescricao;
    }

    public void setStrDescricao(String strDescricao) {
        this.strDescricao = strDescricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqPerfil != null ? seqPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof RediPerfil)) {
            return false;
        }
        RediPerfil other = (RediPerfil) object;
        if ((this.seqPerfil == null && other.seqPerfil != null) || (this.seqPerfil != null && !this.seqPerfil.equals(other.seqPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telefonica.processum.model.RediPerfil[ seqPerfil=" + seqPerfil + " ]";
    }
    
}
