package com.javadevjournal.restexample.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class PostDto {
    private long id;
    @NotBlank
    private String title;
    //@JsonProperty("desc")
    private String description;
    private String content;
}
