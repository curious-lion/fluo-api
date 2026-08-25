/*
 * Copyright (c) 2026 Fluo API. All rights reserved.
 * This software is proprietary. Unauthorized copying, redistribution,
 * or commercial use is strictly prohibited under the terms defined
 * in the project's LICENSE and README.md.
 */
package com.fluo.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Category name is required.")
    @Size(max = 100, message = "Category name must not exceed 100 characters.")
    @Column(nullable = false, unique = true, length = 100)
    private String name;
}
