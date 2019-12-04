package com.Vortex.Test.Controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    String test(){
        return "<h1>welcome</h1>";
    }

    @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
    public String welcomePage() {


        return "welcome";

    }


    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public String adminPage() {

        return "welcome admin";

    }

    @RequestMapping(value = "/dba**", method = RequestMethod.GET)
    public String dbaPage() {


        return "Welcome dba";

    }
}
