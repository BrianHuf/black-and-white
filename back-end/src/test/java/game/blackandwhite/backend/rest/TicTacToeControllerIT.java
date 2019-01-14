package game.blackandwhite.backend.rest;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = App.class)

@AutoConfigureMockMvc
public class TicTacToeControllerIT {
    @Autowired
    private MockMvc mvc;

    @Test
    public void test() throws Exception {
        System.out.println("Hello world");
        final String url = "/api/v1/tictactoe/movesToState/012";

        ResultActions a = mvc.perform(get(url).contentType(MediaType.APPLICATION_JSON));
        a.andExpect(status().isOk());
        a.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
        a.andExpect(jsonPath("state", is("X__OXO_XO")));
    }
}