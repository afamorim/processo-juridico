package br.com.telefonica.processum.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "JUIZO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Juizo.findAll", query = "SELECT j FROM Juizo j")
    , @NamedQuery(name = "Juizo.findByCodJuizo", query = "SELECT j FROM Juizo j WHERE j.juizoPK.codJuizo = :codJuizo")
    , @NamedQuery(name = "Juizo.findByNomJuizo", query = "SELECT j FROM Juizo j WHERE j.nomJuizo = :nomJuizo")
    , @NamedQuery(name = "Juizo.findByCodComarca", query = "SELECT j FROM Juizo j WHERE j.juizoPK.codComarca = :codComarca")})
public class Juizo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected JuizoPK juizoPK;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "NOM_JUIZO")
    private String nomJuizo;
    
    @Size(max = 40)
    @Column(name = "DES_ENDERECO")
    private String desEndereco;
    
    @Size(max = 20)
    @Column(name = "DES_COMP_ENDERECO")
    private String desCompEndereco;
    
    @Size(max = 30)
    @Column(name = "NOM_BAIRRO")
    private String nomBairro;
    
    @Size(max = 18)
    @Column(name = "NUM_CNPJ")
    private String numCnpj;
    
    @Size(max = 18)
    @Column(name = "NUM_INSC_ESTADUAL")
    private String numInscEstadual;
    
    @Size(max = 18)
    @Column(name = "NUM_INSC_MUNICIPAL")
    private String numInscMunicipal;
    
    @Size(max = 13)
    @Column(name = "NUM_TEL_FIXO")
    private String numTelFixo;
    
    @Size(max = 13)
    @Column(name = "NUM_FAX")
    private String numFax;
    
    @Size(max = 10)
    @Column(name = "NUM_CEP")
    private String numCep;
    
    @Size(max = 30)
    @Column(name = "NOM_PESSOA_CONTATO")
    private String nomPessoaContato;
    
    @Size(max = 50)
    @Column(name = "DES_EMAIL")
    private String desEmail;
    
    @Size(max = 1)
    @Column(name = "STS_ATIVO")
    private String stsAtivo;
    
    @Column(name = "STS_RECENTE")
    private Short stsRecente;
    
    @Size(max = 1)
    @Column(name = "STS_MIGRACAO_BENNER")
    private String stsMigracaoBenner;
    
    @JoinColumn(name = "COD_COMARCA", referencedColumnName = "COD_COMARCA", insertable = false, updatable = false)
    @ManyToOne
    @JsonManagedReference
    private Comarca comarca;
    
    @JoinColumns({
        @JoinColumn(name = "COD_NATUREZA", referencedColumnName = "COD_NATUREZA", insertable = false, updatable = false)
        ,@JoinColumn(name = "COD_ESPECIFICACAO_NATUREZA", referencedColumnName = "COD_ESPECIFICACAO_NATUREZA", insertable = false, updatable = false)
        ,@JoinColumn(name = "COD_DETALHE_ESPECIFIC_NATUREZA", referencedColumnName = "COD_DETALHE_ESPECIFIC_NATUREZA", insertable = false, updatable = false)})
    @ManyToOne
    @JsonManagedReference
    private DetalheEspecificNatureza detalheEspecificNatureza;
    
    @JoinColumns({
        @JoinColumn(name = "COD_ESPECIFICACAO_NATUREZA", referencedColumnName = "COD_ESPECIFICACAO_NATUREZA")
        , @JoinColumn(name = "COD_NATUREZA", referencedColumnName = "COD_NATUREZA")})
    @ManyToOne
    @JsonManagedReference
    private EspecificacaoNatureza especificacaoNatureza;
    
    public Juizo() {
    }

    public Juizo(JuizoPK juizoPK) {
        this.juizoPK = juizoPK;
    }

    public Juizo(JuizoPK juizoPK, String nomJuizo) {
        this.juizoPK = juizoPK;
        this.nomJuizo = nomJuizo;
    }

    public Juizo(BigInteger codJuizo, BigInteger codComarca) {
        this.juizoPK = new JuizoPK(codJuizo, codComarca);
    }

    public JuizoPK getJuizoPK() {
        return juizoPK;
    }

    public void setJuizoPK(JuizoPK juizoPK) {
        this.juizoPK = juizoPK;
    }

    public String getNomJuizo() {
        return nomJuizo;
    }

    public void setNomJuizo(String nomJuizo) {
        this.nomJuizo = nomJuizo;
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

    public String getNumCnpj() {
        return numCnpj;
    }

    public void setNumCnpj(String numCnpj) {
        this.numCnpj = numCnpj;
    }

    public String getNumInscEstadual() {
        return numInscEstadual;
    }

    public void setNumInscEstadual(String numInscEstadual) {
        this.numInscEstadual = numInscEstadual;
    }

    public String getNumInscMunicipal() {
        return numInscMunicipal;
    }

    public void setNumInscMunicipal(String numInscMunicipal) {
        this.numInscMunicipal = numInscMunicipal;
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

    public String getNumCep() {
        return numCep;
    }

    public void setNumCep(String numCep) {
        this.numCep = numCep;
    }

    public String getNomPessoaContato() {
        return nomPessoaContato;
    }

    public void setNomPessoaContato(String nomPessoaContato) {
        this.nomPessoaContato = nomPessoaContato;
    }

    public String getDesEmail() {
        return desEmail;
    }

    public void setDesEmail(String desEmail) {
        this.desEmail = desEmail;
    }

    public String getStsAtivo() {
        return stsAtivo;
    }

    public void setStsAtivo(String stsAtivo) {
        this.stsAtivo = stsAtivo;
    }

    public Short getStsRecente() {
        return stsRecente;
    }

    public void setStsRecente(Short stsRecente) {
        this.stsRecente = stsRecente;
    }

    public String getStsMigracaoBenner() {
        return stsMigracaoBenner;
    }

    public void setStsMigracaoBenner(String stsMigracaoBenner) {
        this.stsMigracaoBenner = stsMigracaoBenner;
    }

    public Comarca getComarca() {
        return comarca;
    }

    public void setComarca(Comarca comarca) {
        this.comarca = comarca;
    }

    public DetalheEspecificNatureza getDetalheEspecificNatureza() {
        return detalheEspecificNatureza;
    }

    public void setDetalheEspecificNatureza(DetalheEspecificNatureza detalheEspecificNatureza) {
        this.detalheEspecificNatureza = detalheEspecificNatureza;
    }

    public EspecificacaoNatureza getEspecificacaoNatureza() {
        return especificacaoNatureza;
    }

    public void setEspecificacaoNatureza(EspecificacaoNatureza especificacaoNatureza) {
        this.especificacaoNatureza = especificacaoNatureza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (juizoPK != null ? juizoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Juizo)) {
            return false;
        }
        Juizo other = (Juizo) object;
        if ((this.juizoPK == null && other.juizoPK != null) || (this.juizoPK != null && !this.juizoPK.equals(other.juizoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vivo.processum.entity.Juizo[ juizoPK=" + juizoPK + " ]";
    }


}
