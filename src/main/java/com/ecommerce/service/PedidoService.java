package com.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.dominio.Pedido;
import com.ecommerce.infra.repository.PedidoRepository;

@Service
public class PedidoService {
	
	private PedidoRepository pedidoRepository;

	public PedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}
	
	public void salvar(Pedido pedido) {
		pedidoRepository.save(pedido);
	}
	
	public List<Pedido> buscar() {
		return pedidoRepository.findAll();
	}
}
