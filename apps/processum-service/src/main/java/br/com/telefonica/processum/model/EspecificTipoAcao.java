package br.com.telefonica.processum.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
 * @author jadossantos
 */
@Entity
@Table(name = "ESPECIFIC_TIPO_ACAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EspecificTipoAcao.findAll", query = "SELECT e FROM EspecificTipoAcao e")
    , @NamedQuery(name = "EspecificTipoAcao.findByCodEspecificTipoAcao", query = "SELECT e FROM EspecificTipoAcao e WHERE e.especificTipoAcaoPK.codEspecificTipoAcao = :codEspecificTipoAcao")
    , @NamedQuery(name = "EspecificTipoAcao.findByDesEspecificTipoAcao", query = "SELECT e FROM EspecificTipoAcao e WHERE e.desEspecificTipoAcao = :desEspecificTipoAcao")
    , @NamedQuery(name = "EspecificTipoAcao.findByCodTipoAcao", query = "SELECT e FROM EspecificTipoAcao e WHERE e.especificTipoAcaoPK.codTipoAcao = :codTipoAcao")})
public class EspecificTipoAcao implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected EspecificTipoAcaoPK especificTipoAcaoPK;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "DES_ESPECIFIC_TIPO_ACAO")
    private String desEspecificTipoAcao;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "STS_VISUALIZA_RELATORIO")
    private String stsVisualizaRelatorio;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "STS_ATIVO")
    private String stsAtivo;
    
    @Size(max = 1)
    @Column(name = "STS_MIGRACAO_BENNER")
    private String stsMigracaoBenner;
    
    @JoinColumns({
        @JoinColumn(name = "COD_NATUREZA", referencedColumnName = "COD_NATUREZA")
        , @JoinColumn(name = "COD_ESPECIFICACAO_NATUREZA", referencedColumnName = "COD_ESPECIFICACAO_NATUREZA")
        , @JoinColumn(name = "COD_DETALHE_ESPECIFIC_NATUREZA", referencedColumnName = "COD_DETALHE_ESPECIFIC_NATUREZA")})
    @ManyToOne(optional = false)
    private DetalheEspecificNatureza detalheEspecificNatureza;
    
    @JoinColumn(name = "SIG_ESCRITORIO_CONTRATADO", referencedColumnName = "SIG_ESCRITORIO_CONTRATADO")
    @ManyToOne
    private EscritorioContratado sigEscritorioContratado;
    
    @JoinColumns({
        @JoinColumn(name = "COD_PRE_OBJETO_EMPRESA", referencedColumnName = "COD_PRE_OBJETO_EMPRESA", insertable = false, updatable = false)
        , @JoinColumn(name = "COD_TIPO_ACAO", referencedColumnName = "COD_TIPO_ACAO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private TipoAcao tipoAcao;
    
    public EspecificTipoAcao() {
    }

    public EspecificTipoAcao(EspecificTipoAcaoPK especificTipoAcaoPK) {
        this.especificTipoAcaoPK = especificTipoAcaoPK;
    }

    public EspecificTipoAcao(EspecificTipoAcaoPK especificTipoAcaoPK, String desEspecificTipoAcao, String stsVisualizaRelatorio, String stsAtivo) {
        this.especificTipoAcaoPK = especificTipoAcaoPK;
        this.desEspecificTipoAcao = desEspecificTipoAcao;
        this.stsVisualizaRelatorio = stsVisualizaRelatorio;
        this.stsAtivo = stsAtivo;
    }

    public EspecificTipoAcao(BigInteger codEspecificTipoAcao, BigInteger codTipoAcao, BigInteger codPreObjetoEmpresa) {
        this.especificTipoAcaoPK = new EspecificTipoAcaoPK(codEspecificTipoAcao, codTipoAcao, codPreObjetoEmpresa);
    }

    public EspecificTipoAcaoPK getEspecificTipoAcaoPK() {
        return especificTipoAcaoPK;
    }

    public void setEspecificTipoAcaoPK(EspecificTipoAcaoPK especificTipoAcaoPK) {
        this.especificTipoAcaoPK = especificTipoAcaoPK;
    }

    public String getDesEspecificTipoAcao() {
        return desEspecificTipoAcao;
    }

    public void setDesEspecificTipoAcao(String desEspecificTipoAcao) {
        this.desEspecificTipoAcao = desEspecificTipoAcao;
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

    public String getStsMigracaoBenner() {
        return stsMigracaoBenner;
    }

    public void setStsMigracaoBenner(String stsMigracaoBenner) {
        this.stsMigracaoBenner = stsMigracaoBenner;
    }

    public DetalheEspecificNatureza getDetalheEspecificNatureza() {
        return detalheEspecificNatureza;
    }

    public void setDetalheEspecificNatureza(DetalheEspecificNatureza detalheEspecificNatureza) {
        this.detalheEspecificNatureza = detalheEspecificNatureza;
    }

    public EscritorioContratado getSigEscritorioContratado() {
        return sigEscritorioContratado;
    }

    public void setSigEscritorioContratado(EscritorioContratado sigEscritorioContratado) {
        this.sigEscritorioContratado = sigEscritorioContratado;
    }

    public TipoAcao getTipoAcao() {
        return tipoAcao;
    }

    public void setTipoAcao(TipoAcao tipoAcao) {
        this.tipoAcao = tipoAcao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (especificTipoAcaoPK != null ? especificTipoAcaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EspecificTipoAcao)) {
            return false;
        }
        EspecificTipoAcao other = (EspecificTipoAcao) object;
        if ((this.especificTipoAcaoPK == null && other.especificTipoAcaoPK != null) || (this.especificTipoAcaoPK != null && !this.especificTipoAcaoPK.equals(other.especificTipoAcaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telefonica.processum.model.EspecificTipoAcao[ especificTipoAcaoPK=" + especificTipoAcaoPK + " ]";
    }
    
}
