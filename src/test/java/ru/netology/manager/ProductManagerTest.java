package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repo.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private static final Product first = new Product(1, "Product1", 100);
    private static final Product second = new Product(2, "Product2", 200);
    private static final Product third = new Book(3, "Book1", 100, "Pushkin");
    private static final Book fourth = new Book(4, "Book2", 400, "Tolstoy");
    private static final Smartphone fifth = new Smartphone(5, "Smartphone1", 1000, "Motorola");
    private static final Smartphone sixth = new Smartphone(6, "Smartphone2", 4000, "Nokia");

    private final ProductManager manager = new ProductManager(new ProductRepository());

    @BeforeEach
    void setApp() {
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.save(sixth);
    }


    @Test
    public void shouldFindBook1Author() {
        Product[] expected = {third};
        Product[] actual = manager.searchBy("Pushkin");
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindBook2Author() {
        Product[] expected = {fourth};
        Product[] actual = manager.searchBy("Tolstoy");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBook1Name() {
        Product[] expected = {third};
        Product[] actual = manager.searchBy("Book1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBook2Name() {
        Product[] expected = {fourth};
        Product[] actual = manager.searchBy("Book2");
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindSmartphone1Manufacturer() {
        Product[] expected = {fifth};
        Product[] actual = manager.searchBy("Motorola");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphone2Manufacturer() {
        Product[] expected = {sixth};
        Product[] actual = manager.searchBy("Nokia");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphone1Name() {
        Product[] expected = {fifth};
        Product[] actual = manager.searchBy("Smartphone1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphone2Name() {
        Product[] expected = {sixth};
        Product[] actual = manager.searchBy("Smartphone2");
        assertArrayEquals(expected, actual);
    }

}