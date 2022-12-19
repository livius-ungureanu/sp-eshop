package com.lun.exceptions;

@SuppressWarnings("serial")
public class SongNotFoundException extends RuntimeException {

	public SongNotFoundException(String id) {
		super(String.format("song with id '%s' not found", id));
	}
}