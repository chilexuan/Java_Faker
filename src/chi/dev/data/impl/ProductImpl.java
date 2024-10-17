package hoa.dev.data.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;

import hoa.dev.data.dao.ProductDao;
import hoa.dev.data.model.Product;

public class ProductImpl implements ProductDao {
    private final Faker faker;

    public ProductImpl() {
        // Initialize Faker
        this.faker = new Faker();
    }

    @Override
    public boolean insert(Product product) {
        // Simulate inserting a product
        System.out.println("Inserted product: " + product);
        return true; // Assume insert operation succeeded
    }

    @Override
    public boolean update(Product product) {
        // Simulate updating a product
        System.out.println("Updated product: " + product);
        return true; // Assume update operation succeeded
    }

    @Override
    public boolean delete(int id) {
        // Simulate deleting a product
        System.out.println("Deleted product with ID: " + id);
        return true; // Assume delete operation succeeded
    }

    @Override
    public Product find(int id) {
        // Generate fake product data
        String name = faker.commerce().productName();
        String description = faker.lorem().paragraph();
        
        // Use a static image URL or a randomly generated image URL
        String thumbnail = "https://via.placeholder.com/150"; // Static image URL
        
        Double price = Double.valueOf(faker.commerce().price());
        int quantity = faker.number().numberBetween(1, 100);
        int view = faker.number().numberBetween(0, 1000);
        int categoryId = faker.number().numberBetween(1, 10);
        Timestamp createdAt = new Timestamp(System.currentTimeMillis());

        return new Product(id, name, description, thumbnail, price, quantity, categoryId, createdAt, view);
    }

    @Override
    public List<Product> findAll() {
        List<Product> prodList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) { // Create 10 fake products
            prodList.add(find(i));
        }
        return prodList;
    }
}
