package com.eval.cediaz.evaljava.business;

import com.eval.cediaz.evaljava.domain.UserDomain;
import com.eval.cediaz.evaljava.entity.User;
import com.eval.cediaz.evaljava.mapper.UserMapperServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith({MockitoExtension.class})
@SpringBootTest
public class UserMapperServiceImplTest {

    public static final String SECRET = "5d8cf81e187b792d80f08b4dc5a4f5157f889170a8eed2f1b5b8c64ca58e89dc";

    @InjectMocks
    UserMapperServiceImpl userMapperService;

    @Test
    void whenCreateUserEntityFromDomain() throws IOException {
        ReflectionTestUtils.setField(userMapperService, "secretKey" , SECRET);
        ReflectionTestUtils.setField(userMapperService, "isActive" , true);
        UserDomain userDomain = buildUserDomain();
        User user = userMapperService.createUserEntityFromDomain(userDomain);

        assertEquals(user.getName(),"Juan Rodriguez");
        assertEquals(user.getEmail(),"mail.valid@test.com");
    }

    @Test
    void whenCreateUserDomainFromEntity() {
        ReflectionTestUtils.setField(userMapperService, "secretKey" , SECRET);
        ReflectionTestUtils.setField(userMapperService, "isActive" , true);

        UserDomain userDomain = userMapperService.createUserDomainFromEntity(getUserEntityDummy());

        assertEquals(userDomain.getName(),"Pedro Perez");
        assertEquals(userDomain.getEmail(),"test@test.com");
        assertEquals(userDomain.getId(),"id");
        assertEquals(userDomain.getPassword(), "ABcd123");
        assertTrue(userDomain.getActive());

    }

    private UserDomain buildUserDomain() throws IOException {
        String MOCK_PATH = "src/test/resources/mock/";
        String jsonContent = new String(Files.readAllBytes(Paths.get(MOCK_PATH + "whenCreateUserEntityFromDomain.json")));

        ObjectMapper objectMapper = new ObjectMapper();
        // Convierte el JSON en un objeto Java utilizando Jackson
        return objectMapper.readValue(jsonContent, UserDomain.class);
    }

    private User getUserEntityDummy() {
        User user = new User();

        user.setName("Pedro Perez");
        user.setEmail("test@test.com");
        user.setId("id");
        user.setPassword("ABcd123");
        user.setToken("token");
        user.setActive(true);
        user.setPhones(Collections.emptyList());
        
        return user;
    }
}
