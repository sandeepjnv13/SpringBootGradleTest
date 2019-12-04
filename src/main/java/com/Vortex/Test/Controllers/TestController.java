package com.Vortex.Test.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

    @RequestMapping("/login.html")
    public String login() {
        return "newLoginPanda.html";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    String test(){
        return "<h1>welcome</h1>";
    }

    @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
    @ResponseBody
    public String welcomePage() {


        return "welcome";

    }


    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    @ResponseBody
    public String adminPage() {

        return "welcome admin";

    }

    @RequestMapping(value = "/dba**", method = RequestMethod.GET)
    @ResponseBody
    public String dbaPage() {


        return "Welcome dba";

    }
}
