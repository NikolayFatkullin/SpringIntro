package spring.intro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.intro.config.AppConfig;
import spring.intro.model.User;
import spring.intro.service.UserService;

public class Main {
    private static final AnnotationConfigApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(AppConfig.class);

    public static void main(String[] args) {

        User bob = new User();
        bob.setName("Bob");
        bob.setEmail("bob@example.com");

        User alice = new User();
        alice.setName("Alice");
        alice.setEmail("alice@example.com");

        User john = new User();
        john.setName("John");
        john.setEmail("john@example.com");

        UserService userService = applicationContext.getBean(UserService.class);
        userService.add(bob);
        userService.add(alice);
        userService.add(john);

        System.out.println(userService.listUsers());
    }
}
