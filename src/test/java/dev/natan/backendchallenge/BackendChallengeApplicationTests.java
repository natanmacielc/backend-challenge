package dev.natan.backendchallenge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
class BackendChallengeApplicationTests {
    private static final String PASSWORD_PARAM = "password";
    @Autowired
    private MockMvc mvc;

    @ParameterizedTest
    @ValueSource(strings = {"", "aa", "ab", "AAAbbbCc", "AbTp9!foo", "AbTp9!foA", "AbTp9 fok"})
    void givenInvalidPasswordValidatorRequest_thenReturnInvalid(String password) throws Exception {
        mvc.perform(get("")
                        .queryParam(PASSWORD_PARAM, password)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.isValid", is(false)))
                .andExpect(jsonPath("$.criteria", notNullValue()));
    }

    @ParameterizedTest
    @ValueSource(strings = {"AbTp9!fok", "ZbTp2!fog", "WbTp@1rog", "ZbTp1fo@#", "aSdf1@ghL", "!@#p0iMnb", "Z@9lojsnx"})
    void givenValidPasswordValidatorRequest_thenReturnValid(String password) throws Exception {
        mvc.perform(get("")
                        .queryParam(PASSWORD_PARAM, password)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.isValid", is(true)));
    }

    @Test
    void contextLoads() {
        assertDoesNotThrow(() -> BackendChallengeApplication.main(new String[]{}));
    }
}
