package com.acme.techinterview.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entry(objectClasses = {"inetOrgPerson", "organizationalPerson", "person", "top"}, base = "ou=Users")
public final class User {

    @Id
    @JsonIgnore
    private Name dn;

    @NonNull
    @Attribute(name = "uid")
    @DnAttribute(value = "uid", index = 1)
    private String uid;

    @NonNull
    @Attribute(name = "cn")
    private String firstName;

    @NonNull
    @Attribute(name = "sn")
    private String lastName;

}
