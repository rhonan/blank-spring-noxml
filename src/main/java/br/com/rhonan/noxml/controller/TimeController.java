package br.com.rhonan.noxml.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TimeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndex(final ModelMap model) {
        model.addAttribute("time", new Date());
        return "index";
    }

}
