package com.company.controller;

import com.company.entity.User;
import com.company.formObject.UserForm;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    private UserServiceInter service;

    @RequestMapping(method = RequestMethod.GET, value = "users")
    public String index(@RequestParam(value = "name", required = false) String name,
                        @RequestParam(value = "surname", required = false) String surname) {
        try {
            List<User> list = service.searchingUsers(name, surname);

            if (list.isEmpty()) {
                throw new IllegalArgumentException("There is not user with this name/surname");
            } else {
                ModelAndView mv = new ModelAndView("users");
                mv.addObject("list", list);
            }
        } catch (Exception ex) {
        }
        return "users";
    }

    @ModelAttribute("user")
    public UserForm getUserForm() {
        return new UserForm();
    }

    @RequestMapping(method = RequestMethod.GET, value = "usersm")
    public String indexM(@ModelAttribute("user") UserForm u) {
        try {
            List<User> list = service.searchingUsers(u.getName(), u.getSurname());

            if (list.isEmpty()) {
                throw new IllegalArgumentException("There is not user with this name/surname");
            } else {
                ModelAndView mv = new ModelAndView("users");
                mv.addObject("list", list);
            }
        } catch (Exception ex) {
        }
        return "users";
    }
}
