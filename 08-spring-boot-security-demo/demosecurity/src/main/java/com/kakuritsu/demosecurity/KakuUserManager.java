package com.kakuritsu.demosecurity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class KakuUserManager extends JdbcUserDetailsManager   {
    Collection<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));
public KakuUserManager(DataSource dataSource){
    super(dataSource);
}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return new User("thodoros","{noop}test1234",authorities);
    }


}
