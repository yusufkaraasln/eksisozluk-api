package com.springboot.boilerplate.controllers;


import com.springboot.boilerplate.dtos.HeaderDTO;
import com.springboot.boilerplate.entities.Entry;
import com.springboot.boilerplate.entities.Header;
import com.springboot.boilerplate.requests.HeaderRequest;
import com.springboot.boilerplate.services.EntryService;
import com.springboot.boilerplate.services.HeaderService;
import com.springboot.boilerplate.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/header")
public class HeaderController {

    @Autowired
    private HeaderService headerService;

    @Autowired
    private EntryService entryService;

    @PostMapping
    public Result<Header> createHeader(@RequestBody HeaderRequest body) {
        return headerService.createHeader(body);
    }

    @GetMapping("/{id}")
    public Result<HeaderDTO> getHeader(@PathVariable int id) {
        return headerService.getHeader(id);
    }

    @PostMapping("/{id}")
    public Result<Entry> createEntry(@PathVariable int id, @RequestBody Entry body) {
        return entryService.createEntry(id, body);
    }


}
