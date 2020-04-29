package co.edu.unal.software_engineering.labs.controller;
import co.edu.unal.software_engineering.labs.service.NewServiceUser;
import co.edu.unal.software_engineering.labs.model.Role;
import co.edu.unal.software_engineering.labs.model.User;
import co.edu.unal.software_engineering.labs.pojo.LoginUserPOJO;
import co.edu.unal.software_engineering.labs.service.RoleService;
import co.edu.unal.software_engineering.labs.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.List;


@RestController
public class NewControllerUser {
    private UserService userService;
    private NewServiceUser newserviceUser;

    private RoleService roleService;

    private PasswordEncoder passwordEncoder;

    public NewControllerUser( UserService userService, RoleService roleService, PasswordEncoder passwordEncoder ){
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping( value = { "/principal/roles/" }, consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity registerRoleToUser(@PathVariable Integer nuevo, @RequestBody UserService service){
        String username = SecurityContextHolder.getContext( ).getAuthentication( ).getName( );
        service.getAll(username);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}

