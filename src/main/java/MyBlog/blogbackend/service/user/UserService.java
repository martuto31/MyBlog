package MyBlog.blogbackend.service.user;

import java.util.stream.Collectors;
import java.util.Optional;
import java.util.List;

import MyBlog.blogbackend.DTO.UpdateUserDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MyBlog.blogbackend.mapper.EntityMapper;
import MyBlog.blogbackend.repository.user.UserRepository;

import MyBlog.blogbackend.model.User;

import MyBlog.blogbackend.DTO.UserDTO;
import MyBlog.blogbackend.DTO.LoginDTO;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final EntityMapper<User, UserDTO> userMapper;

    @Autowired
    public UserService(
            UserRepository userRepository,
            BCryptPasswordEncoder passwordEncoder,
            EntityMapper<User, UserDTO> userMapper) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    public UserDTO register(UserDTO userDTO) throws Exception {
        // Check if email is already taken
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new Exception("Email is already taken");
        }

        // Encode the password before saving it to the database
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User user = userMapper.convertToEntity(userDTO, User.class);
        User savedUser = userRepository.save(user);

        return userMapper.convertToDto(savedUser, UserDTO.class);
    }

    public Optional<UserDTO> login(LoginDTO loginDTO) {
        User user = userRepository.findByEmailOrUsername(loginDTO.getEmail(), loginDTO.getUsername());

        if (user != null && passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            return Optional.of(userMapper.convertToDto(user, UserDTO.class));
        }

        return Optional.empty();
    }

    public Optional<UserDTO> getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        return optionalUser.map(user -> userMapper.convertToDto(user, UserDTO.class));
    }

    public List<UserDTO> getAllUsers() throws Exception {
        List<User> users = userRepository.findAll();

        if (users.isEmpty()) {
            throw new Exception("No users found in database");
        }

        return users.stream()
                .map(user -> userMapper.convertToDto(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    public User updateUser(Long userId, UpdateUserDTO updateUserDTO) throws Exception {
        Optional<User> existingUser = userRepository.findById(userId);

        if (existingUser.isEmpty()) {
            throw new Exception("User not found.");
        }

        User user = existingUser.get();

        user.setFirstName(updateUserDTO.getFirstName());
        user.setLastName(updateUserDTO.getLastName());

        // If the password is provided, update it after encoding
        if (updateUserDTO.getPassword() != null && !updateUserDTO.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(updateUserDTO.getPassword()));
        }

        return userRepository.save(user);
    }

}
