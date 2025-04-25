package petstore.test;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import petstore.config.BaseTest;
import petstore.model.Pet;
import petstore.service.PetService;

import static org.hamcrest.Matchers.*;

public class PetTest extends BaseTest {

    @Test
    @DisplayName("Deve retornar 404 para pet inexistente")
    public void deveRetornar404ParaPetInexistente() {
        // Arrange
        long petIdInexistente = 999999999L;

        // Act
        Response response = PetService.getPetById(petIdInexistente);

        // Assert
        response.then()
                .statusCode(404)
                .body("message", equalTo("Pet not found"));
    }

    @Test
    @DisplayName("Deve atualizar um pet com sucesso")
    public void deveAtualizarPetComSucesso() {
        // Arrange - cria o pet inicialmente
        long petId = System.currentTimeMillis();
        Pet petInicial = Pet.create(petId, "Tobby", "available");

        PetService.createPet(petInicial)
                .then()
                .statusCode(200)
                .body("name", equalTo("Tobby"))
                .body("status", equalTo("available"));

        // Arrange - prepara dados atualizados
        Pet petAtualizado = Pet.create(petId, "Tobby Atualizado", "sold");

        // Act
        Response responseAtualizacao = PetService.updatePet(petAtualizado);

        // Assert
        responseAtualizacao.then()
                .statusCode(200)
                .body("id", notNullValue()) // converte long → int para compatibilidade do JSON
                .body("name", equalTo("Tobby Atualizado"))
                .body("status", equalTo("sold"));
    }

    @Test
    @DisplayName("Deve buscar pets com status pending")
    public void deveBuscarPetsComStatusPending() {
        // Act
        Response response = PetService.findPetsByStatus("pending");

        // Assert
        response.then()
                .statusCode(200)
                .body("status", everyItem(equalTo("pending")));
    }
}
