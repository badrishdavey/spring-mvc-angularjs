package com.xvitcoder.angualrspringapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */
@Controller
@RequestMapping("/")
public class IndexController {
	



    @RequestMapping
    public String getIndexPage() {
        return "index";
    }
    
    @RequestMapping("/home/layout")
    public String getHomePartialPage() {
        return "home/layout";
    }

}
