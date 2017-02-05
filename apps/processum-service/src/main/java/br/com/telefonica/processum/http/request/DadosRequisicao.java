package br.com.telefonica.processum.http.request;

import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Ivan Queiroz <ifbomfim@indracompany.com>
 */
@Data
@Builder
public class DadosRequisicao {

    private String tipoFiltro;
    private String filtro;
    private String codigoConta;

    public String getBuscaListaPessoasRequest() {
        String request = "";
        if (StringUtils.isNotBlank(tipoFiltro) && StringUtils.isNotBlank(filtro)) {
            request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ger=\"http://www.vivo.com.br/MC/Geral\" xmlns:pes=\"http://www.vivo.com.br/SN/Pessoa\">"
                    + "   <soapenv:Header>"
                    + "      <ger:cabecalhoVivo xmlns:ger=\"http://www.vivo.com.br/MC/Geral\">"
                    + "         <ger:loginUsuario>VivoIntegracao</ger:loginUsuario>"
                    + "         <ger:codigoSessao>1</ger:codigoSessao>"
                    + "         <ger:nomeAplicacao>VivoIntegracao</ger:nomeAplicacao>"
                    + "         <ger:enderecoIP>10.128.0.39</ger:enderecoIP>"
                    + "         <ger:codigoFuncionalidade>5</ger:codigoFuncionalidade>"
                    + "         <ger:dataTransacao>2014-10-07T10:42:55.628-03:00</ger:dataTransacao>"
                    + "         <ger:nomeServico>Habilitacao</ger:nomeServico>"
                    + "      </ger:cabecalhoVivo>"
                    + "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">"
                    + "         <wsse:UsernameToken wsu:id=\"UsernameToken-202715994\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">"
                    + "            <wsse:Username>VivoIntegracao</wsse:Username>"
                    + "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">vivointegracao</wsse:Password>"
                    + "         </wsse:UsernameToken>"
                    + "      </wsse:Security>"
                    + "   </soapenv:Header>"
                    + "   <soapenv:Body>"
                    + "      <pes:buscarListaPessoasRequest>"
                    + "         <pes:tipoFiltro>" + tipoFiltro + "</pes:tipoFiltro>"
                    + "         <pes:filtro1>" + filtro + "</pes:filtro1>"
                    + "         <pes:usarFiltroExtra>false</pes:usarFiltroExtra>"
                    + "         <pes:nrRegPorPagina>20</pes:nrRegPorPagina>"
                    + "         <pes:nrPagina>1</pes:nrPagina>"
                    + "      </pes:buscarListaPessoasRequest>"
                    + "   </soapenv:Body>"
                    + "</soapenv:Envelope>";
        }
        return request;
    }

    public String getBuscaContaRequest() {
        String request = "";
        if (StringUtils.isNotBlank(codigoConta)) {
            request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ger=\"http://www.vivo.com.br/MC/Geral\" xmlns:con=\"http://www.vivo.com.br/SN/Conta\">"
                    + "   <soapenv:Header>"
                    + "      <ger:cabecalhoVivo xmlns:ger=\"http://www.vivo.com.br/MC/Geral\">"
                    + "         <ger:loginUsuario>VivoIntegracao</ger:loginUsuario>"
                    + "         <ger:codigoSessao>1</ger:codigoSessao>"
                    + "         <ger:nomeAplicacao>VivoIntegracao</ger:nomeAplicacao>"
                    + "         <ger:enderecoIP>10.128.0.39</ger:enderecoIP>"
                    + "         <ger:codigoFuncionalidade>5</ger:codigoFuncionalidade>"
                    + "         <ger:dataTransacao>2014-10-07T10:42:55.628-03:00</ger:dataTransacao>"
                    + "         <ger:nomeServico>Habilitacao</ger:nomeServico>"
                    + "      </ger:cabecalhoVivo>"
                    + "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">"
                    + "         <wsse:UsernameToken wsu:id=\"UsernameToken-202715994\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">"
                    + "            <wsse:Username>VivoIntegracao</wsse:Username>"
                    + "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">vivointegracao</wsse:Password>"
                    + "         </wsse:UsernameToken>"
                    + "      </wsse:Security>"
                    + "   </soapenv:Header>"
                    + "   <soapenv:Body>"
                    + "      <con:buscarContaRequest>"
                    + "         <con:idConta>" + codigoConta + "</con:idConta>"
                    + "      </con:buscarContaRequest>"
                    + "   </soapenv:Body>"
                    + "</soapenv:Envelope>";
        }
        return request;
    }

