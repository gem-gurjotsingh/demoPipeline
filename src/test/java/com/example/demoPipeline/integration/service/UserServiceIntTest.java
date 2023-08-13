package com.example.demoPipeline.integration.service;

import com.example.demoPipeline.entity.User;
import com.example.demoPipeline.repo.UserRepo;
import com.example.demoPipeline.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceIntTest {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    @BeforeEach
    void setup() {
        User user = createUser(1L, "Gurjot");
        userRepo.save(user);
    }

    @Test
    void testGetUsersById() {
        User user = userService.getUserById(1L);
        assertNotNull(user);
        assertEquals("Gurjot", user.getUsername());
    }

    private User createUser(Long id, String name) {
        User user = new User();
        user.setId(id);
        user.setUsername(name);
        return user;
    }
}
