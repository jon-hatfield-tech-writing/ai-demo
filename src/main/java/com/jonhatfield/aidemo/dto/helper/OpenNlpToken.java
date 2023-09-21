package com.jonhatfield.aidemo.dto.helper;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(name="ZooChatbotToken", description="Model for holding a token and its associated probability")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpenNlpToken {
    @Schema(required = true)
    private String token;

    @Schema(required = true)
    private Double probability;
}