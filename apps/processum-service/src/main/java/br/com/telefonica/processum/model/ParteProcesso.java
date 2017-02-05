package br.com.telefonica.processum.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "PARTE_PROCESSO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParteProcesso.findAll", query = "SELECT p FROM ParteProcesso p")
    , @NamedQuery(name = "ParteProcesso.findByCodParteProcesso", query = "SELECT p FROM ParteProcesso p WHERE p.codParteProcesso = :codParteProcesso")
    , @NamedQuery(name = "ParteProcesso.findByNomParteProcesso", query = "SELECT p FROM ParteProcesso p WHERE p.nomParteProcesso = :nomParteProcesso")
    , @NamedQuery(name = "ParteProcesso.findByNumCpfCnpj", query = "SELECT p FROM ParteProcesso p WHERE p.numCpfCnpj = :numCpfCnpj")})
public class ParteProcesso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_PARTE_PROCESSO")
    private BigDecimal codParteProcesso;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "NOM_PARTE_PROCESSO")
    private String nomParteProcesso;
    
    @Size(max = 1)
    @Column(name = "STS_PESSOA_FISICA")
    private String stsPessoaFisica;
    
    @Size(max = 20)
    @Column(name = "NUM_CPF_CNPJ")
    private String numCpfCnpj;
    
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
    
    @Size(max = 18)
    @Column(name = "NUM_INSC_ESTADUAL")
    private String numInscEstadual;
    
    @Size(max = 18)
    @Column(name = "NUM_INSC_MUNICIPAL")
    private String numInscMunicipal;
    
    @Size(max = 30)
    @Column(name = "NOM_PESSOA_CONTATO")
    private String nomPessoaContato;
    
    @Size(max = 1)
    @Column(name = "STS_FUNCIONARIO")
    private String stsFuncionario;
    
    @Size(max = 1)
    @Column(name = "STS_CONDUTOR")
    private String stsCondutor;
    
    @Size(max = 1)
    @Column(name = "STS_EMPRESA_OPERADORA")
    private String stsEmpresaOperadora;
    @Size(max = 50)
    @Column(name = "NUM_CONTA")
    private String numConta;
    
    @Size(max = 1)
    @Column(name = "STS_CAD_PARCIAL")
    private String stsCadParcial;
    
    @Size(max = 20)
    @Column(name = "NUM_CTPS")
    private String numCtps;
    
    @Size(max = 20)
    @Column(name = "NUM_PIS")
    private String numPis;
    
    @Size(max = 3)
    @Column(name = "STS_AREA_RESPONSAVEL")
    private String stsAreaResponsavel;
    
    @Size(max = 1)
    @Column(name = "STS_MIGRACAO_BENNER")
    private String stsMigracaoBenner;
    
    @JoinColumn(name = "COD_ESTADO_CIVIL", referencedColumnName = "COD_ESTADO_CIVIL")
    @ManyToOne
    private EstadoCivil codEstadoCivil;
    
    @JoinColumns({
        @JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA")
        , @JoinColumn(name = "COD_FUNCIONARIO", referencedColumnName = "COD_FUNCIONARIO")})
    @ManyToOne
    private Funcionario funcionario;
    
    @JoinColumns({
        @JoinColumn(name = "SIG_MUNICIPIO", referencedColumnName = "SIG_MUNICIPIO")
        , @JoinColumn(name = "SIG_ESTADO", referencedColumnName = "SIG_ESTADO")})
    @ManyToOne
    private Municipio municipio;

    public ParteProcesso() {
    }

    public ParteProcesso(BigDecimal codParteProcesso) {
        this.codParteProcesso = codParteProcesso;
    }

    public ParteProcesso(BigDecimal codParteProcesso, String nomParteProcesso) {
        this.codParteProcesso = codParteProcesso;
        this.nomParteProcesso = nomParteProcesso;
    }

    public BigDecimal getCodParteProcesso() {
        return codParteProcesso;
    }

    public void setCodParteProcesso(BigDecimal codParteProcesso) {
        this.codParteProcesso = codParteProcesso;
    }

    public String getNomParteProcesso() {
        return nomParteProcesso;
    }

    public void setNomParteProcesso(String nomParteProcesso) {
        this.nomParteProcesso = nomParteProcesso;
    }

    public String getStsPessoaFisica() {
        return stsPessoaFisica;
    }

    public void setStsPessoaFisica(String stsPessoaFisica) {
        this.stsPessoaFisica = stsPessoaFisica;
    }

    public String getNumCpfCnpj() {
        return numCpfCnpj;
    }

    public void setNumCpfCnpj(String numCpfCnpj) {
        this.numCpfCnpj = numCpfCnpj;
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

    public String getNomPessoaContato() {
        return nomPessoaContato;
    }

    public void setNomPessoaContato(String nomPessoaContato) {
        this.nomPessoaContato = nomPessoaContato;
    }

    public String getStsFuncionario() {
        return stsFuncionario;
    }

    public void setStsFuncionario(String stsFuncionario) {
        this.stsFuncionario = stsFuncionario;
    }

    public String getStsCondutor() {
        return stsCondutor;
    }

    public void setStsCondutor(String stsCondutor) {
        this.stsCondutor = stsCondutor;
    }

    public String getStsEmpresaOperadora() {
        return stsEmpresaOperadora;
    }

    public void setStsEmpresaOperadora(String stsEmpresaOperadora) {
        this.stsEmpresaOperadora = stsEmpresaOperadora;
    }

    public String getNumConta() {
        return numConta;
    }

    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }

    public String getStsCadParcial() {
        return stsCadParcial;
    }

    public void setStsCadParcial(String stsCadParcial) {
        this.stsCadParcial = stsCadParcial;
    }

    public String getNumCtps() {
        return numCtps;
    }

    public void setNumCtps(String numCtps) {
        this.numCtps = numCtps;
    }

    public String getNumPis() {
        return numPis;
    }

    public void setNumPis(String numPis) {
        this.numPis = numPis;
    }

    public String getStsAreaResponsavel() {
        return stsAreaResponsavel;
    }

    public void setStsAreaResponsavel(String stsAreaResponsavel) {
        this.stsAreaResponsavel = stsAreaResponsavel;
    }

    public String getStsMigracaoBenner() {
        return stsMigracaoBenner;
    }

    public void setStsMigracaoBenner(String stsMigracaoBenner) {
        this.stsMigracaoBenner = stsMigracaoBenner;
    }

    public EstadoCivil getCodEstadoCivil() {
        return codEstadoCivil;
    }

    public void setCodEstadoCivil(EstadoCivil codEstadoCivil) {
        this.codEstadoCivil = codEstadoCivil;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
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
        hash += (codParteProcesso != null ? codParteProcesso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ParteProcesso)) {
            return false;
        }
        ParteProcesso other = (ParteProcesso) object;
        if ((this.codParteProcesso == null && other.codParteProcesso != null) || (this.codParteProcesso != null && !this.codParteProcesso.equals(other.codParteProcesso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telefonica.processum.model.ParteProcesso[ codParteProcesso=" + codParteProcesso + " ]";
    }
    
}
