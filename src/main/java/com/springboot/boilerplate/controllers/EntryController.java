package com.springboot.boilerplate.controllers;


import com.springboot.boilerplate.entities.Entry;
import com.springboot.boilerplate.services.EntryService;
import com.springboot.boilerplate.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/entry")
public class EntryController {


    @Autowired
    private EntryService entryService;

    @GetMapping("/{id}")
    public Result<Entry> getEntry(@PathVariable int id) {
        return entryService.getEntry(id);
    }


    @DeleteMapping("/{id}")

    public Result<Entry> deleteEntry(@PathVariable int id) {
        return entryService.deleteEntry(id);
    }

    @PutMapping("/{id}")
    public Result<Entry> updateEntry(@PathVariable int id, @RequestBody Entry body) {
        return entryService.updateEntry(id, body);
    }


}
