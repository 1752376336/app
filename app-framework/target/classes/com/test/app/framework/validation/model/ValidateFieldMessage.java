package com.test.app.framework.validation.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ValidateFieldMessage implements Serializable {
    private String field;
    private String message;
}
