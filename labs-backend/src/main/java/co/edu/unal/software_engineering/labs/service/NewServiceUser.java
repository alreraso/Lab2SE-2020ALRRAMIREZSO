package co.edu.unal.software_engineering.labs.service;

import co.edu.unal.software_engineering.labs.model.Role;
import co.edu.unal.software_engineering.labs.model.User;
import co.edu.unal.software_engineering.labs.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NewServiceUser{

    private final UserRepository userrepository;

    public NewServiceUser( UserRepository userRepository ){
        this.userrepository = userRepository;
    }

    public User findUsername( String username ){
        return userrepository.findByUsername( username );
    }

    public List<Role> getAlln(String usuarioNuevo){
        User variableNombre = findUsername(usuarioNuevo);
        return variableNombre.getRoles();
    }
}