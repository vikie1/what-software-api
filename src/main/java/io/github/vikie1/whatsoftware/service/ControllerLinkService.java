package io.github.vikie1.whatsoftware.service;

import io.github.vikie1.whatsoftware.entity.CategoryEntity;
import io.github.vikie1.whatsoftware.entity.NestedCategoryEntity;
import io.github.vikie1.whatsoftware.entity.SoftwareEntity;
import io.github.vikie1.whatsoftware.pojo.DeriveEntityFromPojo;
import io.github.vikie1.whatsoftware.pojo.SoftwareAttributesPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ControllerLinkService {

    @Autowired
    SoftwareService softwareService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    NestedCategoryService nestedCategoryService;
    @Autowired
    TypeService typeService;

    //POST Request
    public void postSoftwareDetails(SoftwareAttributesPojo softwareAttributes){
        softwareService.addSoftware(DeriveEntityFromPojo.constructSoftwareEntity(softwareAttributes));
        typeService.addType(DeriveEntityFromPojo.constructTypeEntity(softwareAttributes));
        if (softwareAttributes.isNested()) nestedCategoryService.addNestedCategory((NestedCategoryEntity) DeriveEntityFromPojo.constructCategory(softwareAttributes));
        else categoryService.addCategory((CategoryEntity) DeriveEntityFromPojo.constructCategory(softwareAttributes));
    }

    //PUT Request
    public void putFullSoftwareDetailsUpdate(SoftwareAttributesPojo softwareAttributesPojo){
        try {
            softwareService.updateSoftware(DeriveEntityFromPojo.constructSoftwareEntity(softwareAttributesPojo));
            if (softwareAttributesPojo.isNested()) nestedCategoryService.updateNestedCategory((NestedCategoryEntity) DeriveEntityFromPojo.constructCategory(softwareAttributesPojo));
            else categoryService.updateCategory((CategoryEntity) DeriveEntityFromPojo.constructCategory(softwareAttributesPojo));
        } catch (
                SoftwareService.SoftwareNotFoundException |
                        NestedCategoryService.NestedCategoryNotFoundException | CategoryService.CategoryNotFoundException e) {
            e.printStackTrace();
        }
    }

    //GET Requests
}
