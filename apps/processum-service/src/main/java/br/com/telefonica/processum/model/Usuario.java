package br.com.telefonica.processum.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jadossantos
 */
@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByNomUsuario", query = "SELECT u FROM Usuario u WHERE u.nomUsuario = :nomUsuario")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOM_USUARIO")
    private String nomUsuario;
    
    @Size(max = 20)
    @Column(name = "DES_SENHA")
    private String desSenha;
    
    @Size(max = 1)
    @Column(name = "STS_VISUALIZA_TODOS")
    private String stsVisualizaTodos;
    
    @Size(max = 1)
    @Column(name = "STS_PRIMEIRO_LOGON")
    private String stsPrimeiroLogon;
    
    @Size(max = 1)
    @Column(name = "STS_FUNCIONARIO_ADV_ESC_CONT")
    private String stsFuncionarioAdvEscCont;
    
    @Column(name = "DTC_TROCA_SENHA")
    @Temporal(TemporalType.DATE)
    private Date dtcTrocaSenha;
    
    @Size(max = 1)
    @Column(name = "STS_TEXTO_TOOLBAR")
    private String stsTextoToolbar;
    
    @Size(max = 1)
    @Column(name = "STS_VISUA_RESUMO_ATIVIDADES")
    private String stsVisuaResumoAtividades;
    
    @Size(max = 1)
    @Column(name = "STS_MONITORA_TEMPO_CONSULTA")
    private String stsMonitoraTempoConsulta;
    
    @Column(name = "COD_AUTORIZADO_OFICIO")
    private BigInteger codAutorizadoOficio;
    
    @Column(name = "DTC_CADASTRO")
    @Temporal(TemporalType.DATE)
    private Date dtcCadastro;
    
    @Column(name = "NUM_TENTATIVA_LOGIN")
    private BigInteger numTentativaLogin;
    
    @Column(name = "COD_OBJETO_SISTEMA")
    private BigInteger codObjetoSistema;
    
    @Size(max = 200)
    @Column(name = "DES_SENHA_NOVA")
    private String desSenhaNova;
    
    @Column(name = "DTC_ULTIMO_ACESSO")
    @Temporal(TemporalType.DATE)
    private Date dtcUltimoAcesso;
    
    @Size(max = 1)
    @Column(name = "STS_USUARIO_FIXA")
    private String stsUsuarioFixa;
    
    @Column(name = "COD_REG_ADVOGADO")
    private BigInteger codRegAdvogado;
    
    @Size(max = 50)
    @Column(name = "NOM_USUARIO_AD")
    private String nomUsuarioAd;
    
    @JoinColumn(name = "SIG_ADVOGADO", referencedColumnName = "SIG_ADVOGADO")
    @ManyToOne
    private Advogado sigAdvogado;
    
    @JoinColumn(name = "SIG_ADVOGADO_ESC_CONTRATADO", referencedColumnName = "SIG_ADVOGADO")
    @ManyToOne
    private Advogado sigAdvogadoEscContratado;
    
    @JoinColumn(name = "SIG_ESCRITORIO_CONTRATADO", referencedColumnName = "SIG_ESCRITORIO_CONTRATADO")
    @ManyToOne
    private EscritorioContratado sigEscritorioContratado;
    
    @JoinColumns({
        @JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA")
        , @JoinColumn(name = "COD_FUNCIONARIO", referencedColumnName = "COD_FUNCIONARIO")})
    @ManyToOne
    private Funcionario funcionario;
    
    @JoinColumn(name = "COD_PERFIL_USUARIO", referencedColumnName = "COD_PERFIL_USUARIO")
    @ManyToOne
    private PerfilUsuario codPerfilUsuario;
    
    @JoinColumn(name = "SEQ_PERFIL_REDI", referencedColumnName = "SEQ_PERFIL")
    @ManyToOne
    private RediPerfil seqPerfilRedi;
    
    @JoinColumn(name = "ID_PERFIL_OBRIGACAO", referencedColumnName = "ID_PERFIL_OBRIGACAO")
    @ManyToOne
    private TobrPerfilObrigacao idPerfilObrigacao;

    public Usuario() {
    }

    public Usuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getDesSenha() {
        return desSenha;
    }

    public void setDesSenha(String desSenha) {
        this.desSenha = desSenha;
    }

    public String getStsVisualizaTodos() {
        return stsVisualizaTodos;
    }

    public void setStsVisualizaTodos(String stsVisualizaTodos) {
        this.stsVisualizaTodos = stsVisualizaTodos;
    }

    public String getStsPrimeiroLogon() {
        return stsPrimeiroLogon;
    }

    public void setStsPrimeiroLogon(String stsPrimeiroLogon) {
        this.stsPrimeiroLogon = stsPrimeiroLogon;
    }

    public String getStsFuncionarioAdvEscCont() {
        return stsFuncionarioAdvEscCont;
    }

    public void setStsFuncionarioAdvEscCont(String stsFuncionarioAdvEscCont) {
        this.stsFuncionarioAdvEscCont = stsFuncionarioAdvEscCont;
    }

    public Date getDtcTrocaSenha() {
        return dtcTrocaSenha;
    }

    public void setDtcTrocaSenha(Date dtcTrocaSenha) {
        this.dtcTrocaSenha = dtcTrocaSenha;
    }

    public String getStsTextoToolbar() {
        return stsTextoToolbar;
    }

    public void setStsTextoToolbar(String stsTextoToolbar) {
        this.stsTextoToolbar = stsTextoToolbar;
    }

    public String getStsVisuaResumoAtividades() {
        return stsVisuaResumoAtividades;
    }

    public void setStsVisuaResumoAtividades(String stsVisuaResumoAtividades) {
        this.stsVisuaResumoAtividades = stsVisuaResumoAtividades;
    }

    public String getStsMonitoraTempoConsulta() {
        return stsMonitoraTempoConsulta;
    }

    public void setStsMonitoraTempoConsulta(String stsMonitoraTempoConsulta) {
        this.stsMonitoraTempoConsulta = stsMonitoraTempoConsulta;
    }

    public BigInteger getCodAutorizadoOficio() {
        return codAutorizadoOficio;
    }

    public void setCodAutorizadoOficio(BigInteger codAutorizadoOficio) {
        this.codAutorizadoOficio = codAutorizadoOficio;
    }

    public Date getDtcCadastro() {
        return dtcCadastro;
    }

    public void setDtcCadastro(Date dtcCadastro) {
        this.dtcCadastro = dtcCadastro;
    }

    public BigInteger getNumTentativaLogin() {
        return numTentativaLogin;
    }

    public void setNumTentativaLogin(BigInteger numTentativaLogin) {
        this.numTentativaLogin = numTentativaLogin;
    }

    public BigInteger getCodObjetoSistema() {
        return codObjetoSistema;
    }

    public void setCodObjetoSistema(BigInteger codObjetoSistema) {
        this.codObjetoSistema = codObjetoSistema;
    }

    public String getDesSenhaNova() {
        return desSenhaNova;
    }

    public void setDesSenhaNova(String desSenhaNova) {
        this.desSenhaNova = desSenhaNova;
    }

    public Date getDtcUltimoAcesso() {
        return dtcUltimoAcesso;
    }

    public void setDtcUltimoAcesso(Date dtcUltimoAcesso) {
        this.dtcUltimoAcesso = dtcUltimoAcesso;
    }

    public String getStsUsuarioFixa() {
        return stsUsuarioFixa;
    }

    public void setStsUsuarioFixa(String stsUsuarioFixa) {
        this.stsUsuarioFixa = stsUsuarioFixa;
    }

    public BigInteger getCodRegAdvogado() {
        return codRegAdvogado;
    }

    public void setCodRegAdvogado(BigInteger codRegAdvogado) {
        this.codRegAdvogado = codRegAdvogado;
    }

    public String getNomUsuarioAd() {
        return nomUsuarioAd;
    }

    public void setNomUsuarioAd(String nomUsuarioAd) {
        this.nomUsuarioAd = nomUsuarioAd;
    }

    public Advogado getSigAdvogado() {
        return sigAdvogado;
    }

    public void setSigAdvogado(Advogado sigAdvogado) {
        this.sigAdvogado = sigAdvogado;
    }

    public Advogado getSigAdvogadoEscContratado() {
        return sigAdvogadoEscContratado;
    }

    public void setSigAdvogadoEscContratado(Advogado sigAdvogadoEscContratado) {
        this.sigAdvogadoEscContratado = sigAdvogadoEscContratado;
    }

    public EscritorioContratado getSigEscritorioContratado() {
        return sigEscritorioContratado;
    }

    public void setSigEscritorioContratado(EscritorioContratado sigEscritorioContratado) {
        this.sigEscritorioContratado = sigEscritorioContratado;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public PerfilUsuario getCodPerfilUsuario() {
        return codPerfilUsuario;
    }

    public void setCodPerfilUsuario(PerfilUsuario codPerfilUsuario) {
        this.codPerfilUsuario = codPerfilUsuario;
    }

    public RediPerfil getSeqPerfilRedi() {
        return seqPerfilRedi;
    }

    public void setSeqPerfilRedi(RediPerfil seqPerfilRedi) {
        this.seqPerfilRedi = seqPerfilRedi;
    }

    public TobrPerfilObrigacao getIdPerfilObrigacao() {
        return idPerfilObrigacao;
    }

    public void setIdPerfilObrigacao(TobrPerfilObrigacao idPerfilObrigacao) {
        this.idPerfilObrigacao = idPerfilObrigacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomUsuario != null ? nomUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.nomUsuario == null && other.nomUsuario != null) || (this.nomUsuario != null && !this.nomUsuario.equals(other.nomUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telefonica.processum.model.Usuario[ nomUsuario=" + nomUsuario + " ]";
    }
    
}
