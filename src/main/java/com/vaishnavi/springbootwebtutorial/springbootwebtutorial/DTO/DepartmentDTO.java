package com.vaishnavi.springbootwebtutorial.springbootwebtutorial.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    private long id;
    private String title;
    private String createdAt;
    @JsonProperty("isActive")
    private boolean isActive;
}