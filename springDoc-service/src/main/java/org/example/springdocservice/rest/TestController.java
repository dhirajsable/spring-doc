package org.example.springdocservice.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/auth/test")
@Tag(name = "TestApi")
public class TestController {

    @RequestMapping(value = "/getString",
            method = RequestMethod.GET)
    @Operation(summary = "Test GET API", description = "TEST API for APp")
    ResponseEntity<String> validateCsrf() {
        return ResponseEntity.status(HttpStatus.OK).body("RESPONSE FROM getString API");
    }
}
