package com.uxtest.backend.controller;


import com.uxtest.backend.model.Recording;
import com.uxtest.backend.model.user.User;
import com.uxtest.backend.service.RecordingService;
import com.uxtest.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/recordingUpload")
public class RecordingController {

    @Autowired
    private RecordingService recordingService;
    @Autowired
    private UserService userService;
//    @Autowired
//    private TestService testService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public byte[] getRecording(@PathVariable("id") long id){
        return recordingService.getRecordingById(id).getContent();
    }


//    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/{userId}/{testId}", method = RequestMethod.POST)
    public void addRecording(@PathVariable("userId") Long userId, @PathVariable("testId") Long testId, @RequestBody byte[] video) {

        User user = userService.getUserById(userId);
//        Test task = testService.getTestById(testId);

//        recordingService.createRecording(Recording.builder().content(content).user(user).test(test).build());
        recordingService.createRecording(Recording.builder().video(video).user(user).build());
    }
}
