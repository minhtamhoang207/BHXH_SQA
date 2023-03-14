package com.tom.bhxhsqa.controller;

import com.tom.bhxhsqa.entity.Payment;
import com.tom.bhxhsqa.entity.User;
import com.tom.bhxhsqa.repository.CompanyRepository;
import com.tom.bhxhsqa.repository.UserRepository;
import com.tom.bhxhsqa.service.PaymentService;
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
public class HomePageController {
    @Autowired
    UserService userService;

    @Autowired
    PaymentService paymentService;

    @RequestMapping(value = "/homepage-personal", method = RequestMethod.GET)
    public String showHomePage(ModelMap model) {
        return "homepage-personal";
    }

    @RequestMapping(value = "/homepage-company", method = RequestMethod.GET)
    public String showPersonalInsurance(ModelMap model) {
        return "homepage-company";
    }

    @RequestMapping(value = "/update-info-personal", method = RequestMethod.GET)
    public String showUpdateInfoPersonal(ModelMap model) {
        return "update-info-personal";
    }

    @RequestMapping(value = "/update-info-personal", method = RequestMethod.POST)
    public String updateInfoPersonal(
            ModelMap model,
            HttpSession session,
            HttpServletRequest request
    ) {
        User user = new User();
        user.setId(Long.parseLong(session.getAttribute("id").toString()));
        user.setFullName(request.getParameter("full_name"));
        user.setCccd(request.getParameter("citizen_id"));
        user.setAddress(request.getParameter("address"));
        user.setPhone(request.getParameter("phone_number"));
        user.setEmail(request.getParameter("email"));
        user.setCoQuanBaoHiemThanhPho(request.getParameter("cqbh"));
        user.setMaSoThue(request.getParameter("tax_code"));
        user.setSalary(Long.parseLong(request.getParameter("salary")));

        userService.updateUserInfo(user);
        return "update-info-personal";
    }

    @RequestMapping(value = "/payment-personal", method = RequestMethod.GET)
    public String showPaymentPersonal(ModelMap model) {
        return "payment-personal";
    }

    @RequestMapping(value = "/payment-personal", method = RequestMethod.POST)
    public void paymentPersonal(
            ModelMap model,
            HttpSession session,
            HttpServletRequest request
    ) {
        Payment payment = new Payment();
        User user = new User();
        user.setId(Long.parseLong(session.getAttribute("id").toString()));
        payment.setUser(user);
        payment.setChiNhanhNganHang(request.getParameter("branch"));
        payment.setLoaiGiaoDich(1);
        payment.setNganHang(request.getParameter("bank_name"));
        payment.setNoiDung(request.getParameter("content"));
        payment.setNgayThanhToan(request.getParameter("payment_date"));
        payment.setSoTien(Double.parseDouble(request.getParameter("payment_amount")));

        paymentService.thanhToan(payment);

    }
}
