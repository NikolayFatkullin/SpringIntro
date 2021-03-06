package spring.intro.service;

import spring.intro.dto.UserResponseDto;
import spring.intro.model.User;

public interface UserMapper {
    UserResponseDto mapToDto(User user);
}
