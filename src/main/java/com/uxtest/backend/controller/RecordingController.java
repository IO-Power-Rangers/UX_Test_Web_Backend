package com.uxtest.backend.controller;

import com.uxtest.backend.dto.recording.RecordingDTO;
import com.uxtest.backend.service.RecordingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recordings")
public class RecordingController {

    @Autowired
    private RecordingService recordingService;

//    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/{videoId}", method = RequestMethod.GET)
    public @ResponseBody RecordingDTO getRecording(@PathVariable("videoId") Long videoId){
        return recordingService.getRecordingById(videoId).mapToDTO();
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody RecordingDTO addRecording(@RequestBody RecordingDTO recordingDTO) {
        recordingService.createRecording(recordingDTO.parseRecording());
        return recordingDTO;
    }
}
