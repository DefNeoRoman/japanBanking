package web;

import com.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;
import service.JpyService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


//Start after starting server
public class MainJapanBankingControllerTest {
    @Test
    public void buy() throws Exception {
        System.out.println(printUrlContents(new URL("http://localhost:8080/buy?sum=78")));
    }

    @Test
    public void sell() throws Exception {
        System.out.println(printUrlContents(new URL("http://localhost:8080/sell?sum=78")));
    }
    private static String printUrlContents(URL url) throws IOException {
        StringBuilder sb = new StringBuilder();
        try(InputStream stream = url.openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {

            while((reader.ready())) {
               sb.append(reader.readLine());
            }

        }
        return sb.toString();
    }


}