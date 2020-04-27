package com.uxtest.backend.controller;

import com.uxtest.backend.model.Recording;
import com.uxtest.backend.service.RecordingService;
import com.uxtest.backend.service.TestService;
import com.uxtest.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recordingUpload")
public class RecordingController {

    @Autowired
    private RecordingService recordingService;
    @Autowired
    private UserService userService;
    @Autowired
    private TestService testService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public byte[] getRecording(@PathVariable("id") Long id){
        return recordingService.getRecordingById(id).video;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/{userId}/{testId}", method = RequestMethod.POST)
    public void addRecording(@PathVariable("userId") Long userId, @PathVariable("testId") Long testId, @RequestBody byte[] video) {
        recordingService.createRecording(
                Recording.builder()
                        .video(video)
                        .user(userService.getUserById(userId))
                        .test(testService.getTestById(testId))
                        .build());
    }
}
