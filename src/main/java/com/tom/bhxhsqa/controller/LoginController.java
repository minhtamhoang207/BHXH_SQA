package com.tom.bhxhsqa.controller;

import com.tom.bhxhsqa.dto.UserDTO;
import com.tom.bhxhsqa.service.LoginService;
import com.tom.bhxhsqa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String showWelcomePage(
            ModelMap model,
            HttpServletRequest request,
            @RequestParam String name,
            @RequestParam String password
    ){
        String userType = request.getParameter("userType");
        UserDTO user = userService.login(name, password);
        System.out.println(user == null);
        if (user == null) {
            model.put("errorMessage", "Invalid Credentials");
            return "login";
        } else if( userType == null){
            model.put("errorMessage", "Vui long chon user type");
            return "login";
        }

        model.put("name", name);
        model.put("password", password);
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        return "redirect:home_page";
    }

}
