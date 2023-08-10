package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
    
@Component 
public class DatabaseLoader implements CommandLineRunner { 

	private final InstrumentoRepository repositoryA;
	private final MusicoRepository repositoryB;

	@Autowired 
	public DatabaseLoader(InstrumentoRepository repositoryA, MusicoRepository repositoryB) {
		this.repositoryA = repositoryA;
		this.repositoryB = repositoryB;
	}

	@Override
	public void run(String... strings) throws Exception { 
		this.repositoryA.save(new Instrumento("Gitarra", "Cuerda", "Caja de madera con cuerdas"));
		this.repositoryA.save(new Instrumento("Bajo", "Cuerda", "Gitarra electrica"));
		this.repositoryA.save(new Instrumento("Flauta", "Viento", "Tubo con huecos"));
		this.repositoryB.save(new Musico("Juan Gabriel"));
	}
}