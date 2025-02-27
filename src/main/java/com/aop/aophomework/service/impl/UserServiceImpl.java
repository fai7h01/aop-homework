package com.aop.aophomework.service.impl;

import com.aop.aophomework.dto.UserDTO;
import com.aop.aophomework.repository.FakeUserRepository;
import com.aop.aophomework.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final FakeUserRepository fakeUserRepository;

    public UserServiceImpl(FakeUserRepository fakeUserRepository) {
        this.fakeUserRepository = fakeUserRepository;
    }

    @Override
    public List<UserDTO> findAll() {
        return fakeUserRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(UserDTO::getFirstName))
                .toList();
    }
}
