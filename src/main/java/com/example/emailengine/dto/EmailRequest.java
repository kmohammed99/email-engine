package com.example.emailengine.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Validated
public class EmailRequest {
    private List<String> to;
    private String subject;
    private String body;

}