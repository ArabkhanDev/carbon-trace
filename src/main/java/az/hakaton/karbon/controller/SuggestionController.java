package az.hakaton.karbon.controller;

import az.hakaton.karbon.dto.request.SuggestionRequest;
import az.hakaton.karbon.dto.response.SuggestionResponse;
import az.hakaton.karbon.service.inter.SuggestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/suggestions")
@RequiredArgsConstructor
public class SuggestionController {

    private final SuggestionService suggestionService;

    @PostMapping("/generate")
    public ResponseEntity<SuggestionResponse> getSuggestion(@RequestBody SuggestionRequest requestDTO) {
        SuggestionResponse response = suggestionService.generateSuggestions(requestDTO);
        return ResponseEntity.ok(response);
    }

}
