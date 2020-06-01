package com.uxtest.backend.controller;


import com.uxtest.backend.model.questionnaire.ExcelExport;
import com.uxtest.backend.service.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/api/export")
public class ExportController {

    @Autowired
    ExportService exportService;

    @GetMapping("/{id}")
    public ExcelExport getExcelExport(@PathVariable("id") Long questionnaireId) throws IOException {
        return exportService.getExcelExport(questionnaireId);
    }
}
