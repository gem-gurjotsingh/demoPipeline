package com.example.demoPipeline.integration.controller;

import com.example.demoPipeline.entity.User;
import com.example.demoPipeline.repo.UserRepo;
import com.example.demoPipeline.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class UserControllerIntTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepo userRepo;

    @BeforeEach
    void setup() {
        User user = createUser(1L, "Gurjot");
        userRepo.save(user);
    }

    @Test
    void testGetUsersById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.username").value("Gurjot"));
    }

    private User createUser(Long id, String name) {
        User user = new User();
        user.setId(id);
        user.setUsername(name);
        return user;
    }
}
