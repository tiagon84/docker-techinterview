package com.acme.techinterview.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
public class WebConfig {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build();
  }


//    @Bean
//    ContextSource contextSource() {
//
//        LdapContextSource ldapContextSource = new LdapContextSource();
//        ldapContextSource.setUrl("ldap://localhost:389");
//        ldapContextSource.setBase("dc=techinterview,dc=com");
//        ldapContextSource.setPassword("123456");
//        ldapContextSource.setUserDn("cn=admin,dc=techinterview,dc=com");
//
//        return ldapContextSource;
//    }
//
//    @Bean
//    LdapTemplate ldapTemplate(ContextSource contextSource) {
//        return new LdapTemplate(contextSource);
//    }

//    @Autowired
//    private LdapContextSource ldapContextSource;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic().and().authorizeRequests().antMatchers("/users","/").permitAll()
//                .anyRequest().authenticated().and().csrf().disable();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.ldapAuthentication().contextSource(ldapContextSource)
//                .userSearchBase("ou=Users")
//                .groupSearchBase("ou=groups")
//                .groupSearchFilter("member={0}")
//                .userDnPatterns("ou=Users,dc=techinterview,dc=com")
//                .userSearchFilter("uid={0}");
//    }



//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .anyRequest().fullyAuthenticated()
//                .and()
//                .formLogin();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .ldapAuthentication()
//                .userDnPatterns("uid={0},ou=people")
//                .groupSearchBase("ou=groups")
//                .contextSource()
//                .url("ldap://localhost:8389/dc=springframework,dc=org")
//                .and()
//                .passwordCompare()
//                .passwordEncoder(new BCryptPasswordEncoder())
//                .passwordAttribute("userPassword");
//    }
}
