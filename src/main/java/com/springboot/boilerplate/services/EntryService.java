package com.springboot.boilerplate.services;

import com.springboot.boilerplate.entities.Entry;
import com.springboot.boilerplate.entities.Header;
import com.springboot.boilerplate.entities.User;
import com.springboot.boilerplate.repositories.EntryRepository;
import com.springboot.boilerplate.repositories.HeaderRepository;
import com.springboot.boilerplate.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EntryService {

    @Autowired
    public EntryRepository entryRepository;

    @Autowired
    public HeaderRepository headerRepository;

    @Autowired
    public AuthService authService;

    public Result<Entry> createEntry(Integer id, Entry body) {

        User user = authService.getUser().getData();
        Header header = headerRepository.findById(id).get();


        Entry entry = new Entry();
        entry.setHeader(header);
        entry.setContent(body.getContent());
        entry.setUser(user);
        entry.setCreatedAt(new Date());
        entry.setUpdatedAt(new Date());
        entryRepository.save(entry);

        return new Result<>(true, "success", entry);


    }


    public Result<Entry> getEntry(int id) {

        Entry entry = entryRepository.findById(id).get();
        return new Result<>(true, "success", entry);

    }

    public Result<Entry> deleteEntry(int id) {

        User user = authService.getUser().getData();
        Entry entry = entryRepository.findById(id).get();
        if (user.getId() != entry.getUser().getId()) {
            return new Result<>(false, "unauthorized", null);
        } else if (entry == null) {
            return new Result<>(false, "entry not found", null);
        }


        entryRepository.delete(entry);
        return new Result<>(true, "success", entry);
    }

    public Result<Entry> updateEntry(int id, Entry body) {

        User user = authService.getUser().getData();
        Entry entry = entryRepository.findById(id).get();
        if (user.getId() != entry.getUser().getId()) {
            return new Result<>(false, "unauthorized", null);
        } else if (entry == null) {
            return new Result<>(false, "entry not found", null);


        }
        entry.setContent(body.getContent());
        entry.setUpdatedAt(new Date());
        entryRepository.save(entry);

        return new Result<>(true, "success", entry);


    }


}
