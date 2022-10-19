package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;


@RestController
@RequestMapping("/quotes")
public class QuotesController {

    @Autowired
    private QuotesRepository quotesRepository;



    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Quotes>> getQuotes() {


        Iterable<Quotes> quotes = quotesRepository.findAll();

        ResponseEntity<Iterable<Quotes>> local  = ResponseEntity.of(Optional.of(quotes));
        return local;
        //return ResponseEntity.ok().body(quotes);
    }


    @RequestMapping(path="professor/{professor}", method = RequestMethod.GET)
    public ResponseEntity<Quotes> getQuotesByName(@PathVariable("professor") String searchedName) {
        Iterable<Quotes> quotes = quotesRepository.findAll();
        ResponseEntity<Quotes> local;
        for (Quotes quote : quotes) {
            if(quote.getProfessor().equals(searchedName)) {
                local  = ResponseEntity.of(Optional.of(quote));
                return local;
            }
        }
        local  = ResponseEntity.notFound().build();
        return local;
    }

    @RequestMapping(path="id/{id}", method = RequestMethod.GET)
    public ResponseEntity<Quotes> getQuotesByID(@PathVariable("id") int searchedID) {
        Iterable<Quotes> quotes = quotesRepository.findAll();
        ResponseEntity<Quotes> local;
        for (Quotes quote : quotes) {
            if(((int) quote.getId()) == searchedID) {
                local  = ResponseEntity.of(Optional.of(quote));
                return local;
            }
        }
        local  = ResponseEntity.notFound().build();
        return local;
    }
    public ResponseEntity<String> getGreetingsFromPath(@PathVariable("id") String name) {
        return ResponseEntity.ok().body(name);
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity<String> getGreetingsFromParam(@RequestParam String name) {
//        return ResponseEntity.ok().body(name);
//    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity postGreetings(@RequestBody Greeting greeting) throws URISyntaxException {
        return ResponseEntity.created(new URI("/id123")).build();
    }
}
