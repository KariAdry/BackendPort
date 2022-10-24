package com.otraPrueba.backendPort.Controller;

import com.otraPrueba.backendPort.Entity.Conocimientos;
import com.otraPrueba.backendPort.JDTO.DtoConocimientos;
import com.otraPrueba.backendPort.Security.Controller.Mensaje;
import com.otraPrueba.backendPort.Security.Service.ServConocimiento;
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
@RequestMapping("/cono")
@CrossOrigin (origins= {"https://frontendportfolio-b206c.web.app","http://localhost:4200"})

public class ContConocimientos
{
   @Autowired 
   
   ServConocimiento servConocimiento;
  
   @GetMapping("/lista")
   public ResponseEntity<List<Conocimientos>>list()
 {
   List<Conocimientos> list = servConocimiento.list();
   return new ResponseEntity (list, HttpStatus.OK);
 }
   
   @GetMapping("/detail/{id}")
   public ResponseEntity<Conocimientos> getById(@PathVariable("id") int id)
   {
   if(!servConocimiento.existsById(id))
     {
     return new ResponseEntity(new Mensaje ("El id requerido no existe"),HttpStatus.NOT_FOUND);
     }
   Conocimientos conocimientos = servConocimiento.getOne(id).get();
   return new ResponseEntity (conocimientos, HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<Conocimientos> delete(@PathVariable("id")int id)
   {
    if(!servConocimiento.existsById(id))
    {
    return new ResponseEntity(new Mensaje("El id requerido no existe"),HttpStatus.BAD_REQUEST);
    }
    servConocimiento.delete(id);
    return new ResponseEntity(new Mensaje ("El conocimiento ha sido eliminado correctamente"),HttpStatus.OK);
   }
   
   @PostMapping("/create")
   public ResponseEntity<?> create(@RequestBody DtoConocimientos dtoCo)
   {
   if (StringUtils.isBlank(dtoCo.getNombreCo()))
   {
   return new ResponseEntity(new Mensaje ("El campo no puede estar vacio"),HttpStatus.BAD_REQUEST);
   }
   
   if(servConocimiento.existsByNombreCo(dtoCo.getNombreCo()))
   {
   return new ResponseEntity(new Mensaje ("El conocimiento ingresado ya existe"),HttpStatus.BAD_REQUEST);
   }
  Conocimientos conocimientos = new Conocimientos(dtoCo.getNombreCo(),dtoCo.getPorcentajeCo());
  
  servConocimiento.save(conocimientos);
  return new ResponseEntity(new Mensaje("Se ha crreado un conocimiento"),HttpStatus.OK);
   }
   
  @PutMapping("/update/{id}")
   public ResponseEntity<?>update(@PathVariable("id") int id, @RequestBody DtoConocimientos dtoCo)
   {
   if(!servConocimiento.existsById(id))
   {
   return new ResponseEntity(new Mensaje("El id pedido no existe"),HttpStatus.BAD_REQUEST);
   }
   
   if(servConocimiento.existsByNombreCo(dtoCo.getNombreCo())&&
   servConocimiento.getByNombreCo(dtoCo.getNombreCo()).get().getId() !=id)
   {
   return new ResponseEntity(new Mensaje("la actualizacion del conocimiento,ya existe"),HttpStatus.BAD_REQUEST);
   }
   
   if(StringUtils.isBlank(dtoCo.getNombreCo()))
   {
   return new ResponseEntity(new Mensaje("El campo no debe estar vacio"),HttpStatus.BAD_REQUEST);
   }
   Conocimientos conocimientos = servConocimiento.getOne(id).get();
   conocimientos.setNombreCo(dtoCo.getNombreCo());
   conocimientos.setPorcentajeCo(dtoCo.getPorcentajeCo());
   
   servConocimiento.save(conocimientos);
   return new ResponseEntity(new Mensaje("El conocimiento ha sido actualizado correctamente"),HttpStatus.OK);
   }
}
