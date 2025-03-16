package com.kusl.randomGeneratorBE.dto;

public enum ResponseCode {

    SUCCESS(200, "Success"),
    NOT_FOUND(404, "Not Found");

    private final int code;
    private final String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
