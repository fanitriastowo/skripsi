package com.skripsi.beni.apps.exception;

public class GlobalRuntimeException extends IllegalArgumentException {

	private String exceptionMsg;

	private static final long serialVersionUID = 1L;

	public GlobalRuntimeException(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
}
