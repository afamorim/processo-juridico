package br.com.telefonica.processum.exception;

import java.util.HashMap;

/**
 *
 * @author Ivan Queiroz <ifbomfim@indracompany.com>
 */
public class ServicoException extends Exception {

    private static final long serialVersionUID = -256904942685783664L;

    HashMap<String, String> mMap = new HashMap<>();

    public ServicoException(String message) {
        super(message);
    }

    public ServicoException(String message, Throwable cause) {
        super(message, cause);
    }

    public HashMap<String, String> getmMap() {
        return mMap;
    }

    public void setmMap(HashMap<String, String> mMap) {
        this.mMap = mMap;
    }
    
}
