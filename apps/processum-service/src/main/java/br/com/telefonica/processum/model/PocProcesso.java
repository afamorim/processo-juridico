package br.com.telefonica.processum.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author jadossantos
 */
@Entity
@Table(name = "POC_PROCESSO")
@Data
public class PocProcesso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_POC_PROCESSO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_POC_PROCESSO")
    @SequenceGenerator(name = "SEQ_POC_PROCESSO", sequenceName = "SEQ_POC_PROCESSO", allocationSize = 10)
    private BigDecimal idPocProcesso;

    @Column(name = "COD_EMPRESA")
    private BigDecimal codEmpresa;

    @Size(max = 60)
    @Column(name = "NOM_EMPRESA")
    private String nomEmpresa;

    @Column(name = "COD_NATUREZA")
    private BigDecimal codNatureza;

    @Size(max = 40)
    @Column(name = "DES_NATUREZA")
    private String desNatureza;

    @Column(name = "COD_ESPECIFICACAO_NATUREZA")
    private BigInteger codEspecificacaoNatureza;

    @Size(max = 40)
    @Column(name = "DES_ESPECIFICACAO_NATUREZA")
    private String desEspecificacaoNatureza;

    @Column(name = "COD_DETALHE_ESPECIFIC_NATUREZA")
    private BigInteger codDetalheEspecificNatureza;

    @Size(max = 60)
    @Column(name = "NOM_DETALHE_ESPECIFIC_NATUREZA")
    private String nomDetalheEspecificNatureza;

    @Column(name = "COD_PRE_OBJETO_EMPRESA")
    private BigDecimal codPreObjetoEmpresa;

    @Size(max = 50)
    @Column(name = "NOM_PRE_OBJETO_EMPRESA")
    private String nomPreObjetoEmpresa;

    @Column(name = "DTC_CITACAO")
    @Temporal(TemporalType.DATE)
    private Date dtcCitacao;

    @Column(name = "DTC_PROTOCOLO_AFORAMENTO")
    @Temporal(TemporalType.DATE)
    private Date dtcProtocoloAforamento;

    @Size(max = 1)
    @Column(name = "STS_PASSOU_CALL_CENTER")
    private String stsPassouCallCenter;

    @Size(max = 1)
    @Column(name = "STS_RELEVANTE")
    private String stsRelevante;

    @Size(max = 1)
    @Column(name = "STS_CONSUMERISTA")
    private String stsConsumerista;

    @Size(max = 1)
    @Column(name = "STS_PASSOU_PROCON")
    private String stsPassouProcon;

    @Size(min = 1, max = 255)
    @Column(name = "NOM_TIPO_ACAO_PROCESSO")
    private String nomTipoAcaoProcesso;

    @Column(name = "COD_DIVISAO_PROCESSO")
    private BigDecimal codDivisaoProcesso;

    @Size(max = 50)
    @Column(name = "NOM_DIVISAO")
    private String nomDivisao;

    @Column(name = "NUM_PROCESSO")
    private String numProcesso;

    @Column(name = "DTC_ENVIO_ESC_CONTRATADO")
    @Temporal(TemporalType.DATE)
    private Date dtcEnvioEscContratado;

    @Column(name = "COD_TIPO_ACAO_PROCESSO")
    private BigDecimal codTipoAcaoProcesso;

    @Column(name = "COD_TIPO_ACAO")
    private BigInteger codTipoAcao;

    @Size(min = 1, max = 70)
    @Column(name = "DES_TIPO_ACAO")
    private String desTipoAcao;

    @Column(name = "SIG_ESCRITORIO_CONTRATADO")
    private String sigEscritorioContratado;

    @Size(max = 50)
    @Column(name = "NOM_ESCRITORIO_CONTRATADO")
    private String nomEscritorioContratado;

    @Column(name = "SIG_ESTADO")
    private String sigEstado;

    @Size(max = 30)
    @Column(name = "NOM_ESTADO")
    private String nomEstado;

    @Size(min = 1, max = 100)
    @Column(name = "SIG_MUNICIPIO")
    private String sigMunicipio;

    @Size(min = 1, max = 45)
    @Column(name = "NOM_MUNICIPIO")
    private String nomMunicipio;

    @Column(name = "COD_COMARCA")
    private BigDecimal codComarca;

    @Size(min = 1, max = 45)
    @Column(name = "NOM_COMARCA")
    private String nomComarca;

    @Column(name = "COD_JUIZO")
    private BigInteger codJuizo;

    @Size(min = 1, max = 80)
    @Column(name = "NOM_JUIZO")
    private String nomJuizo;

    @Size(min = 1, max = 10)
    @Column(name = "SIG_ADVOGADO")
    private String sigAdvogado;

    @Size(min = 1, max = 100)
    @Column(name = "NOM_ADVOGADO")
    private String nomAdvogado;

    @Size(min = 1, max = 10)
    @Column(name = "SIG_CORRESPONSAVEL")
    private String sigCorresponsavel;

    @Size(min = 1, max = 100)
    @Column(name = "NOM_CORRESPONSAVEL")
    private String nomCorresponsavel;

    @Size(min = 1, max = 4000)
    @Column(name = "NOM_POLO_ATIVO")
    private String nomPoloAtivo;

    @Size(min = 1, max = 4000)
    @Column(name = "NOM_POLO_PASSIVO")
    private String nomPoloPassivo;

    @Size(min = 1, max = 4000)
    @Column(name = "NOM_TERCEIRO_INTERESSADO")
    private String nomTerceiroInteressado;
}
