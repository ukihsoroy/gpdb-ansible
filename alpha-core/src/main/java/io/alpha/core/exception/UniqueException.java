package io.alpha.core.exception;

public class UniqueException extends BusinessException {
    public UniqueException(String message) {
        super(message);
        super.setCode(503);
    }
}
