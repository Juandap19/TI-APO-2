package exceptions;

public class TuberiaValidaException extends Exception{
    public TuberiaValidaException() {
    }

    public TuberiaValidaException(String message) {
        super(message);
    }

    public TuberiaValidaException(String message, Throwable cause) {
        super(message, cause);
    }

    public TuberiaValidaException(Throwable cause) {
        super(cause);
    }

    public TuberiaValidaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
