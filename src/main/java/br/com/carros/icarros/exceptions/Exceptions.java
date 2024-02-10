package br.com.carros.icarros.exceptions;

public abstract class Exceptions extends RuntimeException {
    private String message;

    public Exceptions(String message) {
        setMessage(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
