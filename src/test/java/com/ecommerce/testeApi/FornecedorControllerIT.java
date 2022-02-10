package com.ecommerce.testeApi;

import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.Test;

public class FornecedorControllerIT {
	
	@Test
	public void deveCadastrarComSucesso() {
		
		String request = "{\r\n"
				+ "    \"cnpj\": \"123456789\",\r\n"
				+ "    \"nomeFantasia\": \"ShaiyaUncharted\",\r\n"
				+ "    \"contato\": {\r\n"
				+ "        \"email\": \"uncharted@gmail.com\",\r\n"
				+ "        \"telefone\": \"123456\"\r\n"
				+ "    },\r\n"
				+ "    \"endereco\": {\r\n"
				+ "        \"rua\": \"ruazinha\",\r\n"
				+ "        \"numero\": \"99\",\r\n"
				+ "        \"bairro\": \"dos cria\",\r\n"
				+ "        \"complemento\": \"aiai\",\r\n"
				+ "        \"cep\": \"987456\",\r\n"
				+ "        \"cidade\": \"alvorada\",\r\n"
				+ "        \"estado\": \"RS\"\r\n"
				+ "    }\r\n"
				+ "}";
		
		given()
		.header("Content-type", "application/json")
		.and()
		.body(request)
		.when()
		.post("/fornecedor")
		.then()
		.statusCode(200);
	}
}
