package br.com.rhonan.noxml.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) final String error,
            @RequestParam(value = "logout", required = false) final String logout,
            final ModelMap model) {
        if (error != null) {
            model.addAttribute("error", "wrong_authentication");
        }

        if (logout != null) {
            model.addAttribute("msg", "successfully_logout");
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "login";
    }

    @RequestMapping(value = "/userLogout401", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public void logout401() {
    }

}
