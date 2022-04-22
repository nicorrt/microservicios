package com.anramirez.microserviciosusuarioservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anramirez.microserviciosusuarioservice.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer > {

}
