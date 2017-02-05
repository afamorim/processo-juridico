package br.com.telefonica.processum.http.response;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author ifbomfim
 */
@Data
@ToString
public class Conta {
    
    private String codigo;
    private String codigoContaSistemOrigem;
    private String tipoConta;
    private String dataInicialCiclo;
    private String nomeConta;
    private List<Fatura> faturas = new ArrayList<>();
    private List<Pagamento> pagamentos = new ArrayList<>();
    
}
