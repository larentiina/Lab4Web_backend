package com.example.lab44.mappers;

import com.example.lab44.dtos.CredentialsDto;
import com.example.lab44.dtos.UserDto;
import com.example.lab44.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(CredentialsDto signUpDto);

}
