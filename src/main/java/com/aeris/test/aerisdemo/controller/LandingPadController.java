package com.aeris.test.aerisdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LandingPadController {


    @RequestMapping("/get-data")
    public String serviceGetData() {

        String responseStr;
        responseStr = " LandingPadController : get-data ";
        // Return

        return (responseStr);
    }


    @RequestMapping("/get-image")
    public String serviceGetImage() {

        String responseStr;
        responseStr = " LandingPadController : get-image ";
        System.out.println(responseStr);

        return (responseStr);
    }

    @RequestMapping("/get-info")
    public String serviceGetInfo() {

        String responseStr;

        responseStr = " LandingPadController : get-info ";
        System.out.println(responseStr);

        return (responseStr);
    }


}
