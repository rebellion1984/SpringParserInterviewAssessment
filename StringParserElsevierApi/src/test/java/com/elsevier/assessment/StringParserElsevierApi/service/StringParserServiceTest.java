package com.elsevier.assessment.StringParserElsevierApi.service;

import com.elsevier.assessment.StringParserElsevierApi.model.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StringParserServiceTest {


    @Autowired
    private StringParserService service;

    @Test
    public void full_name_contains_three_parts_returns_ok() {

        String inputValue = "Peter Hans Kristensen";

        Author output = service.getAuthor(inputValue);

        assertEquals("Peter", output.getFirstName());
        assertEquals("Kristensen", output.getLastName());
    }

    @Test
    public void full_name_contains_two_parts_returns_ok() {

        String inputValue = "John Doe";

        Author output = service.getAuthor(inputValue);

        assertEquals("John", output.getFirstName());
        assertEquals("Doe", output.getLastName());
    }

//    @Test
//    public void full_name_contains_one_part_returns_ok() {
//
//        String singleInputValue = "John";
//
//        Author outputValue = service.getAuthor(singleInputValue);
//
//        assertEquals("John", outputValue.getFirstName());
//        assertNull(outputValue.getLastName());
//    }

    @Test
    public void full_name_contains_two_parts_and_first_name_contains_dash_returns_ok() {

        String inputValue = "Hans-Christian Jensen";

        Author output = service.getAuthor(inputValue);

        assertEquals("Hans-Christian", output.getFirstName());
        assertEquals("Jensen", output.getLastName());
    }

    @Test
    public void full_name_contains_two_parts_and_first_name_contains_dot_returns_ok() {

        String inputValue = "P.H. Kristensen";

        Author output = service.getAuthor(inputValue);

        assertEquals("P.H.", output.getFirstName());
        assertEquals("Kristensen", output.getLastName());
    }

    // test for the endpoint that receives multiple input
    @Test
    public void input_contains_multiple_authors_returns_ok() {

        String inputValue = "H-C Jensen, Peter Hans Kristensen, John Doe";

        List<Author> response = service.getAuthors(inputValue);

        for (Author item : response) {
            assertEquals("H-C", response.get(0).getFirstName());
            assertEquals("Jensen", response.get(0).getLastName());
            assertEquals("Peter", response.get(1).getFirstName());
            assertEquals("Kristensen", response.get(1).getLastName());
            assertEquals("John", response.get(2).getFirstName());
            assertEquals("Doe", response.get(2).getLastName());
        }
    }

}