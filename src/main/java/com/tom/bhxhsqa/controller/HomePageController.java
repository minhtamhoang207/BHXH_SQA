package com.tom.bhxhsqa.controller;

import com.tom.bhxhsqa.common.Expense;
import com.tom.bhxhsqa.entity.Payment;
import com.tom.bhxhsqa.entity.User;
import com.tom.bhxhsqa.service.PaymentService;
import com.tom.bhxhsqa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Controller
public class HomePageController {
    @Autowired
    UserService userService;

    @Autowired
    PaymentService paymentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String init() {
        return "redirect:login";
    }

    @RequestMapping(value = "/homepage-personal", method = RequestMethod.GET)
    public String showHomePage(ModelMap model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(user== null){
            return "redirect:login";
        }
        model.put("userName", user.getFullName() );
        return "homepage-personal";
    }

    @RequestMapping(value = "/homepage-company", method = RequestMethod.GET)
    public String showPersonalInsurance(ModelMap model, HttpSession session) {
        if(session.getAttribute("user")== null){
            return "redirect:login";
        }
        Long userId = Long.parseLong(session.getAttribute("id").toString());
        User user = userService.findById(userId);
        List<User> users = userService.getUserByMaDonVi(user.getMaDonVi());
        model.addAttribute("users", users);
        return "homepage-company";
    }

    @RequestMapping(value = "/update-info-personal", method = RequestMethod.GET)
    public String showUpdateInfoPersonal(ModelMap model,HttpSession session) {
        model.addAttribute("showToast", false);
        if(session.getAttribute("user")== null){
            return "redirect:login";
        }
        Long userId = Long.parseLong(session.getAttribute("id").toString());
        User user = userService.findById(userId);
        System.out.println(user.getFullName());
        model.addAttribute("user",user);
        return "update-info-personal";
    }

    @RequestMapping(value = "/update-info-personal", method = RequestMethod.POST)
    public String updateInfoPersonal(
            ModelMap model,
            HttpSession session,
            HttpServletRequest request
    ) {
        if(session.getAttribute("user")== null){
            return "redirect:login";
        }
        User user = new User();
        user.setId(Long.parseLong(session.getAttribute("id").toString()));
        user.setFullName(request.getParameter("full_name"));
        user.setCccd(request.getParameter("citizen_id"));
        user.setAddress(request.getParameter("address"));
        user.setPhone(request.getParameter("phone_number"));
        user.setEmail(request.getParameter("email"));
        user.setCoQuanBaoHiemThanhPho(request.getParameter("cqbh"));
        user.setMaSoThue(request.getParameter("tax_code"));

        if(user.getFullName().isEmpty() ||
            user.getCccd().isEmpty() ||
            user.getAddress().isEmpty() ||
            user.getPhone().isEmpty() ||
            user.getEmail().isEmpty() ||
            user.getCoQuanBaoHiemThanhPho().isEmpty() ||
            user.getMaSoThue().isEmpty() ||
            request.getParameter("salary").isEmpty()) {

            model.put("errorMessage","Vui lòng nhập đầy đủ thông tin");
            model.addAttribute("showToast", true);
            return "update-info-personal";
        } else {
            if(Long.parseLong(request.getParameter("salary"))<= 0){
                model.put("errorMessage","Lương phải lớn hơn 0");
                model.addAttribute("showToast", true);
                return "update-info-personal";
            } else {
                user.setSalary(Long.parseLong(request.getParameter("salary")));
                userService.updateUserInfo(user);
                return "redirect:homepage-personal";
            }
        }
    }

    @RequestMapping(value = "/payment-personal", method = RequestMethod.GET)
    public String showPaymentPersonal(ModelMap model, HttpSession session) {
        if(session.getAttribute("user")== null){
            return "redirect:login";
        }
        User user = userService.findById(Long.valueOf(session.getAttribute("id").toString()));
        if (user.getSalary() == null ||
                user.getFullName() == null ||
                user.getCoQuanBaoHiemThanhPho() == null ||
                user.getAddress() == null ||
                user.getCccd() == null ||
                user.getEmail() == null ||
                user.getPhone() == null ||
                user.getMaSoThue() == null
        ){
            model.put("errorMessage", "Vui lòng cập nhật đầy đủ thông tin trước khi thanh toán");
            model.addAttribute("showToast", true);
            return "/homepage-personal";
        } else {
            model.addAttribute("user", user);
            double salary = Expense.tinhPhiBaoHiemCaNhan(user.getSalary());
            String transaction_code = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
            String currentDate = currentDate();
            model.put("disable_button_pay", false);
            model.put("transaction_code", transaction_code);
            model.put("payment_date", currentDate);

            Locale locale = new Locale("vn", "VN");
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
            System.out.println(currencyFormatter.format(salary));

            model.put("payment_amount", currencyFormatter.format(salary));
            return "payment-personal";
        }
    }

