package oleg.diplom.security;

import oleg.diplom.persistance.UserRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * Created by user1 on 15.06.2016.
 */

@Component
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    UserRepositiry userRepositiry;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //oleg.diplom.model.User dbUser = userRepositiry.findOne(username);
        //User user = new User(dbUser.getId(), dbUser.getPassword(), Collections.<GrantedAuthority>emptyList());
        User user = new User("oleg@example.com", "password", Collections.<GrantedAuthority>emptyList());
        return user;
    }
}
