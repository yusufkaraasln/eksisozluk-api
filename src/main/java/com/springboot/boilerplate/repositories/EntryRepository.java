package com.springboot.boilerplate.repositories;

import com.springboot.boilerplate.entities.Entry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EntryRepository extends CrudRepository<Entry, Integer> {

    public List<Entry> findAllByHeaderId(Integer headerId);

}
