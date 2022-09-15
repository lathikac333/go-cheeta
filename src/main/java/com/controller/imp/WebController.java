package com.controller.imp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    
    @RequestMapping(value = "/index")
   public String index() {
      return "index";
   }

   @RequestMapping(value = "/customer")
   public String customer()
   {
      return "customer";
   }

   @RequestMapping(value = "/driver")
   public String driver()
   {
      return "driver";
   }

   @RequestMapping(value = "/admin")
   public String admin()
   {
      return "admin";
   }
}
