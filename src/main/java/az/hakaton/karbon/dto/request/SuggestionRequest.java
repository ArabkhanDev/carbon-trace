package az.hakaton.karbon.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuggestionRequest {
    private String userId;
    private double currentCarbonEmission; // in kg CO2e
    private List<String> habits; // e.g., ["drive car daily", "uses plastic bags"]
    private String region; // for location-specific suggestions
}
