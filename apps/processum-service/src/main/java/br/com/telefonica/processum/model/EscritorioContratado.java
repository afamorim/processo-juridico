package br.com.telefonica.processum.model;

import java.io.Serializable;
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
@Table(name = "ESCRITORIO_CONTRATADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscritorioContratado.findAll", query = "SELECT e FROM EscritorioContratado e")
    , @NamedQuery(name = "EscritorioContratado.findBySigEscritorioContratado", query = "SELECT e FROM EscritorioContratado e WHERE e.sigEscritorioContratado = :sigEscritorioContratado")
    , @NamedQuery(name = "EscritorioContratado.findByNomEscritorioContratado", query = "SELECT e FROM EscritorioContratado e WHERE e.nomEscritorioContratado = :nomEscritorioContratado")})
public class EscritorioContratado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 4)
    @Column(name = "SIG_ESCRITORIO_CONTRATADO")
    private String sigEscritorioContratado;
    
    @Size(max = 50)
    @Column(name = "NOM_ESCRITORIO_CONTRATADO")
    private String nomEscritorioContratado;
    
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
    
    @Size(max = 255)
    @Column(name = "DES_EMAIL")
    private String desEmail;
    
    @Size(max = 1)
    @Column(name = "STS_MIGRACAO_BENNER")
    private String stsMigracaoBenner;
    
    @Size(max = 1)
    @Column(name = "SIG_PROCESSUM")
    private String sigProcessum;
    
    @Size(max = 1)
    @Column(name = "NOM_PROCESSUM")
    private String nomProcessum;
    
    @Size(max = 1)
    @Column(name = "STS_PROCESSOS_CRIMINAIS")
    private String stsProcessosCriminais;
    
    @JoinColumn(name = "COD_GRUPO_USUARIO", referencedColumnName = "COD_GRUPO_USUARIO")
    @ManyToOne
    private GrupoUsuario codGrupoUsuario;
    
    @JoinColumns({
        @JoinColumn(name = "SIG_MUNICIPIO", referencedColumnName = "SIG_MUNICIPIO")
        , @JoinColumn(name = "SIG_ESTADO", referencedColumnName = "SIG_ESTADO")})
    @ManyToOne
    private Municipio municipio;
    
    public EscritorioContratado() {
    }

    public EscritorioContratado(String sigEscritorioContratado) {
        this.sigEscritorioContratado = sigEscritorioContratado;
    }

    public String getSigEscritorioContratado() {
        return sigEscritorioContratado;
    }

    public void setSigEscritorioContratado(String sigEscritorioContratado) {
        this.sigEscritorioContratado = sigEscritorioContratado;
    }

    public String getNomEscritorioContratado() {
        return nomEscritorioContratado;
    }

    public void setNomEscritorioContratado(String nomEscritorioContratado) {
        this.nomEscritorioContratado = nomEscritorioContratado;
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

    public String getStsMigracaoBenner() {
        return stsMigracaoBenner;
    }

    public void setStsMigracaoBenner(String stsMigracaoBenner) {
        this.stsMigracaoBenner = stsMigracaoBenner;
    }

    public String getSigProcessum() {
        return sigProcessum;
    }

    public void setSigProcessum(String sigProcessum) {
        this.sigProcessum = sigProcessum;
    }

    public String getNomProcessum() {
        return nomProcessum;
    }

    public void setNomProcessum(String nomProcessum) {
        this.nomProcessum = nomProcessum;
    }

    public String getStsProcessosCriminais() {
        return stsProcessosCriminais;
    }

    public void setStsProcessosCriminais(String stsProcessosCriminais) {
        this.stsProcessosCriminais = stsProcessosCriminais;
    }

    public GrupoUsuario getCodGrupoUsuario() {
        return codGrupoUsuario;
    }

    public void setCodGrupoUsuario(GrupoUsuario codGrupoUsuario) {
        this.codGrupoUsuario = codGrupoUsuario;
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
        hash += (sigEscritorioContratado != null ? sigEscritorioContratado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EscritorioContratado)) {
            return false;
        }
        EscritorioContratado other = (EscritorioContratado) object;
        if ((this.sigEscritorioContratado == null && other.sigEscritorioContratado != null) || (this.sigEscritorioContratado != null && !this.sigEscritorioContratado.equals(other.sigEscritorioContratado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vivo.processum.entity.EscritorioContratado[ sigEscritorioContratado=" + sigEscritorioContratado + " ]";
    }

}
