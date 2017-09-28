package com.csye6225.demo.controllers;


import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.*;

@Controller
public class HomeController {

  private final static Logger logger = LoggerFactory.getLogger(HomeController.class);

  @Autowired
  private UserRepository userRepository;

  @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
  @ResponseBody
  public String welcome(HttpServletRequest req) {

    JsonObject jsonObject = new JsonObject();

   // List<user> users = userRepository.findAll();

    String username = req.getParameter("email");
    String password = req.getParameter("password");

   Iterable <user> users = userRepository.findAll();
   int count =0;

    for(user u:users){

      if(u.getEmail().equals(username) && u.getPassword().equalsIgnoreCase(password)){

        jsonObject.addProperty("message", "you are logged in. current time is " + new Date().toString());
      }

      else{
        jsonObject.addProperty("message", "you are not logged in!!!");
      }
count++;
    }

    if(count==0){
      jsonObject.addProperty("message", "you are not logged in!!!");
    }


/*
    if (SecurityContextHolder.getContext().getAuthentication() != null
        && SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken) {
      jsonObject.addProperty("message", "you are not logged in!!!");
    } else {
      jsonObject.addProperty("message", "you are logged in. current time is " + new Date().toString());
    }*/

    return jsonObject.toString();
  }

  @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
  @ResponseBody
  public String test() {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("message", "authorized for /test");
    return jsonObject.toString();
  }
  @RequestMapping(path="/register", method = RequestMethod.POST) // Map ONLY GET Requests
  public @ResponseBody String addNewUser (@RequestParam String name
          , @RequestParam String email, @RequestParam String password) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    user n = new user();
    n.setName(name);
    n.setEmail(email);
    n.setPassword(password);
    userRepository.save(n);
    return "Saved";
  }

}
