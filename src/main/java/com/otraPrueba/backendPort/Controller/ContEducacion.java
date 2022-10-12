package com.otraPrueba.backendPort.Controller;

import com.otraPrueba.backendPort.Entity.Educacion;
import com.otraPrueba.backendPort.JDTO.DtoEducacion;
import com.otraPrueba.backendPort.Security.Controller.Mensaje;
import com.otraPrueba.backendPort.Security.Service.ServEducacion;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/educacion")
@CrossOrigin (origins = "http://localhost:4200")
public class ContEducacion 
{
 @Autowired
 ServEducacion servEducacion;
 
 @GetMapping("/lista")
 public ResponseEntity<List<Educacion>>list()
 {
 List<Educacion>list = servEducacion.list();
 return new ResponseEntity(list, HttpStatus.OK);
 }
 
 @GetMapping("/detail/{id}")
 public ResponseEntity<Educacion>getById(@PathVariable("id")int id)
 {
 if(!servEducacion.existById(id))
 {
     return new ResponseEntity(new Mensaje("El Id no existe"),HttpStatus.NOT_FOUND);
 }    
 Educacion educacion = servEducacion.getOne(id).get();
 return new ResponseEntity(educacion,HttpStatus.OK);
 }
 
 @DeleteMapping("/delete/{id}")
 public ResponseEntity<Educacion>delete(@PathVariable("id")int id)
 {
 if(!servEducacion.existById(id))
 {
     return new ResponseEntity(new Mensaje("El id no existe"),HttpStatus.BAD_REQUEST);
 }   
 servEducacion.delete(id);
 return new ResponseEntity(new Mensaje("La instruccion ha sido eliminada"),HttpStatus.OK);
 }   
 
 @PostMapping("/create")
 public ResponseEntity<?>create(@RequestBody DtoEducacion dtoEdu)
 {
 if(StringUtils.isBlank(dtoEdu.getNombreEdu()))
 {
   return new ResponseEntity(new Mensaje("Debe ingresar el nombre de la instruccion"),HttpStatus.BAD_REQUEST);
 }
 if(servEducacion.existByNombreEdu(dtoEdu.getNombreEdu()))
 {
   return new ResponseEntity(new Mensaje("La instruccion ya existe"),HttpStatus.BAD_REQUEST);
 }    
 Educacion educacion = new Educacion (dtoEdu.getNombreEdu(), dtoEdu.getDescripcionEdu());
  servEducacion.save(educacion);
  
  return new ResponseEntity(new Mensaje("La instruccion ha sido guardada"),HttpStatus.OK);
 
 }       
 
 @PutMapping("/update/{id}")
public ResponseEntity<?>update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoEdu)
{
   if(!servEducacion.existById(id))
   {
   return new ResponseEntity(new Mensaje("El id no existe"),HttpStatus.BAD_REQUEST);
   }
   if(servEducacion.existByNombreEdu(dtoEdu.getNombreEdu())&& servEducacion.getByNombreEdu(dtoEdu.getNombreEdu()).get().getId()!=id)
   {
   return new ResponseEntity(new Mensaje("La experiencia actualizada ya existe"),HttpStatus.BAD_REQUEST);
   }
   if(StringUtils.isBlank(dtoEdu.getNombreEdu()))
   {
   return new ResponseEntity(new Mensaje("El campo debe estar completo"),HttpStatus.BAD_REQUEST);
   }    
   
   Educacion educacion = servEducacion.getOne(id).get();
   educacion.setNombreEdu(dtoEdu.getNombreEdu());
   educacion.setDescripcionEdu(dtoEdu.getDescripcionEdu());
   
   servEducacion.save(educacion);
   return new ResponseEntity(new Mensaje("La actualizacion de educacion esta terminada"),HttpStatus.OK);
}  
}

