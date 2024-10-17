package hoa.dev.data.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;

import hoa.dev.data.dao.OrderDao;
import hoa.dev.data.model.Order;

public class OrderImpl implements OrderDao {
    private final Faker faker;

    public OrderImpl() {
        // Khởi tạo Faker
        this.faker = new Faker();
    }

    @Override
    public boolean insert(Order order) {
        // Giả lập việc thêm order
        System.out.println("Inserted order: " + order);
        return true; // Giả sử việc chèn thành công
    }

    @Override
    public boolean update(Order order) {
        System.out.println("Updated order: " + order);
        return true; // Giả sử việc cập nhật thành công
    }

    @Override
    public boolean delete(int id) {
        System.out.println("Deleted order with ID: " + id);
        return true; // Giả sử việc xóa thành công
    }

    @Override
    public Order find(int id) {
        // Tạo dữ liệu giả mạo cho Order
        return new Order(id, faker.code().ean8(), faker.random().nextBoolean() ? "Pending" : "Completed", faker.number().randomDigitNotZero(), new Timestamp(System.currentTimeMillis()));
    }

    @Override
    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < 10; i++) { // Tạo 10 đơn hàng giả
            int id = i + 1; // ID từ 1 đến 10
            orders.add(find(id));
        }
        return orders;
    }

    @Override
    public List<Order> findByUser(int userId) {
        List<Order> orderList = new ArrayList<>();
        for (int i = 0; i < 5; i++) { // Tạo 5 đơn hàng giả cho một user
            int id = i + 1;
            orderList.add(find(id));
        }
        return orderList;
    }

    @Override
    public Order findByCode(String code) {
        // Tạo dữ liệu giả mạo cho Order
        return new Order(1, code, faker.random().nextBoolean() ? "Pending" : "Completed", faker.number().randomDigitNotZero(), new Timestamp(System.currentTimeMillis()));
    }

    @Override
    public List<Order> findByStatus(String status) {
        List<Order> orderList = new ArrayList<>();
        for (int i = 0; i < 3; i++) { // Tạo 3 đơn hàng giả với trạng thái cụ thể
            int id = i + 1;
            orderList.add(find(id));
        }
        return orderList;
    }

    @Override
    public int countOrderByDay(String date) {
        return faker.number().numberBetween(1, 20); // Trả về số lượng ngẫu nhiên từ 1 đến 20
    }

    @Override
    public double earningOrderByDay(String date) {
        return faker.number().randomDouble(2, 100, 500); // Trả về doanh thu ngẫu nhiên từ 100 đến 500
    }
}
