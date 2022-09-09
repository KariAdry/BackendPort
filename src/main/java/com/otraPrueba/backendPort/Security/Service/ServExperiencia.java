package com.otraPrueba.backendPort.Security.Service;

import com.otraPrueba.backendPort.Entity.Experiencia;
import com.otraPrueba.backendPort.Repository.RepoExperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServExperiencia {
 @Autowired
 
 RepoExperiencia repoExperiencia;
 
 public List<Experiencia>list()
 {
  return repoExperiencia.findAll();
 }
 
 public Optional<Experiencia> getOne(int id)
 {
 return repoExperiencia.findById(id);
 } 
 
 public Optional<Experiencia> getByNombreExp(String nombreExp)
 {
 return repoExperiencia.findByNombreExp(nombreExp);
 }   
 
 public void save(Experiencia exper)
 {
  repoExperiencia.save(exper);
 }   
 
 public void delete(int id)
 {
 repoExperiencia.deleteById(id);
 }     
 
 public boolean existsById(int id)
 {
 return repoExperiencia.existsById(id);
 } 
 
 public boolean existsByNombreExp(String NombreExp)
 {
 return repoExperiencia.existsByNombreExp(NombreExp);
 }        
         
}
