package az.hakaton.karbon.dto.request;

import az.hakaton.karbon.enums.ManufactureType;
import az.hakaton.karbon.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleRequest {

    private VehicleType vehicleType;
    private int manufactureYear;
    private ManufactureType manufactureType;
    private String model;

}
