package br.com.telefonica.processum.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ifbomfim
 */
@Embeddable
public class MunicipioPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SIG_MUNICIPIO")
    private String sigMunicipio;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "SIG_ESTADO")
    private String sigEstado;

    public MunicipioPK() {
    }

    public MunicipioPK(String sigMunicipio, String sigEstado) {
        this.sigMunicipio = sigMunicipio;
        this.sigEstado = sigEstado;
    }

    public String getSigMunicipio() {
        return sigMunicipio;
    }

    public void setSigMunicipio(String sigMunicipio) {
        this.sigMunicipio = sigMunicipio;
    }

    public String getSigEstado() {
        return sigEstado;
    }

    public void setSigEstado(String sigEstado) {
        this.sigEstado = sigEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sigMunicipio != null ? sigMunicipio.hashCode() : 0);
        hash += (sigEstado != null ? sigEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MunicipioPK)) {
            return false;
        }
        MunicipioPK other = (MunicipioPK) object;
        if ((this.sigMunicipio == null && other.sigMunicipio != null) || (this.sigMunicipio != null && !this.sigMunicipio.equals(other.sigMunicipio))) {
            return false;
        }
        return !((this.sigEstado == null && other.sigEstado != null) || (this.sigEstado != null && !this.sigEstado.equals(other.sigEstado)));
    }

    @Override
    public String toString() {
        return sigEstado + "§" + sigMunicipio;
    }
}
