package com.uxtest.backend.controller;

import com.uxtest.backend.dto.UxModelDTO;
import com.uxtest.backend.model.uxmodel.UxModel;
import com.uxtest.backend.service.UxModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/uxmodels", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UxModelController {
    @Autowired
    private UxModelService uxModelService;

    @GetMapping("/{id}")
    @ResponseBody
    public UxModelDTO getUxModel(@PathVariable("id") URL id) {
        return uxModelService.getUxModelById(id).mapToDTO();
    }

    @GetMapping
    @ResponseBody
    public List<UxModelDTO> getUxModel() {
        return uxModelService.getUxModels().stream().map(UxModel::mapToDTO).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUxModel(@RequestBody UxModelDTO uxModelDTO) {
        uxModelService.createUxModel(uxModelDTO.parseUxModel());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUxModel(@RequestBody UxModelDTO uxModelDTO, @PathVariable URL id) {
        uxModelService.updateUxModel(uxModelDTO.parseUxModel(), id);
    }
}
