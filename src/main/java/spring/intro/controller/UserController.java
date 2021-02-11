package spring.intro.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.intro.dto.UserResponseDto;
import spring.intro.model.User;
import spring.intro.service.UserMapper;
import spring.intro.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/inject")
    public String inject() {
        User tony = new User();
        tony.setName("Tony");
        tony.setEmail("tony@example.com");
        User steve = new User();
        steve.setName("Steve");
        steve.setEmail("steve@example.com");
        User bruce = new User();
        bruce.setName("Bruce");
        bruce.setEmail("bruce@example.com");
        User thor = new User();
        thor.setName("Thor");
        thor.setEmail("thor@example.com");
        userService.add(tony);
        userService.add(steve);
        userService.add(bruce);
        userService.add(thor);
        return "All users are successfully added to the DB";
    }

    @GetMapping("/{userId}")
    public UserResponseDto get(@PathVariable(name = "userId") Long userId) {
        return userMapper.mapToDto(userService.getById(userId));
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.listUsers()
                .stream()
                .map(userMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
