package com.glassdoorbi.glassdoorbi.controller;

import java.io.File;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CollectionController {

  public static final String uploadingdir = System.getProperty("user.dir") + "/uploadingdir/";

  @RequestMapping({"/", "/hello"})
  public String hello(Model model,
      @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
    System.out.println("Hello being hit");
    model.addAttribute("name", name);
    return "add-collection";
  }

  @RequestMapping("/add")
  public String addcollection() {
    System.out.println("Add collection being called");
    return "add-collection";
  }

  @RequestMapping(method= RequestMethod.POST, value= "/add")
  public String addCollection (@RequestParam("file") MultipartFile[] files) {
    for(MultipartFile uploadedFile: files) {
      File file = new File(uploadingdir + uploadedFile.getOriginalFilename());
      try {
        uploadedFile.transferTo(file);

      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return "redirect/";
  }
}
