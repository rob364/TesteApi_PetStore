package petstore.utils;

import petstore.model.Order;
import petstore.model.Pet;

import java.util.Arrays; // necessário para usar Arrays.asList
import java.util.List;

public class DataFactory {

    public static Order gerarOrderValido() {
        Order o = new Order();
        o.id = System.currentTimeMillis();
        o.petId = o.id + 1;
        o.quantity = 1;
        o.shipDate = "2025-04-23T00:00:00.000Z";
        o.status = "placed";
        o.complete = true;
        return o;
    }

    public static Pet gerarPetValido(String nome, String status) {
        Pet p = new Pet();
        p.id = System.currentTimeMillis();
        p.name = nome;
        p.photoUrls = Arrays.asList("url1");
        p.status = status;
        return p;
    }
}
