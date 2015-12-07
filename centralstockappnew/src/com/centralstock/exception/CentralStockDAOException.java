package com.centralstock.exception;

public class CentralStockDAOException  extends RuntimeException{
	
	private String errorMessage;
	
	public CentralStockDAOException(String errorMessage){
		
		this.errorMessage=errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
