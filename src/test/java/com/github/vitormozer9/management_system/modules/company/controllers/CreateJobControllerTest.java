package com.github.vitormozer9.management_system.modules.company.controllers;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.vitormozer9.management_system.modules.company.dto.CreateJobDTO;
import com.github.vitormozer9.management_system.modules.utils.TestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CreateJobControllerTest {

    // mock mvc , simula o servidor rodando
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    // Antes disso temos que organizar o setup do mvc (aquele beforeEach que vimos)

    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(context).apply(SecurityMockMvcConfigurers.springSecurity()).build();
    }

    @Test
    public void should_be_able_to_create_a_new_job() throws Exception {

        var createJobDTO = CreateJobDTO.builder()
                            .benefits("BENEFITS TEST")
                            .description("DESCRIPTION_TEST")
                            .level("LEVEL_TEST")
                            .build();

        var result = mvc.perform(MockMvcRequestBuilders.post("company/job/")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtils.objectToJSON(createJobDTO))
            .header("Authorization", TestUtils.generateToken(UUID.randomUUID())))
            .andExpect(MockMvcResultMatchers.status().isOk());

        System.out.println(result);
    }

}
