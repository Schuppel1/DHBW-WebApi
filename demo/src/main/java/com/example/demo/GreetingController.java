package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    @RequestMapping(path="/all", method = RequestMethod.GET)
    public ResponseEntity<String> getGreetings() {
        return ResponseEntity.ok().body("Hi all!");
    }

    @RequestMapping(path="/{benutzername}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("benutzername") String name) {
        return ResponseEntity.ok().body(name);
    }

    @RequestMapping(path="/{benutzername}", method = RequestMethod.GET)
    public ResponseEntity<String> getGreetingsFromPath(@PathVariable("benutzername") String name) {
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
