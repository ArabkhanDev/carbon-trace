package az.hakaton.karbon.controller;

import az.hakaton.karbon.dto.common.UserSubmitDataDTO;
import az.hakaton.karbon.dto.response.UserDataCalculatedResponse;
import az.hakaton.karbon.service.inter.UserCarbonDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user-carbon-data")
@RequiredArgsConstructor
public class UserCarbonDataController {

    private final UserCarbonDataService userCarbonDataService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserSubmitDataDTO getCarbonDataById(@PathVariable Long id) {
        return userCarbonDataService.getCarbonDataById(id);
    }

    @GetMapping("/carbon/energy/{id}")
    @ResponseStatus(HttpStatus.OK)
    public double calculateEnergy(@PathVariable Long id) {
        return userCarbonDataService.calculateEnergy(id);
    }

    @GetMapping("/carbon/secondary/{id}")
    @ResponseStatus(HttpStatus.OK)
    public double calculateSecondary(@PathVariable Long id) {
        return userCarbonDataService.calculateSecondary(id);
    }

    @GetMapping("/carbon/transport/{id}")
    @ResponseStatus(HttpStatus.OK)
    public double calculateTransport(@PathVariable Long id) {
        return userCarbonDataService.calculateTransport(id);
    }

    @GetMapping("/carbon/vehicle/{id}")
    @ResponseStatus(HttpStatus.OK)
    public double calculateVehicle(@PathVariable Long id) {
        return userCarbonDataService.calculateVehicle(id);
    }

    @GetMapping("/carbon/total/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDataCalculatedResponse calculateTotal(@PathVariable Long id) {
        return userCarbonDataService.calculateTotal(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserSubmitDataDTO saveUserCarbonData(@RequestBody UserSubmitDataDTO request) {
        return userCarbonDataService.saveUserCarbonData(request);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCarbonData(@PathVariable Long id, @RequestBody UserSubmitDataDTO request) {
        userCarbonDataService.updateCarbonData(id, request);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCarbonData(@PathVariable Long id) {
        userCarbonDataService.deleteCarbonData(id);
    }
}

