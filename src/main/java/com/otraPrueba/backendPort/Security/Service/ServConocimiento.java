package com.otraPrueba.backendPort.Security.Service;

import com.otraPrueba.backendPort.Entity.Conocimientos;
import com.otraPrueba.backendPort.Repository.RepoConocimiento;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServConocimiento {
   @Autowired
  RepoConocimiento repoConocimiento;
   
   public List<Conocimientos>list()
   {
   return repoConocimiento.findAll();
   }
   
   public Optional<Conocimientos>getOne(int id)
   {
   return repoConocimiento.findById(id);
   }
   
   public Optional<Conocimientos>getByNombreCo(String nombreCo)
   {
   return repoConocimiento.findByNombreCo(nombreCo);
   }
   
    public void save(Conocimientos conoc)
   {
    repoConocimiento.save(conoc);
   }
   
    public void delete(int id)
    {
    repoConocimiento.deleteById(id);
    }         
        
    public boolean existsById(int id)
    {
    return repoConocimiento.existsById(id);
    }
    
    public boolean existsByNombreCo(String nombreCo)
    {
    return repoConocimiento.existsByNombreCo(nombreCo);
    }
}
