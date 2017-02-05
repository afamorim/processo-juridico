package br.com.telefonica.processum.http.response;

import lombok.Data;
import lombok.ToString;

/**
 *
 * @author ifbomfim
 */
@Data
@ToString
public class Assinatura {

    private String tipoAssinatura;
    private String statusAssinatura;

}
