package com.bienvenu.service;

import com.bienvenu.model.Event;
import com.bienvenu.model.OllamaRequest;
import com.bienvenu.model.OllamaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AIEventDetailsImpl implements AIEventDetails{
    private static final String OLLAMA_URL = "http://localhost:11434/api/generate";
    private static final String DEFAULT_MODEL = "llama3";

    @Autowired
    private EventService eventService;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String generateEventDetails(Long eventId){
        Event event = eventService.findById(eventId);

        String prompt = buildPrompt(event);
        OllamaRequest request = new OllamaRequest(DEFAULT_MODEL, prompt, false);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<OllamaRequest> entity = new HttpEntity<>(request, headers);

        ResponseEntity<OllamaResponse> response = restTemplate.exchange(
                OLLAMA_URL,
                HttpMethod.POST,
                entity,
                OllamaResponse.class
        );

        if(response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            return response.getBody().getResponse();
        }else {
            return "[AI summary generation failed: " + response.getStatusCode() + "]";
        }
    }

    private String buildPrompt(Event event) {
        return "give more insights on how the event would be and what it is about, based on this data: \n"
                + "- title of the event: " + event.getTitle() + "\n"
                + "- description of the event: " + event.getDescription() + "\n"
                + "- place of the event: " + event.getPlace() + "\n"
                + "- date of the event: " + event.getDatetime() + "\n"
                + "- number of people that are interested: " + event.getTotalInterest();
    }
}
