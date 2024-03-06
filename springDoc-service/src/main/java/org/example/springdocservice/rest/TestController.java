package org.example.springdocservice.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/auth/test")
public class TestController {

    @RequestMapping(value = "/getString",
            method = RequestMethod.GET)
    ResponseEntity<String> validateCsrf() {
        return ResponseEntity.status(HttpStatus.OK).body("RESPONSE FROM getString API");
    }
}
