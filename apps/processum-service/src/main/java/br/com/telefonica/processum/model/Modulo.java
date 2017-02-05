package br.com.telefonica.processum.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author ifbomfim
 */
@Entity
@Table(name = "MODULO")
@Data
public class Modulo implements Serializable {

    @Id
    @Column(name = "COD_MODULO")
    private Long codModulo;

    @Column(name = "NOM_MODULO")
    private String nomModulo;

}
