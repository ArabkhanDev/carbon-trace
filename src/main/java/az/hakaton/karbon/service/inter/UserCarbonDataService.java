package az.hakaton.karbon.service.inter;

import az.hakaton.karbon.dto.common.UserCarbonDataDTO;
import az.hakaton.karbon.dto.response.UserDataCalculatedResponse;

public interface UserCarbonDataService {

    UserCarbonDataDTO getCarbonDataById(Long id);

    void saveUserCarbonData(UserCarbonDataDTO userCarbonDataDTO);

    void updateCarbonData(Long id, UserCarbonDataDTO request);

    void deleteCarbonData(Long id);

    double calculateEnergy(Long id);

    double calculateSecondary(Long id);

    double calculateTransport(Long id);

    double calculateVehicle(Long id);

    UserDataCalculatedResponse calculateTotal(Long id);


}
