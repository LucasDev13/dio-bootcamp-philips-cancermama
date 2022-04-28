package br.com.project.cancermama.entrypoints.controllers;

import br.com.project.cancermama.dataproviders.entities.Regiao;
import br.com.project.cancermama.entrypoints.response.RegiaoResponse;
import br.com.project.cancermama.repository.RegiaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class RegiaoController {

    private final RegiaoRepository repository;

    public RegiaoController(RegiaoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/regiao")
    public ResponseEntity<List<Regiao>> getRegiao(){
        var regiao = repository.findAll();
        /*RegiaoResponse.toResponse(regiao);*/
        return ResponseEntity.ok(regiao);
    }

    @GetMapping("regiao/{id}")
    public ResponseEntity<?> regiaoFindById(@PathVariable Long id){
        var regiaoById = repository.findById(id);
        if(regiaoById.isPresent()){
            var request = regiaoById.get();
            return new ResponseEntity<>(request, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/regiao/novo")
    public void putRegiao(Regiao newRegiao){
        repository.save(newRegiao);
    }

    @PostMapping("/regiao/salvar")
    public ResponseEntity<?> postRegiao(@RequestBody Regiao regiao){
        var regiaoSaved = repository.save(regiao);
        return new ResponseEntity<>(regiaoSaved, HttpStatus.CREATED);
    }

    @DeleteMapping("/regiao/delete/{id}")
    public ResponseEntity<?> deleteRegiao(@PathVariable Long id){
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }
}
