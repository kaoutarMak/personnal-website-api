package com.example.demo.controller;


import com.example.demo.model.ContactMessage;
import com.example.demo.service.MailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ResumeController {

    @Autowired
    private MailService mailService;

    @Autowired
    private ContactMessage contactMessage;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/api/v1/myResume")
    public @ResponseBody
    Object getResume() {
        Resource resource = new ClassPathResource("/static/data.json");
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(resource.getInputStream(), Object.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping(path= "/api/v1/contactMe", consumes= MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public String contactMe(@RequestBody ContactMessage message) {
        this.mailService.sendEmail(message);

        return "Congratulations! Your mail has been send to Kaoutar MAKDAD.";
    }

}