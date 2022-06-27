package com.fis.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/admin")
public class AdminController {
        @RequestMapping("/")
        @ResponseBody
        public String welcome() {
            return "Welcome admin";
        }

    @RequestMapping("/create")
    @PreAuthorize(value = ("hasRole('ADMIN')"))
    @ResponseBody
    public String dis() {
        return "create admin Example.";
    }



}
