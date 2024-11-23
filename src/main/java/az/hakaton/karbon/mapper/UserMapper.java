package az.hakaton.karbon.mapper;

import az.hakaton.karbon.dto.common.UserDTO;
import az.hakaton.karbon.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User mapToEntity(UserDTO request);

    @Mapping(target = "id",ignore = true)
    void updateUserFromDTO(UserDTO movieStreamRequestDTO, @MappingTarget User user);

    UserDTO mapToResponseDTO(User user);
}
