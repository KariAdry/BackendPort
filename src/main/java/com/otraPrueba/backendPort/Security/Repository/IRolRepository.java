package com.otraPrueba.backendPort.Security.Repository;

import com.otraPrueba.backendPort.Entity.Rol;
import com.otraPrueba.backendPort.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface IRolRepository extends JpaRepository<Rol, Integer>{
     
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
    
}
