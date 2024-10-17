package hoa.dev.data.seeder;
import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;

import hoa.dev.data.model.User;

public class UserSeeder {

	public List<User> seederUser(int User){
		Faker faker = new Faker();
		List<User> users = new ArrayList<>();
		
		for(int i = 1; i<User;i++) {
			int id = i;
			String email = faker.internet().emailAddress();
			String password = faker.internet().password();
			String role = faker.random().nextBoolean()?"Admin":"User";
			
			User user = new User(id,email,password,role);
			users.add(user);
		}
		return users;
		}
}
