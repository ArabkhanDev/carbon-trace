package az.hakaton.karbon.service.impl;

import az.hakaton.karbon.dto.common.UserDTO;
import az.hakaton.karbon.mapper.UserMapper;
import az.hakaton.karbon.model.User;
import az.hakaton.karbon.repository.UserRepository;
import az.hakaton.karbon.service.inter.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Page<UserDTO> getAllUsers(Pageable pageable) {
        Page<User> userPage = repository.findAll(pageable);
        return userPage.map(UserDTO::new);
    }

    @Override
    public UserDTO getUserById(Long id) {
        return repository.findById(id)
                .map(UserDTO::new)
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "User not found with id: " + id));
    }

    @Transactional
    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "User not found with id:" + id));
        userMapper.updateUserFromDTO(userDTO, user);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return userMapper.mapToResponseDTO(repository.save(user));

    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UserDTO changePassword(Long id, UserDTO userDTO) {
        User user = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "User not found with id:" + id));
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return userMapper.mapToResponseDTO(repository.save(user));
    }
}
