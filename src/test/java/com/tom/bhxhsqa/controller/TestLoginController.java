package com.tom.bhxhsqa.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tom.bhxhsqa.service.LoginService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest()
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class TestLoginController {

    private MockMvc mockMvc;

    @InjectMocks
    private LoginController loginController;

    @Mock
    private LoginService loginService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
    }


    @Test
    public void testLoginSuccessful() throws Exception {
        mockMvc.perform(get("login"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }
}