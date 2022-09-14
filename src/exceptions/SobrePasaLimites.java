package exceptions;

public class SobrePasaLimites extends Exception{
    public SobrePasaLimites() {
    }

    public SobrePasaLimites(String message) {
        super(message);
    }

    public SobrePasaLimites(String message, Throwable cause) {
        super(message, cause);
    }

    public SobrePasaLimites(Throwable cause) {
        super(cause);
    }

    public SobrePasaLimites(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
