package br.com.telefonica.processum.http.response;

import java.util.List;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author ifbomfim
 */
@Data
@ToString
public class Pessoa {
    
    private String nomeCliente;
    private List<Assinatura> assinaturas;
    private List<Conta> contas;
    
    
}
