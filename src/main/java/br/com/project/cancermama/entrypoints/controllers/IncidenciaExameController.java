package br.com.project.cancermama.entrypoints.controllers;

import br.com.project.cancermama.dataproviders.entities.IncidenciaExame;
import br.com.project.cancermama.repository.IncidenciaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class IncidenciaExameController {

    private final IncidenciaRepository repository;

    public IncidenciaExameController(IncidenciaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/incidencias")
    public ResponseEntity<List<IncidenciaExame>> findAllIncidencias(){
        var listaIncidencia = repository.findAll();
        try {
            if(listaIncidencia.isEmpty())
                return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(listaIncidencia, HttpStatus.OK);
    }

    @GetMapping("/incidencia/{id}")
    public ResponseEntity<?> findIncidenciaById(@PathVariable Long id){
        var incidenciaOptional = repository.findById(id);
        try {
            if(incidenciaOptional.isPresent()){
                var incidenviaUnid = incidenciaOptional.get();
                return new ResponseEntity<>(incidenviaUnid, HttpStatus.OK);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/incidencia/novo")
    public ResponseEntity<?> novoIncidencia(@RequestBody IncidenciaExame incidenciaExame){
        var response = repository.save(incidenciaExame);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
