package com.arfurniture.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/home")
public class HomeController {
    
    @Autowired
    private FurnitureRepository furnitureRepository; // Furniture 엔티티를 다루는 Repository

    @Autowired
    private HomeRepository homeRepository; // Home 엔티티를 다루는 Repository


    @PostMapping("")
    public ResponseEntity<String> createHome(@RequestBody JsonNode requestBody) {
        List<Furniture> furnitureList = new ArrayList<>();

        Home home = new Home();
        homeRepository.save(home);

        for (JsonNode itemNode : requestBody.get("saveItems")) {
            JsonNode itemPrefabNode = itemNode.get("itemPrefab");
            JsonNode nameNode = itemNode.get("name");
            JsonNode positionNode = itemNode.get("position");
            JsonNode scaleNode = itemNode.get("scale");
            JsonNode rotationNode = itemNode.get("rotation");

            int m_FileID = itemPrefabNode.get("m_FileID").asInt();
            int m_PathID = itemPrefabNode.get("m_PathID").asInt();

            String name = nameNode.asText();

            double positionX = positionNode.get("x").asDouble();
            double positionY = positionNode.get("y").asDouble();
            double positionZ = positionNode.get("z").asDouble();

            double scaleX = scaleNode.get("x").asDouble();
            double scaleY = scaleNode.get("y").asDouble();
            double scaleZ = scaleNode.get("z").asDouble();

            double rotationX = rotationNode.get("x").asDouble();
            double rotationY = rotationNode.get("y").asDouble();
            double rotationZ = rotationNode.get("z").asDouble();
            double rotationW = rotationNode.get("w").asDouble();

            Furniture furniture = new Furniture(m_FileID, m_PathID, name, positionX, positionY, positionZ, scaleX, scaleY, scaleZ, rotationX, rotationY, rotationZ, rotationW, home);
            furnitureList.add(furniture);
        }

        for (Furniture furniture : furnitureList) {
            furniture.setHome(home);
            furnitureRepository.save(furniture);

            System.out.println("Furniture id: " + furniture.getId() + " m_FileID: " + furniture.getM_FileID() + " m_PathID: " + furniture.getM_PathID() + " Name: " + furniture.getName() + " Position: " + furniture.getPositionX()
                    + ", " + furniture.getPositionY() + ", " + furniture.getPositionZ() + " Scale: "
                    + furniture.getScaleX() + ", " + furniture.getScaleY() + ", " + furniture.getScaleZ()
                    + " Rotation: " + furniture.getRotationX() + ", " + furniture.getRotationY() + ", "
                    + furniture.getRotationZ() + ", " + furniture.getRotationW());
        }

        return new ResponseEntity<>(String.valueOf(home.getId()), HttpStatus.OK);
    }

    // @GetMapping("furniture/{id}")
    // public List<Furniture> getFurnitureByHomeId(@PathVariable String id) {
    //     return furnitureRepository.findByHomeId(id);
    // }
    @GetMapping("furniture/{id}")
    public ResponseEntity<JsonNode> getFurnitureByHomeId(@PathVariable String id) {
    List<Furniture> furnitureList = furnitureRepository.findByHomeId(id);

    ObjectMapper objectMapper = new ObjectMapper();
    ArrayNode saveItems = objectMapper.createArrayNode();

    for (Furniture furniture : furnitureList) {
        ObjectNode itemNode = objectMapper.createObjectNode();

        ObjectNode itemPrefabNode = objectMapper.createObjectNode();
        itemPrefabNode.put("m_FileID", furniture.getM_FileID());
        itemPrefabNode.put("m_PathID", furniture.getM_PathID());
        itemNode.set("itemPrefab", itemPrefabNode);

        itemNode.put("name", furniture.getName());

        ObjectNode positionNode = objectMapper.createObjectNode();
        positionNode.put("x", furniture.getPositionX());
        positionNode.put("y", furniture.getPositionY());
        positionNode.put("z", furniture.getPositionZ());
        itemNode.set("position", positionNode);

        ObjectNode scaleNode = objectMapper.createObjectNode();
        scaleNode.put("x", furniture.getScaleX());
        scaleNode.put("y", furniture.getScaleY());
        scaleNode.put("z", furniture.getScaleZ());
        itemNode.set("scale", scaleNode);

        ObjectNode rotationNode = objectMapper.createObjectNode();
        rotationNode.put("x", furniture.getRotationX());
        rotationNode.put("y", furniture.getRotationY());
        rotationNode.put("z", furniture.getRotationZ());
        rotationNode.put("w", furniture.getRotationW());
        itemNode.set("rotation", rotationNode);

        saveItems.add(itemNode);
    }

    ObjectNode responseBody = objectMapper.createObjectNode();
    responseBody.set("saveItems", saveItems);

    return new ResponseEntity<>(responseBody, HttpStatus.OK);
}

    // remove by id
    @PostMapping("furniture/{id}")
    public void removeFurnitureByHomeId(@PathVariable String id) {
        List<Furniture> furnitureList = furnitureRepository.findByHomeId(id);
        for (Furniture f : furnitureList) {
            furnitureRepository.delete(f);
        }
        homeRepository.delete(homeRepository.findById(id).get());
    }

    @GetMapping("")
    public String getTest() {
        return "now testing";
    }
}

