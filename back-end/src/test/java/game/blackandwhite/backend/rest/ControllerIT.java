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
public class ControllerIT {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testMovesToState() throws Exception {
        final String url = "/api/v1/movesToState?game=tictactoe&moves=012";

        ResultActions a = mvc.perform(get(url).contentType(MediaType.APPLICATION_JSON));
        a.andExpect(status().isOk());
        a.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
        a.andExpect(jsonPath("state", is("XOX______")));
    }

    @Test
    public void testMovesTree() throws Exception {
        final String url = "/api/v1/movesTree?game=tictactoe&moves=012&depth=2";

        ResultActions a = mvc.perform(get(url).contentType(MediaType.APPLICATION_JSON));
        a.andExpect(status().isOk());
        a.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
        a.andExpect(jsonPath("visits", is(1000)));
    }

}