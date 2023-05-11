package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Use1", "Lastname1", "user1@mail.ru");
      User user2 = new User("Use2", "Lastname2", "user2@mail.ru");

      Car car1 = new Car("f1", 111);
      Car car2 = new Car("f2", 222);

      user1.setCar(car1);
      user2.setCar(car2);

      userService.add(user1);
      userService.add(user2);


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }

      System.out.println(userService.getUserByCar("f2", 222));

      context.close();
   }
}
