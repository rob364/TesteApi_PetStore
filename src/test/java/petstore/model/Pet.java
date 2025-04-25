package petstore.model;

import java.util.List;
import java.util.Arrays;

public class Pet {
    public Long id;
    public String name;
    public List<String> photoUrls;
    public String status;

    public static Pet create(Long id, String name, String status) {
        Pet pet = new Pet();
        pet.id = id;
        pet.name = name;
        pet.photoUrls = Arrays.asList("https://example.com/photo.jpg");
        pet.status = status;
        return pet;
    }
}
