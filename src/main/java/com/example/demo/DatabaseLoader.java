package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
    
@Component 
public class DatabaseLoader implements CommandLineRunner { 

	private final InstrumentoRepository repository;

	@Autowired 
	public DatabaseLoader(InstrumentoRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) throws Exception { 
		this.repository.save(new Instrumento("Gitarra", "Cuerda", "Caja de madera con cuerdas"));
		this.repository.save(new Instrumento("Bajo", "Cuerda", "Gitarra electrica"));
		this.repository.save(new Instrumento("Flauta", "Viento", "Tubo con huecos"));
	}
}