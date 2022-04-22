package com.anramirez.microserviciosusuarioservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anramirez.microserviciosusuarioservice.allModels.Coche;
import com.anramirez.microserviciosusuarioservice.allModels.Moto;
import com.anramirez.microserviciosusuarioservice.model.Usuario;
import com.anramirez.microserviciosusuarioservice.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<List<Usuario>> listarUsuarios() {
		List<Usuario> usuarios = usuarioService.getAll();

		if (usuarios.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(usuarios);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> obtenerUsuarios(@PathVariable("id") int id) {
		Usuario usuario = usuarioService.getUsuarioById(id);
		if (usuario == null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(usuario);
		}
	}

	@PostMapping
	public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usario) {
		Usuario nuevoUsuario = usuarioService.save(usario);
		return ResponseEntity.ok(nuevoUsuario);
	}

	/**
	 * Método que a través del id de un usuario te devuelve una lista de coches
	 * usando el microservicio de coches
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/coches/{usuarioId}")
	public ResponseEntity<List<Coche>> getCoches(@PathVariable("usuarioId") int id) {
		Usuario usuario = usuarioService.getUsuarioById(id);
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		} else {
			List<Coche> coches = usuarioService.getCoches(id);
			return ResponseEntity.ok(coches);
		}
	}

	/**
	 * Método que a través de la id del usuario te devuelve una lista de motos
	 * usando el microservicio de motos
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/motos/{usuarioId}")
	public ResponseEntity<List<Moto>> getMotos(@PathVariable("usuarioId") int id) {
		Usuario usuario = usuarioService.getUsuarioById(id);
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		} else {
			List<Moto> motos = usuarioService.getMotos(id);
			return ResponseEntity.ok(motos);
		}

	}

	/**
	 * Método que guarda un coche a través del microservicio de Coches
	 * 
	 * @param usuarioId
	 * @param coche
	 * @return
	 */
	@PostMapping("/coche/{usuarioId}")
	public ResponseEntity<Coche> guardarCoche(@PathVariable("usuarioId") int usuarioId, @RequestBody Coche coche) {
		Coche nuevoCoche = usuarioService.saveCoche(usuarioId, coche);
		return ResponseEntity.ok(nuevoCoche);
	}

	/**
	 * Método que guarda una moto a través del microservicio de Motos
	 * 
	 * @param usuarioId
	 * @param moto
	 * @return
	 */
	@PostMapping("/moto/{usuarioId}")
	public ResponseEntity<Moto> guardarMoto(@PathVariable("usuarioId") int usuarioId, @RequestBody Moto moto) {
		Moto nuevaMoto = usuarioService.saveMoto(usuarioId, moto);
		return ResponseEntity.ok(nuevaMoto);
	}

	/**
	 * Método que usa el microservicio de motos y coches para realizar una lista de
	 * ambos vehículos
	 * 
	 * @param usuarioId
	 * @return
	 */
	@GetMapping("/todos/{usuarioId}")
	public ResponseEntity<Map<String, Object>> listarTodosLosVehiculos(@PathVariable("usuarioId") int usuarioId) {
		Map<String, Object> resultado = usuarioService.getUsuarioAndVehiculos(usuarioId);
		return ResponseEntity.ok(resultado);
	}

}
