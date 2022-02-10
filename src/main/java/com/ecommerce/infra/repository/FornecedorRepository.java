package com.ecommerce.infra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.dominio.Fornecedor;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
	
	@Query("SELECT c FROM Fornecedor c WHERE c.nomeFantasia LIKE %:nomeFantasia%")
	public List<Fornecedor> buscarFornecedor(@Param("nomeFantasia") String nome);
}
