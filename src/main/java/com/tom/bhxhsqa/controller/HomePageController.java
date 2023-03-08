package com.tom.bhxhsqa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class HomePageController {
    @RequestMapping(value="/home_page", method = RequestMethod.GET)
    public String showHomePage(ModelMap model){
        return "home_page";
    }
}
