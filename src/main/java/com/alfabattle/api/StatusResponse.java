package com.alfabattle.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * User: @AleksandrMIM
 * Date: 27.06.2020
 * Time: 16:16
 */
@Getter
@Setter
@AllArgsConstructor
public class StatusResponse {

  public static final String OK = "OK";
  public static final String UP = "UP";
  public static final String PERSON_NOT_FOUND = "person not found";
  public static final String LOAN_NOT_FOUND = "loan not found";

  private String status;
}
