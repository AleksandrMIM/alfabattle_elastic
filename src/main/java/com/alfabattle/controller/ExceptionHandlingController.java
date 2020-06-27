package com.alfabattle.controller;

import com.alfabattle.api.StatusResponse;
import com.alfabattle.exception.LoanNotFound;
import com.alfabattle.exception.PersonNotFound;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * User: @AleksandrMIM
 * Date: 25.06.2020
 * Time: 23:34
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandlingController extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Void> handleException(@NotNull Exception e) {
    logger.error(e.getMessage(), e);
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(PersonNotFound.class)
  public ResponseEntity<StatusResponse> handlePersonNotFound(@NotNull PersonNotFound ignore) {
    return new ResponseEntity<>(new StatusResponse(StatusResponse.PERSON_NOT_FOUND), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(LoanNotFound.class)
  public ResponseEntity<StatusResponse> handleLoanNotFound(@NotNull LoanNotFound ignore) {
    return new ResponseEntity<>(new StatusResponse(StatusResponse.LOAN_NOT_FOUND), HttpStatus.BAD_REQUEST);
  }
}
