package com.giovannicarmo.webserviceappoio.services.excepition;

public class FileException extends RuntimeException {
    private static final long seralVersionUID = 1L;

    public FileException(String message) {
        super(message);
    }

    public FileException(String message, Throwable cause) {
        super(message, cause);
    }

}
