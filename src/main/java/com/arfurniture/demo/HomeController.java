package com.arfurniture.demo;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
    @PostMapping("")
    public String createHome(@RequestBody List<Furniture> furniture) {
        Home home = new Home();
        System.out.println("Home id: " + home.getId());
        for (Furniture f : furniture) {
            // f.setHomeId(home.getId());
            System.out.println("Furniture id: " + f.getId() + " Position: " + f.getPosition());
        }
        return home.getId();
    }

    @GetMapping("/{id}")
    public Home getHome(@PathVariable String id) {
        Home home = new Home();
        home.setId(id);
        return home;
    }
}

