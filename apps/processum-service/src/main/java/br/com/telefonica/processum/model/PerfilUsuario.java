package br.com.telefonica.processum.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "PERFIL_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerfilUsuario.findAll", query = "SELECT p FROM PerfilUsuario p")
    , @NamedQuery(name = "PerfilUsuario.findByCodPerfilUsuario", query = "SELECT p FROM PerfilUsuario p WHERE p.codPerfilUsuario = :codPerfilUsuario")
    , @NamedQuery(name = "PerfilUsuario.findByNomPerfilUsuario", query = "SELECT p FROM PerfilUsuario p WHERE p.nomPerfilUsuario = :nomPerfilUsuario")})
public class PerfilUsuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "COD_PERFIL_USUARIO")
    private BigDecimal codPerfilUsuario;
    
    @Size(max = 80)
    @Column(name = "NOM_PERFIL_USUARIO")
    private String nomPerfilUsuario;
    
    @Size(max = 1)
    @Column(name = "STS_COMENTA_PARECER")
    private String stsComentaParecer;
    
    @Size(max = 1)
    @Column(name = "STS_COMENTA_CONTRATO")
    private String stsComentaContrato;
    
    @Size(max = 3)
    @Column(name = "STS_AREA_RESPONSAVEL_OFICIO")
    private String stsAreaResponsavelOficio;
    
    @Size(max = 1)
    @Column(name = "STS_ATUALIZA_TODO_PROTOCOLO")
    private String stsAtualizaTodoProtocolo;
    
    @Size(max = 1)
    @Column(name = "STS_COMENTA_PROCESSO")
    private String stsComentaProcesso;
    
    @Size(max = 3)
    @Column(name = "STS_AREA_RESPONSAVEL_PROCESSO")
    private String stsAreaResponsavelProcesso;
    
    @Size(max = 1)
    @Column(name = "STS_ATUALIZA_IG_COMPLETO")
    private String stsAtualizaIgCompleto;
    
    @Size(max = 1)
    @Column(name = "STS_VISUA_RESUMO_OFICIO_COMP")
    private String stsVisuaResumoOficioComp;
    
    @Size(max = 1)
    @Column(name = "STS_ACESSO_VIA_INTERNET")
    private String stsAcessoViaInternet;
    
    @Size(max = 1)
    @Column(name = "STS_CARREGA_MAP")
    private String stsCarregaMap;
    
    @Size(max = 1)
    @Column(name = "STS_OBRIGA_ESP_OBJETO_ACAO")
    private String stsObrigaEspObjetoAcao;
    
    @Size(max = 3)
    @Column(name = "STS_AREA_RESPONSAVEL_INVEST")
    private String stsAreaResponsavelInvest;
    
    @Size(max = 1)
    @Column(name = "STS_ADMINISTRADOR_INVESTIGACAO")
    private String stsAdministradorInvestigacao;
    
    @Size(max = 1)
    @Column(name = "STS_ACOMPANHANTE_INVESTIGACAO")
    private String stsAcompanhanteInvestigacao;
    
    @Size(max = 5)
    @Column(name = "STS_ANALISTA_INVESTIGACAO")
    private String stsAnalistaInvestigacao;
    
    @Size(max = 1)
    @Column(name = "STS_AREA_RESPONSAVEL_ALERTA")
    private String stsAreaResponsavelAlerta;
    
    @Size(max = 1)
    @Column(name = "STS_EDITAR_PROCESSO")
    private String stsEditarProcesso;
    
    @Size(max = 4000)
    @Column(name = "DES_PERFIL_USUARIO")
    private String desPerfilUsuario;
    
    @Size(max = 3)
    @Column(name = "STS_PERFIL_COMPRA")
    private String stsPerfilCompra;
    
    @Size(max = 1)
    @Column(name = "STS_PAINEL_OFICIO_FAX")
    private String stsPainelOficioFax;
    
    @Size(max = 3)
    @Column(name = "STS_PERFIL_PROCURACAO")
    private String stsPerfilProcuracao;
    
    @Size(max = 5)
    @Column(name = "STS_PERFIL_FRAUDE")
    private String stsPerfilFraude;
    
    @Size(max = 3)
    @Column(name = "STS_AREA_RESPONSAVEL_GERAL")
    private String stsAreaResponsavelGeral;
    
    @Size(max = 1)
    @Column(name = "STS_PERFIL_CADASTRO_OFICIO")
    private String stsPerfilCadastroOficio;
    
    @Size(max = 1)
    @Column(name = "STS_PERFIL_RESPOSTA_OFICIO")
    private String stsPerfilRespostaOficio;
    
    @Size(max = 3)
    @Column(name = "STS_AREA_RESP_PROCURACAO")
    private String stsAreaRespProcuracao;
    
    @Size(max = 1)
    @Column(name = "STS_PERFIL_REGULATORIO")
    private String stsPerfilRegulatorio;
    
    @Size(max = 3)
    @Column(name = "STS_ADVOGADO_CONTENCIOSO")
    private String stsAdvogadoContencioso;
    
    @Size(max = 3)
    @Column(name = "STS_SECRETARIO_CONTENCIOSO")
    private String stsSecretarioContencioso;
    
    @JoinColumn(name = "COD_AREA_PARECER", referencedColumnName = "COD_AREA_PARECER")
    @ManyToOne
    private AreaParecer codAreaParecer;
    
    public PerfilUsuario() {
    }

    public PerfilUsuario(BigDecimal codPerfilUsuario) {
        this.codPerfilUsuario = codPerfilUsuario;
    }

    public BigDecimal getCodPerfilUsuario() {
        return codPerfilUsuario;
    }

    public void setCodPerfilUsuario(BigDecimal codPerfilUsuario) {
        this.codPerfilUsuario = codPerfilUsuario;
    }

    public String getNomPerfilUsuario() {
        return nomPerfilUsuario;
    }

    public void setNomPerfilUsuario(String nomPerfilUsuario) {
        this.nomPerfilUsuario = nomPerfilUsuario;
    }

    public String getStsComentaParecer() {
        return stsComentaParecer;
    }

    public void setStsComentaParecer(String stsComentaParecer) {
        this.stsComentaParecer = stsComentaParecer;
    }

    public String getStsComentaContrato() {
        return stsComentaContrato;
    }

    public void setStsComentaContrato(String stsComentaContrato) {
        this.stsComentaContrato = stsComentaContrato;
    }

    public String getStsAreaResponsavelOficio() {
        return stsAreaResponsavelOficio;
    }

    public void setStsAreaResponsavelOficio(String stsAreaResponsavelOficio) {
        this.stsAreaResponsavelOficio = stsAreaResponsavelOficio;
    }

    public String getStsAtualizaTodoProtocolo() {
        return stsAtualizaTodoProtocolo;
    }

    public void setStsAtualizaTodoProtocolo(String stsAtualizaTodoProtocolo) {
        this.stsAtualizaTodoProtocolo = stsAtualizaTodoProtocolo;
    }

    public String getStsComentaProcesso() {
        return stsComentaProcesso;
    }

    public void setStsComentaProcesso(String stsComentaProcesso) {
        this.stsComentaProcesso = stsComentaProcesso;
    }

    public String getStsAreaResponsavelProcesso() {
        return stsAreaResponsavelProcesso;
    }

    public void setStsAreaResponsavelProcesso(String stsAreaResponsavelProcesso) {
        this.stsAreaResponsavelProcesso = stsAreaResponsavelProcesso;
    }

    public String getStsAtualizaIgCompleto() {
        return stsAtualizaIgCompleto;
    }

    public void setStsAtualizaIgCompleto(String stsAtualizaIgCompleto) {
        this.stsAtualizaIgCompleto = stsAtualizaIgCompleto;
    }

    public String getStsVisuaResumoOficioComp() {
        return stsVisuaResumoOficioComp;
    }

    public void setStsVisuaResumoOficioComp(String stsVisuaResumoOficioComp) {
        this.stsVisuaResumoOficioComp = stsVisuaResumoOficioComp;
    }

    public String getStsAcessoViaInternet() {
        return stsAcessoViaInternet;
    }

    public void setStsAcessoViaInternet(String stsAcessoViaInternet) {
        this.stsAcessoViaInternet = stsAcessoViaInternet;
    }

    public String getStsCarregaMap() {
        return stsCarregaMap;
    }

    public void setStsCarregaMap(String stsCarregaMap) {
        this.stsCarregaMap = stsCarregaMap;
    }

    public String getStsObrigaEspObjetoAcao() {
        return stsObrigaEspObjetoAcao;
    }

    public void setStsObrigaEspObjetoAcao(String stsObrigaEspObjetoAcao) {
        this.stsObrigaEspObjetoAcao = stsObrigaEspObjetoAcao;
    }

    public String getStsAreaResponsavelInvest() {
        return stsAreaResponsavelInvest;
    }

    public void setStsAreaResponsavelInvest(String stsAreaResponsavelInvest) {
        this.stsAreaResponsavelInvest = stsAreaResponsavelInvest;
    }

    public String getStsAdministradorInvestigacao() {
        return stsAdministradorInvestigacao;
    }

    public void setStsAdministradorInvestigacao(String stsAdministradorInvestigacao) {
        this.stsAdministradorInvestigacao = stsAdministradorInvestigacao;
    }

    public String getStsAcompanhanteInvestigacao() {
        return stsAcompanhanteInvestigacao;
    }

    public void setStsAcompanhanteInvestigacao(String stsAcompanhanteInvestigacao) {
        this.stsAcompanhanteInvestigacao = stsAcompanhanteInvestigacao;
    }

    public String getStsAnalistaInvestigacao() {
        return stsAnalistaInvestigacao;
    }

    public void setStsAnalistaInvestigacao(String stsAnalistaInvestigacao) {
        this.stsAnalistaInvestigacao = stsAnalistaInvestigacao;
    }

    public String getStsAreaResponsavelAlerta() {
        return stsAreaResponsavelAlerta;
    }

    public void setStsAreaResponsavelAlerta(String stsAreaResponsavelAlerta) {
        this.stsAreaResponsavelAlerta = stsAreaResponsavelAlerta;
    }

    public String getStsEditarProcesso() {
        return stsEditarProcesso;
    }

    public void setStsEditarProcesso(String stsEditarProcesso) {
        this.stsEditarProcesso = stsEditarProcesso;
    }

    public String getDesPerfilUsuario() {
        return desPerfilUsuario;
    }

    public void setDesPerfilUsuario(String desPerfilUsuario) {
        this.desPerfilUsuario = desPerfilUsuario;
    }

    public String getStsPerfilCompra() {
        return stsPerfilCompra;
    }

    public void setStsPerfilCompra(String stsPerfilCompra) {
        this.stsPerfilCompra = stsPerfilCompra;
    }

    public String getStsPainelOficioFax() {
        return stsPainelOficioFax;
    }

    public void setStsPainelOficioFax(String stsPainelOficioFax) {
        this.stsPainelOficioFax = stsPainelOficioFax;
    }

    public String getStsPerfilProcuracao() {
        return stsPerfilProcuracao;
    }

    public void setStsPerfilProcuracao(String stsPerfilProcuracao) {
        this.stsPerfilProcuracao = stsPerfilProcuracao;
    }

    public String getStsPerfilFraude() {
        return stsPerfilFraude;
    }

    public void setStsPerfilFraude(String stsPerfilFraude) {
        this.stsPerfilFraude = stsPerfilFraude;
    }

    public String getStsAreaResponsavelGeral() {
        return stsAreaResponsavelGeral;
    }

    public void setStsAreaResponsavelGeral(String stsAreaResponsavelGeral) {
        this.stsAreaResponsavelGeral = stsAreaResponsavelGeral;
    }

    public String getStsPerfilCadastroOficio() {
        return stsPerfilCadastroOficio;
    }

    public void setStsPerfilCadastroOficio(String stsPerfilCadastroOficio) {
        this.stsPerfilCadastroOficio = stsPerfilCadastroOficio;
    }

    public String getStsPerfilRespostaOficio() {
        return stsPerfilRespostaOficio;
    }

    public void setStsPerfilRespostaOficio(String stsPerfilRespostaOficio) {
        this.stsPerfilRespostaOficio = stsPerfilRespostaOficio;
    }

    public String getStsAreaRespProcuracao() {
        return stsAreaRespProcuracao;
    }

    public void setStsAreaRespProcuracao(String stsAreaRespProcuracao) {
        this.stsAreaRespProcuracao = stsAreaRespProcuracao;
    }

    public String getStsPerfilRegulatorio() {
        return stsPerfilRegulatorio;
    }

    public void setStsPerfilRegulatorio(String stsPerfilRegulatorio) {
        this.stsPerfilRegulatorio = stsPerfilRegulatorio;
    }

    public String getStsAdvogadoContencioso() {
        return stsAdvogadoContencioso;
    }

    public void setStsAdvogadoContencioso(String stsAdvogadoContencioso) {
        this.stsAdvogadoContencioso = stsAdvogadoContencioso;
    }

    public String getStsSecretarioContencioso() {
        return stsSecretarioContencioso;
    }

    public void setStsSecretarioContencioso(String stsSecretarioContencioso) {
        this.stsSecretarioContencioso = stsSecretarioContencioso;
    }

    public AreaParecer getCodAreaParecer() {
        return codAreaParecer;
    }

    public void setCodAreaParecer(AreaParecer codAreaParecer) {
        this.codAreaParecer = codAreaParecer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPerfilUsuario != null ? codPerfilUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PerfilUsuario)) {
            return false;
        }
        PerfilUsuario other = (PerfilUsuario) object;
        if ((this.codPerfilUsuario == null && other.codPerfilUsuario != null) || (this.codPerfilUsuario != null && !this.codPerfilUsuario.equals(other.codPerfilUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telefonica.processum.model.PerfilUsuario[ codPerfilUsuario=" + codPerfilUsuario + " ]";
    }
    
}
