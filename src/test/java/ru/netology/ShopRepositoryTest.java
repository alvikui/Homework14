package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    ShopRepository repo = new ShopRepository();

    Product product1 = new Product(53, "cat", 4_567);
    Product product2 = new Product(74, "dog", 3_786);
    Product product3 = new Product(65, "fish", 2_698);

    @Test
    public void shouldRemoveTheElement() {

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(15);
        });
    }

    @Test
    public void shouldGenerateWhenTryingANonExistingElement() {

        repo.add(product1);
        repo.add(product2);
        repo.remove(74);
        Product[] actual = repo.findAll();
        Product[] expected = {product1};

        Assertions.assertArrayEquals(actual, expected);
    }
}