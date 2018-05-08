package com.giovannicarmo.webserviceappoio.services.excepition;

public class AuthorizationExcepition extends RuntimeException {
    private static final long seralVersionUID = 1L;

    public AuthorizationExcepition(String message) {
        super(message);
    }

    public AuthorizationExcepition(String message, Throwable cause) {
        super(message, cause);
    }

}
