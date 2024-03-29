package com.tom.bhxhsqa.model;

import com.tom.bhxhsqa.entity.User;
import com.tom.bhxhsqa.repository.UserRepository;
import com.tom.bhxhsqa.service.UserService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestCapNhatUser {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Test
    @Order(1)
    public void testCreate() {
        User user = new User();
        user.setUsername("tamhm1");
        user.setPassword("12345678");
        user.setFullName("Hoang Minh Tam");
        user.setCccd("31827391739812");
        user.setAddress("Lang Son city");
        user.setPhone("0375266302");
        user.setEmail("minhtamhoang207@gmail.com");
        user.setIsCompanyAccount(false);

        try {
            if(userRepository.findByUsername("tamhm").isPresent()){
                throw(new RuntimeException("Error: Tên đăng nhập đã được sử dụng"));
            }
            userRepository.save(user);
            assertNotNull(userRepository.findById(user.getId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(2)
    public void testFindUser() {
        User user = new User();
        try {
            user = userRepository.findOneByUsername("tamhm1");
            assertNotNull(user);
            assertEquals(user.getUsername(), "tamhm1");
            assertEquals(user.getCccd(), "31827391739812");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(3)
    public void testUpdate() {
        User user = userRepository.findOneByUsername("tamhm1");
        user.setId(user.getId());
        user.setCccd("020207001111");
        user.setAddress("Lang Son");
        user.setIsCompanyAccount(false);

        try {
            userService.updateUserInfo(user);
            assertNotNull(user);
            assertEquals(user.getUsername(), "tamhm1");
            assertEquals(user.getCccd(), "020207001111");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(4)
    public void testFindUserUpdated() {
        User user = new User();
        try {
            user = userRepository.findOneByUsername("tamhm1");
            assertNotNull(user);
            assertEquals(user.getUsername(), "tamhm1");
            assertEquals(user.getCccd(), "020207001111");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(5)
    public void testDelete() {
        try {
            User user = userRepository.findOneByUsername("tamhm1");
            userRepository.deleteById(user.getId());
            assertFalse(userRepository.existsById(user.getId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    @Order(6)
    public void testDeleteSuccess() {
        User user;
        try {
            user = userRepository.findOneByUsername("tamhm1");
            assertNull(user.getUsername(), "tamhm1");
            assertNull(user.getCccd(), "020207001111");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
