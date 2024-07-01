//AI-TYPE:service

package ai.kapeta.crmapp.service;

import ai.kapeta.crmapp.dto.JwtTokenDTO;
import ai.kapeta.crmapp.dto.UserDTO;
import ai.kapeta.crmapp.repositories.users.User;
import ai.kapeta.crmapp.repositories.users.UserRepository;
import com.kapeta.spring.exceptions.IllegalArgumentException;
import com.kapeta.spring.exceptions.InvalidStateException;
import com.kapeta.spring.exceptions.NotFoundException;
import com.kapeta.spring.security.provider.JWTCreatorService;
import java.util.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersUsersService implements IUsersUsersService {

    private final ModelMapper modelMapper;
    private final JWTCreatorService jwtCreatorService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UsersRepository usersRepository;

    // STORM-AI: If adding properties to this class make sure you make them final and add constructor parameters
    @Autowired
    public UsersUsersService(
        ModelMapper modelMapper,
        JWTCreatorService jwtCreatorService,
        BCryptPasswordEncoder passwordEncoder,
        UsersRepository usersRepository
    ) {
        this.modelMapper = modelMapper;
        this.jwtCreatorService = jwtCreatorService;
        this.passwordEncoder = passwordEncoder;
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDTO signup(UserDTO user) {
        // STORM-AI: Implement this method
        throw new RuntimeException("Not implemented");
    }

    @Override
    public JwtTokenDTO login(String username, String password) {
        // STORM-AI: Implement this method
        throw new RuntimeException("Not implemented");
    }

    @Override
    public UserDTO getUser(String id) {
        // STORM-AI: Implement this method
        throw new RuntimeException("Not implemented");
    }

    @Override
    public UserDTO updateUser(String id, UserDTO user) {
        // STORM-AI: Implement this method
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void deleteUser(String id) {
        // STORM-AI: Implement this method
        throw new RuntimeException("Not implemented");
    }
}
