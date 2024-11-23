package az.hakaton.karbon.service.impl;

import az.hakaton.karbon.dto.common.UserCarbonDataDTO;
import az.hakaton.karbon.mapper.UserCarbonDataMapper;
import az.hakaton.karbon.model.User;
import az.hakaton.karbon.model.UserCarbonData;
import az.hakaton.karbon.repository.UserCarbonDataRepository;
import az.hakaton.karbon.repository.UserRepository;
import az.hakaton.karbon.service.inter.UserCarbonDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserCarbonDataServiceImpl implements UserCarbonDataService {

    private final UserCarbonDataRepository repository;
    private final UserRepository userRepository;
    private final UserCarbonDataMapper mapper;


    @Override
    public UserCarbonDataDTO getCarbonDataById(Long id) {
        UserCarbonDataDTO userCarbonDataDTO = mapper.mapToResponseDTO(repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "UserCarbonData not found with id: " + id)));
        userCarbonDataDTO.setUserId(userCarbonDataDTO.getUserId());
        return userCarbonDataDTO;
    }

    @Transactional
    @Override
    public void saveUserCarbonData(UserCarbonDataDTO request) {
        UserCarbonData userCarbonData = mapper.mapToEntity(request);
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "User not found with id: " + request.getUserId()));
        userCarbonData.setUser(user);
        repository.save(userCarbonData);
    }

    @Transactional
    @Override
    public void updateCarbonData(Long id, UserCarbonDataDTO request) {
        UserCarbonData userCarbonData = repository.findById(id)
                .orElseThrow(() ->new ResponseStatusException(NOT_FOUND, "UserCarbonData not found with id: " + id));
        mapper.updateEntityFromDto(request, userCarbonData);
        repository.save(userCarbonData);
    }

    @Override
    public void deleteCarbonData(Long id) {
        repository.deleteById(id);
    }
}
