package com.exprivia.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.exprivia.entity.Contatto;


public interface ContattoRepository extends CrudRepository<Contatto, String> {

    Optional<Contatto> findById(String cognome);

    List<Contatto> findByNome(String nome);

    List<Contatto> findAll();

}
