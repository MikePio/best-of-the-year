package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
  @GetMapping("/")
  @ResponseBody
  public String PrintName(){

    final String titleHomePage = "Benvenuto! <br> Aggiungi \"/step1\" all'url ";

    return "<html><body><h1>" + titleHomePage + "</h1></body></html>";
  }

  @GetMapping("/step1")
  public String step1(Model model){
    
    final String name = "Michele";

    model.addAttribute("name", name);

    return "step-1";
  }
}
