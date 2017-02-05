package br.com.telefonica.processum.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
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
@Table(name = "EMPRESA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e")
    , @NamedQuery(name = "Empresa.findByCodEmpresa", query = "SELECT e FROM Empresa e WHERE e.codEmpresa = :codEmpresa")
    , @NamedQuery(name = "Empresa.findByNomEmpresa", query = "SELECT e FROM Empresa e WHERE e.nomEmpresa = :nomEmpresa")})
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "COD_EMPRESA")
    private BigDecimal codEmpresa;
    
    @Size(max = 60)
    @Column(name = "NOM_EMPRESA")
    private String nomEmpresa;
    
    @Size(max = 60)
    @Column(name = "NOM_FANTASIA_EMPRESA")
    private String nomFantasiaEmpresa;
    
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
    
    @Size(max = 255)
    @Column(name = "DES_LOGOMARCA_EMPRESA")
    private String desLogomarcaEmpresa;
    
    @Size(max = 255)
    @Column(name = "DES_CHANCELA_JURIDICO")
    private String desChancelaJuridico;
    
    @Size(max = 50)
    @Column(name = "NOM_FINAL_EMAIL")
    private String nomFinalEmail;
    
    @Column(name = "NUM_OFICIO_LIMITE_INICIO")
    private BigInteger numOficioLimiteInicio;
    
    @Column(name = "NUM_OFICIO_LIMITE_FIM")
    private BigInteger numOficioLimiteFim;
    
    @Size(max = 4)
    @Column(name = "ANO_REF_OFICIO_LIMITE")
    private String anoRefOficioLimite;
    
    @Size(max = 100)
    @Column(name = "NOM_CIDADE")
    private String nomCidade;
    
    @Size(max = 255)
    @Column(name = "NOM_USUARIO_ENVIO_COPIA_AGENDA")
    private String nomUsuarioEnvioCopiaAgenda;
    
    @Size(max = 1)
    @Column(name = "STS_ENVIA_EMAIL_ESTACAO")
    private String stsEnviaEmailEstacao;
    
    @Size(max = 1)
    @Column(name = "STS_OBRIGA_DIGITALIZACAO_PROT")
    private String stsObrigaDigitalizacaoProt;
    
    @Size(max = 1)
    @Column(name = "STS_OBRIGA_ASSOCIACAO_PROT")
    private String stsObrigaAssociacaoProt;
    
    @Size(max = 1)
    @Column(name = "STS_ENVIA_EMAIL_ALT_PROC_WEB")
    private String stsEnviaEmailAltProcWeb;
    
    @Lob
    @Column(name = "ARQ_LOGO_EMPRESA")
    private byte[] arqLogoEmpresa;
    
    @Size(max = 1)
    @Column(name = "STS_TIPO_EMPRESA")
    private String stsTipoEmpresa;
    
    @Size(max = 200)
    @Column(name = "NOM_HOLDING")
    private String nomHolding;
    
    @Size(max = 1)
    @Column(name = "STS_EMPRESA_TERCEIRO")
    private String stsEmpresaTerceiro;
    
    @Size(max = 4)
    @Column(name = "SIG_DIVISAO_SAP")
    private String sigDivisaoSap;
    
    @Size(max = 4)
    @Column(name = "STS_TIPO_EMPRESA_SAP")
    private String stsTipoEmpresaSap;
    
    @Size(max = 4)
    @Column(name = "VERSAO_SAP")
    private String versaoSap;
    
    @Size(max = 4)
    @Column(name = "SIG_EMPRESA")
    private String sigEmpresa;
    
    @Size(max = 6)
    @Column(name = "STS_AREA_RESPONSAVEL_PROCESSO")
    private String stsAreaResponsavelProcesso;
    @JoinColumns({
        @JoinColumn(name = "SIG_MUNICIPIO", referencedColumnName = "SIG_MUNICIPIO")
        , @JoinColumn(name = "SIG_ESTADO", referencedColumnName = "SIG_ESTADO")})
    @ManyToOne
    private Municipio municipio;

    public Empresa() {
    }

    public Empresa(BigDecimal codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public BigDecimal getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(BigDecimal codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public String getNomEmpresa() {
        return nomEmpresa;
    }

    public void setNomEmpresa(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
    }

    public String getNomFantasiaEmpresa() {
        return nomFantasiaEmpresa;
    }

    public void setNomFantasiaEmpresa(String nomFantasiaEmpresa) {
        this.nomFantasiaEmpresa = nomFantasiaEmpresa;
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

    public String getDesLogomarcaEmpresa() {
        return desLogomarcaEmpresa;
    }

    public void setDesLogomarcaEmpresa(String desLogomarcaEmpresa) {
        this.desLogomarcaEmpresa = desLogomarcaEmpresa;
    }

    public String getDesChancelaJuridico() {
        return desChancelaJuridico;
    }

    public void setDesChancelaJuridico(String desChancelaJuridico) {
        this.desChancelaJuridico = desChancelaJuridico;
    }

    public String getNomFinalEmail() {
        return nomFinalEmail;
    }

    public void setNomFinalEmail(String nomFinalEmail) {
        this.nomFinalEmail = nomFinalEmail;
    }

    public BigInteger getNumOficioLimiteInicio() {
        return numOficioLimiteInicio;
    }

    public void setNumOficioLimiteInicio(BigInteger numOficioLimiteInicio) {
        this.numOficioLimiteInicio = numOficioLimiteInicio;
    }

    public BigInteger getNumOficioLimiteFim() {
        return numOficioLimiteFim;
    }

    public void setNumOficioLimiteFim(BigInteger numOficioLimiteFim) {
        this.numOficioLimiteFim = numOficioLimiteFim;
    }

    public String getAnoRefOficioLimite() {
        return anoRefOficioLimite;
    }

    public void setAnoRefOficioLimite(String anoRefOficioLimite) {
        this.anoRefOficioLimite = anoRefOficioLimite;
    }

    public String getNomCidade() {
        return nomCidade;
    }

    public void setNomCidade(String nomCidade) {
        this.nomCidade = nomCidade;
    }

    public String getNomUsuarioEnvioCopiaAgenda() {
        return nomUsuarioEnvioCopiaAgenda;
    }

    public void setNomUsuarioEnvioCopiaAgenda(String nomUsuarioEnvioCopiaAgenda) {
        this.nomUsuarioEnvioCopiaAgenda = nomUsuarioEnvioCopiaAgenda;
    }

    public String getStsEnviaEmailEstacao() {
        return stsEnviaEmailEstacao;
    }

    public void setStsEnviaEmailEstacao(String stsEnviaEmailEstacao) {
        this.stsEnviaEmailEstacao = stsEnviaEmailEstacao;
    }

    public String getStsObrigaDigitalizacaoProt() {
        return stsObrigaDigitalizacaoProt;
    }

    public void setStsObrigaDigitalizacaoProt(String stsObrigaDigitalizacaoProt) {
        this.stsObrigaDigitalizacaoProt = stsObrigaDigitalizacaoProt;
    }

    public String getStsObrigaAssociacaoProt() {
        return stsObrigaAssociacaoProt;
    }

    public void setStsObrigaAssociacaoProt(String stsObrigaAssociacaoProt) {
        this.stsObrigaAssociacaoProt = stsObrigaAssociacaoProt;
    }

    public String getStsEnviaEmailAltProcWeb() {
        return stsEnviaEmailAltProcWeb;
    }

    public void setStsEnviaEmailAltProcWeb(String stsEnviaEmailAltProcWeb) {
        this.stsEnviaEmailAltProcWeb = stsEnviaEmailAltProcWeb;
    }
    
    public byte[] getArqLogoEmpresa() {
        return arqLogoEmpresa;
    }

    public void setArqLogoEmpresa(byte[] arqLogoEmpresa) {
        this.arqLogoEmpresa = arqLogoEmpresa;
    }
    
    public String getStsTipoEmpresa() {
        return stsTipoEmpresa;
    }

    public void setStsTipoEmpresa(String stsTipoEmpresa) {
        this.stsTipoEmpresa = stsTipoEmpresa;
    }

    public String getNomHolding() {
        return nomHolding;
    }

    public void setNomHolding(String nomHolding) {
        this.nomHolding = nomHolding;
    }

    public String getStsEmpresaTerceiro() {
        return stsEmpresaTerceiro;
    }

    public void setStsEmpresaTerceiro(String stsEmpresaTerceiro) {
        this.stsEmpresaTerceiro = stsEmpresaTerceiro;
    }

    public String getSigDivisaoSap() {
        return sigDivisaoSap;
    }

    public void setSigDivisaoSap(String sigDivisaoSap) {
        this.sigDivisaoSap = sigDivisaoSap;
    }

    public String getStsTipoEmpresaSap() {
        return stsTipoEmpresaSap;
    }

    public void setStsTipoEmpresaSap(String stsTipoEmpresaSap) {
        this.stsTipoEmpresaSap = stsTipoEmpresaSap;
    }

    public String getVersaoSap() {
        return versaoSap;
    }

    public void setVersaoSap(String versaoSap) {
        this.versaoSap = versaoSap;
    }

    public String getSigEmpresa() {
        return sigEmpresa;
    }

    public void setSigEmpresa(String sigEmpresa) {
        this.sigEmpresa = sigEmpresa;
    }

    public String getStsAreaResponsavelProcesso() {
        return stsAreaResponsavelProcesso;
    }

    public void setStsAreaResponsavelProcesso(String stsAreaResponsavelProcesso) {
        this.stsAreaResponsavelProcesso = stsAreaResponsavelProcesso;
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
        hash += (codEmpresa != null ? codEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.codEmpresa == null && other.codEmpresa != null) || (this.codEmpresa != null && !this.codEmpresa.equals(other.codEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vivo.processum.model.Empresa[ codEmpresa=" + codEmpresa + " ]";
    }

}
