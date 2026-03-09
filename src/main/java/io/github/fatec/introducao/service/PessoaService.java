package io.github.fatec.introducao.service;

import io.github.fatec.introducao.dto.PessoaRequest;
import io.github.fatec.introducao.model.Pessoa;
import io.github.fatec.introducao.repository.PessoaRepository;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class PessoaService {

    private final PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public List<Pessoa> listar(){
        return repository.findAll();
    }

    public Pessoa criar(PessoaRequest request) {
        Pessoa pessoa = new Pessoa(
                request.getNome(),
                request.getTelefone(),
                request.getEndereco()
        );
        return repository.save(pessoa);
    }

    public Pessoa atualizar(Long id, PessoaRequest request) {
        Pessoa pessoa = (Pessoa) repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: não encontrado, tente novamente!"));

        pessoa.setNome(request.getNome());
        pessoa.setEndereco(request.getEndereco());
        pessoa.setTelefone(request.getTelefone());

        return repository.save(pessoa);
    }

    public String deletar(Long id) {
        repository.deleteById(id);

        return "Usuário: " + id + "foi deletado com sucesso";
    }
}
