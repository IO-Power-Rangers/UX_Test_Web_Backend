package com.uxtest.backend.service;

import com.uxtest.backend.model.uxmodel.UxModel;
import com.uxtest.backend.repository.UxModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.net.URL;
import java.util.List;

@Service
public class UxModelService {
    @Autowired
    UxModelRepository uxModelRepository;

    public UxModel getUxModelById(URL id) {
        return uxModelRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ux model not found"));
    }


    public void createUxModel(UxModel uxModel) {
        uxModelRepository.save(uxModel);
    }

    public void updateUxModel(UxModel uxModel, URL id) {
        if (uxModelRepository.existsById(id)) {
            uxModel.setAxLink(id);
            uxModelRepository.save(uxModel);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ux model not found");
        }
    }

    public List<UxModel> getUxModels() {
        return uxModelRepository.findAll();
    }
}
