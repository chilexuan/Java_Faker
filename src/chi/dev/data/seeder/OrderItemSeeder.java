package hoa.dev.data.seeder;

import java.util.ArrayList;
import java.util.List;
import com.github.javafaker.Faker;
import hoa.dev.data.model.OrderItem;

public class OrderItemSeeder {

    // Phương thức sinh dữ liệu ngẫu nhiên cho OrderItem
    public List<OrderItem> seedOrderItems(int count) {
        Faker faker = new Faker();
        List<OrderItem> orderItems = new ArrayList<>();

        for (int i = 1; i <= count; i++) {
            int id = i;
            int quantity = faker.number().numberBetween(1, 10); // Số lượng ngẫu nhiên từ 1 đến 10
            double price = faker.number().randomDouble(2, 10, 100); // Giá từ 10 đến 100, với 2 chữ số thập phân
            int orderId = faker.number().numberBetween(1, 50); // ID đơn hàng ngẫu nhiên
            int productId = faker.number().numberBetween(1, 100); // ID sản phẩm ngẫu nhiên

            // Tạo đối tượng OrderItem và thêm vào danh sách
            OrderItem orderItem = new OrderItem(id, quantity, price, orderId, productId);
            orderItems.add(orderItem);
        }

        return orderItems;
    }
}
