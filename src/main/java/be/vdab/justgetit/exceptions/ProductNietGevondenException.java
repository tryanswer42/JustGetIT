package be.vdab.justgetit.exceptions;

public class ProductNietGevondenException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ProductNietGevondenException(String message) {
        super(message);
    }

    public ProductNietGevondenException(String message, Exception oorspronkelijkeFout) {
        super(message, oorspronkelijkeFout);
    }
}