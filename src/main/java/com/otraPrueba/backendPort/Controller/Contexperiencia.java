package com.otraPrueba.backendPort.Controller;

import com.otraPrueba.backendPort.Entity.Experiencia;
import com.otraPrueba.backendPort.JDTO.DtoExperiencia;
import com.otraPrueba.backendPort.Security.Controller.Mensaje;
import com.otraPrueba.backendPort.Security.Service.ServExperiencia;
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
@CrossOrigin(origins = "http://localhost:4200")
public class Contexperiencia {

    @Autowired
    ServExperiencia servExperiencia;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = servExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id) {
        if (!servExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id ingresado no existe"), HttpStatus.NOT_FOUND);
        }
        Experiencia experiencia = servExperiencia.getOne(id).get();

        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Experiencia> delete(@PathVariable("id") int id) {
        if (!servExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id buscado no existe"), HttpStatus.BAD_REQUEST);
        }
        servExperiencia.delete(id);
        return new ResponseEntity(new Mensaje("La experiencia ha sido eliminada"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoExpe) {
        if (StringUtils.isBlank(dtoExpe.getNombreExp())) {
            return new ResponseEntity(new Mensaje("El campo debe ser completado"), HttpStatus.BAD_REQUEST);
        }
        if (servExperiencia.existsByNombreExp(dtoExpe.getNombreExp())) {
            return new ResponseEntity(new Mensaje("El nombre de la experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = new Experiencia(dtoExpe.getNombreExp(), dtoExpe.getDescripcionExp());
        servExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("la experiencia ha sido creada correctamente"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoExpe) {
        if (!servExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id solicitado no existe"), HttpStatus.BAD_REQUEST);
        }
        if (servExperiencia.existsByNombreExp(dtoExpe.getNombreExp()) && servExperiencia.getByNombreExp(dtoExpe.getNombreExp()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("La experiencia actualizada ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoExpe.getNombreExp())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        Experiencia experiencia = servExperiencia.getOne(id).get();
        experiencia.setNombreExp(dtoExpe.getNombreExp());
        experiencia.setDescripcionExp((dtoExpe.getDescripcionExp()));

        servExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("La actualizacion ha sido guardada"), HttpStatus.OK);
    }
}
