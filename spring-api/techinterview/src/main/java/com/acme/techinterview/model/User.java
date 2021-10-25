package com.acme.techinterview.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.naming.Name;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entry(objectClasses = {"inetOrgPerson", "organizationalPerson", "person",
    "top"}, base = "ou=Users")
public final class User {

  @Id
  @JsonIgnore
  private Name dn;

  @NonNull
  @Attribute(name = "uid")
  @DnAttribute(value = "uid", index = 1)
  @NotBlank
  private String uid;

  @NonNull
  @Attribute(name = "cn")
  @JsonProperty("cn")
  private String firstName;

  @NonNull
  @Attribute(name = "sn")
  @JsonProperty("sn")
  private String lastName;

}
