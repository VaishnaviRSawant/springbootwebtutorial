package com.vaishnavi.springbootwebtutorial.springbootwebtutorial.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vaishnavi.springbootwebtutorial.springbootwebtutorial.Annotation.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.PrivateKey;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDTO {
private Long id ;

@NotBlank(message = "Name field cannot be blank")
@Size(min=3,max = 15, message = "Number of characters in name should be in range :[3,15]")
private String name;

@NotBlank(message ="Email cannot be empty")
@Email(message = "Email should be a valid email")
private String email;

@NotNull(message = "Age cannot be null")
@Max(value = 70,message = "Age cannot be greater than 80 ")
@Min(value = 18, message = "Age cannot be less than 18")
private Integer age;

@EmployeeRoleValidation
@NotBlank(message ="Role cannot be empty")
private String role;

@NotNull(message = "salary cannot be null")
@Positive(message ="salary should be positive")
@Digits(integer = 6, fraction = 2)
@DecimalMax(value = "10000.99")
@DecimalMin(value = "100.50")
private Double salary;

@PastOrPresent(message ="dateOfJoining field can only be of past or present")
private LocalDate dateOfJoining;

@AssertTrue(message = "isActive has to be true")
@JsonProperty("isActive")
private Boolean isActive;

}
