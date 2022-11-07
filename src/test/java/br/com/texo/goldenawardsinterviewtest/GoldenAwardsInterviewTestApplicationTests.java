package br.com.texo.goldenawardsinterviewtest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class GoldenAwardsInterviewTestApplicationTests {

    @LocalServerPort
    int randomServerPort;
    
    @Autowired
    private MockMvc mockmvc;
    
	@Test
	void contextLoads() throws Exception {	    
	    mockmvc.perform(get("/intervals")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            
	            .andExpect(jsonPath("$.max").exists())
	            .andExpect(jsonPath("$.max").isNotEmpty())
	            .andExpect(jsonPath("$.max").isArray())
	            
	            .andExpect(jsonPath("$.min").exists())
                .andExpect(jsonPath("$.min").isNotEmpty())
                .andExpect(jsonPath("$.min").isArray())
                
	            .andDo(MockMvcResultHandlers.print());
	}

}
