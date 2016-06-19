package oleg.diplom;

import oleg.diplom.model.Task;
import oleg.diplom.model.User;
import oleg.diplom.persistance.TaskRepository;
import oleg.diplom.persistance.UserRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user1 on 07.06.2016.
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepositiry userRepositiry;


    @RequestMapping("/admin")
    public String admin(){
        return "ADMIN";
    }

    @RequestMapping("/me")
    public User login(HttpServletRequest request){
/*
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object o1 = auth.getPrincipal();
        Object o2 = auth.getCredentials();
        Object o3 = auth.getDetails();
        Object o4 = auth.getName();
        User user = new User("testid", "testtype", "testname");
*/
        return null;
    }


    @RequestMapping(value = "/signin", params = {"email", "password"})
    public User signIn(
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password) throws DeniedException {
        User existUser = userRepositiry.findByEmail(email);
        if (existUser == null){
            existUser = new User(email, passwordEncoder.encode(password));
            existUser = userRepositiry.save(existUser);
        }else{
            if (!passwordEncoder.matches(password, existUser.getPassword())){
                throw new DeniedException();
            }
        }
        return existUser;
    }


    @ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "password incorrect")
    class DeniedException extends Exception{

    }

}
