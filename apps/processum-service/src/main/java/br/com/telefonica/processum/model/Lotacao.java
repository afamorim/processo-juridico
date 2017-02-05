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
@Table(name = "LOTACAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lotacao.findAll", query = "SELECT l FROM Lotacao l")
    , @NamedQuery(name = "Lotacao.findByCodEmpresa", query = "SELECT l FROM Lotacao l WHERE l.lotacaoPK.codEmpresa = :codEmpresa")
    , @NamedQuery(name = "Lotacao.findByCodLotacao", query = "SELECT l FROM Lotacao l WHERE l.lotacaoPK.codLotacao = :codLotacao")
    , @NamedQuery(name = "Lotacao.findByDesLotacao", query = "SELECT l FROM Lotacao l WHERE l.desLotacao = :desLotacao")})
public class Lotacao implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected LotacaoPK lotacaoPK;
    
    @Size(max = 45)
    @Column(name = "DES_LOTACAO")
    private String desLotacao;
    
    @Size(max = 40)
    @Column(name = "DES_ENDERECO")
    private String desEndereco;
    
    @Size(max = 20)
    @Column(name = "DES_COMP_ENDERECO")
    private String desCompEndereco;
    
    @Size(max = 30)
    @Column(name = "NOM_BAIRRO")
    private String nomBairro;
    
    @Size(max = 10)
    @Column(name = "NUM_CEP")
    private String numCep;
    
    @Size(max = 5)
    @Column(name = "NUM_DDD")
    private String numDdd;
    
    @Size(max = 13)
    @Column(name = "NUM_TEL_FIXO")
    private String numTelFixo;
    
    @Size(max = 13)
    @Column(name = "NUM_FAX")
    private String numFax;
    
    @JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false)
    @ManyToOne
    private Empresa empresa;
    
    @JoinColumns({
        @JoinColumn(name = "SIG_MUNICIPIO", referencedColumnName = "SIG_MUNICIPIO")
        , @JoinColumn(name = "SIG_ESTADO", referencedColumnName = "SIG_ESTADO")})
    @ManyToOne
    private Municipio municipio;
    
    public Lotacao() {
    }

    public Lotacao(LotacaoPK lotacaoPK) {
        this.lotacaoPK = lotacaoPK;
    }

    public Lotacao(BigInteger codEmpresa, BigInteger codLotacao) {
        this.lotacaoPK = new LotacaoPK(codEmpresa, codLotacao);
    }

    public LotacaoPK getLotacaoPK() {
        return lotacaoPK;
    }

    public void setLotacaoPK(LotacaoPK lotacaoPK) {
        this.lotacaoPK = lotacaoPK;
    }

    public String getDesLotacao() {
        return desLotacao;
    }

    public void setDesLotacao(String desLotacao) {
        this.desLotacao = desLotacao;
    }

    public String getDesEndereco() {
        return desEndereco;
    }

    public void setDesEndereco(String desEndereco) {
        this.desEndereco = desEndereco;
    }

    public String getDesCompEndereco() {
        return desCompEndereco;
    }

    public void setDesCompEndereco(String desCompEndereco) {
        this.desCompEndereco = desCompEndereco;
    }

    public String getNomBairro() {
        return nomBairro;
    }

    public void setNomBairro(String nomBairro) {
        this.nomBairro = nomBairro;
    }

    public String getNumCep() {
        return numCep;
    }

    public void setNumCep(String numCep) {
        this.numCep = numCep;
    }

    public String getNumDdd() {
        return numDdd;
    }

    public void setNumDdd(String numDdd) {
        this.numDdd = numDdd;
    }

    public String getNumTelFixo() {
        return numTelFixo;
    }

    public void setNumTelFixo(String numTelFixo) {
        this.numTelFixo = numTelFixo;
    }

    public String getNumFax() {
        return numFax;
    }

    public void setNumFax(String numFax) {
        this.numFax = numFax;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lotacaoPK != null ? lotacaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Lotacao)) {
            return false;
        }
        Lotacao other = (Lotacao) object;
        if ((this.lotacaoPK == null && other.lotacaoPK != null) || (this.lotacaoPK != null && !this.lotacaoPK.equals(other.lotacaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telefonica.processum.model.Lotacao[ lotacaoPK=" + lotacaoPK + " ]";
    }
    
}
