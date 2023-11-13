package br.com.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
