package az.hakaton.karbon.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnergyRequest {
    private double electricity;
    private double naturalGas;
    private double heatingOil;
    private double coal;
    private double lpg;
    private double propane;
    private double wood;
}
