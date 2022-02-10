package com.ecommerce.testeApi;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class ClienteControllerIT {
	
	@Test
	public void deveCadastrarComSucesso() {
		
		String request = "{\r\n"
				+ "    \"cpfCliente\": \"123456789\",\r\n"
				+ "    \"nomeCliente\": \"lucas 2\",\r\n"
				+ "    \"contato\": {\r\n"
				+ "        \"email\": \"lucas@gmail.com\",\r\n"
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
		.post("/cliente")
		.then()
		.statusCode(200);
	}
}
