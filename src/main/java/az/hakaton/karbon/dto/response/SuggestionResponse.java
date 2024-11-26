package az.hakaton.karbon.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuggestionResponse {
    private double potentialReduction; // in kg CO2e
    private List<String> suggestions;
}
