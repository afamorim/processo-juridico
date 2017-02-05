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
@Table(name = "PROCESSO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Processo.findAll", query = "SELECT p FROM Processo p")
    , @NamedQuery(name = "Processo.findByNumProcesso", query = "SELECT p FROM Processo p WHERE p.processoPK.numProcesso = :numProcesso")
    , @NamedQuery(name = "Processo.findByDtcCadastro", query = "SELECT p FROM Processo p WHERE p.dtcCadastro = :dtcCadastro")})
public class Processo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProcessoPK processoPK;
    
    @Column(name = "DTC_CADASTRO")
    @Temporal(TemporalType.DATE)
    private Date dtcCadastro;
    
    @Column(name = "DTC_CITACAO")
    @Temporal(TemporalType.DATE)
    private Date dtcCitacao;
    
    @Column(name = "DTC_FIM")
    @Temporal(TemporalType.DATE)
    private Date dtcFim;

    @Column(name = "VLR_ACAO")
    private Float vlrAcao;
    
    @Column(name = "VLR_PAGO")
    private Float vlrPago;
    
    @Size(max = 13)
    @Column(name = "NUM_TEL_PARTE_CONTRARIA")
    private String numTelParteContraria;
    
    @Size(max = 4000)
    @Column(name = "DES_OBSERVACAO")
    private String desObservacao;
    
    @Size(max = 1)
    @Column(name = "STS_ATIVO")
    private String stsAtivo;
    
    @Size(max = 1)
    @Column(name = "STS_INDIVIDUAL")
    private String stsIndividual;
    
    @Column(name = "DTC_ARQUIVAMENTO")
    @Temporal(TemporalType.DATE)
    private Date dtcArquivamento;
    
    @Column(name = "VLR_PROVISIONAMENTO")
    private Float vlrProvisionamento;
    
    @Column(name = "VLR_PROVAVEL")
    private Float vlrProvavel;
    
    @Column(name = "VLR_POSSIVEL")
    private Float vlrPossivel;
    
    @Column(name = "VLR_REMOTO")
    private Float vlrRemoto;
    
    @Column(name = "VLR_PEDIDO")
    private Float vlrPedido;
    
    @Size(max = 4)
    @Column(name = "SIG_ADVOGADO_CO_RESPONSAVEL")
    private String sigAdvogadoCoResponsavel;
    
    @Column(name = "DTC_ENVIO_ESCRITORIO_EXTERNO")
    @Temporal(TemporalType.DATE)
    private Date dtcEnvioEscritorioExterno;
    
    @Column(name = "VLR_ACAO_INDICE")
    private Float vlrAcaoIndice;
    
    @Column(name = "VLR_PEDIDO_INDICE")
    private Float vlrPedidoIndice;
    
    @Column(name = "VLR_PROVAVEL_INDICE")
    private Float vlrProvavelIndice;
    
    @Column(name = "VLR_POSSIVEL_INDICE")
    private Float vlrPossivelIndice;
    
    @Column(name = "VLR_REMOTO_INDICE")
    private Float vlrRemotoIndice;
    
    @Column(name = "DTC_LAVRATURA")
    @Temporal(TemporalType.DATE)
    private Date dtcLavratura;
    
    @Column(name = "DTC_PROTOCOLO_AFORAMENTO")
    @Temporal(TemporalType.DATE)
    private Date dtcProtocoloAforamento;
    
    @Column(name = "VLR_TRIBUTO")
    private Float vlrTributo;
    
    @Column(name = "VLR_MULTA_TRIBUTO")
    private Float vlrMultaTributo;
    
    @Column(name = "VLR_JUROS_TRIBUTO")
    private Float vlrJurosTributo;
    
    @Column(name = "VLR_TRIBUTO_INDICE")
    private Float vlrTributoIndice;
    
    @Column(name = "VLR_MULTA_TRIBUTO_INDICE")
    private Float vlrMultaTributoIndice;
    
    @Column(name = "VLR_JUROS_TRIBUTO_INDICE")
    private Float vlrJurosTributoIndice;
    
    @Column(name = "NUM_SEQ_PROCESSO")
    private BigInteger numSeqProcesso;
    
    @Size(max = 4)
    @Column(name = "DTC_ANO_NUM_SEQ_PROCESSO")
    private String dtcAnoNumSeqProcesso;
    
    @Size(max = 40)
    @Column(name = "NUM_PROCESSO1_INSTANCIA")
    private String numProcesso1Instancia;
    
    @Size(max = 30)
    @Column(name = "NUM_PROCESSO2_INSTANCIA")
    private String numProcesso2Instancia;
    
    @Size(max = 30)
    @Column(name = "NUM_AUTO_INFRACAO")
    private String numAutoInfracao;
    
    @Size(max = 1)
    @Column(name = "STS_RELEVANTE")
    private String stsRelevante;
    
    @Size(max = 3)
    @Column(name = "STS_AREA_RESPONSAVEL")
    private String stsAreaResponsavel;
    
    @Size(max = 1)
    @Column(name = "STS_FATURAVEL")
    private String stsFaturavel;
    
    @Lob
    @Column(name = "STR_PALAVRAS_CHAVE")
    private String strPalavrasChave;
    
    @Size(max = 1)
    @Column(name = "STS_PROCESSA_PALAVRAS")
    private String stsProcessaPalavras;
    
    @Size(max = 1)
    @Column(name = "STS_CONSUMERISTA")
    private String stsConsumerista;
    
    @Size(max = 1)
    @Column(name = "STS_CALL_CENTER")
    private String stsCallCenter;
    
    @Column(name = "COD_TIPO_INCIDENTE")
    private BigInteger codTipoIncidente;
    
    @Size(max = 1)
    @Column(name = "STS_TIPO_PRAZO")
    private String stsTipoPrazo;
    
    @Column(name = "COD_TIPO_ACAO_PROCESSO")
    private BigInteger codTipoAcaoProcesso;
    
    @Size(max = 1)
    @Column(name = "STS_PROCON")
    private String stsProcon;
    
    @Size(max = 1)
    @Column(name = "STS_DRC")
    private String stsDrc;
    
    @Column(name = "VLR_LONGO_PRAZO")
    private Float vlrLongoPrazo;
    
    @Size(max = 200)
    @Column(name = "MOTIVO_ARQUIVAMENTO")
    private String motivoArquivamento;
    
    @Size(max = 1)
    @Column(name = "STS_EXCLUIDO")
    private String stsExcluido;
    
    @Column(name = "VLR_ORIGINAL")
    private Float vlrOriginal;
    
    @Column(name = "DATA_ORIGINAL")
    @Temporal(TemporalType.DATE)
    private Date dataOriginal;
    
    @Column(name = "COD_PRODUTO")
    private BigInteger codProduto;
    
    @Size(max = 3)
    @Column(name = "STS_AREA_RESPONSAVEL_GERAL")
    private String stsAreaResponsavelGeral;
    
    @Size(max = 25)
    @Column(name = "PASTA_BENNER")
    private String pastaBenner;
    
    @Column(name = "ID_BENNER")
    private BigInteger idBenner;
    
    @Size(max = 1)
    @Column(name = "STS_MIGRACAO_BENNER")
    private String stsMigracaoBenner;
    
    @Column(name = "VLR_CURTO_PRAZO_FIN")
    private Float vlrCurtoPrazoFin;
    
    @Column(name = "VLR_LONGO_PRAZO_FIN")
    private Float vlrLongoPrazoFin;
    
    @Column(name = "VLR_PAGAMENTO")
    private Float vlrPagamento;
    
    @Column(name = "PROV_OPERACIONAL_ANTERIOR")
    private Float provOperacionalAnterior;
    
    @Column(name = "PROV_FINANCEIRA_ANTERIOR")
    private Float provFinanceiraAnterior;
    
    @Column(name = "PROV_CP_FINANCEIRA_ANTERIOR")
    private Float provCpFinanceiraAnterior;
    
    @Column(name = "PROV_LP_OPERACIONAL_ANTERIOR")
    private Float provLpOperacionalAnterior;
    
    @Column(name = "PROV_LP_FINANCEIRA_ANTERIOR")
    private Float provLpFinanceiraAnterior;
    
    @Column(name = "PROVISAO_CURTO_ANTERIOR")
    private Float provisaoCurtoAnterior;
    
    @Column(name = "PROVISAO_LONGO_ANTERIOR")
    private Float provisaoLongoAnterior;
    
    @Column(name = "BAIXA_PROV_OPERACIONAL")
    private Float baixaProvOperacional;
    
    @Column(name = "BAIXA_PROV_FINANCEIRA")
    private Float baixaProvFinanceira;
    
    @Column(name = "JUROS_PROV")
    private Float jurosProv;
    
    @Column(name = "AJUSTE_OPERACIONAL")
    private Float ajusteOperacional;
    
    @Column(name = "AJUSTE_FINANCEIRO", columnDefinition="decimal")
    private Float ajusteFinanceiro;
    
    @Column(name = "AJUSTE_OPERACIONAL_PROV_CP")
    private Float ajusteOperacionalProvCp;
    
    @Column(name = "AJUSTE_FINANCEIRO_PROV_CP")
    private Float ajusteFinanceiroProvCp;
    
    @Column(name = "BAIXA_PROV_CURTO_OPERACIONAL")
    private Float baixaProvCurtoOperacional;
    
    @Column(name = "CORRECAO_PROV_CURTO")
    private Float correcaoProvCurto;
    
    @Column(name = "JUROS_PROV_CURTO")
    private Float jurosProvCurto;
    
    @Column(name = "BAIXA_PROV_LONGO_OPERACIONAL")
    private Float baixaProvLongoOperacional;
    
    @Column(name = "BAIXA_PROV_LONGO_FINANCEIRA")
    private Float baixaProvLongoFinanceira;
    
    @Column(name = "CORRECAO_PROV_LONGO")
    private Float correcaoProvLongo;
    
    @Column(name = "JUROS_PROV_LONGO")
    private Float jurosProvLongo;
    
    @Column(name = "AJUSTE_OPERACIONAL_PROV_LP")
    private Float ajusteOperacionalProvLp;
    
    @Column(name = "AJUSTE_FINANCEIRO_PROV_LP")
    private Float ajusteFinanceiroProvLp;
    
    @Column(name = "TOTAL_PROVAVEL_OPERACIONAL")
    private Float totalProvavelOperacional;
    
    @Column(name = "PROV_CP_OPERACIONAL_ANTERIOR")
    private Float provCpOperacionalAnterior;
    
    @Column(name = "CORRECAO_PROV")
    private Float correcaoProv;
    
    @Column(name = "BAIXA_PROV_CURTO_FINANCEIRA")
    private Float baixaProvCurtoFinanceira;
    
    @Column(name = "TOTAL_PROVAVEL_FINANCEIRO")
    private Float totalProvavelFinanceiro;
    
    @Column(name = "DTC_ANO_SALDO_OPER")
    @Temporal(TemporalType.DATE)
    private Date dtcAnoSaldoOper;
    
    @JoinColumns({
        @JoinColumn(name = "COD_TIPO_ACAO", referencedColumnName = "COD_TIPO_ACAO")
        , @JoinColumn(name = "COD_ESPECIFIC_TIPO_ACAO", referencedColumnName = "COD_ESPECIFIC_TIPO_ACAO")
        , @JoinColumn(name = "COD_DET_ESPECIFIC_TIPO_ACAO", referencedColumnName = "COD_DET_ESPECIFIC_TIPO_ACAO")
        , @JoinColumn(name = "COD_PRE_OBJETO_EMPRESA", referencedColumnName = "COD_PRE_OBJETO_EMPRESA")})
    @ManyToOne
    private DetEspecificTipoAcao detEspecificTipoAcao;
    
    @JoinColumn(name = "SIG_ADVOGADO_CONTRA", referencedColumnName = "SIG_ADVOGADO")
    @ManyToOne
    private Advogado sigAdvogadoContra;
    
    @JoinColumn(name = "SIG_ADVOGADO_EXTERNO", referencedColumnName = "SIG_ADVOGADO")
    @ManyToOne
    private Advogado sigAdvogadoExterno;
    
    @JoinColumn(name = "SIG_ADVOGADO_RESPONSAVEL", referencedColumnName = "SIG_ADVOGADO")
    @ManyToOne
    private Advogado sigAdvogadoResponsavel;
    
    @JoinColumn(name = "COD_COMARCA", referencedColumnName = "COD_COMARCA", insertable = false, updatable = false)
    @ManyToOne
    private Comarca codComarca;
    
    @JoinColumn(name = "COD_TIPO_CONTINGENCIA", referencedColumnName = "COD_TIPO_CONTINGENCIA")
    @ManyToOne
    private TipoContingencia codTipoContingencia;
    
    @JoinColumns({
        @JoinColumn(name = "COD_NATUREZA", referencedColumnName = "COD_NATUREZA")
        , @JoinColumn(name = "COD_ESPECIFICACAO_NATUREZA", referencedColumnName = "COD_ESPECIFICACAO_NATUREZA")
        , @JoinColumn(name = "COD_DETALHE_ESPECIFIC_NATUREZA", referencedColumnName = "COD_DETALHE_ESPECIFIC_NATUREZA")})
    @ManyToOne
    private DetalheEspecificNatureza detalheEspecificNatureza;
    
    @JoinColumn(name = "COD_JUIZ", referencedColumnName = "COD_JUIZ")
    @ManyToOne
    private Juiz codJuiz;
    
    @JoinColumns({
        @JoinColumn(name = "SIG_MUNICIPIO", referencedColumnName = "SIG_MUNICIPIO")
        , @JoinColumn(name = "SIG_ESTADO", referencedColumnName = "SIG_ESTADO")})
    @ManyToOne
    private Municipio municipio;
    
    @JoinColumn(name = "SIG_INDICE_MOEDA_VLR_TRIBUTO", referencedColumnName = "SIG_INDICE_MOEDA")
    @ManyToOne
    private IndiceMoeda sigIndiceMoedaVlrTributo;
    
    @JoinColumn(name = "SIG_INDICE_MOEDA_VLR_REMOTO", referencedColumnName = "SIG_INDICE_MOEDA")
    @ManyToOne
    private IndiceMoeda sigIndiceMoedaVlrRemoto;
    
    @JoinColumn(name = "COD_JUIZ_RELATOR_REVISOR", referencedColumnName = "COD_JUIZ")
    @ManyToOne
    private Juiz codJuizRelatorRevisor;
    
    @JoinColumn(name = "COD_DET_ESP_TIPO_CONTINGENCIA", referencedColumnName = "COD_DET_ESP_TIPO_CONTINGENCIA")
    @ManyToOne
    private DetEspTipoContingencia codDetEspTipoContingencia;
    
    @JoinColumn(name = "SIG_INDICE_MOEDA_VLR_PEDIDO", referencedColumnName = "SIG_INDICE_MOEDA")
    @ManyToOne
    private IndiceMoeda sigIndiceMoedaVlrPedido;
    
    @JoinColumn(name = "COD_DIVISAO_PROCESSO", referencedColumnName = "COD_DIVISAO_PROCESSO")
    @ManyToOne
    private DivisaoProcesso codDivisaoProcesso;
    
    @JoinColumns({
        @JoinColumn(name = "COD_JUIZO", referencedColumnName = "COD_JUIZO")
        , @JoinColumn(name = "COD_COMARCA", referencedColumnName = "COD_COMARCA")})
    @ManyToOne
    private Juizo juizo;
    
    @JoinColumn(name = "SIG_INDICE_MOEDA_VLR_POSSIVEL", referencedColumnName = "SIG_INDICE_MOEDA")
    @ManyToOne
    private IndiceMoeda sigIndiceMoedaVlrPossivel;
    
    @JoinColumn(name = "COD_NATUREZA", referencedColumnName = "COD_NATUREZA", insertable = false, updatable = false)
    @ManyToOne
    private Natureza codNatureza;
    
    @JoinColumn(name = "COD_TIPO_PROVISAO", referencedColumnName = "COD_TIPO_PROVISAO")
    @ManyToOne
    private TipoProvisao codTipoProvisao;
    
    @JoinColumns({
        @JoinColumn(name = "COD_EMPRESA_PREPOSTO", referencedColumnName = "COD_EMPRESA")
        , @JoinColumn(name = "COD_PREPOSTO", referencedColumnName = "COD_FUNCIONARIO")})
    @ManyToOne
    private Funcionario funcionario;
    
    @JoinColumn(name = "COD_SOLVENCIA", referencedColumnName = "COD_SOLVENCIA")
    @ManyToOne
    private Solvencia codSolvencia;
    
    @JoinColumn(name = "NOM_USUARIO", referencedColumnName = "NOM_USUARIO")
    @ManyToOne
    private Usuario nomUsuario;
    
    @JoinColumn(name = "COD_RISCO", referencedColumnName = "COD_RISCO")
    @ManyToOne
    private Risco codRisco;
    
    @JoinColumn(name = "SIG_INDICE_MOEDA_VLR_ACAO", referencedColumnName = "SIG_INDICE_MOEDA")
    @ManyToOne
    private IndiceMoeda sigIndiceMoedaVlrAcao;
    
    @JoinColumn(name = "SIG_ESCRITORIO_CONTRATADO", referencedColumnName = "SIG_ESCRITORIO_CONTRATADO")
    @ManyToOne
    private EscritorioContratado sigEscritorioContratado;
    
    @JoinColumns({
        @JoinColumn(name = "COD_ESPECIFICACAO_NATUREZA", referencedColumnName = "COD_ESPECIFICACAO_NATUREZA", insertable = false, updatable = false)
        , @JoinColumn(name = "COD_NATUREZA", referencedColumnName = "COD_NATUREZA", insertable = false, updatable = false)})
    @ManyToOne
    private EspecificacaoNatureza especificacaoNatureza;
    
    @JoinColumn(name = "COD_FASE_PROCESSUAL", referencedColumnName = "COD_FASE_PROCESSUAL")
    @ManyToOne
    private FaseProcessual codFaseProcessual;
    
    @JoinColumn(name = "COD_ESPECIF_TIPO_CONTINGENCIA", referencedColumnName = "COD_ESPECIF_TIPO_CONTINGENCIA")
    @ManyToOne
    private EspecifTipoContingencia codEspecifTipoContingencia;
    
    @JoinColumn(name = "SIG_INDICE_MOEDA_VLR_PROVAVEL", referencedColumnName = "SIG_INDICE_MOEDA")
    @ManyToOne
    private IndiceMoeda sigIndiceMoedaVlrProvavel;
    
    public Processo() {
    }

    public Processo(ProcessoPK processoPK) {
        this.processoPK = processoPK;
    }

    public Processo(String numProcesso, BigInteger codEmpresa) {
        this.processoPK = new ProcessoPK(numProcesso, codEmpresa);
    }

    public ProcessoPK getProcessoPK() {
        return processoPK;
    }

    public void setProcessoPK(ProcessoPK processoPK) {
        this.processoPK = processoPK;
    }

    public Date getDtcCadastro() {
        return dtcCadastro;
    }

    public void setDtcCadastro(Date dtcCadastro) {
        this.dtcCadastro = dtcCadastro;
    }

    public Date getDtcCitacao() {
        return dtcCitacao;
    }

    public void setDtcCitacao(Date dtcCitacao) {
        this.dtcCitacao = dtcCitacao;
    }

    public Date getDtcFim() {
        return dtcFim;
    }

    public void setDtcFim(Date dtcFim) {
        this.dtcFim = dtcFim;
    }

    public Float getVlrAcao() {
        return vlrAcao;
    }

    public void setVlrAcao(Float vlrAcao) {
        this.vlrAcao = vlrAcao;
    }

    public Float getVlrPago() {
        return vlrPago;
    }

    public void setVlrPago(Float vlrPago) {
        this.vlrPago = vlrPago;
    }

    public String getNumTelParteContraria() {
        return numTelParteContraria;
    }

    public void setNumTelParteContraria(String numTelParteContraria) {
        this.numTelParteContraria = numTelParteContraria;
    }

    public String getDesObservacao() {
        return desObservacao;
    }

    public void setDesObservacao(String desObservacao) {
        this.desObservacao = desObservacao;
    }

    public String getStsAtivo() {
        return stsAtivo;
    }

    public void setStsAtivo(String stsAtivo) {
        this.stsAtivo = stsAtivo;
    }

    public String getStsIndividual() {
        return stsIndividual;
    }

    public void setStsIndividual(String stsIndividual) {
        this.stsIndividual = stsIndividual;
    }

    public Date getDtcArquivamento() {
        return dtcArquivamento;
    }

    public void setDtcArquivamento(Date dtcArquivamento) {
        this.dtcArquivamento = dtcArquivamento;
    }

    public Float getVlrProvisionamento() {
        return vlrProvisionamento;
    }

    public void setVlrProvisionamento(Float vlrProvisionamento) {
        this.vlrProvisionamento = vlrProvisionamento;
    }

    public Float getVlrProvavel() {
        return vlrProvavel;
    }

    public void setVlrProvavel(Float vlrProvavel) {
        this.vlrProvavel = vlrProvavel;
    }

    public Float getVlrPossivel() {
        return vlrPossivel;
    }

    public void setVlrPossivel(Float vlrPossivel) {
        this.vlrPossivel = vlrPossivel;
    }

    public Float getVlrRemoto() {
        return vlrRemoto;
    }

    public void setVlrRemoto(Float vlrRemoto) {
        this.vlrRemoto = vlrRemoto;
    }

    public Float getVlrPedido() {
        return vlrPedido;
    }

    public void setVlrPedido(Float vlrPedido) {
        this.vlrPedido = vlrPedido;
    }

    public String getSigAdvogadoCoResponsavel() {
        return sigAdvogadoCoResponsavel;
    }

    public void setSigAdvogadoCoResponsavel(String sigAdvogadoCoResponsavel) {
        this.sigAdvogadoCoResponsavel = sigAdvogadoCoResponsavel;
    }

    public Date getDtcEnvioEscritorioExterno() {
        return dtcEnvioEscritorioExterno;
    }

    public void setDtcEnvioEscritorioExterno(Date dtcEnvioEscritorioExterno) {
        this.dtcEnvioEscritorioExterno = dtcEnvioEscritorioExterno;
    }

    public Float getVlrAcaoIndice() {
        return vlrAcaoIndice;
    }

    public void setVlrAcaoIndice(Float vlrAcaoIndice) {
        this.vlrAcaoIndice = vlrAcaoIndice;
    }

    public Float getVlrPedidoIndice() {
        return vlrPedidoIndice;
    }

    public void setVlrPedidoIndice(Float vlrPedidoIndice) {
        this.vlrPedidoIndice = vlrPedidoIndice;
    }

    public Float getVlrProvavelIndice() {
        return vlrProvavelIndice;
    }

    public void setVlrProvavelIndice(Float vlrProvavelIndice) {
        this.vlrProvavelIndice = vlrProvavelIndice;
    }

    public Float getVlrPossivelIndice() {
        return vlrPossivelIndice;
    }

    public void setVlrPossivelIndice(Float vlrPossivelIndice) {
        this.vlrPossivelIndice = vlrPossivelIndice;
    }

    public Float getVlrRemotoIndice() {
        return vlrRemotoIndice;
    }

    public void setVlrRemotoIndice(Float vlrRemotoIndice) {
        this.vlrRemotoIndice = vlrRemotoIndice;
    }

    public Date getDtcLavratura() {
        return dtcLavratura;
    }

    public void setDtcLavratura(Date dtcLavratura) {
        this.dtcLavratura = dtcLavratura;
    }

    public Date getDtcProtocoloAforamento() {
        return dtcProtocoloAforamento;
    }

    public void setDtcProtocoloAforamento(Date dtcProtocoloAforamento) {
        this.dtcProtocoloAforamento = dtcProtocoloAforamento;
    }

    public Float getVlrTributo() {
        return vlrTributo;
    }

    public void setVlrTributo(Float vlrTributo) {
        this.vlrTributo = vlrTributo;
    }

    public Float getVlrMultaTributo() {
        return vlrMultaTributo;
    }

    public void setVlrMultaTributo(Float vlrMultaTributo) {
        this.vlrMultaTributo = vlrMultaTributo;
    }

    public Float getVlrJurosTributo() {
        return vlrJurosTributo;
    }

    public void setVlrJurosTributo(Float vlrJurosTributo) {
        this.vlrJurosTributo = vlrJurosTributo;
    }

    public Float getVlrTributoIndice() {
        return vlrTributoIndice;
    }

    public void setVlrTributoIndice(Float vlrTributoIndice) {
        this.vlrTributoIndice = vlrTributoIndice;
    }

    public Float getVlrMultaTributoIndice() {
        return vlrMultaTributoIndice;
    }

    public void setVlrMultaTributoIndice(Float vlrMultaTributoIndice) {
        this.vlrMultaTributoIndice = vlrMultaTributoIndice;
    }

    public Float getVlrJurosTributoIndice() {
        return vlrJurosTributoIndice;
    }

    public void setVlrJurosTributoIndice(Float vlrJurosTributoIndice) {
        this.vlrJurosTributoIndice = vlrJurosTributoIndice;
    }

    public BigInteger getNumSeqProcesso() {
        return numSeqProcesso;
    }

    public void setNumSeqProcesso(BigInteger numSeqProcesso) {
        this.numSeqProcesso = numSeqProcesso;
    }

    public String getDtcAnoNumSeqProcesso() {
        return dtcAnoNumSeqProcesso;
    }

    public void setDtcAnoNumSeqProcesso(String dtcAnoNumSeqProcesso) {
        this.dtcAnoNumSeqProcesso = dtcAnoNumSeqProcesso;
    }

    public String getNumProcesso1Instancia() {
        return numProcesso1Instancia;
    }

    public void setNumProcesso1Instancia(String numProcesso1Instancia) {
        this.numProcesso1Instancia = numProcesso1Instancia;
    }

    public String getNumProcesso2Instancia() {
        return numProcesso2Instancia;
    }

    public void setNumProcesso2Instancia(String numProcesso2Instancia) {
        this.numProcesso2Instancia = numProcesso2Instancia;
    }

    public String getNumAutoInfracao() {
        return numAutoInfracao;
    }

    public void setNumAutoInfracao(String numAutoInfracao) {
        this.numAutoInfracao = numAutoInfracao;
    }

    public String getStsRelevante() {
        return stsRelevante;
    }

    public void setStsRelevante(String stsRelevante) {
        this.stsRelevante = stsRelevante;
    }

    public String getStsAreaResponsavel() {
        return stsAreaResponsavel;
    }

    public void setStsAreaResponsavel(String stsAreaResponsavel) {
        this.stsAreaResponsavel = stsAreaResponsavel;
    }

    public String getStsFaturavel() {
        return stsFaturavel;
    }

    public void setStsFaturavel(String stsFaturavel) {
        this.stsFaturavel = stsFaturavel;
    }

    public String getStrPalavrasChave() {
        return strPalavrasChave;
    }

    public void setStrPalavrasChave(String strPalavrasChave) {
        this.strPalavrasChave = strPalavrasChave;
    }

    public String getStsProcessaPalavras() {
        return stsProcessaPalavras;
    }

    public void setStsProcessaPalavras(String stsProcessaPalavras) {
        this.stsProcessaPalavras = stsProcessaPalavras;
    }

    public String getStsConsumerista() {
        return stsConsumerista;
    }

    public void setStsConsumerista(String stsConsumerista) {
        this.stsConsumerista = stsConsumerista;
    }

    public String getStsCallCenter() {
        return stsCallCenter;
    }

    public void setStsCallCenter(String stsCallCenter) {
        this.stsCallCenter = stsCallCenter;
    }

    public BigInteger getCodTipoIncidente() {
        return codTipoIncidente;
    }

    public void setCodTipoIncidente(BigInteger codTipoIncidente) {
        this.codTipoIncidente = codTipoIncidente;
    }

    public String getStsTipoPrazo() {
        return stsTipoPrazo;
    }

    public void setStsTipoPrazo(String stsTipoPrazo) {
        this.stsTipoPrazo = stsTipoPrazo;
    }

    public BigInteger getCodTipoAcaoProcesso() {
        return codTipoAcaoProcesso;
    }

    public void setCodTipoAcaoProcesso(BigInteger codTipoAcaoProcesso) {
        this.codTipoAcaoProcesso = codTipoAcaoProcesso;
    }

    public String getStsProcon() {
        return stsProcon;
    }

    public void setStsProcon(String stsProcon) {
        this.stsProcon = stsProcon;
    }

    public String getStsDrc() {
        return stsDrc;
    }

    public void setStsDrc(String stsDrc) {
        this.stsDrc = stsDrc;
    }

    public Float getVlrLongoPrazo() {
        return vlrLongoPrazo;
    }

    public void setVlrLongoPrazo(Float vlrLongoPrazo) {
        this.vlrLongoPrazo = vlrLongoPrazo;
    }

    public String getMotivoArquivamento() {
        return motivoArquivamento;
    }

    public void setMotivoArquivamento(String motivoArquivamento) {
        this.motivoArquivamento = motivoArquivamento;
    }

    public String getStsExcluido() {
        return stsExcluido;
    }

    public void setStsExcluido(String stsExcluido) {
        this.stsExcluido = stsExcluido;
    }

    public Float getVlrOriginal() {
        return vlrOriginal;
    }

    public void setVlrOriginal(Float vlrOriginal) {
        this.vlrOriginal = vlrOriginal;
    }

    public Date getDataOriginal() {
        return dataOriginal;
    }

    public void setDataOriginal(Date dataOriginal) {
        this.dataOriginal = dataOriginal;
    }

    public BigInteger getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(BigInteger codProduto) {
        this.codProduto = codProduto;
    }

    public String getStsAreaResponsavelGeral() {
        return stsAreaResponsavelGeral;
    }

    public void setStsAreaResponsavelGeral(String stsAreaResponsavelGeral) {
        this.stsAreaResponsavelGeral = stsAreaResponsavelGeral;
    }

    public String getPastaBenner() {
        return pastaBenner;
    }

    public void setPastaBenner(String pastaBenner) {
        this.pastaBenner = pastaBenner;
    }

    public BigInteger getIdBenner() {
        return idBenner;
    }

    public void setIdBenner(BigInteger idBenner) {
        this.idBenner = idBenner;
    }

    public String getStsMigracaoBenner() {
        return stsMigracaoBenner;
    }

    public void setStsMigracaoBenner(String stsMigracaoBenner) {
        this.stsMigracaoBenner = stsMigracaoBenner;
    }

    public Float getVlrCurtoPrazoFin() {
        return vlrCurtoPrazoFin;
    }

    public void setVlrCurtoPrazoFin(Float vlrCurtoPrazoFin) {
        this.vlrCurtoPrazoFin = vlrCurtoPrazoFin;
    }

    public Float getVlrLongoPrazoFin() {
        return vlrLongoPrazoFin;
    }

    public void setVlrLongoPrazoFin(Float vlrLongoPrazoFin) {
        this.vlrLongoPrazoFin = vlrLongoPrazoFin;
    }

    public Float getVlrPagamento() {
        return vlrPagamento;
    }

    public void setVlrPagamento(Float vlrPagamento) {
        this.vlrPagamento = vlrPagamento;
    }

    public Float getProvOperacionalAnterior() {
        return provOperacionalAnterior;
    }

    public void setProvOperacionalAnterior(Float provOperacionalAnterior) {
        this.provOperacionalAnterior = provOperacionalAnterior;
    }

    public Float getProvFinanceiraAnterior() {
        return provFinanceiraAnterior;
    }

    public void setProvFinanceiraAnterior(Float provFinanceiraAnterior) {
        this.provFinanceiraAnterior = provFinanceiraAnterior;
    }

    public Float getProvCpFinanceiraAnterior() {
        return provCpFinanceiraAnterior;
    }

    public void setProvCpFinanceiraAnterior(Float provCpFinanceiraAnterior) {
        this.provCpFinanceiraAnterior = provCpFinanceiraAnterior;
    }

    public Float getProvLpOperacionalAnterior() {
        return provLpOperacionalAnterior;
    }

    public void setProvLpOperacionalAnterior(Float provLpOperacionalAnterior) {
        this.provLpOperacionalAnterior = provLpOperacionalAnterior;
    }

    public Float getProvLpFinanceiraAnterior() {
        return provLpFinanceiraAnterior;
    }

    public void setProvLpFinanceiraAnterior(Float provLpFinanceiraAnterior) {
        this.provLpFinanceiraAnterior = provLpFinanceiraAnterior;
    }

    public Float getProvisaoCurtoAnterior() {
        return provisaoCurtoAnterior;
    }

    public void setProvisaoCurtoAnterior(Float provisaoCurtoAnterior) {
        this.provisaoCurtoAnterior = provisaoCurtoAnterior;
    }

    public Float getProvisaoLongoAnterior() {
        return provisaoLongoAnterior;
    }

    public void setProvisaoLongoAnterior(Float provisaoLongoAnterior) {
        this.provisaoLongoAnterior = provisaoLongoAnterior;
    }

    public Float getBaixaProvOperacional() {
        return baixaProvOperacional;
    }

    public void setBaixaProvOperacional(Float baixaProvOperacional) {
        this.baixaProvOperacional = baixaProvOperacional;
    }

    public Float getBaixaProvFinanceira() {
        return baixaProvFinanceira;
    }

    public void setBaixaProvFinanceira(Float baixaProvFinanceira) {
        this.baixaProvFinanceira = baixaProvFinanceira;
    }

    public Float getJurosProv() {
        return jurosProv;
    }

    public void setJurosProv(Float jurosProv) {
        this.jurosProv = jurosProv;
    }

    public Float getAjusteOperacional() {
        return ajusteOperacional;
    }

    public void setAjusteOperacional(Float ajusteOperacional) {
        this.ajusteOperacional = ajusteOperacional;
    }

    public Float getAjusteFinanceiro() {
        return ajusteFinanceiro;
    }

    public void setAjusteFinanceiro(Float ajusteFinanceiro) {
        this.ajusteFinanceiro = ajusteFinanceiro;
    }

    public Float getAjusteOperacionalProvCp() {
        return ajusteOperacionalProvCp;
    }

    public void setAjusteOperacionalProvCp(Float ajusteOperacionalProvCp) {
        this.ajusteOperacionalProvCp = ajusteOperacionalProvCp;
    }

    public Float getAjusteFinanceiroProvCp() {
        return ajusteFinanceiroProvCp;
    }

    public void setAjusteFinanceiroProvCp(Float ajusteFinanceiroProvCp) {
        this.ajusteFinanceiroProvCp = ajusteFinanceiroProvCp;
    }

    public Float getBaixaProvCurtoOperacional() {
        return baixaProvCurtoOperacional;
    }

    public void setBaixaProvCurtoOperacional(Float baixaProvCurtoOperacional) {
        this.baixaProvCurtoOperacional = baixaProvCurtoOperacional;
    }

    public Float getCorrecaoProvCurto() {
        return correcaoProvCurto;
    }

    public void setCorrecaoProvCurto(Float correcaoProvCurto) {
        this.correcaoProvCurto = correcaoProvCurto;
    }

    public Float getJurosProvCurto() {
        return jurosProvCurto;
    }

    public void setJurosProvCurto(Float jurosProvCurto) {
        this.jurosProvCurto = jurosProvCurto;
    }

    public Float getBaixaProvLongoOperacional() {
        return baixaProvLongoOperacional;
    }

    public void setBaixaProvLongoOperacional(Float baixaProvLongoOperacional) {
        this.baixaProvLongoOperacional = baixaProvLongoOperacional;
    }

    public Float getBaixaProvLongoFinanceira() {
        return baixaProvLongoFinanceira;
    }

    public void setBaixaProvLongoFinanceira(Float baixaProvLongoFinanceira) {
        this.baixaProvLongoFinanceira = baixaProvLongoFinanceira;
    }

    public Float getCorrecaoProvLongo() {
        return correcaoProvLongo;
    }

    public void setCorrecaoProvLongo(Float correcaoProvLongo) {
        this.correcaoProvLongo = correcaoProvLongo;
    }

    public Float getJurosProvLongo() {
        return jurosProvLongo;
    }

    public void setJurosProvLongo(Float jurosProvLongo) {
        this.jurosProvLongo = jurosProvLongo;
    }

    public Float getAjusteOperacionalProvLp() {
        return ajusteOperacionalProvLp;
    }

    public void setAjusteOperacionalProvLp(Float ajusteOperacionalProvLp) {
        this.ajusteOperacionalProvLp = ajusteOperacionalProvLp;
    }

    public Float getAjusteFinanceiroProvLp() {
        return ajusteFinanceiroProvLp;
    }

    public void setAjusteFinanceiroProvLp(Float ajusteFinanceiroProvLp) {
        this.ajusteFinanceiroProvLp = ajusteFinanceiroProvLp;
    }

    public Float getTotalProvavelOperacional() {
        return totalProvavelOperacional;
    }

    public void setTotalProvavelOperacional(Float totalProvavelOperacional) {
        this.totalProvavelOperacional = totalProvavelOperacional;
    }

    public Float getProvCpOperacionalAnterior() {
        return provCpOperacionalAnterior;
    }

    public void setProvCpOperacionalAnterior(Float provCpOperacionalAnterior) {
        this.provCpOperacionalAnterior = provCpOperacionalAnterior;
    }

    public Float getCorrecaoProv() {
        return correcaoProv;
    }

    public void setCorrecaoProv(Float correcaoProv) {
        this.correcaoProv = correcaoProv;
    }

    public Float getBaixaProvCurtoFinanceira() {
        return baixaProvCurtoFinanceira;
    }

    public void setBaixaProvCurtoFinanceira(Float baixaProvCurtoFinanceira) {
        this.baixaProvCurtoFinanceira = baixaProvCurtoFinanceira;
    }

    public Float getTotalProvavelFinanceiro() {
        return totalProvavelFinanceiro;
    }

    public void setTotalProvavelFinanceiro(Float totalProvavelFinanceiro) {
        this.totalProvavelFinanceiro = totalProvavelFinanceiro;
    }

    public Date getDtcAnoSaldoOper() {
        return dtcAnoSaldoOper;
    }

    public void setDtcAnoSaldoOper(Date dtcAnoSaldoOper) {
        this.dtcAnoSaldoOper = dtcAnoSaldoOper;
    }

    public DetEspecificTipoAcao getDetEspecificTipoAcao() {
        return detEspecificTipoAcao;
    }

    public void setDetEspecificTipoAcao(DetEspecificTipoAcao detEspecificTipoAcao) {
        this.detEspecificTipoAcao = detEspecificTipoAcao;
    }

    public Advogado getSigAdvogadoContra() {
        return sigAdvogadoContra;
    }

    public void setSigAdvogadoContra(Advogado sigAdvogadoContra) {
        this.sigAdvogadoContra = sigAdvogadoContra;
    }

    public Advogado getSigAdvogadoExterno() {
        return sigAdvogadoExterno;
    }

    public void setSigAdvogadoExterno(Advogado sigAdvogadoExterno) {
        this.sigAdvogadoExterno = sigAdvogadoExterno;
    }

    public Advogado getSigAdvogadoResponsavel() {
        return sigAdvogadoResponsavel;
    }

    public void setSigAdvogadoResponsavel(Advogado sigAdvogadoResponsavel) {
        this.sigAdvogadoResponsavel = sigAdvogadoResponsavel;
    }

    public Comarca getCodComarca() {
        return codComarca;
    }

    public void setCodComarca(Comarca codComarca) {
        this.codComarca = codComarca;
    }

    public TipoContingencia getCodTipoContingencia() {
        return codTipoContingencia;
    }

    public void setCodTipoContingencia(TipoContingencia codTipoContingencia) {
        this.codTipoContingencia = codTipoContingencia;
    }

    public DetalheEspecificNatureza getDetalheEspecificNatureza() {
        return detalheEspecificNatureza;
    }

    public void setDetalheEspecificNatureza(DetalheEspecificNatureza detalheEspecificNatureza) {
        this.detalheEspecificNatureza = detalheEspecificNatureza;
    }

    public Juiz getCodJuiz() {
        return codJuiz;
    }

    public void setCodJuiz(Juiz codJuiz) {
        this.codJuiz = codJuiz;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public IndiceMoeda getSigIndiceMoedaVlrTributo() {
        return sigIndiceMoedaVlrTributo;
    }

    public void setSigIndiceMoedaVlrTributo(IndiceMoeda sigIndiceMoedaVlrTributo) {
        this.sigIndiceMoedaVlrTributo = sigIndiceMoedaVlrTributo;
    }

    public IndiceMoeda getSigIndiceMoedaVlrRemoto() {
        return sigIndiceMoedaVlrRemoto;
    }

    public void setSigIndiceMoedaVlrRemoto(IndiceMoeda sigIndiceMoedaVlrRemoto) {
        this.sigIndiceMoedaVlrRemoto = sigIndiceMoedaVlrRemoto;
    }

    public Juiz getCodJuizRelatorRevisor() {
        return codJuizRelatorRevisor;
    }

    public void setCodJuizRelatorRevisor(Juiz codJuizRelatorRevisor) {
        this.codJuizRelatorRevisor = codJuizRelatorRevisor;
    }

    public DetEspTipoContingencia getCodDetEspTipoContingencia() {
        return codDetEspTipoContingencia;
    }

    public void setCodDetEspTipoContingencia(DetEspTipoContingencia codDetEspTipoContingencia) {
        this.codDetEspTipoContingencia = codDetEspTipoContingencia;
    }

    public IndiceMoeda getSigIndiceMoedaVlrPedido() {
        return sigIndiceMoedaVlrPedido;
    }

    public void setSigIndiceMoedaVlrPedido(IndiceMoeda sigIndiceMoedaVlrPedido) {
        this.sigIndiceMoedaVlrPedido = sigIndiceMoedaVlrPedido;
    }

    public DivisaoProcesso getCodDivisaoProcesso() {
        return codDivisaoProcesso;
    }

    public void setCodDivisaoProcesso(DivisaoProcesso codDivisaoProcesso) {
        this.codDivisaoProcesso = codDivisaoProcesso;
    }

    public Juizo getJuizo() {
        return juizo;
    }

    public void setJuizo(Juizo juizo) {
        this.juizo = juizo;
    }

    public IndiceMoeda getSigIndiceMoedaVlrPossivel() {
        return sigIndiceMoedaVlrPossivel;
    }

    public void setSigIndiceMoedaVlrPossivel(IndiceMoeda sigIndiceMoedaVlrPossivel) {
        this.sigIndiceMoedaVlrPossivel = sigIndiceMoedaVlrPossivel;
    }

    public Natureza getCodNatureza() {
        return codNatureza;
    }

    public void setCodNatureza(Natureza codNatureza) {
        this.codNatureza = codNatureza;
    }

    public TipoProvisao getCodTipoProvisao() {
        return codTipoProvisao;
    }

    public void setCodTipoProvisao(TipoProvisao codTipoProvisao) {
        this.codTipoProvisao = codTipoProvisao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Solvencia getCodSolvencia() {
        return codSolvencia;
    }

    public void setCodSolvencia(Solvencia codSolvencia) {
        this.codSolvencia = codSolvencia;
    }

    public Usuario getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(Usuario nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public Risco getCodRisco() {
        return codRisco;
    }

    public void setCodRisco(Risco codRisco) {
        this.codRisco = codRisco;
    }

    public IndiceMoeda getSigIndiceMoedaVlrAcao() {
        return sigIndiceMoedaVlrAcao;
    }

    public void setSigIndiceMoedaVlrAcao(IndiceMoeda sigIndiceMoedaVlrAcao) {
        this.sigIndiceMoedaVlrAcao = sigIndiceMoedaVlrAcao;
    }

    public EscritorioContratado getSigEscritorioContratado() {
        return sigEscritorioContratado;
    }

    public void setSigEscritorioContratado(EscritorioContratado sigEscritorioContratado) {
        this.sigEscritorioContratado = sigEscritorioContratado;
    }

    public EspecificacaoNatureza getEspecificacaoNatureza() {
        return especificacaoNatureza;
    }

    public void setEspecificacaoNatureza(EspecificacaoNatureza especificacaoNatureza) {
        this.especificacaoNatureza = especificacaoNatureza;
    }

    public FaseProcessual getCodFaseProcessual() {
        return codFaseProcessual;
    }

    public void setCodFaseProcessual(FaseProcessual codFaseProcessual) {
        this.codFaseProcessual = codFaseProcessual;
    }

    public EspecifTipoContingencia getCodEspecifTipoContingencia() {
        return codEspecifTipoContingencia;
    }

    public void setCodEspecifTipoContingencia(EspecifTipoContingencia codEspecifTipoContingencia) {
        this.codEspecifTipoContingencia = codEspecifTipoContingencia;
    }

    public IndiceMoeda getSigIndiceMoedaVlrProvavel() {
        return sigIndiceMoedaVlrProvavel;
    }

    public void setSigIndiceMoedaVlrProvavel(IndiceMoeda sigIndiceMoedaVlrProvavel) {
        this.sigIndiceMoedaVlrProvavel = sigIndiceMoedaVlrProvavel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (processoPK != null ? processoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Processo)) {
            return false;
        }
        Processo other = (Processo) object;
        if ((this.processoPK == null && other.processoPK != null) || (this.processoPK != null && !this.processoPK.equals(other.processoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telefonica.processum.model.Processo[ processoPK=" + processoPK + " ]";
    }
    
}
