package user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import user.service.AiService;

import java.io.IOException;

@RestController
public class VoiceController {

    private AiService aiService;

    public VoiceController(AiService aiService) {
        this.aiService = aiService;
    }

    @PostMapping(path = "voice/text", produces = "text/json;charset=utf-8")
    public ResponseEntity<String> getText(@RequestParam("voice") MultipartFile multipartFile) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(aiService.getText(multipartFile.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK).body("");
    }
}