package oleg.diplom;

import oleg.diplom.model.Task;
import oleg.diplom.model.User;
import oleg.diplom.persistance.TaskRepository;
import oleg.diplom.persistance.UserRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepositiry userRepositiry;


    @RequestMapping("/admin")
    public String admin(){
        return "ASDMIN";
    }

    @RequestMapping("/me")
    public User login(HttpServletRequest request){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object o1 = auth.getPrincipal();
        Object o2 = auth.getCredentials();
        Object o3 = auth.getDetails();
        Object o4 = auth.getName();
        User user = new User("testid", "testtype", "testname");
        return user;
    }



}
