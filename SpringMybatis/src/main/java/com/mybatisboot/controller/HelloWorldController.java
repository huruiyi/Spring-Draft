package com.mybatisboot.controller;

import com.mybatisboot.entity.User;
import com.mybatisboot.entity.UserProfile;
import com.mybatisboot.service.UserProfileService;
import com.mybatisboot.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
public class HelloWorldController {
    protected final Logger logger = LogManager.getLogger(this.getClass().getName());

    @Autowired
    UserProfileService userProfileService;

    @Autowired
    UserService userService;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("greeting", "Hi, Welcome to mysite");
        mv.setViewName("welcome");
        return mv;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminPage() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", getPrincipal());
        mv.setViewName("admin");
        return mv;
    }

    @RequestMapping(value = "/dba", method = RequestMethod.GET)
    public ModelAndView dbaPage(ModelMap model) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", getPrincipal());
        mv.setViewName("dba");
        return mv;
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public ModelAndView accessDeniedPage(ModelMap model) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("accessDenied");
        model.addAttribute("user", getPrincipal());
        return mv;
    }

    @RequestMapping(value = "/loginpage", method = RequestMethod.GET)
    public ModelAndView loginPage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/loginpage?logout");
        return mv;
    }


    @RequestMapping(value = "/newUser", method = RequestMethod.GET)
    public ModelAndView newRegistration(Model model) {
        ModelAndView mv = new ModelAndView();
        User user = new User();
        model.addAttribute("user", user);
        mv.setViewName("newuser");
        return mv;
    }


    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public ModelAndView saveRegistration(@Valid @ModelAttribute("user") User user,
                                         BindingResult result, ModelMap model) {
        ModelAndView mv = new ModelAndView();
        if (result.hasErrors()) {
            mv.setViewName("newuser");
            logger.info("There are errors");
            return mv;
        }
        userService.save(user);

        logger.info("First Name : {}", user.getFirstName());
        logger.info("Last Name : {}", user.getLastName());
        logger.info("SSO ID : {}", user.getSsoId());
        logger.info("Password : {}", user.getPassword());
        logger.info("Email : {}", user.getEmail());
        logger.info("Checking UsrProfiles....");
        if (user.getUserProfiles() != null) {
            for (UserProfile profile : user.getUserProfiles()) {
                logger.info("Profile : " + profile.getType());
            }
        }

        model.addAttribute("success", "User " + user.getFirstName() + " has been registered successfully");
        mv.setViewName("registrationsuccess");
        return mv;
    }


    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }


    @ModelAttribute("roles")
    public List<UserProfile> initializeProfiles() {
        return userProfileService.findAll();
    }

}