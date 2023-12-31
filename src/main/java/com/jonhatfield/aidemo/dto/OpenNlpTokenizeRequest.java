package com.jonhatfield.aidemo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Schema(name="ZooChatbotTokenizeRequest", description="Model for sending a message to tokenize")
@Getter
@Setter
@RequiredArgsConstructor
public class OpenNlpTokenizeRequest {

    @Schema(description = "Message to tokenize", required = true, example = "any giraffes?")
    String message;
}