    String currentDate(){
        Date date = new Date();
        String strDateFormat = "dd/MM/yyyy";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        return dateFormat.format(date);
    }

    @RequestMapping(value = "/payment-personal", method = RequestMethod.POST)
    public void paymentPersonal(
            ModelMap model,
            HttpSession session,
            HttpServletRequest request
    ) {
        if(session.getAttribute("user")== null){
            return;
        }
        Payment payment = new Payment();
        User user = new User();
        user.setId(Long.parseLong(session.getAttribute("id").toString()));
        payment.setNganHang(request.getParameter("bank_name"));
        payment.setCode(request.getParameter("transaction_code"));
        payment.setLoaiGiaoDich(1);
        payment.setNoiDung(request.getParameter("content"));
        payment.setNgayThanhToan(request.getParameter("payment_date"));
        if(!request.getParameter("payment_amount").isEmpty()&&request.getParameter("payment_amount").matches("[0-9]+")){
            payment.setSoTien(Double.parseDouble((request.getParameter("payment_amount"))));
        } else {
            model.put("error_message", "Đã xảy ra lỗi");
        }
        if(!payment.getCode().isEmpty()){
            try {
                paymentService.thanhToan(payment);
                model.put("success_message", "Thanh toán thành công, nhấn để trờ về trang chủ");
            } catch (Exception e){
                model.put("error_message", "Đã xảy ra lỗi trong quá trình thanh toán");
            }
        }
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.GET)
    public String addUserToCompany(
            ModelMap model,
            HttpSession session
    ) {
        if(session.getAttribute("user")== null){
            return "redirect:login";
        }
        User user = (User) session.getAttribute("user");
        System.out.println("user: "+user.getIsCompanyAccount());
        if(user.getIsCompanyAccount()) {
            System.out.println("Error2 "+model.getAttribute("errorMessage"));
            return "add-user";
        }
        else
            return "redirect:homepage-personal";
    }

    @RequestMapping(value = {"/company-remove-user/{id}"}, method = RequestMethod.GET)
    public String removeUser(@PathVariable("id") Long id, ModelMap model, HttpSession session) {
        if(session.getAttribute("user")== null){
            return "redirect:login";
        }
        User userAcc = (User) session.getAttribute("user");
        System.out.println("user: "+userAcc.getIsCompanyAccount());
        if(userAcc.getIsCompanyAccount()) {
            Long userId = Long.parseLong(session.getAttribute("id").toString());
            User currentUser = userService.findById(userId);
            User user = userService.findById(id);
            Boolean result = userService.removeUser(currentUser, user);
            return "redirect:/homepage-company";
        }else {
            return "redirect:homepage-personal";
        }
    }

    @RequestMapping(value = {"/payment-company/{id}"}, method = RequestMethod.GET)
    public String addPayment(@PathVariable("id") Long id, ModelMap model,HttpSession session) {
        if(session.getAttribute("user")== null){
            return "redirect:login";
        }
        User userAcc = (User) session.getAttribute("user");
        System.out.println("user: "+userAcc.getIsCompanyAccount());
        if(userAcc.getIsCompanyAccount()) {
            User user = userService.findById(id);
            model.addAttribute("user", user);

            double salary = Expense.tinhPhiBaoHiemDN(user.getSalary());

            String transaction_code = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
            String currentDate = currentDate();
            model.put("transaction_code", transaction_code);
            model.put("payment_date", currentDate);
            model.put("payment_amount", NumberFormat.getCurrencyInstance(new Locale("vn", "VN"))
                    .format(salary));
            return "payment-company";
        } else
            return "redirect:homepage-personal";
    }

