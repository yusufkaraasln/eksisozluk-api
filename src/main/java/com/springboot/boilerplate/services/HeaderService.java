package com.springboot.boilerplate.services;

import com.springboot.boilerplate.dtos.HeaderDTO;
import com.springboot.boilerplate.entities.Entry;
import com.springboot.boilerplate.entities.Header;
import com.springboot.boilerplate.entities.User;
import com.springboot.boilerplate.repositories.EntryRepository;
import com.springboot.boilerplate.repositories.HeaderRepository;
import com.springboot.boilerplate.requests.HeaderRequest;
import com.springboot.boilerplate.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

@Service
public class HeaderService {


    @Autowired
    private HeaderRepository headerRepository;

    @Autowired
    private EntryRepository entryRepository;

    @Autowired
    private AuthService authService;

    public Result<Header> createHeader(HeaderRequest body) {

        User user = authService.getUser().getData();
        Header header = new Header();
        header.setTitle(body.getTitle());
        headerRepository.save(header);

        Entry entry = new Entry();
        entry.setHeader(header);
        entry.setUser(user);
        entry.setContent(body.getContent());
        entryRepository.save(entry);
        header.setEntries(new ArrayList<>(Arrays.asList(entry)));


        return new Result<>(true, "success", header);


    }

    public Result<HeaderDTO> getHeader(int id) {

        Optional<Header> header = headerRepository.findById(id);

        header.get().setEntries(entryRepository.findAllByHeaderId(id));

        if (header.isEmpty()) {
            return new Result<>(false, "header not found", null);
        }

        HeaderDTO headerDTO = new HeaderDTO();
        headerDTO.setHeader(header.get().getTitle());
        headerDTO.setEntries(header.get().getEntries());

        return new Result<>(true, "success", headerDTO);

    }

}
