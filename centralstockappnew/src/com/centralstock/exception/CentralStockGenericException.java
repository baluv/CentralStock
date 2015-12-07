package com.centralstock.exception;

public class CentralStockGenericException extends RuntimeException{
	
	private String errorMessage;
	
	public CentralStockGenericException(String errorMessage){
		
		this.errorMessage=errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
