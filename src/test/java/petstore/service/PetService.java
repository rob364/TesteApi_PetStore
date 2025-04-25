package petstore.service;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import petstore.model.Pet;

import static io.restassured.RestAssured.given;

/**
 * Serviço para interação com a API /pet da PetStore
 */
public class PetService {

    private static final String PET_ENDPOINT = "/pet";

    public static Response createPet(Pet pet) {
        return given()
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .post(PET_ENDPOINT);
    }

    public static Response updatePet(Pet pet) {
        return given()
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .put(PET_ENDPOINT);
    }

    public static Response getPetById(Long petId) {
        return given()
                .when()
                .get(PET_ENDPOINT + "/" + petId);
    }

    public static Response findPetsByStatus(String status) {
        return given()
                .queryParam("status", status)
                .when()
                .get(PET_ENDPOINT + "/findByStatus");
    }
}
