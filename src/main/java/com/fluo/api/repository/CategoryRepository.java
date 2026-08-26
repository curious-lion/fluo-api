/*
 * Copyright (c) 2026 Fluo API. All rights reserved.
 * This software is proprietary. Unauthorized copying, redistribution,
 * or commercial use is strictly prohibited under the terms defined
 * in the project's LICENSE and README.md.
 */
package com.fluo.api.repository;

import com.fluo.api.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    public boolean existsByName(String name);
}
