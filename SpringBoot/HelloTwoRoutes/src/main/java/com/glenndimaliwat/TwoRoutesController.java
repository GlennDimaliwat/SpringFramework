package com.glenndimaliwat;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TwoRoutesController {

    @RequestMapping("/")
    public String showHome(){

        String html = "<a href=\"/Route1\">Go to Route 1</a><br/>"
                    + "<a href=\"/Route2\">Go to Route 2</a><br/>";

        return html;
    }

    @RequestMapping("/Route1")
    public String showRoute1(){
        return "This is Route 1";
    }

    @RequestMapping("/Route2")
    public String showRoute2(){
        return "This is Route 2";
    }

}
