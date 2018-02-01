package main.java.com.compania.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Владислав on 01.02.2018.
 */
@Controller
public class FirstController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String test(Model model, @RequestParam("name") String param){
       model.addAttribute("name",param);
       return "hello";
    }
}
