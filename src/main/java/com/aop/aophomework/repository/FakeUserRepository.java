package com.aop.aophomework.repository;

import com.aop.aophomework.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FakeUserRepository {

    public List<UserDTO> findAll() {
        return List.of(
                new UserDTO("Luka", "Varsimashvili", "faith", "luca.varsimashvili@gmail.com", "Abc1"),
                new UserDTO("John", "Doe", "johndoe", "john@gmail.com", "Abc1"),
                new UserDTO("Mike", "Meyer", "mike01", "mike@gmail.com", "Abc1"),
                new UserDTO("Melissa", "Lisbon", "melissa02", "melissa@gmail.com", "Abc1"),
                new UserDTO("Nobara", "Kugisaki", "nobara03", "nobara@gmail.com", "Abc1")
        );
    }

}
