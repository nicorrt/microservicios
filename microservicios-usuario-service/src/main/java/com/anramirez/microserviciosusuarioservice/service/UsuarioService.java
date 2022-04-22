package com.anramirez.microserviciosusuarioservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.anramirez.microserviciosusuarioservice.allModels.Coche;
import com.anramirez.microserviciosusuarioservice.allModels.Moto;
import com.anramirez.microserviciosusuarioservice.feignclients.CocheFeignClient;
import com.anramirez.microserviciosusuarioservice.feignclients.MotoFeignClient;
import com.anramirez.microserviciosusuarioservice.model.Usuario;
import com.anramirez.microserviciosusuarioservice.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private CocheFeignClient cocheFeingClient;

	@Autowired
	private MotoFeignClient motoFeignClient;

	/**
	 * Método que crea una comunicacion entre el microservicio de usuario con el
	 * metodo del microservicio de coches que devulve las coches de un usuario
	 * 
	 * @param usuarioId
	 * @return lista de coches
	 */
	public List<Coche> getCoches(int usuarioId) {
		List<Coche> coches = restTemplate.getForObject("http://localhost:8002/coche/usuario/" + usuarioId, List.class);
		return coches;
	}

	/**
	 * Método que crea una comunicacion entre el microservicio de usuario con el
	 * metodo del microservicio de moto que devuelve las motos de un usuario
	 * 
	 * @param usuarioId
	 * @return lista de motos
	 */
	public List<Moto> getMotos(int usuarioId) {
		List<Moto> motos = restTemplate.getForObject("http://localhost:8003/moto/usuario/" + usuarioId, List.class);
		return motos;
	}

	/**
	 * 
	 * @param usuarioId
	 * @param coche
	 * @return
	 */
	public Coche saveCoche(int usuarioId, Coche coche) {
		coche.setUsuarioId(usuarioId);
		Coche nuevoCoche = cocheFeingClient.save(coche);
		return nuevoCoche;
	}

	/**
	 * 
	 * @param usuarioId
	 * @param moto
	 * @return
	 */
	public Moto saveMoto(int usuarioId, Moto moto) {
		moto.setUsuarioId(usuarioId);
		Moto nuevaMoto = motoFeignClient.save(moto);
		return nuevaMoto;
	}

	public Map<String, Object> getUsuarioAndVehiculos(int usuarioId) {
		Map<String, Object> resultado = new HashMap<>();
		Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);

		if (usuario == null) {
			resultado.put("Mensaje", "El usuario no existe");
			return resultado;
		} else {
			List<Coche> coches = cocheFeingClient.getCoches(usuarioId);
			List<Moto> motos = motoFeignClient.getMotos(usuarioId);
			if (coches.isEmpty()) {
				resultado.put("Coches", "El usuario no tienes coches");
			} else {
				resultado.put("Coches: ", coches);
			}
			if (motos.isEmpty()) {
				resultado.put("Motos", "El usuario no tiene motos");
			} else {
				resultado.put("Motos: ", motos);
			}
			return resultado;
		}
	}

	public List<Usuario> getAll() {
		return usuarioRepository.findAll();
	}

	public Usuario getUsuarioById(int id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	public Usuario save(Usuario usuario) {
		Usuario nuevoUsuario = usuarioRepository.save(usuario);
		return nuevoUsuario;
	}
}
