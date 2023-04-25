package com.tom.bhxhsqa.controller;

import com.tom.bhxhsqa.dto.RegisterDTO;
import com.tom.bhxhsqa.entity.Company;
import com.tom.bhxhsqa.entity.User;
import com.tom.bhxhsqa.repository.CompanyRepository;
import com.tom.bhxhsqa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

	private final CompanyRepository companyRepository;
    private final UserRepository userRepository;
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    @Autowired
    public UserController(UserRepository injectedBean, CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
		this.userRepository = injectedBean;
    }
    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String showRegisterPage(){
        return "register";
    }
    
    @RequestMapping(value="/register-personal", method = RequestMethod.GET)
    public String showRegisterPersonalPage(ModelMap model){
        model.addAttribute("showToast", false);
        return "register-personal";
    }
    
    @RequestMapping(value="/register-company", method = RequestMethod.GET)
    public String showRegisterCompanyPage(ModelMap model){
        model.addAttribute("showToast", false);
        return "register-company";
    }
    
    @RequestMapping(value="/register-company", method = RequestMethod.POST)
    public String showHomePage(
            HttpServletRequest request,
            ModelMap model
    ){
    	String randomUnitCode = UUID.randomUUID().toString();
    	randomUnitCode = randomUnitCode.substring(0, Math.min(randomUnitCode.length(), 8));
    	Company company = new Company();
        company.setName(request.getParameter("company_name"));
        company.setAddress(request.getParameter("address"));
        company.setEmail(request.getParameter("email"));
        company.setPhone(request.getParameter("phone_number"));
        company.setRepresentative(request.getParameter("representative"));
        company.setTaxCode(request.getParameter("tax_code"));
        company.setUnitCode(randomUnitCode.toUpperCase());
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setPhone(request.getParameter("phone_number"));
        user.setIsCompanyAccount(true);
        user.setMaDonVi(randomUnitCode.toUpperCase());
        if(!user.getUsername().isEmpty()) {
            try {
                userRepository.save(user);
                companyRepository.save(company);
                return "redirect:login";
            } catch (Exception e){
                e.printStackTrace();
                return "register";
            }
        } else {
            model.put("errorMessage", "Tên đăng nhập phải chứa từ 6 kí tự");
            model.addAttribute("showToast", true);
            return "/register-company";
        }
    }


    @RequestMapping(value="/register-personal", method = RequestMethod.POST)
    public String showWelcomePage(
            ModelMap model,
            HttpServletRequest request
    ){
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setUsername(request.getParameter("username"));
        registerDTO.setPassword(request.getParameter("password"));
        registerDTO.setFullName(request.getParameter("full_name"));
        registerDTO.setCccd(request.getParameter("citizen_id"));
        registerDTO.setAddress(request.getParameter("address"));
        registerDTO.setPhone(request.getParameter("phone_number"));
        registerDTO.setEmail(request.getParameter("email"));

        User user = new User();
        if(validInfo(registerDTO, model, request)){
            user.setUsername(registerDTO.getUsername().trim());
            user.setPassword(registerDTO.getPassword().trim());
            user.setFullName(registerDTO.getFullName().trim());
            user.setCccd(registerDTO.getCccd().trim());
            user.setAddress(registerDTO.getAddress().trim());
            user.setPhone(registerDTO.getPhone().trim());
            user.setEmail(registerDTO.getEmail().trim());
            user.setIsCompanyAccount(false);

            try {
                userRepository.save(user);
                return "redirect:login";
            } catch (Exception e){
                e.printStackTrace();
                return "register-personal";
            }
        } else {
            return "register-personal";
        }
    }

    Boolean validInfo(RegisterDTO registerDTO, ModelMap model, HttpServletRequest request){
        if(registerDTO.getUsername().isEmpty() ||
            registerDTO.getPassword().isEmpty() ||
            registerDTO.getFullName().isEmpty() ||
            registerDTO.getCccd().isEmpty() ||
            registerDTO.getAddress().isEmpty() ||
            registerDTO.getPhone().isEmpty() ||
            registerDTO.getEmail().isEmpty()
        ) {
            model.put("errorMessage", "Bạn cần điền đầy đủ thông tin");
            model.addAttribute("showToast", true);
            return false;
        } else {
            if(!registerDTO.getUsername().isEmpty()){
                if(registerDTO.getUsername().length() < 6){
                    model.put("errorMessage", "Tên đăng nhập phải chứa từ 6 kí tự");
                    model.addAttribute("showToast", true);
                    return false;
                }
            } else {
                model.put("errorMessage", "Tên đăng nhập không được để trống");
                model.addAttribute("showToast", true);
                return false;
            }
            if(userRepository.findOneByUsername(registerDTO.getUsername())!= null){
                model.put("errorMessage", "Tên đăng nhập đã tồn tại!");
                model.addAttribute("showToast", true);
                return false;
            }
            if(!registerDTO.getPassword().isEmpty()){
                if(registerDTO.getPassword().length() < 6){
                    model.put("errorMessage", "Mật khẩu phải chứa từ 6 kí tự");
                    model.addAttribute("showToast", true);
                    return false;
                } else {
                    if (!registerDTO.getPassword().equals(request.getParameter("confirm_password"))) {
                        model.put("errorMessage", "Mật khẩu không khớp");
                        model.addAttribute("showToast", true);
                        return false;
                    }
                }
            } else {
                model.put("errorMessage", "Vui lòng nhập mật khẩu");
                model.addAttribute("showToast", true);
                return false;
            }

            if(registerDTO.getFullName().isEmpty()){
                model.put("errorMessage", "Vui lòng nhập Họ và tên");
                model.addAttribute("showToast", true);
                return false;
            }

            if(registerDTO.getCccd().isEmpty()){
                model.put("errorMessage", "Vui lòng nhập số CCCD/CMND/Hộ chiếu");
                model.addAttribute("showToast", true);
                return false;
            }
            if(!registerDTO.getCccd().matches("[0-9]+")&& registerDTO.getCccd().length()!=12){
                model.put("errorMessage", "Vui lòng nhập đúng số CCCD/CMND/Hộ chiếu");
                model.addAttribute("showToast", true);
                return false;
            }

            if(registerDTO.getAddress().isEmpty()){
                model.put("errorMessage", "Vui lòng nhập địa chỉ");
                model.addAttribute("showToast", true);
                return false;
            }

            if(registerDTO.getPhone().isEmpty()){
                model.put("errorMessage", "Vui lòng nhập số điện thoại");
                model.addAttribute("showToast", true);
                return false;
            }
            if(userRepository.existsByPhone(registerDTO.getPhone())){
                model.put("errorMessage", "Mỗi số điện thoại chỉ được đăng kí 1 lần");
                model.addAttribute("showToast", true);
                return false;
            }
            if(!registerDTO.getPhone().matches("[0-9]+")&&registerDTO.getPhone().length()!=10){
                model.put("errorMessage", "Số điện thoại sai định dạng");
                model.addAttribute("showToast", true);
                return false;
            }

            if(registerDTO.getEmail().isEmpty()){
                model.put("errorMessage", "Vui lòng nhập thư điện tử");
                model.addAttribute("showToast", true);
                return false;
            }

            if(userRepository.existsByEmail(registerDTO.getEmail())){
                model.put("errorMessage", "Mỗi email chỉ được đăng kí 1 lần");
                model.addAttribute("showToast", true);
                return false;
            }
            Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(registerDTO.getEmail());
            if(!matcher.matches()){
                model.put("errorMessage", "Vui lòng điền đúng định dạng thư điện tử");
                model.addAttribute("showToast", true);
                return false;
            }
        }
        return true;
    }
}
