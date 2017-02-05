package br.com.telefonica.processum.http.response;

import lombok.Data;
import lombok.ToString;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
@Data
@ToString
public class Pagamento {
    private String formaPagamento;
}
