package hoa.dev.data.seeder;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;
import hoa.dev.data.model.Order;

public class OrderSeeder {
    // Khai báo mảng trạng thái đơn hàng
    private static final String[] STATUSES = { Order.PENDING, Order.FINISHED }; // Sử dụng hằng số đã định nghĩa trong lớp Order

    // Phương thức để tạo dữ liệu ngẫu nhiên cho đơn hàng
    public List<Order> seedOrders(int count) {
        Faker faker = new Faker();
        List<Order> orders = new ArrayList<>();

        // Tạo dữ liệu đơn hàng ngẫu nhiên
        for (int i = 1; i <= count; i++) {
            int id = i; 
            String code = faker.commerce().promotionCode(); // Mã đơn hàng ngẫu nhiên
            String status = STATUSES[faker.random().nextInt(STATUSES.length)]; // Trạng thái ngẫu nhiên
            Timestamp createdAt = Timestamp.valueOf(
                LocalDateTime.now().minusDays(faker.number().numberBetween(1, 30))
            );
            int userId = faker.number().numberBetween(1, 100); // ID người dùng ngẫu nhiên
            
            // Tạo đối tượng Order và thêm vào danh sách
            Order order = new Order(id, code, status, userId, createdAt);
            orders.add(order);
        }
        return orders;
    }
}
