package com.mysql.publicationmanagement.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/")
public class HomeController {

    @Value("${app.version}")
    private String appversion;

    @GetMapping
    public Map getVersion(){
        System.out.println("home");
        Map appv=new HashMap<String,String>();
        appv.put("Application Version",appversion);
        return appv;

    }
}
