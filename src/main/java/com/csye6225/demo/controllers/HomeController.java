package com.csye6225.demo.controllers;


import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
    jsonObject.addProperty("message", "Welcome to Home Page! Current time is " + new Date().toString());
    return jsonObject.toString();
  }

  @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
  @ResponseBody
  public String test() {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("message", "authorized for /test");
    return jsonObject.toString();
  }

  @RequestMapping(path="/register", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = "application/json") // Map ONLY GET Requests
  public @ResponseBody String addNewUser (@RequestBody user ua) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    List<user> ulist=(ArrayList<user>)userRepository.findAll();
    for(user u:ulist)
    {
      if(ua.getEmail().equals(u.getEmail()))
      {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("message", "User email already exists");
        return jsonObject.toString();
      }
    }
    userRepository.save(ua);
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("message", "User registered successfully");
    return jsonObject.toString();
  }

  @RequestMapping(path="/login", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = "application/json") // Map ONLY GET Requests
  public @ResponseBody String userLogin (@RequestBody user ual) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    List<user> ulist=(ArrayList<user>)userRepository.findAll();
    for(user ul:ulist)
    {
      if(ual.getEmail().equals(ul.getEmail()) && ual.getPassword().equals(ul.getPassword()))
      {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("message", "User Logged in successfully.Current time is " + new Date().toString());
        return jsonObject.toString();
      }
    }
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("message", "Login failed. Invalid credentials");
    return jsonObject.toString();
  }

}
