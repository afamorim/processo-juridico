package br.com.telefonica.processum.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jadossantos
 */
@Entity
@Table(name = "FUNCIONARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f")
    , @NamedQuery(name = "Funcionario.findByCodEmpresa", query = "SELECT f FROM Funcionario f WHERE f.funcionarioPK.codEmpresa = :codEmpresa")
    , @NamedQuery(name = "Funcionario.findByCodFuncionario", query = "SELECT f FROM Funcionario f WHERE f.funcionarioPK.codFuncionario = :codFuncionario")
    , @NamedQuery(name = "Funcionario.findByNomFuncionario", query = "SELECT f FROM Funcionario f WHERE f.nomFuncionario = :nomFuncionario")})
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected FuncionarioPK funcionarioPK;
    
    @Size(max = 80)
    @Column(name = "NOM_FUNCIONARIO")
    private String nomFuncionario;
    
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
    
    @Size(max = 13)
    @Column(name = "NUM_TEL_CELULAR")
    private String numTelCelular;
    
    @Size(max = 80)
    @Column(name = "DES_EMAIL")
    private String desEmail;
    
    @Size(max = 1)
    @Column(name = "STS_GERENTE")
    private String stsGerente;
    
    @Size(max = 1)
    @Column(name = "STS_ATIVO")
    private String stsAtivo;
    
    @Column(name = "DTC_RECISAO")
    @Temporal(TemporalType.DATE)
    private Date dtcRecisao;
    
    @Lob
    @Column(name = "ARQ_ASSINATURA")
    private Serializable arqAssinatura;
    
    @Column(name = "SEQ_DIRETORIA")
    private Long seqDiretoria;
    
    @JoinColumns({
        @JoinColumn(name = "COD_CARGO", referencedColumnName = "COD_CARGO", insertable = false, updatable = false)
        , @JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false)})
    @ManyToOne
    private Cargo cargo;
    
    @Column(name = "COD_CARGO")
    private BigInteger codCargo;
    
    @JoinColumn(name = "SIG_CENTRO_CUSTO_VP", referencedColumnName = "SIG_CENTRO_CUSTO")
    @ManyToOne
    private CentroCusto sigCentroCustoVp;
    
    @JoinColumn(name = "SIG_CENTRO_CUSTO_DIR", referencedColumnName = "SIG_CENTRO_CUSTO")
    @ManyToOne
    private CentroCusto sigCentroCustoDir;
    
    @JoinColumn(name = "SIG_CENTRO_CUSTO", referencedColumnName = "SIG_CENTRO_CUSTO")
    @ManyToOne
    private CentroCusto sigCentroCusto;
    
    @JoinColumn(name = "COD_EMPRESA_TERCEIRO", referencedColumnName = "COD_EMPRESA")
    @ManyToOne
    private Empresa codEmpresaTerceiro;
    @JoinColumn(name = "COD_ESTADO_CIVIL", referencedColumnName = "COD_ESTADO_CIVIL")
    @ManyToOne
    private EstadoCivil codEstadoCivil;
    
    @JoinColumns({
        @JoinColumn(name = "COD_EMPRESA_SUPERIOR", referencedColumnName = "COD_EMPRESA")
        , @JoinColumn(name = "COD_FUNCIONARIO_SUPERIOR", referencedColumnName = "COD_FUNCIONARIO")})
    @ManyToOne
    private Funcionario funcionario;
    
    @JoinColumns({
        @JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false)
        , @JoinColumn(name = "COD_LOTACAO", referencedColumnName = "COD_LOTACAO", insertable = false, updatable = false)})
    @ManyToOne
    private Lotacao lotacao;
    
     @Column(name = "COD_LOTACAO")
    private BigInteger codLotacao;
    
    @JoinColumns({
        @JoinColumn(name = "SIG_MUNICIPIO", referencedColumnName = "SIG_MUNICIPIO")
        , @JoinColumn(name = "SIG_ESTADO", referencedColumnName = "SIG_ESTADO")})
    @ManyToOne
    private Municipio municipio;
    
    public Funcionario() {
    }

    public Funcionario(FuncionarioPK funcionarioPK) {
        this.funcionarioPK = funcionarioPK;
    }

    public Funcionario(BigInteger codEmpresa, BigInteger codFuncionario) {
        this.funcionarioPK = new FuncionarioPK(codEmpresa, codFuncionario);
    }

    public FuncionarioPK getFuncionarioPK() {
        return funcionarioPK;
    }

    public void setFuncionarioPK(FuncionarioPK funcionarioPK) {
        this.funcionarioPK = funcionarioPK;
    }

    public String getNomFuncionario() {
        return nomFuncionario;
    }

    public void setNomFuncionario(String nomFuncionario) {
        this.nomFuncionario = nomFuncionario;
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

    public String getStsGerente() {
        return stsGerente;
    }

    public void setStsGerente(String stsGerente) {
        this.stsGerente = stsGerente;
    }

    public String getStsAtivo() {
        return stsAtivo;
    }

    public void setStsAtivo(String stsAtivo) {
        this.stsAtivo = stsAtivo;
    }

    public Date getDtcRecisao() {
        return dtcRecisao;
    }

    public void setDtcRecisao(Date dtcRecisao) {
        this.dtcRecisao = dtcRecisao;
    }

    public Serializable getArqAssinatura() {
        return arqAssinatura;
    }

    public void setArqAssinatura(Serializable arqAssinatura) {
        this.arqAssinatura = arqAssinatura;
    }

    public Long getSeqDiretoria() {
        return seqDiretoria;
    }

    public void setSeqDiretoria(Long seqDiretoria) {
        this.seqDiretoria = seqDiretoria;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public BigInteger getCodCargo() {
        return codCargo;
    }

    public void setCodCargo(BigInteger codCargo) {
        this.codCargo = codCargo;
    }
    
    public CentroCusto getSigCentroCustoVp() {
        return sigCentroCustoVp;
    }

    public void setSigCentroCustoVp(CentroCusto sigCentroCustoVp) {
        this.sigCentroCustoVp = sigCentroCustoVp;
    }

    public CentroCusto getSigCentroCustoDir() {
        return sigCentroCustoDir;
    }

    public void setSigCentroCustoDir(CentroCusto sigCentroCustoDir) {
        this.sigCentroCustoDir = sigCentroCustoDir;
    }

    public CentroCusto getSigCentroCusto() {
        return sigCentroCusto;
    }

    public void setSigCentroCusto(CentroCusto sigCentroCusto) {
        this.sigCentroCusto = sigCentroCusto;
    }

    public Empresa getCodEmpresaTerceiro() {
        return codEmpresaTerceiro;
    }

    public void setCodEmpresaTerceiro(Empresa codEmpresaTerceiro) {
        this.codEmpresaTerceiro = codEmpresaTerceiro;
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

    public Lotacao getLotacao() {
        return lotacao;
    }

    public void setLotacao(Lotacao lotacao) {
        this.lotacao = lotacao;
    }

    public BigInteger getCodLotacao() {
        return codLotacao;
    }

    public void setCodLotacao(BigInteger codLotacao) {
        this.codLotacao = codLotacao;
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
        hash += (funcionarioPK != null ? funcionarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.funcionarioPK == null && other.funcionarioPK != null) || (this.funcionarioPK != null && !this.funcionarioPK.equals(other.funcionarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telefonica.processum.model.Funcionario[ funcionarioPK=" + funcionarioPK + " ]";
    }
    
}
