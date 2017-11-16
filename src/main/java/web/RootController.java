package web;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RootController {
    @RequestMapping(value = "/",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public String
    welcome(Model model) {

        return "index";
    }
}
