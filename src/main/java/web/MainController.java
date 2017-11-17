package web;

import model.JPYModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.JpyService;

@RestController
public class MainController {
    @Autowired
    JpyService service;
    @RequestMapping(value = "/getLast",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public JPYModel getLast(){
        return service.getLast();
    }
}
