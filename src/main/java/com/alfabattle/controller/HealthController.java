package com.alfabattle.controller;

import com.alfabattle.api.StatusResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

  @GetMapping("/health")
  public StatusResponse health() {
    return new StatusResponse(StatusResponse.UP);
  }
}
