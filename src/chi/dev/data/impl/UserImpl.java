package hoa.dev.data.impl;

import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;

import hoa.dev.data.dao.UserDao;
import hoa.dev.data.model.User;

public class UserImpl implements UserDao {
    private final Faker faker = new Faker(); // Create a Faker instance
    private final List<User> users = new ArrayList<>(); // Simulated database

    @Override
    public boolean insert(User user) {
        user.setId(users.size() + 1); // Simulate auto-incrementing ID
        users.add(user);
        return true; // Always return true as we are simulating the insert
    }

    @Override
    public boolean update(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == user.getId()) {
                users.set(i, user); // Update the user
                return true; // Return true if updated
            }
        }
        return false; // Return false if not found
    }

    @Override
    public boolean delete(int userId) {
        return users.removeIf(user -> user.getId() == userId); // Remove if found
    }

    @Override
    public User find(int userId) {
        for (User user : users) {
            if (user.getId() == userId) {
                return user; // Return the found user
            }
        }
        return null; // Return null if not found
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users); // Return a copy of the users list
    }

    // Method to generate fake users
    public void generateFakeUsers(int count) {
        for (int i = 0; i < count; i++) {
            String email = faker.internet().emailAddress();
            String password = faker.internet().password();
            String role = faker.job().title();
            User user = new User(0, email, password, role); // ID will be set in insert
            insert(user);
        }
    }
}
