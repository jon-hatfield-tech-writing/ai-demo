package com.jonhatfield.aidemo.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class OpenNlpCategoriseRequest {
    String message;
}