    public String getBuscaListaUltimasFaturasRequest() {
        String request = "";
        if (StringUtils.isNotBlank(codigoConta)) {
            request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ger=\"http://www.vivo.com.br/MC/Geral\" xmlns:con=\"http://www.vivo.com.br/SN/Conta\">"
                    + "    <soapenv:Header>"
                    + "      <ger:cabecalhoVivo xmlns:ger=\"http://www.vivo.com.br/MC/Geral\">"
                    + "         <ger:loginUsuario>VivoIntegracao</ger:loginUsuario>"
                    + "         <ger:codigoSessao>1</ger:codigoSessao>"
                    + "         <ger:nomeAplicacao>VivoIntegracao</ger:nomeAplicacao>"
                    + "         <ger:enderecoIP>10.128.0.39</ger:enderecoIP>"
                    + "         <ger:codigoFuncionalidade>5</ger:codigoFuncionalidade>"
                    + "         <ger:dataTransacao>2014-10-07T10:42:55.628-03:00</ger:dataTransacao>"
                    + "         <ger:nomeServico>Habilitacao</ger:nomeServico>"
                    + "      </ger:cabecalhoVivo>"
                    + "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">"
                    + "         <wsse:UsernameToken wsu:id=\"UsernameToken-202715994\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">"
                    + "            <wsse:Username>VivoIntegracao</wsse:Username>"
                    + "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">vivointegracao</wsse:Password>"
                    + "         </wsse:UsernameToken>"
                    + "      </wsse:Security>"
                    + "   </soapenv:Header>"
                    + "   <soapenv:Body>"
                    + "      <con:buscarListaUltimasFaturasRequest>"
                    + "         <con:idContaSisOrigem>" + codigoConta + "</con:idContaSisOrigem>"
                    + "         <!--Optional:-->"
                    + "         <con:tipoDaBusca>3</con:tipoDaBusca>"
                    + "         <!--Optional:-->"
                    + "         <con:status>2</con:status>"
                    + "         <!--Optional:-->"
                    + "         <con:periodoDe>2016-01-01</con:periodoDe>"
                    + "         <!--Optional:-->"
                    + "         <con:periodoAte>2017-02-02</con:periodoAte>"
                    + "      </con:buscarListaUltimasFaturasRequest>"
                    + "   </soapenv:Body>"
                    + "</soapenv:Envelope>";
        }
        return request;
    }

    public String getBuscaPagamentosRequest() {
        String request = "";
        if (StringUtils.isNotBlank(codigoConta)) {
            request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ger=\"http://www.vivo.com.br/MC/Geral\" xmlns:con=\"http://www.vivo.com.br/SN/Conta\">"
                    + "    <soapenv:Header>"
                    + "      <ger:cabecalhoVivo xmlns:ger=\"http://www.vivo.com.br/MC/Geral\">"
                    + "         <ger:loginUsuario>VivoIntegracao</ger:loginUsuario>"
                    + "         <ger:codigoSessao>1</ger:codigoSessao>"
                    + "         <ger:nomeAplicacao>VivoIntegracao</ger:nomeAplicacao>"
                    + "         <ger:enderecoIP>10.128.0.39</ger:enderecoIP>"
                    + "         <ger:codigoFuncionalidade>5</ger:codigoFuncionalidade>"
                    + "         <ger:dataTransacao>2014-10-07T10:42:55.628-03:00</ger:dataTransacao>"
                    + "         <ger:nomeServico>Habilitacao</ger:nomeServico>"
                    + "      </ger:cabecalhoVivo>"
                    + "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">"
                    + "         <wsse:UsernameToken wsu:id=\"UsernameToken-202715994\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">"
                    + "            <wsse:Username>VivoIntegracao</wsse:Username>"
                    + "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">vivointegracao</wsse:Password>"
                    + "         </wsse:UsernameToken>"
                    + "      </wsse:Security>"
                    + "   </soapenv:Header>"
                    + "   <soapenv:Body>"
                    + "      <con:buscarPagamentosContaRequest>"
                    + "         <con:idContaSisOrigem>" + codigoConta + "</con:idContaSisOrigem>"
                    + "         <con:dt_inicioBusca>2016-01-01</con:dt_inicioBusca>"
                    + "         <!--Optional:-->"
                    + "         <con:dt_finalBusca>2017-02-02</con:dt_finalBusca>"
                    + "      </con:buscarPagamentosContaRequest>"
                    + "   </soapenv:Body>"
                    + "</soapenv:Envelope>";
        }
        return request;
    }

}
