package petstore.test;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import petstore.config.BaseTest;
import petstore.model.Order;
import petstore.service.StoreService;

import static org.hamcrest.Matchers.*;

public class StoreTestTemp extends BaseTest {

    @Test
    @DisplayName("Deve cadastrar um pedido com sucesso")
    public void deveCadastrarPedidoComSucesso() {
        Order order = Order.createDefault();

        Response response = StoreService.createOrder(order);

        response.then()
                .statusCode(200)
                .body("id", notNullValue())
                .body("petId", notNullValue())
                .body("status", equalTo(order.status))
                .body("complete", equalTo(order.complete));
    }
}
