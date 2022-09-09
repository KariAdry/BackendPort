package com.otraPrueba.backendPort.Security.Repository;

import com.otraPrueba.backendPort.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
    
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);

    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);
    
    
}
