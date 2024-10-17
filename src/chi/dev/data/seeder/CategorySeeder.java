package hoa.dev.data.seeder;

import com.github.javafaker.Faker;

import hoa.dev.data.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategorySeeder {

    // Phương thức để tạo dữ liệu ngẫu nhiên cho các Category
    public List<Category> seedCategories(int numberOfCategories) {
        Faker faker = new Faker();
        List<Category> categories = new ArrayList<>();

        // Tạo dữ liệu Category ngẫu nhiên
        for (int i = 1; i <= numberOfCategories; i++) {
            String name = faker.commerce().department(); // Tên danh mục ngẫu nhiên
            String description = faker.lorem().sentence(); // Mô tả ngẫu nhiên

            // Tạo đối tượng Category và thêm vào danh sách
            Category category = new Category(i, name, description);
            categories.add(category);
        }
        return categories;
    }
}

