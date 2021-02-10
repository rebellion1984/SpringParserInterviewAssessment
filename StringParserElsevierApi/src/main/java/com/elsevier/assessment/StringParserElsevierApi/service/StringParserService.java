package com.elsevier.assessment.StringParserElsevierApi.service;

import com.elsevier.assessment.StringParserElsevierApi.model.Author;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StringParserService {

    private String firstName;
    private String lastName;

    public Author getAuthor(String inputValue) {
        String[] result = Arrays.stream(inputValue.split("[ ,]+"))
                .map(String::trim)
                .toArray(String[]::new);

        return getAuthorDetails(result);
    }

    private Author getAuthorDetails(String[] result) {
        if (result.length == 1) {
            firstName = result[0];
        }else if (result.length == 2) {
            firstName = result[0];
            lastName = result[1];
        }else{
            int lastWord = result.length - 1;
            firstName = result[0];
            lastName = result[lastWord];
        }

        Author author = new Author(firstName, lastName);
        return author;
    }

    public List<Author> getAuthors(String inputValues) {
        List<String> authors = new ArrayList<>();

        // array of all authors entered
        String[] result = Arrays.stream(inputValues.split(","))
                .map(String::trim)
                .toArray(String[]::new);

        // add every author to the list
        for (String item : result) {
            authors.add(item);
        }

        //list to array
        String[] newArrayFromList = authors.stream().toArray(String[]::new);

        //another list to store each author's first and last names
        List<Author> eachAuthorDetails= new ArrayList<>();

        //getting first and last names of every author and populating it in the list
        for (String item : newArrayFromList) {
            String[] fullName = Arrays.stream(item.split(" "))
                    .map(String::trim)
                    .toArray(String[]::new);

            Author author = new Author(fullName[0], fullName[fullName.length-1]);
            eachAuthorDetails.add(author);
        }

        return eachAuthorDetails;
    }
}

