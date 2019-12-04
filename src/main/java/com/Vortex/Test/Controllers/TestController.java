package com.Vortex.Test.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

    @RequestMapping("/login.html")
    public String login() {
        return "newLoginPanda.html";
    }


    // Login form with error
    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "newLoginPanda.html";
    }

    @RequestMapping(value = { "/", "/welcome**"}, method = RequestMethod.GET)
    @ResponseBody
    public String welcomePage() {


        return "<h1>Welcome, You have been Authenticated</h1>";

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
