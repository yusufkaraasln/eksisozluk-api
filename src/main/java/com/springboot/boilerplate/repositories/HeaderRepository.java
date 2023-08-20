package com.springboot.boilerplate.repositories;

import com.springboot.boilerplate.entities.Header;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.List;


@Repository
public interface HeaderRepository extends CrudRepository<Header, Integer> {


}
