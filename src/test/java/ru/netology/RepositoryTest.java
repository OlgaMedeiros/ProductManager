package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {

    Product book1 = new Book("1984", "A", 10, 100);
    Product book2 = new Book("Сила подсознания", "B", 11, 300);
    Product book3 = new Book("Девушка из Германии", "C", 12, 500);
    Product smartphone1 = new Smartphone("Samsung", 13, 1000, "Китай");


    @Test
    public void testRemove() {
    }

    Repository repo = new Repository();

    public Repository getRepo() {
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.removeById(book2);

        Product[] expected = {book2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testRemoveWhenNoExistId() {
        Repository repo = new Repository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.removeById(5)
        );

    }

    @Test
    public void testFindAll() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.findAll();

        Product[] expected = {book1, book2, book3, smartphone1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testFindById() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);


        Product[] expected = {book2};
        Product[] actual = new Product[]{repo.findById(2)};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testFindByIdWhenNoId() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);


        Product[] expected = {null};
        Product[] actual = new Product[]{repo.findById(5)};

        Assertions.assertArrayEquals(expected, actual);
    }
