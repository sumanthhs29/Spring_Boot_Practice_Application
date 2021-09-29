package com.example.pooja_archana.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class ResponseWrapper<PayloadType> {

    private Boolean success=true;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message="";
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PayloadType payload;

    public ResponseWrapper() { }

    public ResponseWrapper(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ResponseWrapper(Boolean success, PayloadType payload) {
        this.success = success;
        this.payload = payload;
    }

    public ResponseWrapper(Boolean success, String message, PayloadType payload) {
        this.success = success;
        this.message = message;
        this.payload = payload;
    }
}
