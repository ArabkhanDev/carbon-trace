package az.hakaton.karbon.service.impl;

import az.hakaton.karbon.dto.request.SuggestionRequest;
import az.hakaton.karbon.dto.response.SuggestionResponse;
import az.hakaton.karbon.service.inter.SuggestionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SuggestionServiceImpl implements SuggestionService {

    public SuggestionResponse generateSuggestions(SuggestionRequest requestDTO) {
        double currentEmission = requestDTO.getCurrentCarbonEmission();
        List<String> habits = requestDTO.getHabits();

        List<String> suggestions = new ArrayList<>();
        double potentialReduction = 0.0;

        if (habits.contains("drive car daily")) {
            suggestions.add("Consider carpooling or using public transportation.");
            potentialReduction += currentEmission * 0.3; // 30% reduction
        }
        if (habits.contains("uses plastic bags")) {
            suggestions.add("Switch to reusable bags to reduce plastic waste.");
            potentialReduction += 5; // assume a fixed reduction
        }

        return new SuggestionResponse(potentialReduction, suggestions);
    }
}
