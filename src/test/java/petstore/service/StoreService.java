package petstore.service;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import petstore.model.Order;

import static io.restassured.RestAssured.given;

public class StoreService {

    private static final String STORE_ORDER_ENDPOINT = "/store/order";

    public static Response createOrder(Order order) {
        return given()
                .contentType(ContentType.JSON)
                .body(order)
                .when()
                .post(STORE_ORDER_ENDPOINT);
    }
}
