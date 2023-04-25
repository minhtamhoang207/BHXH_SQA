package com.tom.bhxhsqa.controller;

import com.tom.bhxhsqa.entity.User;
import com.tom.bhxhsqa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        model.addAttribute("showToast", false);
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String showWelcomePage(
            ModelMap model,
            HttpSession session,
            HttpServletRequest request
    ){
        String userType = request.getParameter("user_type");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.length() > 6 && password.length() >= 6) {
            try {
                long userID = userService.login(username, password);
                if (userID == -1) {
                    model.put("errorMessage", "Tài khoản hoặc mật khẩu không chính xác");
                    model.addAttribute("showToast", true);
                    return "login";
                } else {
                    User user = userService.getUserByName(username);
                    if(user.getIsCompanyAccount()) {
                        session.setAttribute("id", userID);
                        session.setAttribute("user", user);
                        return "redirect:homepage-company";
                    } else {
                        session.setAttribute("id", userID);
                        session.setAttribute("user", user);
                        return "redirect:homepage-personal";
                    }

                }
            } catch (Exception e){
                e.printStackTrace();
                model.put("errorMessage", "Đã xảy ra lỗi");
            }
        } else {
            if (username.isEmpty()) {
                model.put("errorMessage", "Tên đăng nhập không được để trống");
                model.addAttribute("showToast", true);
            } else if (password.isEmpty()) {
                model.put("errorMessage", "Mật khẩu không được để trống");
                model.addAttribute("showToast", true);
            } else {
                model.put("errorMessage", "Tên đăng nhập hoặc mật khẩu không chính xác");
                model.addAttribute("showToast", true);
            }
        }
        
        return "login";
    }

}
