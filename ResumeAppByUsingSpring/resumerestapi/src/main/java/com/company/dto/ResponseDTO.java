package com.company.dto;

public class ResponseDTO {
    private Integer errorCode;
    private String errorMessage;
    private String successMessage;
    private Object object;

    private ResponseDTO(){}

    public static ResponseDTO createResponse(Object o){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setObject(o);
        return responseDTO;
    }

    public static ResponseDTO createResponse(Object o, String successMessage){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setObject(o);
        responseDTO.setSuccessMessage(successMessage);
        return responseDTO;
    }

    public static ResponseDTO createResponse(Object o, Integer errorCode, String errorMessage){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setObject(o);
        responseDTO.setErrorCode(errorCode);
        responseDTO.setErrorMessage(errorMessage);
        return responseDTO;
    }

    public Integer getErrorCode() {return errorCode;}

    public void setErrorCode(Integer errorCode) {this.errorCode = errorCode;}

    public String getErrorMessage() {return errorMessage;}

    public void setErrorMessage(String errorMessage) {this.errorMessage = errorMessage;}

    public String getSuccessMessage() {return successMessage;}

    public void setSuccessMessage(String successMessage) {this.successMessage = successMessage;}

    public Object getObject() {return object;}

    public void setObject(Object object) {this.object = object;}
}
