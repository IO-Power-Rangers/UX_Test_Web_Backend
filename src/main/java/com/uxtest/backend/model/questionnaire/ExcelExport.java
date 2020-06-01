package com.uxtest.backend.model.questionnaire;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExcelExport {
    String base64StringFile;
    String fileName;
}
