package com.alfabattle.controller;

import com.alfabattle.api.*;
import com.alfabattle.entity.PersonEntity;
import com.alfabattle.exception.LoanNotFound;
import com.alfabattle.exception.PersonNotFound;
import com.alfabattle.mapper.CreditHistoryEndpointMapper;
import com.alfabattle.mapper.LoanEndpointMapper;
import com.alfabattle.mapper.PersonEndpointMapper;
import com.alfabattle.mapper.PersonWithLoanMapper;
import com.alfabattle.service.LoanService;
import com.alfabattle.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/loans")
@RequiredArgsConstructor
public class LoansController {

  private final PersonEndpointMapper personMapper;
  private final LoanEndpointMapper loanMapper;
  private final PersonService personService;
  private final LoanService loanService;
  private final CreditHistoryEndpointMapper creditHistoryEndpointMapper;
  private final PersonWithLoanMapper personWithLoanMapper;

  @PostMapping("/loadPersons")
  public StatusResponse loadPersons() {
    personService.load();
    return new StatusResponse(StatusResponse.OK);
  }

  @PostMapping("/loadLoans")
  public StatusResponse loadLoans() {
    loanService.load();
    return new StatusResponse(StatusResponse.OK);
  }

  @GetMapping("/getPerson/{docId}/")
  public PersonResponse getPerson(@PathVariable("docId") String docId) {
    return personService.getByDocId(docId)
        .map(personMapper::map)
        .orElseThrow(PersonNotFound::new);
  }

  @GetMapping("/getLoan/{docId}/")
  public LoanResponse getLoan(@PathVariable("docId") String docId) {
    return loanService.getByDocId(docId)
        .map(loanMapper::map)
        .orElseThrow(LoanNotFound::new);
  }

  @GetMapping("/creditHistory/{docId}/")
  public CreditHistoryResponse creditHistory(@PathVariable("docId") String docId) {
    return creditHistoryEndpointMapper.map(loanService.getCreditHistory(docId));
  }

  @GetMapping("/creditClosed")
  public List<LoanResponse> creditClosed() {
    return loanService.getClosed()
        .stream()
        .map(loanMapper::map)
        .collect(Collectors.toList());
  }

  @GetMapping("/loansSortByPersonBirthday")
  public List<PersonWithLoanResponse> loansSortByPersonBirthday() {
    List<PersonEntity> personEntities = personService.getPersonSortById();
    return personEntities.stream()
        .map(personEntity -> {
          PersonWithLoanResponse personWithLoanResponse = personWithLoanMapper.map(personEntity);
          personWithLoanResponse.setLoanResponses(loanService.getByDocumentId(personWithLoanResponse.getDocId())
              .stream()
              .map(loanMapper::map)
              .collect(Collectors.toList()));
          return personWithLoanResponse;
        }).collect(Collectors.toList());
  }
}
