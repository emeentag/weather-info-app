package com.care.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * AppController
 */
@Controller
@RequestMapping("/")
public class AppController {

  @GetMapping
  public ModelAndView getIndex(ModelAndView mav) {

    mav.setViewName("index");

    return mav;
  }
}