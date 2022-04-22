package com.anramirez.microservicioscocheservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anramirez.microservicioscocheservice.cocheRepository.CocheRepository;
import com.anramirez.microservicioscocheservice.model.Coche;


@Service
public class CocheService {
	
	
	@Autowired
	private CocheRepository cocheRepository;
	
	public List<Coche> getAll(){
		return cocheRepository.findAll();
	}
	
	public Coche getCocheById(int id) {
		return cocheRepository.findById(id).orElse(null);
	}
	
	public Coche save (Coche coche) {
		Coche nuevoCoche = cocheRepository.save(coche);
		return nuevoCoche;
	}
	
	public List<Coche> byUsuario(int usuarioId){
		return cocheRepository.findByUsuarioId(usuarioId);
	}
}
