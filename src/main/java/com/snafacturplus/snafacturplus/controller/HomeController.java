/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.snafacturplus.snafacturplus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author PCDeveloper
 */
@Controller
public class HomeController {
  @GetMapping("/")
    public String loginPage() {
        return "redirect:/login";
        //return "Home"; // login.html en templates
    }    
}
