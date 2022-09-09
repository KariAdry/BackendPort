
package com.otraPrueba.backendPort.Security.Service;

import com.otraPrueba.backendPort.Entity.Educacion;
import com.otraPrueba.backendPort.Repository.RepoEducacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServEducacion {
 @Autowired
         
 RepoEducacion repoEducacion;
 
 public List<Educacion> list(){
     return repoEducacion.findAll();
 }
 
 public Optional<Educacion>getOne(int id){
     return repoEducacion.findById(id);
 }
 
 public Optional<Educacion> getByNombreEdu(String nombreEdu){
 return repoEducacion.findByNombreEdu(nombreEdu);
 }
 
 public void save(Educacion educ){
   repoEducacion.save(educ);
 }
 
 public void delete(int id){
 repoEducacion.deleteById(id);
 }
 
 public boolean existById(int id ){
 return repoEducacion.existsById(id);
 }
 
 public boolean existByNombreEdu(String nombreEdu){
 return repoEducacion.existsByNombreEdu(nombreEdu);
 }
 
}
