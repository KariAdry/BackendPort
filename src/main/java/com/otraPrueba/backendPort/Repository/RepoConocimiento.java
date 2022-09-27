package com.otraPrueba.backendPort.Repository;

import com.otraPrueba.backendPort.Entity.Conocimientos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RepoConocimiento extends JpaRepository<Conocimientos, Integer>
    {
    public Optional <Conocimientos> findByNombreCo(String nombreCo);
    
    public boolean existsByNombreCo(String nombreCo);
    }  

