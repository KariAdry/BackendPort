package com.otraPrueba.backendPort.Repository;

import com.otraPrueba.backendPort.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoEducacion extends JpaRepository<Educacion, Integer>{
    public Optional <Educacion> findByNombreEdu(String nombreEdu);
    
    public boolean existsByNombreEdu(String nombreEdu);    
}
