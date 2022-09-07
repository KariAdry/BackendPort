package com.otraPrueba.backendPort.Controller;

import com.otraPrueba.backendPort.Entity.Experiencia;
import com.otraPrueba.backendPort.JDTO.DtoExperiencia;
import com.otraPrueba.backendPort.Security.Controller.Mensaje;
import com.otraPrueba.backendPort.Service.ServExperiencia;
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
@RequestMapping("/explab")
@CrossOrigin(origins= "http://localhost:4200")
public class ContExperiencia {
    @Autowired
    ServExperiencia servExperiencia;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = servExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    
     @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!servExperiencia.existById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = servExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!servExperiencia.existById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        servExperiencia.delete(id);
        return new ResponseEntity(new Mensaje("La experiencia ha sido eliminada"), HttpStatus.OK);
    }
   
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoExp) {
        if (StringUtils.isBlank(dtoExp.getNombreExp()))
        {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if (servExperiencia.existByNombreExp(dtoExp.getNombreExp())) {
            return new ResponseEntity(new Mensaje("El nombre de esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        Experiencia experiencia = new Experiencia(dtoExp.getNombreExp(), dtoExp.getDescripcionExp());
        servExperiencia.save(experiencia);

        return new ResponseEntity(new Mensaje("ha agregado una nueva experiencia"), HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoExp) {
        if (!servExperiencia.existById(id)) {
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        }
        if (servExperiencia.existByNombreExp(dtoExp.getNombreExp()) && servExperiencia.getByNombreExp(dtoExp.getNombreExp()).get().getId()!=id) {
            return new ResponseEntity(new Mensaje("La experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoExp.getNombreExp())) {
            return new ResponseEntity(new Mensaje("Es obligatorio completar el campo"), HttpStatus.BAD_REQUEST);
        }
        Experiencia experiencia = servExperiencia.getOne(id).get();
        experiencia.setNombreExp(dtoExp.getNombreExp());
        experiencia.setDescripcionExp(dtoExp.getDescripcionExp());

        servExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Se ha agregado una experiencia"), HttpStatus.OK);
    }
}
