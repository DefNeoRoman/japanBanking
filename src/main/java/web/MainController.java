package web;

import model.JPYModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.JpyService;

@RestController
public class MainController {
    @Autowired
    JpyService service;
    @RequestMapping(value = "/getLast",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public JPYModel getLast(){
        return service.getLast();
    }
    @GetMapping(value = "/buy", produces = MediaType.APPLICATION_JSON_VALUE)
    public Double buy(@RequestParam("sum") Double sum) {
        JPYModel jpyModel = service.getLast();
        Double currentCourse = jpyModel.getValue();
        return sum/currentCourse;
    }
    @GetMapping(value = "/sell", produces = MediaType.APPLICATION_JSON_VALUE)
    public Double sell (@RequestParam("sum") Double sum) {
        JPYModel jpyModel = service.getLast();
        Double currentCourse = jpyModel.getValue();
        return sum*currentCourse;
    }

}
