package com.arfurniture.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTestController {
    
    @RequestMapping("/restTest")
    public String restTest(@RequestParam String str){
        return str + " : Rest Test 완료!!!";
    }
    
    @RequestMapping("/User")
    public String User(@RequestParam Integer id){
        return id + " : User 정보를 가져옵니다.";
    }
}