    @RequestMapping(value = {"/payment-company/{id}"}, method = RequestMethod.POST)
    public String updatePaymentToUser(@PathVariable("id") Long id, ModelMap model, HttpServletRequest request,
                                      HttpSession session) {
        if(session.getAttribute("user")== null){
            return "redirect:login";
        }
        User userAcc = (User) session.getAttribute("user");
        System.out.println("user: "+userAcc.getIsCompanyAccount());
        if(userAcc.getIsCompanyAccount()) {
            Payment payment = new Payment();
            User user = new User();
            user.setId(id);
            payment.setNganHang(request.getParameter("bank_name"));
            payment.setCode(request.getParameter("transaction_code"));
            payment.setLoaiGiaoDich(1);
            payment.setNoiDung(request.getParameter("content"));
            payment.setNgayThanhToan(request.getParameter("payment_date"));
            if (!request.getParameter("payment_amount").isEmpty()) {
                NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
                try {
                    double currencyDouble = currencyFormat.parse(request.getParameter("payment_amount")).doubleValue();
                    payment.setSoTien(currencyDouble);
                } catch (ParseException e) {
                    payment.setSoTien(0.0);
                }
            } else {
                model.put("error_message", "Đã xảy ra lỗi");
            }
            if (!payment.getCode().isEmpty()) {
                try {
                    paymentService.thanhToan(payment);
                    model.put("success_message", "Thanh toán thành công, nhấn để trờ về trang chủ");
                } catch (Exception e) {
                    model.put("error_message", "Đã xảy ra lỗi trong quá trình thanh toán");
                }
            }
            return "redirect:/homepage-company";
        }
        else {
            return "redirect:homepage-personal";
        }
    }

    @RequestMapping(value = {"/company-update-user/{id}"}, method = RequestMethod.GET)
    public String updateUser(@PathVariable("id") Long id, ModelMap model, HttpSession session  ) {
        if(session.getAttribute("user")== null){
            return "redirect:login";
        }
        User userAcc = (User) session.getAttribute("user");
        System.out.println("user: "+userAcc.getIsCompanyAccount());
        if(userAcc.getIsCompanyAccount()) {
            User user = userService.findById(id);
            model.addAttribute("user", user);
            return "update-user-company";
        }else {
            return "redirect:homepage-personal";
        }
    }

