package com.thoughtworks.rachael.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rachael")
public class RachaelController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public String rachael() {
        return "rachael";
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{name}")
    public String callName(@PathVariable("name") String name) {
        return name;
    }
}
