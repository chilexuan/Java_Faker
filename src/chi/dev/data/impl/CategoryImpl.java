package hoa.dev.data.impl;

import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;
import hoa.dev.data.dao.CategoryDao;
import hoa.dev.data.model.Category;

public class CategoryImpl implements CategoryDao {
    private Faker faker = new Faker();

    @Override
    public boolean insert(Category category) {
        // Với dữ liệu giả, bạn không cần insert vào CSDL
        System.out.println("Insert: " + category);
        return true;
    }

    @Override
    public boolean update(Category category) {
        System.out.println("Update: " + category);
        return true;
    }

    @Override
    public boolean delete(int categoryId) {
        System.out.println("Delete category with ID: " + categoryId);
        return true;
    }

    @Override
    public Category find(int categoryId) {
        // Sinh ngẫu nhiên một Category theo ID
        String name = faker.commerce().department();
        String description = faker.lorem().sentence();
        return new Category(categoryId, name, description);
    }

    @Override
    public List<Category> findAll() {
        List<Category> cateList = new ArrayList<>();
        // Sinh ra 5 danh mục ngẫu nhiên
        for (int i = 1; i <= 5; i++) {
            String name = faker.commerce().department();
            String description = faker.lorem().sentence();
            cateList.add(new Category(i, name, description));
        }
        return cateList;
    }
}
