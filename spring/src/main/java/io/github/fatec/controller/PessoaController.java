package io.github.fatec.introducao.controller;

import io.github.fatec.introducao.dto.PessoaRequest;
import io.github.fatec.introducao.model.Pessoa;
import io.github.fatec.introducao.service.PessoaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pessoa> listar() {
        return service.listar();
    }

    @PostMapping
    public Pessoa criar(@RequestBody PessoaRequest request) {
        return service.criar(request);
    }

    @PutMapping("/{id}")
    public Pessoa atualizar(@PathVariable Long id,
                            @RequestBody PessoaRequest request) {
        return service.atualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        return service.deletar(id);
    }
}