    @RequestMapping(value = {"/company-update-user/{id}"}, method = RequestMethod.POST)
    public String updateUserInfo(@PathVariable("id") Long id, ModelMap model,
                                 HttpServletRequest request, HttpSession session) {
        if(session.getAttribute("user")== null){
            return "redirect:login";
        }
        User userAcc = (User) session.getAttribute("user");
        System.out.println("user: "+userAcc.getIsCompanyAccount());
        if(userAcc.getIsCompanyAccount()) {
            User user = new User();
            user.setId(id);
            user.setFullName(request.getParameter("full_name"));
            user.setCccd(request.getParameter("citizen_id"));
            user.setAddress(request.getParameter("address"));
            user.setPhone(request.getParameter("phone_number"));
            user.setEmail(request.getParameter("email"));
            user.setCoQuanBaoHiemThanhPho(request.getParameter("cqbh"));
            user.setMaSoThue(request.getParameter("tax_code"));
            if(!request.getParameter("salary").isEmpty()) {
                if(Long.parseLong(request.getParameter("salary"))<= 0){
                    model.put("errorMessage", "Lương phải là 1 số dương");
                    model.addAttribute("showToast", true);
                    return "redirect:/company-update-user/{id}";
                } else {
                    user.setSalary(Long.parseLong(request.getParameter("salary")));
                }
            }

            if(user.getFullName().isEmpty()){
                model.put("errorMessage", "Vui lòng nhập tên nhân viên");
                model.addAttribute("showToast", true);
                return "redirect:/company-update-user/{id}";
            }


            if(!isValidateNum(user.getCccd()) && user.getCccd().length()!=12){
                model.put("errorMessage", "Vui lòng nhập đúng số CCCD!");
                model.addAttribute("showToast", true);
                return "redirect:/company-update-user/{id}";
            }
            if(user.getAddress().isEmpty()){
                model.put("errorMessage", "Vui lòng nhập địa chỉ!");
                model.addAttribute("showToast", true);
                return "redirect:/company-update-user/{id}";
            }

            if(user.getPhone().isEmpty()){
                model.put("errorMessage", "Số điện thoại không được bỏ trống");
                model.addAttribute("showToast", true);
                return "redirect:/company-update-user/{id}";
            }
            if(!isValidateNum(user.getPhone()) && user.getPhone().length()!=10){
                model.put("errorMessage", "Vui lòng nhập đúng số điện thoại!");
                model.addAttribute("showToast", true);
                return "redirect:/company-update-user/{id}";
            }

            if(user.getEmail().isEmpty()){
                model.put("errorMessage", "Vui lòng nhập email!");
                model.addAttribute("showToast", true);
                return "redirect:/company-update-user/{id}";
            }

            if(user.getCoQuanBaoHiemThanhPho().isEmpty()){
                model.put("errorMessage", "Vui lòng nhập tên cơ quan bảo hiểm!");
                model.addAttribute("showToast", true);
                return "redirect:/company-update-user/{id}";
            }
            if(user.getMaSoThue().isEmpty()){
                model.put("errorMessage", "Vui lòng nhập mã số thuế");
                model.addAttribute("showToast", true);
                return "redirect:/company-update-user/{id}";
            }

            if(user.getSalary() == null){
                model.put("errorMessage", "Vui lòng nhập lương nhân viên");
                model.addAttribute("showToast", true);
                return "redirect:/company-update-user/{id}";
            }

            if(user.getSalary() == 0){
                model.put("errorMessage", "Lương phải lớn hơn 0");
                model.addAttribute("showToast", true);
                return "redirect:/company-update-user/{id}";
            }

            userService.updateUserInfo(user);

            return "redirect:/homepage-company";
        }
        else {
            return "redirect:homepage-personal";
        }

    }
    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public String addUserToCompany(
            ModelMap model,
            HttpSession session,
            HttpServletRequest request
    ) {
        if(session.getAttribute("user")== null){
            return "redirect:login";
        }
        User userAcc = (User) session.getAttribute("user");
        System.out.println("user: "+userAcc.getIsCompanyAccount());
        if(userAcc.getIsCompanyAccount()) {
            String randomUsername = UUID.randomUUID().toString();
            randomUsername = randomUsername.substring(0, Math.min(randomUsername.length(), 8)).toUpperCase();
            String randomPassword = UUID.randomUUID().toString();
            randomPassword = randomPassword.substring(0, Math.min(randomPassword.length(), 8)).toUpperCase();
            User user = new User();
            Long companyAccountId = Long.parseLong(session.getAttribute("id").toString());

            user.setFullName(request.getParameter("full_name"));
            user.setCccd(request.getParameter("citizen_id"));
            user.setAddress(request.getParameter("address"));
            user.setPhone(request.getParameter("phone_number"));
            user.setEmail(request.getParameter("email"));
            user.setCoQuanBaoHiemThanhPho(request.getParameter("cqbh"));
            user.setMaSoThue(request.getParameter("tax_code"));
            if(!request.getParameter("salary").isEmpty()) {
                user.setSalary(Long.parseLong(request.getParameter("salary")));
            }
            user.setUsername(randomUsername);
            user.setPassword(randomPassword);
            user.setIsCompanyAccount(false);

            if(user.getFullName().isEmpty()){
                model.put("errorMessage", "Vui lòng nhập tên nhân viên");
                model.addAttribute("showToast", true);
                return "add-user";
            }


            if(!isValidateNum(user.getCccd()) && user.getCccd().length()!=12){
                model.put("errorMessage", "Vui lòng nhập đúng số CCCD!");
                model.addAttribute("showToast", true);
                return "add-user";
            }
            if(user.getAddress().isEmpty()){
                model.put("errorMessage", "Vui lòng nhập địa chỉ!");
                model.addAttribute("showToast", true);
                return "add-user";
            }

            if(user.getPhone().isEmpty()){
                model.put("errorMessage", "Số điện thoại không được bỏ trống");
                model.addAttribute("showToast", true);
                return "add-user";
            }
            if(!isValidateNum(user.getPhone()) && user.getPhone().length()!=10){
                model.put("errorMessage", "Vui lòng nhập đúng số điện thoại!");
                model.addAttribute("showToast", true);
                return "add-user";
            }

            if(user.getEmail().isEmpty()){
                model.put("errorMessage", "Vui lòng nhập email!");
                model.addAttribute("showToast", true);
                return "add-user";
            }

            if(user.getCoQuanBaoHiemThanhPho().isEmpty()){
                model.put("errorMessage", "Vui lòng nhập tên cơ quan bảo hiểm!");
                model.addAttribute("showToast", true);
                return "add-user";
            }
            if(user.getMaSoThue().isEmpty()){
                model.put("errorMessage", "Vui lòng nhập mã số thuế");
                model.addAttribute("showToast", true);
                return "add-user";
            }

            if(user.getSalary() == null){
                model.put("errorMessage", "Vui lòng nhập lương nhân viên");
                model.addAttribute("showToast", true);
                return "add-user";
            }

            if(user.getSalary() == 0){
                model.put("errorMessage", "Lương phải lớn hơn 0");
                model.addAttribute("showToast", true);
                return "add-user";
            }

            userService.addUserToCompany(user, companyAccountId);
            return "redirect:/homepage-company";
        } else {
            return "redirect:homepage-personal";
        }
    }

    private boolean isValidateNum(String num){
        return num.matches("[0-9]+");
    }
}
