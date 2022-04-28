package br.com.project.cancermama.entrypoints.controllers;

import br.com.project.cancermama.dataproviders.entities.FaixaEtaria;
import br.com.project.cancermama.repository.FaixaEtariaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class FaixaEtariaController {

    private final FaixaEtariaRepository repository;

    public FaixaEtariaController(FaixaEtariaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/faixaetaria")
    public ResponseEntity<?> getAllFaixaEtaria(){
        try {
            List<FaixaEtaria> list = repository.findAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/faixaetaria/{id}")
    public ResponseEntity<?> faixaEtariaFindById(@PathVariable Long id){
        try {
            var unidOptional = repository.findById(id);
            if(unidOptional.isPresent()){
                FaixaEtaria faixaEtaria = unidOptional.get();
                return new ResponseEntity<>(faixaEtaria, HttpStatus.OK);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/faixaetaria/novo")
    public ResponseEntity<?> novaFaixaEtaria(@RequestBody FaixaEtaria faixaEtaria){
        var saved = repository.save(faixaEtaria);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @DeleteMapping("/faixaetaria/delete/{id}")
    public ResponseEntity<?> deleteFaixaEtaria(@PathVariable Long id){
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
