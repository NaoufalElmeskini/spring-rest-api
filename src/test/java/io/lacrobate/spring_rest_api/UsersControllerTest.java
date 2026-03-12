package io.lacrobate.spring_rest_api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UsersController.class)
class UsersControllerTest {

    @Autowired
    MockMvc mockMvc;

    // Required because UsersController depends on it; we don't exercise it here
    @MockBean
    JsonPlaceholderClient jsonPlaceholderClient;

    @Test
    void existsUser_returnsTrue_whenUserExists() throws Exception {
        mockMvc.perform(get("/users/exists/John"))
            .andExpect(status().isOk())
            .andExpect(content().string("true"));
    }

    @Test
    void existsUser_returnsFalse_whenUserDoesNotExist() throws Exception {
        mockMvc.perform(get("/users/exists/Unknown"))
            .andExpect(status().isOk())
            .andExpect(content().string("false"));
    }

    @Test
    void addUser_addsUserAndReturnsUpdatedList() throws Exception {
        mockMvc.perform(post("/users")
                .contentType(MediaType.TEXT_PLAIN)
                .content("Pierre"))
            .andExpect(status().isOk())
            .andExpect(content().string("[John, Aicha, Pierre]"));
    }
}
