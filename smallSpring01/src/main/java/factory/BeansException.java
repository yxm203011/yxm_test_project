package factory;

public class BeansException extends RuntimeException {
    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}
