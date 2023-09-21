package com.jonhatfield.aidemo.dto;

import com.jonhatfield.aidemo.dto.helper.OpenNlpTag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpenNlpPosResponse {
    private String[] tags;
    List<OpenNlpTag> probabilities;
}
