package com.ecommerce.testeApi;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

public class ProdutoControllerIT {
	
	@Test
	public void deveCadastrarComSucesso() {
		
		String request = "{\r\n"
				+ "    \"nomeDoProduto\": \"Tabuleiro divinity\",\r\n"
				+ "    \"descricaoDoProduto\": \"Acompanha 3 reis\",\r\n"
				+ "    \"valorUnitario\": 7.99\r\n"
				+ "}";
		
		given()
		.header("Content-type", "application/json")
		.and()
		.body(request)
		.when()
		.post("/cliente")
		.then()
		.statusCode(200);
	}
}
