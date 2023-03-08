package com.tom.bhxhsqa.controller;

import com.tom.bhxhsqa.dto.RegisterDTO;
import com.tom.bhxhsqa.entity.User;
import com.tom.bhxhsqa.repository.UserRepository;
import com.tom.bhxhsqa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    private final UserRepository userRepository;
    @Autowired
    public UserController(UserRepository injectedBean) {
        this.userRepository = injectedBean;
    }
    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String showRegisterPage(ModelMap model){
        return "register";
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String showWelcomePage(
            ModelMap model,
            HttpServletRequest request
    ){
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setUsername("tamhm");
        registerDTO.setPassword("123456a@");
        registerDTO.setAddress("ABC dia chi xyz");
        registerDTO.setCccd("238719237912739218");
        registerDTO.setEmail("minhtamhoang207@gmail.com");
        registerDTO.setFullName("Hoang Minh Tommm");

        User user = new User();
        user.setAddress(registerDTO.getAddress());
        user.setUsername(registerDTO.getUsername());
        user.setPassword(registerDTO.getPassword());
        user.setCccd(registerDTO.getCccd());
        user.setEmail(registerDTO.getEmail());
        user.setFullName(registerDTO.getFullName());
        try {
            System.out.println(user);
            userRepository.save(user);
            return "redirect:home_page";
        } catch (Exception e){
            e.printStackTrace();
            return "register";
        }
    }
}
