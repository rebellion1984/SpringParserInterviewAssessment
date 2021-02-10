package com.elsevier.assessment.StringParserElsevierApi.controller;

import com.elsevier.assessment.StringParserElsevierApi.service.StringParserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = StringParserController.class)
class StringParserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StringParserService service;

    @Test
    void empty_input_returns_404_not_found() throws Exception {
        String inputValue = "";
        mockMvc.perform(MockMvcRequestBuilders.get("/author/" + inputValue)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

//    @Test
//    void single_input_returns_200_ok() throws Exception {
//        String inputValue = "John";
//        mockMvc.perform(MockMvcRequestBuilders.get("/author/" + inputValue)
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }

//    @Test
//    void valid_input_returns_200_ok() throws Exception {
//        String inputValue = "John Doe";
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/author/" + inputValue).accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }

}