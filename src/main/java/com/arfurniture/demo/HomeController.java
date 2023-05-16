package com.arfurniture.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
    
    @Autowired
    private FurnitureRepository furnitureRepository; // Furniture 엔티티를 다루는 Repository

    @Autowired
    private HomeRepository homeRepository; // Home 엔티티를 다루는 Repository

    @PostMapping("")
    public String createHome(@RequestBody List<Furniture> furniture) {

        Home home = new Home();
        homeRepository.save(home);
        // System.out.println("Home id: " + home.getId());
        for (Furniture f : furniture) {
            f.setHome(home);
            furnitureRepository.save(f);
            System.out.println("Furniture id: " + f.getId() + " Position: " + f.getPosition() + " Rotation: " + f.getRotation() + " Scale: " + f.getScale());
        }
        return home.getId();
    }

    @GetMapping("/{id}/furniture")
    public List<Furniture> getFurnitureByHomeId(@PathVariable String id) {
        return furnitureRepository.findByHomeId(id);
    }

    @GetMapping("")
    public String getTest() {
        return "now testing";
    }
}

