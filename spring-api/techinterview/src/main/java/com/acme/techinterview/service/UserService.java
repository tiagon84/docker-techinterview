package com.acme.techinterview.service;

import com.acme.techinterview.model.User;
import com.acme.techinterview.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.support.BaseLdapNameAware;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.stereotype.Service;

import javax.naming.ldap.LdapName;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findUser(String uid) {
        return userRepository.getUserByUid(uid);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(String uid) {
        User user = this.findUser(uid);
        if (null != user) {
            userRepository.delete(user);
        }
    }
}
