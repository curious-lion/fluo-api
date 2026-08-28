package com.fluo.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CategoryRequest {

    @NotBlank(message = "Category name is required.")
    @Size(max = 100, message = "Category name must not exceed {max} characters.")
    private String name;
}
