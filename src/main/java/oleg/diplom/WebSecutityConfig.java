package oleg.diplom;

import oleg.diplom.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;

@Configuration
@EnableWebSecurity
public class WebSecutityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService myUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(new BCryptPasswordEncoder(10));
        /*
        auth.inMemoryAuthentication()
                .withUser("oleg").password("oleg").roles("PERFORMER").and()
                .withUser("client").password("client").roles("CLIENT").and()
                .withUser("test").password("test").roles("TEST");
        */
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests().
                antMatchers("/signin").permitAll().
                antMatchers("/tasks/**").authenticated().
/*                antMatchers(HttpMethod.POST, "/task*//*//*comment").authenticated().
                antMatchers(HttpMethod.POST, "/task").hasRole("CLIENT").
                antMatchers(HttpMethod.POST, "/task*//*//*accept").hasRole("PERFORMER").
                antMatchers(HttpMethod.POST, "/task*//*//*accept*//*//*approve").hasRole("CLIENT").
                antMatchers(HttpMethod.GET, "/task*//*//*accept").hasRole("CLIENT").*/
                and().
                csrf().disable();
        //http.csrf().disable();
    }
}
