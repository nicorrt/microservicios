package com.anramirez.microserviciosusuarioservice.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.anramirez.microserviciosusuarioservice.allModels.Coche;

@FeignClient(name = "coche-service", url = "http://localhost:8002", path = "/coche")
public interface CocheFeignClient {

	@PostMapping()
	public Coche save(@RequestBody Coche coche);

	@GetMapping("/usuario/{usuarioId}")
	public List<Coche> getCoches(@PathVariable("usuarioId") int usuarioId);
}
