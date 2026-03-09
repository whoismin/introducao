package io.github.fatec.introducao.repository;

import io.github.fatec.introducao.model.Pessoa;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface PessoaRepository extends Repository<io.github.fatec.introducao.model.Pessoa, Long> {

    List<Pessoa> findAll();

    Pessoa save(Pessoa pessoa);

    Optional<Object> findById(Long id);

    void deleteById(Long id);
};

