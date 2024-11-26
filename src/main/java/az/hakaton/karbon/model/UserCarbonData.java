package az.hakaton.karbon.model;

import az.hakaton.karbon.enums.ManufactureType;
import az.hakaton.karbon.enums.VehicleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicUpdate
@Table(name = "users_carbon_datas")
public class UserCarbonData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Energy-related fields
    private double electricity;
    private double naturalGas;
    private double heatingOil;
    private double coal;
    private double lpg;
    private double propane;
    private double wood;

    // Secondary-related fields
    private double foodAndDrink;
    private double pharmaceuticals;
    private double clothesTextilesAndShoes;
    private double paperBasedProducts;
    private double computersAndITEquipment;
    private double televisionRadioPhone;
    private double motorVehicles;
    private double furnitureManufacturedGoods;
    private double hotelsRestaurantsPubs;
    private double telephoneMobileCosts;
    private double bankingFinance;
    private double insurance;
    private double education;
    private double recreationalCulturalSportingActivities;

    // Transport-related fields
    private int bus;
    private int coach;
    private int localCommuterTrain;
    private int longDistanceTrain;
    private int tram;
    private int subway;
    private int taxi;

    // Vehicle-related fields
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    private int manufactureYear;

    @Enumerated(EnumType.STRING)
    private ManufactureType manufactureType;

    private String model;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;


}
