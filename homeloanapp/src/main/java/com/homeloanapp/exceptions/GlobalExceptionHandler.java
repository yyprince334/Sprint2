package com.homeloanapp.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	private String desc="Description";
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request){
				
		Map<String, String> map = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName = ((FieldError)error).getField();
			String msg = error.getDefaultMessage();
			
			map.put(fieldName, msg);
		});
		
		return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
	}
	

	
	
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> handleCustomerException(CustomerNotFoundException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add(desc, "Trying to get a customer");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
		
	}
	

	@ExceptionHandler(InvalidCredentialException.class)
	public ResponseEntity<String> handleInvalidCredentialException(InvalidCredentialException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add(desc, "Trying to get Credentials");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
		
	}
	@ExceptionHandler(InvalidLoanApplicationException.class)
	public ResponseEntity<String> handleInvalidLoanApplicationException(InvalidLoanApplicationException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add(desc, "Trying to get Loan Application");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
		
	}
	
	@ExceptionHandler(FinanceVerificationOfficerException.class)
	public ResponseEntity<String> handleFinanceVerificationOfficerExceptionException(FinanceVerificationOfficerException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add(desc, "Trying to get FinanceVerificationOfficer Approval");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
		
	}

	@ExceptionHandler(LandVerificationOfficerException.class)
	public ResponseEntity<String> handleLandVerificationOfficerException(LandVerificationOfficerException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add(desc, "Trying to get LandVerificationOfficer Approval");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
		
	}
	
	@ExceptionHandler(ManagerException.class)
	public ResponseEntity<String> handleManagerExceptionException(ManagerException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add(desc, "Trying to get Manager Approval");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
		
	}
	

}