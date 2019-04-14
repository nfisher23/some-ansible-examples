package com.nickolasfisher.simplemvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {

    @GetMapping("/**")
    public ResponseEntity<String> simpleResponder() {
        return new ResponseEntity<>("<h1>Welcome to my site!</h1>", HttpStatus.ACCEPTED);
    }
}
