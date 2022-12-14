package com.lun.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class ErrorInfo {
    private int status;
    private String message;
}