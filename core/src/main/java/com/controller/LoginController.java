package com.controller;

import com.core.entity.User;
import com.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Transactional
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserService userService;

    String randomName;

    public String randomName() {
        randomName = Math.random() * 1000 + "";
        return randomName;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(HttpSession session, HttpServletRequest request) {
        if (session.getAttribute("userName") == null || session.getAttribute("userName").equals("")) {
            request.setAttribute("checkName", randomName());
            return "login";
        }
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpSession session, HttpServletRequest request) {
        session.setAttribute("userName", "");
        request.setAttribute("checkName", randomName());
        return "login";
    }

    @RequestMapping(value = "/loginDeal", method = RequestMethod.POST)
    public String loginDeal(HttpSession session, HttpServletRequest request, User user) {
        String checkOption = request.getParameter(randomName);
        String userName = userService.checkLogin(user);
        if (userName.equals("") || checkOption == null) {
            request.setAttribute("checkName", randomName());
            return "login";
        }
        session.setAttribute("userName", userName);
        return "index";
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session, HttpServletRequest request) {
        userService.logout();
        session.setAttribute("userName", "");
        request.setAttribute("checkName", randomName());
        return "login";
    }

    @RequestMapping(value = "tcpProtocol", method = RequestMethod.GET)
    public String tcpProtocolIndex() {
        return "tcpProtocol/tcpIndex";
    }
}