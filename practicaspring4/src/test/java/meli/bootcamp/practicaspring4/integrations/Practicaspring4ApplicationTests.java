package meli.bootcamp.practicaspring4.integrations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class Practicaspring4ApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createLink() throws Exception {
        String request = "{\"url\": \"https://google.com\", \"password\": \"pepeargento\"}";
        this.mockMvc.perform(
                post("/link/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.linkId").value(5))
                .andExpect(jsonPath("$.url").value("https://google.com"));
    }

    @Test
    void getLink() throws Exception {
        this.mockMvc.perform(
                get("/link/1"))
                .andDo(print()).andExpect(status().is3xxRedirection());
    }

    @Test
    void getMetrics() throws Exception {
        this.mockMvc.perform(
                get("/link/metrics/3"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.cantRedirect").value(15L))
                .andExpect(jsonPath("$.linkId").value(3));
    }

    @Test
    void invalidateLink() throws Exception {
        this.mockMvc.perform(
                post("/link/invalidate/2"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.linkId").value(2))
                .andExpect(jsonPath("$.invalidate").value(true));
    }

}
