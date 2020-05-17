package com.uxtest.backend.service;

import com.uxtest.backend.model.recording.Recording;
import com.uxtest.backend.repository.RecordingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RecordingService {

    @Autowired
    RecordingRepository recordingRepository;

    public Recording getRecordingById(Long id){
        return recordingRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recording not found"));
    }

    public void createRecording(Recording recording){
        recordingRepository.save(recording);
    }
}
