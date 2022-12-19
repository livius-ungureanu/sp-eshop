package com.lun.dto;

public enum ErrorCodes {
	GENERIC_ERROR(2001),
	ITEM_NOT_FOUND(2002),
	LOCATION_NOT_FOUND(2003);
	

	private int code;

	ErrorCodes(int code) {
		this.code = code;
	}

	public int code() {
		return this.code;
	}
}
