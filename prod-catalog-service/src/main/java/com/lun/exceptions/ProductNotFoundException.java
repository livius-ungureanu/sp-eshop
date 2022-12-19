package com.lun.exceptions;

public class ProductNotFoundException extends RuntimeException {

	public ProductNotFoundException(String id) {
		super(String.format("product id '%s' not found in catalog", id));
	}
}