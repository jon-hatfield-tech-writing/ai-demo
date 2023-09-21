package com.jonhatfield.aidemo.dto.helper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpenNlpTag {
    private String tag;
    private Double probability;
}