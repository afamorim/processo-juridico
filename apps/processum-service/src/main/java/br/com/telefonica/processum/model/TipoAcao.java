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
 * @author ifbomfim
 */
@Entity
@Table(name = "TIPO_ACAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAcao.findAll", query = "SELECT t FROM TipoAcao t")
    , @NamedQuery(name = "TipoAcao.findByCodTipoAcao", query = "SELECT t FROM TipoAcao t WHERE t.tipoAcaoPK.codTipoAcao = :codTipoAcao")
    , @NamedQuery(name = "TipoAcao.findByDesTipoAcao", query = "SELECT t FROM TipoAcao t WHERE t.desTipoAcao = :desTipoAcao")})
public class TipoAcao implements Serializable {

    @JoinColumns({
        @JoinColumn(name = "COD_NATUREZA", referencedColumnName = "COD_NATUREZA")
        , @JoinColumn(name = "COD_ESPECIFICACAO_NATUREZA", referencedColumnName = "COD_ESPECIFICACAO_NATUREZA")
        , @JoinColumn(name = "COD_DETALHE_ESPECIFIC_NATUREZA", referencedColumnName = "COD_DETALHE_ESPECIFIC_NATUREZA")})
    @ManyToOne(optional = false)
    private DetalheEspecificNatureza detalheEspecificNatureza;
    
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected TipoAcaoPK tipoAcaoPK;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "DES_TIPO_ACAO")
    private String desTipoAcao;
    
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

    public TipoAcao() {
    }

    public TipoAcao(TipoAcaoPK tipoAcaoPK) {
        this.tipoAcaoPK = tipoAcaoPK;
    }

    public TipoAcao(TipoAcaoPK tipoAcaoPK, String desTipoAcao, String stsVisualizaRelatorio, String stsAtivo) {
        this.tipoAcaoPK = tipoAcaoPK;
        this.desTipoAcao = desTipoAcao;
        this.stsVisualizaRelatorio = stsVisualizaRelatorio;
        this.stsAtivo = stsAtivo;
    }

    public TipoAcao(BigInteger codTipoAcao, BigInteger codPreObjetoEmpresa) {
        this.tipoAcaoPK = new TipoAcaoPK(codTipoAcao, codPreObjetoEmpresa);
    }

    public TipoAcaoPK getTipoAcaoPK() {
        return tipoAcaoPK;
    }

    public void setTipoAcaoPK(TipoAcaoPK tipoAcaoPK) {
        this.tipoAcaoPK = tipoAcaoPK;
    }

    public String getDesTipoAcao() {
        return desTipoAcao;
    }

    public void setDesTipoAcao(String desTipoAcao) {
        this.desTipoAcao = desTipoAcao;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoAcaoPK != null ? tipoAcaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TipoAcao)) {
            return false;
        }
        TipoAcao other = (TipoAcao) object;
        if ((this.tipoAcaoPK == null && other.tipoAcaoPK != null) || (this.tipoAcaoPK != null && !this.tipoAcaoPK.equals(other.tipoAcaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vivo.processum.model.TipoAcao[ tipoAcaoPK=" + tipoAcaoPK + " ]";
    }

    public DetalheEspecificNatureza getDetalheEspecificNatureza() {
        return detalheEspecificNatureza;
    }

    public void setDetalheEspecificNatureza(DetalheEspecificNatureza detalheEspecificNatureza) {
        this.detalheEspecificNatureza = detalheEspecificNatureza;
    }

}
