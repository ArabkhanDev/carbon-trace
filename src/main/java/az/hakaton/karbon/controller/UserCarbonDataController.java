package az.hakaton.karbon.controller;

import az.hakaton.karbon.dto.common.UserCarbonDataDTO;
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
    public UserCarbonDataDTO getCarbonDataById(@PathVariable Long id) {
        return userCarbonDataService.getCarbonDataById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUserCarbonData(@RequestBody UserCarbonDataDTO request) {
        userCarbonDataService.saveUserCarbonData(request);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCarbonData(@PathVariable Long id, @RequestBody UserCarbonDataDTO request) {
        userCarbonDataService.updateCarbonData(id, request);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCarbonData(@PathVariable Long id) {
        userCarbonDataService.deleteCarbonData(id);
    }
}

