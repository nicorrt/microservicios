package com.anramirez.microservicioscocheservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anramirez.microservicioscocheservice.model.Coche;
import com.anramirez.microservicioscocheservice.service.CocheService;

@RestController
@RequestMapping("/coche")
public class CocheController {

	@Autowired
	private CocheService cocheService;

	@GetMapping
	public ResponseEntity<List<Coche>> listarCoches() {
		List<Coche> coches = cocheService.getAll();

		if (coches.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(coches);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Coche> obtenerCoches(@PathVariable("id") int id) {
		Coche coche = cocheService.getCocheById(id);
		if (coche == null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(coche);
		}
	}

	@PostMapping
	public ResponseEntity<Coche> guardarCoche(@RequestBody Coche coche) {
		Coche nuevoCoche = cocheService.save(coche);
		return ResponseEntity.ok(nuevoCoche);
	}

	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Coche>> listarCochesPorUsuariosId(@PathVariable("usuarioId") int usuarioId) {
		List<Coche> coches = cocheService.byUsuario(usuarioId);
		if (coches.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(coches);
		}
	}

}
