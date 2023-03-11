package com.tom.bhxhsqa.controller;

import com.tom.bhxhsqa.dto.UserDTO;
import com.tom.bhxhsqa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

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
            HttpServletRequest request
    ){
        String userType = request.getParameter("user_type");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if( userType == null){
            model.put("errorMessage", "Vui long chon user type");
            return "login";
        } else {
            try {
                boolean loginStatus = userService.login(username, password);
                if (!loginStatus) {
                    model.put("errorMessage", "Tên đăng nhập hoặc mật khẩu không đúng");
                    return "login";
                } else {
                    return "redirect:personal_insurance";
                }
            } catch (Exception e){
                model.put("errorMessage", "Đã xảy ra lỗi vui lòng thử lại sau");
            }
        }
        return "login";
    }

}
