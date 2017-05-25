package com.app.property.service.dto;

import java.util.ArrayList;
import java.util.List;

public class BaseResponse<T> {

    private T data;

    private List<String> errors;

    private List<String> messages;

    private Long status;

   
    public void setError(String error) {
        if (errors == null) {
            this.errors = new ArrayList<String>();
        }

        if (error != null && error.length() > 0) {
            this.errors.add(error);
        }
    }

    public void setMessage(String message) {
        if (messages == null) {
            this.messages = new ArrayList<String>();
        }

        if (message != null && message.length() > 0) {
            messages.add(message);
        }
    }

    
    public T getData() {
        return data;
    }

    
    public void setData(T data) {
        this.data = data;
    }

    
    public List<String> getErrors() {
        return errors;
    }

    
    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    
    public List<String> getMessages() {
        return messages;
    }

    
    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    
    public Long getStatus() {
        return status;
    }

    
    public void setStatus(Long status) {
        this.status = status;
    }

    
  
    
}
