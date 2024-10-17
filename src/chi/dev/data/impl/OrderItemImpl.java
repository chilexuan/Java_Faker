package hoa.dev.data.impl;

import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;

import hoa.dev.data.dao.OrderItemDao;
import hoa.dev.data.model.OrderItem;

public class OrderItemImpl implements OrderItemDao {
    private final Faker faker;

    public OrderItemImpl() {
        // Khởi tạo Faker
        this.faker = new Faker();
    }

    @Override
    public boolean insert(OrderItem orderItem) {
        // Giả lập việc thêm order item
        System.out.println("Inserted order item: " + orderItem);
        return true; // Giả sử việc chèn thành công
    }

    @Override
    public boolean update(OrderItem orderItem) {
        // Giả lập việc cập nhật order item
        System.out.println("Updated order item: " + orderItem);
        return true; // Giả sử việc cập nhật thành công
    }

    @Override
    public boolean delete(int id) {
        // Giả lập việc xóa order item
        System.out.println("Deleted order item with ID: " + id);
        return true; // Giả sử việc xóa thành công
    }

    @Override
    public OrderItem find(int id) {
        // Tạo dữ liệu giả cho OrderItem
        return new OrderItem(id, faker.number().numberBetween(1, 10), 
                             faker.number().randomDouble(2, 10, 100), 
                             faker.number().numberBetween(1, 5), 
                             faker.number().numberBetween(1, 20));
    }

    @Override
    public List<OrderItem> findAll() {
        List<OrderItem> orderItemList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) { // Tạo 10 order items giả
            orderItemList.add(find(i));
        }
        return orderItemList;
    }

    @Override
    public List<OrderItem> findByOder(int orderId) {
        List<OrderItem> orderItemList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) { // Tạo 5 order items giả cho một order
            int id = i;
            orderItemList.add(new OrderItem(id, faker.number().numberBetween(1, 10), 
                                             faker.number().randomDouble(2, 10, 100), 
                                             orderId, 
                                             faker.number().numberBetween(1, 20)));
        }
        return orderItemList;
    }

    @Override
    public List<OrderItem> findByProduct(int prodId) {
        List<OrderItem> orderItemList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) { // Tạo 5 order items giả cho một sản phẩm
            int id = i;
            orderItemList.add(new OrderItem(id, faker.number().numberBetween(1, 10), 
                                             faker.number().randomDouble(2, 10, 100), 
                                             faker.number().numberBetween(1, 5), 
                                             prodId));
        }
        return orderItemList;
    }
}
