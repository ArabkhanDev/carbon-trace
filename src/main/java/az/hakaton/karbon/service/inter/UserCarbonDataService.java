package az.hakaton.karbon.service.inter;

import az.hakaton.karbon.dto.common.UserCarbonDataDTO;
import az.hakaton.karbon.dto.common.UserSubmitDataDTO;
import az.hakaton.karbon.dto.response.UserDataCalculatedResponse;

public interface UserCarbonDataService {

    UserSubmitDataDTO getCarbonDataById(Long id);

    UserSubmitDataDTO saveUserCarbonData(UserSubmitDataDTO userCarbonDataDTO);

    void updateCarbonData(Long id, UserSubmitDataDTO request);

    void deleteCarbonData(Long id);

    double calculateEnergy(Long id);

    double calculateSecondary(Long id);

    double calculateTransport(Long id);

    double calculateVehicle(Long id);

    UserDataCalculatedResponse calculateTotal(Long id);


}
