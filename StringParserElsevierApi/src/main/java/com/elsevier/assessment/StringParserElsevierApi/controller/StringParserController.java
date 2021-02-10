package com.elsevier.assessment.StringParserElsevierApi.controller;

import com.elsevier.assessment.StringParserElsevierApi.model.Author;
import com.elsevier.assessment.StringParserElsevierApi.service.StringParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/stringparser")
public class StringParserController {

    @Autowired
    private StringParserService service;

    @GetMapping(value="/author/{input}")
	public Author getAuthor(@PathVariable String input) {
        return service.getAuthor(input);
	}

    @GetMapping(value="/authors/{input}")
    public List<Author> getAuthors(@PathVariable String input) {
        return service.getAuthors(input);
    }
}
