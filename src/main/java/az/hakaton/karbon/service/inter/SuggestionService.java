package az.hakaton.karbon.service.inter;

import az.hakaton.karbon.dto.request.SuggestionRequest;
import az.hakaton.karbon.dto.response.SuggestionResponse;

public interface SuggestionService {

    SuggestionResponse generateSuggestions(SuggestionRequest requestDTO);
}
