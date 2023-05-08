package br.com.lixotruck.lixotruck.model.truck.exceptions;

public class TruckException extends RuntimeException {
    public TruckException(String message) {
        super(message, new IllegalArgumentException());
    }
}
