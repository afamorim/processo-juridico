package br.com.telefonica.processum.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author ifbomfim
 */
@Entity
@Table(name = "JUIZ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Juiz.findAll", query = "SELECT j FROM Juiz j")
    , @NamedQuery(name = "Juiz.findByCodJuiz", query = "SELECT j FROM Juiz j WHERE j.codJuiz = :codJuiz")
    , @NamedQuery(name = "Juiz.findByNomJuiz", query = "SELECT j FROM Juiz j WHERE j.nomJuiz = :nomJuiz")})
public class Juiz implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "COD_JUIZ")
    private BigDecimal codJuiz;
    @Size(max = 40)
    @Column(name = "NOM_JUIZ")
    private String nomJuiz;
    @Size(max = 20)
    @Column(name = "NOM_APELIDO")
    private String nomApelido;
    @Size(max = 18)
    @Column(name = "NUM_CPF")
    private String numCpf;
    @Size(max = 18)
    @Column(name = "NUM_RG")
    private String numRg;
    @Size(max = 40)
    @Column(name = "DES_ENDERECO")
    private String desEndereco;
    @Size(max = 20)
    @Column(name = "DES_COMP_ENDERECO")
    private String desCompEndereco;
    @Size(max = 30)
    @Column(name = "NOM_BAIRRO")
    private String nomBairro;
    @Size(max = 13)
    @Column(name = "NUM_TEL_FIXO")
    private String numTelFixo;
    @Size(max = 13)
    @Column(name = "NUM_TEL_FAX")
    private String numTelFax;
    @Size(max = 10)
    @Column(name = "NUM_CEP")
    private String numCep;
    @Size(max = 12)
    @Column(name = "NUM_TEL_CELULAR")
    private String numTelCelular;
    @Size(max = 50)
    @Column(name = "DES_EMAIL")
    private String desEmail;
    @Column(name = "STS_CONVENIO")
    private BigInteger stsConvenio;
    @Column(name = "STS_RECENTE")
    private Short stsRecente;
    @Size(max = 12)
    @Column(name = "MATRICULA")
    private String matricula;
    @JoinColumn(name = "COD_ESTADO_CIVIL", referencedColumnName = "COD_ESTADO_CIVIL")
    @ManyToOne
    private EstadoCivil codEstadoCivil;
    @JoinColumns({
        @JoinColumn(name = "COD_JUIZO", referencedColumnName = "COD_JUIZO")
        , @JoinColumn(name = "COD_COMARCA", referencedColumnName = "COD_COMARCA")})
    @ManyToOne
    private Juizo juizo;
    @JoinColumns({
        @JoinColumn(name = "SIG_MUNICIPIO", referencedColumnName = "SIG_MUNICIPIO")
        , @JoinColumn(name = "SIG_ESTADO", referencedColumnName = "SIG_ESTADO")})
    @ManyToOne
    private Municipio municipio;

    public Juiz() {
    }

    public Juiz(BigDecimal codJuiz) {
        this.codJuiz = codJuiz;
    }

    public BigDecimal getCodJuiz() {
        return codJuiz;
    }

    public void setCodJuiz(BigDecimal codJuiz) {
        this.codJuiz = codJuiz;
    }

    public String getNomJuiz() {
        return nomJuiz;
    }

    public void setNomJuiz(String nomJuiz) {
        this.nomJuiz = nomJuiz;
    }

    public String getNomApelido() {
        return nomApelido;
    }

    public void setNomApelido(String nomApelido) {
        this.nomApelido = nomApelido;
    }

    public String getNumCpf() {
        return numCpf;
    }

    public void setNumCpf(String numCpf) {
        this.numCpf = numCpf;
    }

    public String getNumRg() {
        return numRg;
    }

    public void setNumRg(String numRg) {
        this.numRg = numRg;
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

    public String getNumTelFixo() {
        return numTelFixo;
    }

    public void setNumTelFixo(String numTelFixo) {
        this.numTelFixo = numTelFixo;
    }

    public String getNumTelFax() {
        return numTelFax;
    }

    public void setNumTelFax(String numTelFax) {
        this.numTelFax = numTelFax;
    }

    public String getNumCep() {
        return numCep;
    }

    public void setNumCep(String numCep) {
        this.numCep = numCep;
    }

    public String getNumTelCelular() {
        return numTelCelular;
    }

    public void setNumTelCelular(String numTelCelular) {
        this.numTelCelular = numTelCelular;
    }

    public String getDesEmail() {
        return desEmail;
    }

    public void setDesEmail(String desEmail) {
        this.desEmail = desEmail;
    }

    public BigInteger getStsConvenio() {
        return stsConvenio;
    }

    public void setStsConvenio(BigInteger stsConvenio) {
        this.stsConvenio = stsConvenio;
    }

    public Short getStsRecente() {
        return stsRecente;
    }

    public void setStsRecente(Short stsRecente) {
        this.stsRecente = stsRecente;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public EstadoCivil getCodEstadoCivil() {
        return codEstadoCivil;
    }

    public void setCodEstadoCivil(EstadoCivil codEstadoCivil) {
        this.codEstadoCivil = codEstadoCivil;
    }

    public Juizo getJuizo() {
        return juizo;
    }

    public void setJuizo(Juizo juizo) {
        this.juizo = juizo;
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
        hash += (codJuiz != null ? codJuiz.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Juiz)) {
            return false;
        }
        Juiz other = (Juiz) object;
        if ((this.codJuiz == null && other.codJuiz != null) || (this.codJuiz != null && !this.codJuiz.equals(other.codJuiz))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vivo.processum.entity.Juiz[ codJuiz=" + codJuiz + " ]";
    }

}
