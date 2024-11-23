package az.hakaton.karbon.service.impl;

import az.hakaton.karbon.dto.common.UserCarbonDataDTO;
import az.hakaton.karbon.dto.response.UserDataCalculatedResponse;
import az.hakaton.karbon.mapper.UserCarbonDataMapper;
import az.hakaton.karbon.model.User;
import az.hakaton.karbon.model.UserCarbonData;
import az.hakaton.karbon.repository.UserCarbonDataRepository;
import az.hakaton.karbon.repository.UserRepository;
import az.hakaton.karbon.service.inter.UserCarbonDataService;
import jakarta.persistence.EntityNotFoundException;
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

    public static final double FOOD_AND_DRINK = 0.696;
    public static final double PHARMACEUTICALS = 0.514;
    public static final double CLOTHES_TEXTILES_AND_SHOES = 0.782;
    public static final double PAPER_BASED_PRODUCTS = 0.698;
    public static final double COMPUTERS_AND_IT_EQUIPMENT = 0.468;
    public static final double TELEVISION_RADIO_AND_PHONE = 0.111;
    public static final double MOTOR_VEHICLES = 0.366;
    public static final double FURNITURE_AND_MANUFACTURED_GOODS = 0.563;
    public static final double HOTELS_RESTAURANTS_AND_PUBS = 0.241;
    public static final double TELEPHONE_MOBILE_COSTS = 0.178;
    public static final double BANKING_AND_FINANCE = 0.07;
    public static final double INSURANCE = 0.068;
    public static final double EDUCATION = 0.067;
    public static final double RECREATIONAL_CULTURAL_AND_SPORTING_ACTIVITIES = 0.155;

    // House factors
    public static final double ELECTRICITY = 0.3937;
    public static final double NATURAL_GAS = 0.1829;
    public static final double HEATING_OIL = 9.61555;
    public static final double COAL = 0.34721;
    public static final double LPG = 6.28637;
    public static final double PROPANE = 5.84305;
    public static final double WOODEN_PELLETS = 54.33654;

    // Bus factors
    public static final double BUS = 1.0;
    public static final double COACH = 1.0;
    public static final double LOCAL_OR_COMMUTER_TRAIN = 1.0;
    public static final double LONG_DISTANCE_TRAIN = 1.0;
    public static final double TRAM = 1.0;
    public static final double SUBWAY = 1.0;
    public static final double TAXI = 1.0;

    // Car mileage factor
    public static final double CAR_MILEAGE = 1.0;

    // Vehicle-specific emissions
    public static final double AVERAGE_VAN = 177.26; // Assuming average for petrol
    public static final double MOTORBIKE = 177.26;   // Assuming similar to car

    // Petrol car emissions
    public static final double LARGE_PETROL_CAR = 268.85;
    public static final double MEDIUM_PETROL_CAR = 177.26;
    public static final double SMALL_PETROL_CAR = 143.7;

    // Petrol hybrid car emissions
    public static final double LARGE_PETROL_HYBRID_CAR = 154.86;
    public static final double MEDIUM_PETROL_HYBRID_CAR = 114.9;
    public static final double SMALL_PETROL_HYBRID_CAR = 112.74;

    // Plug-in hybrid car emissions
    public static final double LARGE_PLUG_IN_HYBRID_CAR = 103.6;
    public static final double MEDIUM_PLUG_IN_HYBRID_CAR = 81.2;
    public static final double SMALL_PLUG_IN_HYBRID_CAR = 30.12;



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
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "User Carbon Data not found with id: " + request.getUserId()));
        userCarbonData.setUser(user);
        repository.save(userCarbonData);
    }

    @Transactional
    @Override
    public void updateCarbonData(Long id, UserCarbonDataDTO request) {
        UserCarbonData userCarbonData = repository.findById(id)
                .orElseThrow(() ->new ResponseStatusException(NOT_FOUND, "User Carbon Data not found with id: " + id));
        mapper.updateEntityFromDto(request, userCarbonData);
        repository.save(userCarbonData);
    }

    @Override
    public void deleteCarbonData(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UserDataCalculatedResponse calculateTotalCarbonEmission(Long id) {
        // Retrieve the UserCarbonData entity by ID (throw exception if not found)
        UserCarbonData userCarbonData = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("UserCarbonData not found for id: " + id));

        // Initialize category emissions
        double energyEmissions = 0;
        double secondaryEmissions = 0;
        double transportEmissions = 0;
        double vehicleEmissions = 0;

        // Calculate energy-related emissions
        energyEmissions += userCarbonData.getElectricity() * ELECTRICITY;
        energyEmissions += userCarbonData.getNaturalGas() * NATURAL_GAS;
        energyEmissions += userCarbonData.getHeatingOil() * HEATING_OIL;
        energyEmissions += userCarbonData.getCoal() * COAL;
        energyEmissions += userCarbonData.getLpg() * LPG;
        energyEmissions += userCarbonData.getPropane() * PROPANE;
        energyEmissions += userCarbonData.getWood() * WOODEN_PELLETS;

        // Calculate secondary-related emissions
        secondaryEmissions += userCarbonData.getFoodAndDrink() * FOOD_AND_DRINK;
        secondaryEmissions += userCarbonData.getPharmaceuticals() * PHARMACEUTICALS;
        secondaryEmissions += userCarbonData.getClothesTextilesAndShoes() * CLOTHES_TEXTILES_AND_SHOES;
        secondaryEmissions += userCarbonData.getPaperBasedProducts() * PAPER_BASED_PRODUCTS;
        secondaryEmissions += userCarbonData.getComputersAndITEquipment() * COMPUTERS_AND_IT_EQUIPMENT;
        secondaryEmissions += userCarbonData.getTelevisionRadioPhone() * TELEVISION_RADIO_AND_PHONE;
        secondaryEmissions += userCarbonData.getMotorVehicles() * MOTOR_VEHICLES;
        secondaryEmissions += userCarbonData.getFurnitureManufacturedGoods() * FURNITURE_AND_MANUFACTURED_GOODS;
        secondaryEmissions += userCarbonData.getHotelsRestaurantsPubs() * HOTELS_RESTAURANTS_AND_PUBS;
        secondaryEmissions += userCarbonData.getTelephoneMobileCosts() * TELEPHONE_MOBILE_COSTS;
        secondaryEmissions += userCarbonData.getBankingFinance() * BANKING_AND_FINANCE;
        secondaryEmissions += userCarbonData.getInsurance() * INSURANCE;
        secondaryEmissions += userCarbonData.getEducation() * EDUCATION;
        secondaryEmissions += userCarbonData.getRecreationalCulturalSportingActivities() * RECREATIONAL_CULTURAL_AND_SPORTING_ACTIVITIES;

        // Calculate transport-related emissions
        transportEmissions += userCarbonData.getBus() * BUS;
        transportEmissions += userCarbonData.getCoach() * COACH;
        transportEmissions += userCarbonData.getLocalCommuterTrain() * LOCAL_OR_COMMUTER_TRAIN;
        transportEmissions += userCarbonData.getLongDistanceTrain() * LONG_DISTANCE_TRAIN;
        transportEmissions += userCarbonData.getTram() * TRAM;
        transportEmissions += userCarbonData.getSubway() * SUBWAY;
        transportEmissions += userCarbonData.getTaxi() * TAXI;

        // Calculate vehicle-related emissions
        if (userCarbonData.getVehicleType() != null) {
            switch (userCarbonData.getVehicleType()) {
                case LARGE_PETROL_CAR:
                    vehicleEmissions += LARGE_PETROL_CAR;
                    break;
                case MEDIUM_PETROL_CAR:
                    vehicleEmissions += MEDIUM_PETROL_CAR;
                    break;
                case SMALL_PETROL_CAR:
                    vehicleEmissions += SMALL_PETROL_CAR;
                    break;
                case LARGE_PETROL_HYBRID_CAR:
                    vehicleEmissions += LARGE_PETROL_HYBRID_CAR;
                    break;
                case MEDIUM_PETROL_HYBRID_CAR:
                    vehicleEmissions += MEDIUM_PETROL_HYBRID_CAR;
                    break;
                case SMALL_PETROL_HYBRID_CAR:
                    vehicleEmissions += SMALL_PETROL_HYBRID_CAR;
                    break;
                case LARGE_PLUG_IN_HYBRID_CAR:
                    vehicleEmissions += LARGE_PLUG_IN_HYBRID_CAR;
                    break;
                case MEDIUM_PLUG_IN_HYBRID_CAR:
                    vehicleEmissions += MEDIUM_PLUG_IN_HYBRID_CAR;
                    break;
                case SMALL_PLUG_IN_HYBRID_CAR:
                    vehicleEmissions += SMALL_PLUG_IN_HYBRID_CAR;
                    break;
            }
        }

        // Calculate total emissions
        double totalEmissions = energyEmissions + secondaryEmissions + transportEmissions + vehicleEmissions;

        // Return the calculated DTO
        return new UserDataCalculatedResponse(
                energyEmissions,
                secondaryEmissions,
                transportEmissions,
                vehicleEmissions,
                totalEmissions
        );
    }

}
