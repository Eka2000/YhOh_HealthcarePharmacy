package com.yhoh.healthcarepharmacy.exception;

public class ResourceNotFoundException extends PharmacyException{

	public ResourceNotFoundException(String resourceName,String fieldName, Object fieldValue) {
		
		super(resourceName + " not found with " + fieldName + " : " + fieldValue);
		
	}

	public ResourceNotFoundException(String message) {
        super(message);
    }

}
