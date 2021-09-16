package io.github.vikie1.whatsoftware.pojo;

import io.github.vikie1.whatsoftware.entity.CategoryEntity;
import io.github.vikie1.whatsoftware.entity.NestedCategoryEntity;

public class CategoryEntitiesAbstraction {
    private final CategoryEntity category;
    private final NestedCategoryEntity nestedCategory;

    public CategoryEntitiesAbstraction(CategoryEntity category, NestedCategoryEntity nestedCategory){ this.category = category; this.nestedCategory = nestedCategory; }

    public CategoryEntity getCategory() { return category; }
    public NestedCategoryEntity getNestedCategory() { return nestedCategory; }
}
