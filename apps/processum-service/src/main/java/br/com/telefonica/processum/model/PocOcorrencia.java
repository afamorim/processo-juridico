package br.com.telefonica.processum.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author ifbomfim
 */
@Data
@ToString
@Entity
@Table(name = "POC_OCORRENCIA")
public class PocOcorrencia implements Serializable {
    
    @Id
    @Column(name = "ID_POC_OCORRENCIA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_POC_OCORRENCIA")
    @SequenceGenerator(name = "SEQ_POC_OCORRENCIA", sequenceName = "SEQ_POC_OCORRENCIA", allocationSize = 10)
    private BigDecimal idPocOcorrencia;
    
    @Column(name = "STS_POC_OCORRENCIA")
    private String stsPocOcorrencia;
    
    @Column(name = "DTC_POC_OCORRENCIA")
    @Temporal(TemporalType.DATE)
    private Date dtcPocOcorrencia;
    
    @Column(name = "NUM_PROCESSO")
    private String numProcesso;
    
    @Column(name = "NUM_CPF_CNPJ")
    private String numCpfCnpj;
    
    @Column(name = "NUM_LINHA")
    private String numLinha;
    
    @Column(name = "DTC_INICIO_PESQUISA")
    @Temporal(TemporalType.DATE)
    private Date dtcInicioPequisa;
    
    @Column(name = "DTC_FIM_PESQUISA")
    @Temporal(TemporalType.DATE)
    private Date dtcFimPesquisa;
    
    @Column(name = "NOM_CLIENTE")
    private String nomCliente;
    
    @Column(name = "NOM_CONTA")
    private String nomConta;

    @Column(name = "DTC_CADASTRO")
    @Temporal(TemporalType.DATE)
    private Date dtcCadastro;
    
    @Column(name = "NOM_TIPO_CONTA")
    private String nomTipoConta;
    
    @Column(name = "NOM_TIPO_ASSINATURA")
    private String nomTipoAssinatura;
    
    @Column(name = "STS_ASSINATURA")
    private String stsAssinatura;
    
    @Column(name = "DES_ENDERECO_CORRESPONDENCIA")
    private String desEnderecoCorrespondencia;
    
    @Column(name = "DES_ENDERECO_TRIBUTACAO")
    private String desEnderecoTributacao;
    
    @Column(name = "VAL_SALDO")
    private String valSaldo;
    
    @Column(name = "NOM_FORMA_PAGAMENTO")
    private String nomFormaPagamento;
    
    @Column(name="STS_ERRO")
    private String stsErro;
    
    @Column(name="DES_ERRO")
    private String desErro;

}
