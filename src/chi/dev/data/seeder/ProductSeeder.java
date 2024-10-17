package hoa.dev.data.seeder;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;

import hoa.dev.data.model.Product;

public class ProductSeeder {
    public List<Product> seedProducts(int count) {
        Faker faker = new Faker();
        List<Product> products = new ArrayList<>();

        for (int i = 1; i <= count; i++) {
            int id = i; // Unique ID for each product
            String name = faker.commerce().productName();
            String description = faker.lorem().sentence();
            String thumbnail = "thumbnail" + i + ".jpg"; // Assuming thumbnail naming scheme
            double price = Double.parseDouble(faker.commerce().price().replaceAll("[^\\d.]", ""));
            int quantity = faker.number().numberBetween(1, 100);
            int categoryId = faker.number().numberBetween(1, 5); // Assuming you have 5 categories
            int view = faker.number().numberBetween(1, 1000); // Random view count
            Timestamp createdAt = Timestamp.valueOf(LocalDateTime.now()); // Current timestamp

            // Create Product instance using the full constructor
            Product product = new Product(id, name, description, thumbnail, price, quantity, categoryId, createdAt, view);
            products.add(product);
        }

        return products;
    }
}
