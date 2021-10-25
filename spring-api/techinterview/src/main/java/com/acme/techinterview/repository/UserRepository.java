package com.acme.techinterview.repository;

import com.acme.techinterview.model.User;
import org.springframework.data.ldap.repository.LdapRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends LdapRepository<User> {

  User getUserByUid(String uid);
}
