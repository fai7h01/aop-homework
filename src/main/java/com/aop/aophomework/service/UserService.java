package com.aop.aophomework.service;

import com.aop.aophomework.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> findAll();

}
