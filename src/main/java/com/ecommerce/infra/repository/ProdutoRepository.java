package com.ecommerce.infra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.dominio.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	@Query("SELECT c FROM Produto c WHERE c.nomeDoProduto LIKE %:nomeDoProduto%")
	public List<Produto> buscarProduto(@Param("nomeDoProduto") String nome);
}
