package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;


@RestController
@RequestMapping("/quotes")
public class QuotesController {
    @RequestMapping(path="/", method = RequestMethod.GET)
    public ResponseEntity<String> getQuotes() {
        return ResponseEntity.ok().body("Work in progress...");
    }

    @RequestMapping(path="/{benutzername}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("benutzername") String name) {
        return ResponseEntity.ok().body(name);
    }

    @RequestMapping(path="/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> getGreetingsFromPath(@PathVariable("id") String name) {
        return ResponseEntity.ok().body(name);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> getGreetingsFromParam(@RequestParam String name) {
        return ResponseEntity.ok().body(name);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity postGreetings(@RequestBody Greeting greeting) throws URISyntaxException {
        return ResponseEntity.created(new URI("/id123")).build();
    }
}
