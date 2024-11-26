package az.hakaton.karbon.dto.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSubmitDataDTO {

    private Long id;
    // Energy fields
    private int electricity;
    private int naturalGas;
    private int heatingOil;
    private int coal;
    private int lpg;
    private int propane;
    private int wood;

    // Secondary fields
    private int foodAndDrink;
    private int pharmaceuticals;
    private int clothesTextilesAndShoes;
    private int paperBasedProducts;
    private int computersAndITEquipment;
    private int televisionRadioPhone;
    private int motorVehicles;
    private int furnitureManufacturedGoods;
    private int hotelsRestaurantsPubs;
    private int telephoneMobileCosts;
    private int bankingFinance;
    private int insurance;
    private int education;
    private int sportingActivities;

    // Transport fields
    private int bus;
    private int coach;
    private int localCommuterTrain;
    private int longDistanceTrain;
    private int tram;
    private int subway;
    private int taxi;

    // Vehicle fields
    private String vehicleType;
    private int manufactureYear;
    private String manufactureType;
    private String model;

    // User ID
    private Long userId;

}
