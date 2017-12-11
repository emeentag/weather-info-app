package com.care.app.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * AppController
 */
@RestController
public class AppController {

  public ModelAndView getIndex(ModelAndView mav) {

    mav.setViewName("index");

    return mav;
  }
}