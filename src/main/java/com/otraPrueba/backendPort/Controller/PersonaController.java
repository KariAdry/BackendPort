package com.otraPrueba.backendPort.Controller;

import com.otraPrueba.backendPort.Entity.Persona;
import com.otraPrueba.backendPort.Security.Controller.Mensaje;
import com.otraPrueba.backendPort.Security.Dto.DtoPersona;
import com.otraPrueba.backendPort.Service.PersonaService;
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
@RequestMapping ("/persona")
/*@CrossOrigin(origins = "https://frontendportfolio-b206c.web.app")*/
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "*")

public class PersonaController
{
    @Autowired
    PersonaService personaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>>list()
  {
  List<Persona>list = personaService.list();
  return new ResponseEntity(list,HttpStatus.OK);
  }
    
    @GetMapping("/details/{id}")
    public ResponseEntity<Persona>getById(@PathVariable("id")int id)
    {
       if(!personaService.existsById(id))
       {
       return new ResponseEntity(new Mensaje("El id que ingreso no existe"),HttpStatus.BAD_REQUEST);
       }
       Persona persona = personaService.getOne(id).get();
       return new ResponseEntity(persona,HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Persona>delete(@PathVariable("id")int id)
    {
    if(!personaService.existsById(id))
    {
    return new ResponseEntity (new Mensaje("El id buscado no existe"),HttpStatus.BAD_REQUEST);
    }
    personaService.delete(id);
    return new ResponseEntity(new Mensaje ("La persona ha sido borrada"),HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<?>create(@RequestBody DtoPersona dtoPers)
    {
    if(StringUtils.isBlank(dtoPers.getNombre()))
    {
    return new ResponseEntity(new Mensaje("El campo no puede estar vacio"),HttpStatus.BAD_REQUEST);
    }
    if(personaService.existsByNombre(dtoPers.getNombre()))
    {
    return new ResponseEntity(new Mensaje("El nombre de esa persona ya existe"),HttpStatus.BAD_REQUEST);
    }
     Persona persona = new Persona(dtoPers.getNombre(),dtoPers.getApellido(),dtoPers.getDescripcion(),dtoPers.getImagenURL(), dtoPers.getImagenPath());
     personaService.save(persona);
     return new ResponseEntity(new Mensaje("La persona se creo correctamente"),HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody DtoPersona dtoPers)
    {
      if(!personaService.existsById(id))
      {
      return new ResponseEntity(new Mensaje("Ese id no existe"),HttpStatus.BAD_REQUEST);
      }   
      if(personaService.existsByNombre(dtoPers.getNombre())&& personaService.getByNombre(dtoPers.getNombre()).get().getId() !=id)
      {
       return new ResponseEntity(new Mensaje("la actualizacion de esa persona ya existe"),HttpStatus.BAD_REQUEST);
      }
      if(StringUtils.isBlank(dtoPers.getNombre()))
      {
      return new ResponseEntity(new Mensaje("Los caampos no pueden estar vacios"),HttpStatus.BAD_REQUEST);
      }
      Persona persona = personaService.getOne(id).get();
      persona.setNombre(dtoPers.getNombre());
      persona.setApellido(dtoPers.getApellido());
      persona.setDescripcion(dtoPers.getDescripcion());
      persona.setimagenURL(dtoPers.getImagenURL());
      persona.setimagenPath(dtoPers.getImagenPath());
      
     personaService.save(persona);
     return new ResponseEntity(new Mensaje("La persona se actualizo correctamente"),HttpStatus.OK);
    }
}

/*
    @RestController
    @CrossOrigin(origins = {"https://frontendportfolio-b206c.web.app", "http://localhost:4200"})
    public class PersonaController {
    @Autowired
            IPersonaService ipersonaService;

    @GetMapping("/personas/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
   @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("img") String nuevoImg)
        
    {
        Persona persona = ipersonaService.findPersona(id);

        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        
        ipersonaService.savePersona(persona);
        return persona;
    }

    @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((long)1);
    }
}
*/
