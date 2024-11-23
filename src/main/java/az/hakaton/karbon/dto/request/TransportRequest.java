package az.hakaton.karbon.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransportRequest {
    private int bus;
    private int coach;
    private int localCommuterTrain;
    private int longDistanceTrain;
    private int tram;
    private int subway;
    private int taxi;
}
