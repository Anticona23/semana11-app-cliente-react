package com.example.demo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Musico {

	private @Id @GeneratedValue Long id;
	private String nombre;

	private Musico() {}

	public Musico(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Musico musico = (Musico) o;
		return Objects.equals(id, musico.id) &&
			Objects.equals(nombre, musico.nombre);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, nombre);
	}

	@Override
	public String toString() {
		return "Musico{" +
			"id=" + id +
			", nombre='" + nombre + '\'' +
			'}';
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
