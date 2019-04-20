package com.nickolasfisher.simplemvc;

import com.fasterxml.jackson.databind.JsonNode;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SimpleController {

    private static String hotValue = "starter";

    @GetMapping("/slow")
    public ResponseEntity<String> slowEndpoint() throws InterruptedException {
        Thread.sleep(2500);
        return new ResponseEntity<>("<p>Takes a while to get: " + hotValue + " </p>", HttpStatus.ACCEPTED);
    }

    @PostMapping("/api/hotValue")
    @InvalidateNginxCache
    public RedirectView updateHotValue(@RequestBody JsonNode body) {
        hotValue = body.get("hotValue").textValue();
        return new RedirectView("/slow");
    }

    @GetMapping("/")
    public ResponseEntity<String> simpleResponder() {
        return new ResponseEntity<>("<h1>Welcome to my site!</h1>", HttpStatus.ACCEPTED);
    }
}
