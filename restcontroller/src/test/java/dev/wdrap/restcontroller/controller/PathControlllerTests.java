package dev.wdrap.restcontroller.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import dev.wdrap.restcontroller.domain.Path;
import dev.wdrap.restcontroller.service.PathService;

@WebMvcTest(PathControlller.class)
public class PathControlllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PathService pathService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getPath() throws Exception {
            Path path = new Path(0f, 0f);

            Mockito.when(pathService.getPath()).thenReturn(path);

            mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/path"))
                .andExpectAll(
                    MockMvcResultMatchers.status().isOk(),
                    MockMvcResultMatchers.content().contentType("application/json"),
                    MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(path))
                );
    }
}
