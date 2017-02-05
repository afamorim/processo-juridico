package br.com.telefonica.processum.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jadossantos
 */
@Entity
@Table(name = "DET_ESPECIFIC_TIPO_ACAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetEspecificTipoAcao.findAll", query = "SELECT d FROM DetEspecificTipoAcao d")
    , @NamedQuery(name = "DetEspecificTipoAcao.findByCodTipoAcao", query = "SELECT d FROM DetEspecificTipoAcao d WHERE d.detEspecificTipoAcaoPK.codTipoAcao = :codTipoAcao")
    , @NamedQuery(name = "DetEspecificTipoAcao.findByCodEspecificTipoAcao", query = "SELECT d FROM DetEspecificTipoAcao d WHERE d.detEspecificTipoAcaoPK.codEspecificTipoAcao = :codEspecificTipoAcao")
    , @NamedQuery(name = "DetEspecificTipoAcao.findByCodDetEspecificTipoAcao", query = "SELECT d FROM DetEspecificTipoAcao d WHERE d.detEspecificTipoAcaoPK.codDetEspecificTipoAcao = :codDetEspecificTipoAcao")
    , @NamedQuery(name = "DetEspecificTipoAcao.findByNomDetEspecificTipoAcao", query = "SELECT d FROM DetEspecificTipoAcao d WHERE d.nomDetEspecificTipoAcao = :nomDetEspecificTipoAcao")})
public class DetEspecificTipoAcao implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected DetEspecificTipoAcaoPK detEspecificTipoAcaoPK;
    
    @Size(max = 60)
    @Column(name = "NOM_DET_ESPECIFIC_TIPO_ACAO")
    private String nomDetEspecificTipoAcao;
    
    @Size(max = 1)
    @Column(name = "STS_VISUALIZA_RELATORIO")
    private String stsVisualizaRelatorio;
    
    @Size(max = 1)
    @Column(name = "STS_ATIVO")
    private String stsAtivo;
    
    @JoinColumns({
        @JoinColumn(name = "COD_NATUREZA", referencedColumnName = "COD_NATUREZA")
        , @JoinColumn(name = "COD_ESPECIFICACAO_NATUREZA", referencedColumnName = "COD_ESPECIFICACAO_NATUREZA")
        , @JoinColumn(name = "COD_DETALHE_ESPECIFIC_NATUREZA", referencedColumnName = "COD_DETALHE_ESPECIFIC_NATUREZA")})
    @ManyToOne
    private DetalheEspecificNatureza detalheEspecificNatureza;
    
    @JoinColumns({
        @JoinColumn(name = "COD_PRE_OBJETO_EMPRESA", referencedColumnName = "COD_PRE_OBJETO_EMPRESA", insertable = false, updatable = false)
        , @JoinColumn(name = "COD_TIPO_ACAO", referencedColumnName = "COD_TIPO_ACAO", insertable = false, updatable = false)
        , @JoinColumn(name = "COD_ESPECIFIC_TIPO_ACAO", referencedColumnName = "COD_ESPECIFIC_TIPO_ACAO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private EspecificTipoAcao especificTipoAcao;

    public DetEspecificTipoAcao() {
    }

    public DetEspecificTipoAcao(DetEspecificTipoAcaoPK detEspecificTipoAcaoPK) {
        this.detEspecificTipoAcaoPK = detEspecificTipoAcaoPK;
    }

    public DetEspecificTipoAcao(BigInteger codTipoAcao, BigInteger codEspecificTipoAcao, BigInteger codDetEspecificTipoAcao, BigInteger codPreObjetoEmpresa) {
        this.detEspecificTipoAcaoPK = new DetEspecificTipoAcaoPK(codTipoAcao, codEspecificTipoAcao, codDetEspecificTipoAcao, codPreObjetoEmpresa);
    }

    public DetEspecificTipoAcaoPK getDetEspecificTipoAcaoPK() {
        return detEspecificTipoAcaoPK;
    }

    public void setDetEspecificTipoAcaoPK(DetEspecificTipoAcaoPK detEspecificTipoAcaoPK) {
        this.detEspecificTipoAcaoPK = detEspecificTipoAcaoPK;
    }

    public String getNomDetEspecificTipoAcao() {
        return nomDetEspecificTipoAcao;
    }

    public void setNomDetEspecificTipoAcao(String nomDetEspecificTipoAcao) {
        this.nomDetEspecificTipoAcao = nomDetEspecificTipoAcao;
    }

    public String getStsVisualizaRelatorio() {
        return stsVisualizaRelatorio;
    }

    public void setStsVisualizaRelatorio(String stsVisualizaRelatorio) {
        this.stsVisualizaRelatorio = stsVisualizaRelatorio;
    }

    public String getStsAtivo() {
        return stsAtivo;
    }

    public void setStsAtivo(String stsAtivo) {
        this.stsAtivo = stsAtivo;
    }

    public DetalheEspecificNatureza getDetalheEspecificNatureza() {
        return detalheEspecificNatureza;
    }

    public void setDetalheEspecificNatureza(DetalheEspecificNatureza detalheEspecificNatureza) {
        this.detalheEspecificNatureza = detalheEspecificNatureza;
    }

    public EspecificTipoAcao getEspecificTipoAcao() {
        return especificTipoAcao;
    }

    public void setEspecificTipoAcao(EspecificTipoAcao especificTipoAcao) {
        this.especificTipoAcao = especificTipoAcao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detEspecificTipoAcaoPK != null ? detEspecificTipoAcaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DetEspecificTipoAcao)) {
            return false;
        }
        DetEspecificTipoAcao other = (DetEspecificTipoAcao) object;
        if ((this.detEspecificTipoAcaoPK == null && other.detEspecificTipoAcaoPK != null) || (this.detEspecificTipoAcaoPK != null && !this.detEspecificTipoAcaoPK.equals(other.detEspecificTipoAcaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telefonica.processum.model.DetEspecificTipoAcao[ detEspecificTipoAcaoPK=" + detEspecificTipoAcaoPK + " ]";
    }
    
}
