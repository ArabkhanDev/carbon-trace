package az.hakaton.karbon.service.inter;

import az.hakaton.karbon.dto.common.UserDTO;
import az.hakaton.karbon.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<UserDTO> getAllUsers(Pageable pageable);

    UserDTO getUserById(Long id);

    UserDTO updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long id);

}