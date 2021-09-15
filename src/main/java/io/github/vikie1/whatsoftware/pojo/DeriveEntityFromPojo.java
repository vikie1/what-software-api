package io.github.vikie1.whatsoftware.pojo;

import io.github.vikie1.whatsoftware.entity.CategoryEntity;
import io.github.vikie1.whatsoftware.entity.NestedCategoryEntity;
import io.github.vikie1.whatsoftware.entity.SoftwareEntity;
import io.github.vikie1.whatsoftware.entity.TypeEntity;
import org.springframework.lang.NonNull;

/**
 * This class just help reduce the number/size of JSON objects sent to controller
 * It does so by constructing Entity classes from pojo thus reducing redundancy in JSON objects.
 * Am I doing this because I've not fully grasped relational sql
 */

public class DeriveEntityFromPojo {
    private CategoryEntity category;
    private NestedCategoryEntity nestedCategory;

    //Construct SoftwareEntity
    static public SoftwareEntity constructSoftwareEntity(@NonNull SoftwareAttributesPojo softwareAttributesPojo){
        return new SoftwareEntity(
                softwareAttributesPojo.getSoftwareName(),
                softwareAttributesPojo.getDescription(),
                softwareAttributesPojo.getDownloadUrl(),
                constructTypeEntity(softwareAttributesPojo)
        );
    }

    //Construct TypeEntity
    static public TypeEntity constructTypeEntity(@NonNull SoftwareAttributesPojo softwareAttributesPojo){
        return new TypeEntity(
                softwareAttributesPojo.getType(),
                constructCategory(softwareAttributesPojo),
                softwareAttributesPojo.isNested()
        );
    }

    //Create **CategoryEntity via CategoryEntitiesAbstraction
    static public CategoryEntitiesAbstraction constructCategory(@NonNull SoftwareAttributesPojo softwareAttributesPojo){
        if (softwareAttributesPojo.isNested()) {
            return new NestedCategoryEntity(
                    softwareAttributesPojo.getParentCategory(),
                    softwareAttributesPojo.getCategory(),
                    softwareAttributesPojo.getSoftwareName()
            );
        }else{
            return new CategoryEntity(
                    softwareAttributesPojo.getCategory(),
                    softwareAttributesPojo.getSoftwareName(),
                    null
            );
        }
    }

}
