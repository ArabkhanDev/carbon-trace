package az.hakaton.karbon.service.inter;

import az.hakaton.karbon.dto.common.UserCarbonDataDTO;

public interface UserCarbonDataService {

    UserCarbonDataDTO getCarbonDataById(Long id);

    void saveUserCarbonData(UserCarbonDataDTO userCarbonDataDTO);

    void updateCarbonData(Long id, UserCarbonDataDTO request);

    void deleteCarbonData(Long id);


}
