package com.example.demoPipeline.integration.repository;

import com.example.demoPipeline.entity.User;
import com.example.demoPipeline.repo.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepoIntTest {
   @Autowired
   private UserRepo userRepo;

   @BeforeEach
    void setup() {
       User user = createUser(1L, "Prabh");
       userRepo.save(user);
   }

   @Test
   void testGetUserById() {
       User founduser = userRepo.findById(1L).orElse(null);
       assertNotNull(founduser);
   }

    private User createUser(Long id, String name) {
        User user = new User();
        user.setId(id);
        user.setUsername(name);
        return user;
    }
}
