package com.okta.mongodb.springbootmongodbdocker.controller;

import com.okta.mongodb.springbootmongodbdocker.dao.FlipkartRepository;
import com.okta.mongodb.springbootmongodbdocker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/OrderService")
public class FlipkartOrderMgmtController {

    @Autowired
    private FlipkartRepository flipkartRepository;

    @PostMapping("/placedOrderNow")
    public String placeOrder(@RequestBody User user) {
        flipkartRepository.save(user);
        return "Order placed successfully...";
    }

    @GetMapping("/getUserByName/{userName}")
    public List<User> getUserByName(@PathVariable(value = "userName") String name) {
        return flipkartRepository.findByName(name);
    }

    @GetMapping("/getUserByAddress/{city}")
    public List<User> getUserByAddress(@PathVariable(value = "city") String city) {
        return flipkartRepository.findByCity(city);
    }

    @GetMapping("/test")
    public String test() {
        return "test success";
    }
}
