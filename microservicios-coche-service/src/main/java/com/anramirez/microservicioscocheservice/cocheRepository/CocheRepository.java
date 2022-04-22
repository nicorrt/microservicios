package com.anramirez.microservicioscocheservice.cocheRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anramirez.microservicioscocheservice.model.Coche;

@Repository
public interface CocheRepository extends JpaRepository<Coche, Integer> {
	
	List<Coche> findByUsuarioId(int usuarioId);

}
