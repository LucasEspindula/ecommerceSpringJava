package com.ecommerce.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dominio.Pedido;
import com.ecommerce.service.PedidoService;

@RequestMapping("/pedido")
@RestController
public class PedidoController {
	
	private PedidoService pedidoService;

	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}
	
	@GetMapping
	public List<Pedido> buscar() {
		return pedidoService.buscar();
	}
	
	@PostMapping
	public void criarPedido(@RequestBody @Valid Pedido novoPedido) {
		pedidoService.salvar(novoPedido);
	}
}
