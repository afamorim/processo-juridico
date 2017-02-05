package br.com.telefonica.processum.model;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "ADVOGADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Advogado.findAll", query = "SELECT a FROM Advogado a")
    , @NamedQuery(name = "Advogado.findBySigAdvogado", query = "SELECT a FROM Advogado a WHERE a.sigAdvogado = :sigAdvogado")
    , @NamedQuery(name = "Advogado.findByNomAdvogado", query = "SELECT a FROM Advogado a WHERE a.nomAdvogado = :nomAdvogado")})
public class Advogado implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SIG_ADVOGADO")
    private String sigAdvogado;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOM_ADVOGADO")
    private String nomAdvogado;
    
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
    
    @Size(max = 80)
    @Column(name = "DES_EMAIL")
    private String desEmail;
    
    @Size(max = 1)
    @Column(name = "STS_ADVOGADO_INTERNO")
    private String stsAdvogadoInterno;
    
    @Size(max = 1)
    @Column(name = "STS_ADVOGADO_ATIVO")
    private String stsAdvogadoAtivo;
    
    @Column(name = "NUM_PRIORIDADE")
    private BigInteger numPrioridade;
    
    @Column(name = "NUM_QUANT_CONTRATOS")
    private BigInteger numQuantContratos;
    
    @Column(name = "NUM_QUANT_PARECERES")
    private BigInteger numQuantPareceres;
    
    @Size(max = 1)
    @Column(name = "STS_RESP_CONSULTIVO")
    private String stsRespConsultivo;
    
    @Size(max = 1)
    @Column(name = "STS_RESPONSAVEL_SEGURANCA")
    private String stsResponsavelSeguranca;
    
    @Size(max = 1)
    @Column(name = "STS_CORESPONSAVEL_SEGURANCA")
    private String stsCoresponsavelSeguranca;
    
    @Size(max = 1)
    @Column(name = "STS_MIGRACAO_BENNER")
    private String stsMigracaoBenner;
    
    @Size(max = 20)
    @Column(name = "NUM_OAB")
    private String numOab;
    
    @JoinColumn(name = "SIG_ESCRITORIO_CONTRATADO", referencedColumnName = "SIG_ESCRITORIO_CONTRATADO")
    @ManyToOne
    private EscritorioContratado sigEscritorioContratado;
    
    @JoinColumn(name = "COD_ESTADO_CIVIL", referencedColumnName = "COD_ESTADO_CIVIL")
    @ManyToOne
    private EstadoCivil codEstadoCivil;
    
    @JoinColumns({
        @JoinColumn(name = "SIG_MUNICIPIO", referencedColumnName = "SIG_MUNICIPIO")
        , @JoinColumn(name = "SIG_ESTADO", referencedColumnName = "SIG_ESTADO")})
    @ManyToOne
    private Municipio municipio;
    
    public Advogado() {
    }

    public Advogado(String sigAdvogado) {
        this.sigAdvogado = sigAdvogado;
    }

    public Advogado(String sigAdvogado, String nomAdvogado) {
        this.sigAdvogado = sigAdvogado;
        this.nomAdvogado = nomAdvogado;
    }

    public String getSigAdvogado() {
        return sigAdvogado;
    }

    public void setSigAdvogado(String sigAdvogado) {
        this.sigAdvogado = sigAdvogado;
    }

    public String getNomAdvogado() {
        return nomAdvogado;
    }

    public void setNomAdvogado(String nomAdvogado) {
        this.nomAdvogado = nomAdvogado;
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

    public String getStsAdvogadoInterno() {
        return stsAdvogadoInterno;
    }

    public void setStsAdvogadoInterno(String stsAdvogadoInterno) {
        this.stsAdvogadoInterno = stsAdvogadoInterno;
    }

    public String getStsAdvogadoAtivo() {
        return stsAdvogadoAtivo;
    }

    public void setStsAdvogadoAtivo(String stsAdvogadoAtivo) {
        this.stsAdvogadoAtivo = stsAdvogadoAtivo;
    }

    public BigInteger getNumPrioridade() {
        return numPrioridade;
    }

    public void setNumPrioridade(BigInteger numPrioridade) {
        this.numPrioridade = numPrioridade;
    }

    public BigInteger getNumQuantContratos() {
        return numQuantContratos;
    }

    public void setNumQuantContratos(BigInteger numQuantContratos) {
        this.numQuantContratos = numQuantContratos;
    }

    public BigInteger getNumQuantPareceres() {
        return numQuantPareceres;
    }

    public void setNumQuantPareceres(BigInteger numQuantPareceres) {
        this.numQuantPareceres = numQuantPareceres;
    }

    public String getStsRespConsultivo() {
        return stsRespConsultivo;
    }

    public void setStsRespConsultivo(String stsRespConsultivo) {
        this.stsRespConsultivo = stsRespConsultivo;
    }

    public String getStsResponsavelSeguranca() {
        return stsResponsavelSeguranca;
    }

    public void setStsResponsavelSeguranca(String stsResponsavelSeguranca) {
        this.stsResponsavelSeguranca = stsResponsavelSeguranca;
    }

    public String getStsCoresponsavelSeguranca() {
        return stsCoresponsavelSeguranca;
    }

    public void setStsCoresponsavelSeguranca(String stsCoresponsavelSeguranca) {
        this.stsCoresponsavelSeguranca = stsCoresponsavelSeguranca;
    }

    public String getStsMigracaoBenner() {
        return stsMigracaoBenner;
    }

    public void setStsMigracaoBenner(String stsMigracaoBenner) {
        this.stsMigracaoBenner = stsMigracaoBenner;
    }

    public String getNumOab() {
        return numOab;
    }

    public void setNumOab(String numOab) {
        this.numOab = numOab;
    }

    public EscritorioContratado getSigEscritorioContratado() {
        return sigEscritorioContratado;
    }

    public void setSigEscritorioContratado(EscritorioContratado sigEscritorioContratado) {
        this.sigEscritorioContratado = sigEscritorioContratado;
    }

    public EstadoCivil getCodEstadoCivil() {
        return codEstadoCivil;
    }

    public void setCodEstadoCivil(EstadoCivil codEstadoCivil) {
        this.codEstadoCivil = codEstadoCivil;
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
        hash += (sigAdvogado != null ? sigAdvogado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Advogado)) {
            return false;
        }
        Advogado other = (Advogado) object;
        if ((this.sigAdvogado == null && other.sigAdvogado != null) || (this.sigAdvogado != null && !this.sigAdvogado.equals(other.sigAdvogado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telefonica.processum.model.Advogado[ sigAdvogado=" + sigAdvogado + " ]";
    }
    
}
