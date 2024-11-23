package az.hakaton.karbon.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDataCalculatedResponse {
    private double energy;
    private double secondary;
    private double transport;
    private double vehicle;
    private double total;
}
