package com.kusl.randomGeneratorBE.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseData<T> {

    private int status;
    private String message;
    private T data;
    private ResponseCode responseCode;

    public ResponseData(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ResponseData(ResponseCode responseCode, T data) {
        this.status = responseCode.getCode();
        this.message = responseCode.getMessage();
        this.data = data;
    }

    public ResponseData(ResponseCode responseCode) {
        this.status = responseCode.getCode();
        this.message = responseCode.getMessage();
    }
}
