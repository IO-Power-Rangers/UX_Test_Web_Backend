package com.uxtest.backend.controller;

import com.uxtest.backend.dto.TestDTO;
import com.uxtest.backend.dto.recording.RecordingDTO;
import com.uxtest.backend.model.recording.Recording;
import com.uxtest.backend.model.test.Test;
import com.uxtest.backend.service.RecordingService;
import com.uxtest.backend.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/recordings")
public class RecordingController {

    @Autowired
    private RecordingService recordingService;

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/{videoId}", method = RequestMethod.GET)
    public @ResponseBody RecordingDTO getRecording(@PathVariable("videoId") Long videoId){
        return recordingService.getRecordingById(videoId).mapToDTO();
    }

    @RequestMapping(value = "/byTest/{testId}", method = RequestMethod.GET)
    public @ResponseBody List<RecordingDTO> getAllRecordingsInfo(@PathVariable("testId") Long testId){
        return testService.getTestById(testId).getRecordingWithoutVideo().stream().map(Recording::mapToDTO).collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody RecordingDTO addRecording(@RequestBody RecordingDTO recordingDTO) {
        System.out.println(recordingDTO.toString());
        recordingService.createRecording(recordingDTO.parseRecording());
        return recordingDTO;
    }
}
