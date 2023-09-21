package com.jonhatfield.aidemo.dto;

import com.jonhatfield.aidemo.dto.helper.DjlHandwrittenNumber;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DjlImageClassificationResponse {
    private String handwrittenNumber;
    List<DjlHandwrittenNumber> probabilities;
}
