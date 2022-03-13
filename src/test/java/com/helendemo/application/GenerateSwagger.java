package com.helendemo.application;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GenerateSwagger {

    Logger logger = LogManager.getLogger("HelloWorld");

    @Autowired
    WebApplicationContext context;

    @Test
    public void generateSwagger() throws Exception {
        File evalFile = new File("swagger_ext.json");
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/myapi/v2/api-docs?group=EXTERNAL").accept(MediaType.APPLICATION_JSON))
                .andDo((result) -> {
                    logger.info(result);
                    FileUtils.writeStringToFile(evalFile, result.getResponse().getContentAsString(),"UTF_8");
                });
        logger.info("Hello, World!");
    }
}