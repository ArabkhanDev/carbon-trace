package az.hakaton.karbon.dto.common;

import az.hakaton.karbon.dto.request.EnergyRequest;
import az.hakaton.karbon.dto.request.SecondaryRequest;
import az.hakaton.karbon.dto.request.TransportRequest;
import az.hakaton.karbon.dto.request.VehicleRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCarbonDataDTO {

    private EnergyRequest energy;
    private SecondaryRequest secondary;
    private TransportRequest transport;
    private VehicleRequest vehicle;
    private Long userId;

}
