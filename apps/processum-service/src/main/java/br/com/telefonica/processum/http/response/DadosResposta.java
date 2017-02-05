package br.com.telefonica.processum.http.response;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author Ivan Queiroz <ifbomfim@indracompany.com>
 */
@Data
@ToString
public class DadosResposta {

    private String request;
    private String response;
    private List<Pessoa> pessoas = new ArrayList<>();
    private List<String> erros = new ArrayList<>();
    
}
