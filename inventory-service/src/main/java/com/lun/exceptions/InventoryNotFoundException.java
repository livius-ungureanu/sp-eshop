package com.lun.exceptions;

public class InventoryNotFoundException extends RuntimeException {

	public InventoryNotFoundException(String id) {
		super(String.format("Product id '%s' not found", id));
	}
}