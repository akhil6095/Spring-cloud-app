package com.apollo.recorder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.apollo.recorder.model.User;
import com.apollo.recorder.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User saveUpdateUser(final String userName) {
	if (StringUtils.isEmpty(userName)) {
	    throw new IllegalArgumentException("User name cannot be emopty.");
	}

	User user = repository.findByUserName(userName);
	if (user == null) {
	    user = new User(userName);
	} else {
	    user.setCount(user.getCount() + 1);
	}

	repository.save(user);
	return user;
    }

}
