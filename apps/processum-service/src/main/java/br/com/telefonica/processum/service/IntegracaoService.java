package br.com.telefonica.processum.service;

import br.com.telefonica.processum.exception.ServicoException;
import br.com.telefonica.processum.http.request.DadosRequisicao;
import br.com.telefonica.processum.http.response.DadosResposta;

/**
 *
 * @author Ivan Queiroz <ifbomfim@indracompany.com>
 */
public interface IntegracaoService {
    DadosResposta integrar(DadosRequisicao dadosRequisicao) throws ServicoException;
}
