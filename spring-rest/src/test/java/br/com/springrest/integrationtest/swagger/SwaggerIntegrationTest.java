package br.com.springrest.integrationtest.swagger;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.springrest.config.TestConfigs;
import br.com.springrest.integrationtest.testcontainers.AbstractIntegrationTest;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SwaggerIntegrationTest extends AbstractIntegrationTest {

	@Test
	@DisplayName("JUnit test Should Display Swagger Ui Page")
	void testShouldDisplaySwaggerUiPage() {

		var content = given()
			.basePath("/swagger-ui/index.html")
			.port(TestConfigs.SERVER_PORT)
			.when()
				.get()
			.then()
				.statusCode(200)
			.extract()
				.body()
					.asString();

		assertTrue(content.contains("Swagger UI"));
		
	}
	
	
	
}
