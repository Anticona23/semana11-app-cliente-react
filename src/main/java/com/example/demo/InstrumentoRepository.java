package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="instrumentos", path="instrumentos")
public interface InstrumentoRepository extends CrudRepository<Instrumento, Long> { 

}