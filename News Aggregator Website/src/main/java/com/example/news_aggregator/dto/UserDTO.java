package com.example.news_aggregator.dto;

import com.example.news_aggregator.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    private long id;

    @NotBlank(message = "Username is mandatory")
    @Size(max = 255, message = "Username must be less than 255 characters")
    private String username;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 6, max = 255, message = "Password must be between 6 and 255 characters")
    private String password;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    public static User convertToUserEntity(UserDTO userDTO) {
        if (userDTO == null)
            return null;

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());

        return user;
    }

    public static UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());

        return userDTO;
    }

}

