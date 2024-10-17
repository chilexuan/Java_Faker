package hoa.dev;

import java.util.List;

import hoa.dev.data.dao.CategoryDao;
import hoa.dev.data.dao.Database;
import hoa.dev.data.dao.DatabaseDao;
import hoa.dev.data.dao.OrderDao;
import hoa.dev.data.dao.OrderItemDao;
import hoa.dev.data.dao.ProductDao;
import hoa.dev.data.dao.UserDao;
import hoa.dev.data.model.Category;
import hoa.dev.data.model.Order;
import hoa.dev.data.model.OrderItem;
import hoa.dev.data.model.Product;
import hoa.dev.data.model.User;
import hoa.dev.data.seeder.CategorySeeder;
import hoa.dev.data.seeder.OrderItemSeeder;
import hoa.dev.data.seeder.OrderSeeder;
import hoa.dev.data.seeder.ProductSeeder;
import hoa.dev.data.seeder.UserSeeder;

public class MainApp {

    public static void main(String[] args) {
       // Khởi tạo đối tượng CategorySeeder để tạo dữ liệu giả ngẫu nhiên table Categories
        CategorySeeder seeder = new CategorySeeder();
        List<Category> categories = seeder.seedCategories(2); 

        // In ra các Category đã tạo
        categories.forEach(category -> {
            System.out.println("ID: " + category.getId());
            System.out.println("Name: " + category.getName());
            System.out.println("Description: " + category.getDescription());
            System.out.println("--------------");
        });
        
        
        // Sinh sản phẩm ngẫu nhiên với java faker table product
        ProductSeeder productSeeder = new ProductSeeder();
        List<Product> products = productSeeder.seedProducts(2); 

        // Print the generated products
        System.out.println("Generated Products:");
        products.forEach(product -> {
            System.out.println("ID: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println("Description: " + product.getDescription());
            System.out.println("Thumbnail: " + product.getThumbnail());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Quantity: " + product.getQuantity());
            System.out.println("Category ID: " + product.getCategoryId());
            System.out.println("Created At: " + product.getCreatedAt());
            System.out.println("View: " + product.getView());
            System.out.println("--------------");
        });
        
        
        //sinh  san pham ngau nhien với  java faker table order
       OrderSeeder orderSeeder = new OrderSeeder(); 
       List<Order> orders = orderSeeder.seedOrders(2);
       
       orders.forEach(order ->{
    	   System.out.println("ID: "+ order.getId());
    	   System.out.println("Code: "+ order.getCode());
    	   System.out.println("Status: "+ order.getStatus());
    	   System.out.println("Create_At: " +order.getCreatedAt());
    	   System.out.println("User_Id: "+order.getUserId());
    	   
       });
       
       //sinh san pham ngau nhien với java faker table orderItem 
       OrderItemSeeder orderItemSeeder = new OrderItemSeeder();
       List<OrderItem> orderItems = orderItemSeeder.seedOrderItems(2);
       orderItems.forEach(orderItem ->{
    	   System.out.println("Id: " + orderItem.getId());
    	   System.out.println("Quantity: "+ orderItem.getQuantity());
    	   System.out.println("Price: "+orderItem.getPrice());
    	   System.out.println("OrderId: "+ orderItem.getOrderId());
    	   System.out.println("ProductId: "+orderItem.getProductId());   
       });
       
       //sinh thong tin ngươi  dung và admin với java faker table user
       UserSeeder userSeeder = new UserSeeder();
       List<User> users = userSeeder.seederUser(2);
       
       users.forEach(user->{
    	   System.out.println("Id: "+user.getId());
    	   System.out.println("Email: "+user.getEmail());
    	   System.out.println("Password: "+user.getPassword());
    	   System.out.println("Role: "+user.getRole());
       });
       
        // Khởi tạo cơ sở dữ liệu
        DatabaseDao.init(new Database());

        // Khởi tạo các đối tượng DAO (Data Access Object)
        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();
        OrderItemDao orderItemDao = DatabaseDao.getInstance().getOrderItemDao();
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();

        // Hiển thị tất cả Category từ cơ sở dữ liệu
        List<Category> allCats = categoryDao.findAll();
        for (Category category : allCats) {
            System.out.println("Id: " + category.getId() + "; Tên: " + category.getName() + "; Mô tả: " + category.getDescription());
        }

        // Hiển thị tất cả User từ cơ sở dữ liệu
        List<User> allUsers = userDao.findAll();
        for (User user : allUsers) {
            System.out.println("Id: " + user.getId() + "; Email: " + user.getEmail() + "; Mật khẩu: " + user.getPassword() + "; Quyền: " + user.getRole());
        }

        // Hiển thị tất cả Order từ cơ sở dữ liệu
        List<Order> allOrders = orderDao.findAll();
        for (Order order : allOrders) {
            System.out.println("Id: " + order.getId() + "; User: " + order.getUserId() + "; Code: " + order.getCode() + "; Ngày tạo: " + order.getCreatedAt() + "; Tình trạng: " + order.getStatus());
        }

        // Hiển thị tất cả OrderItem từ cơ sở dữ liệu
        List<OrderItem> allOrderItems = orderItemDao.findAll();
        for (OrderItem orderItem : allOrderItems) {
            System.out.println("Id: " + orderItem.getId() + "; ID Order: " + orderItem.getOrderId() + "; ID sản phẩm: " + orderItem.getProductId() + "; Số lượng: " + orderItem.getQuantity() + "; Đơn giá: " + orderItem.getPrice());
        }

        // Hiển thị tất cả Product từ cơ sở dữ liệu
        List<Product> allProducts = productDao.findAll();
        for (Product product : allProducts) {
            System.out.println("Id: " + product.getId() + "; Tên sản phẩm: " + product.getName() + "; Giá bán: " + product.getPrice());
        }
    }
}
