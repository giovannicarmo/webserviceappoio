package com.giovannicarmo.webserviceappoio.services.excepition;

public class ObjectNotFoundException extends RuntimeException {
    private static final long seralVersionUID = 1L;

    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
