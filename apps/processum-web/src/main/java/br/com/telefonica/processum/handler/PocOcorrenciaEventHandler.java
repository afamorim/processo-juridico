package br.com.telefonica.processum.handler;

import br.com.telefonica.processum.model.PocOcorrencia;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author ifbomfim
 */
@Component
@RepositoryEventHandler(PocOcorrencia.class)
public class PocOcorrenciaEventHandler {

    @HandleBeforeCreate
    public void handlePocOcorrenciaSave(PocOcorrencia p) {
        System.out.println("TESTE ---------" + p);
    }
}
