package io.github.vikie1.whatsoftware.service;

import io.github.vikie1.whatsoftware.entity.CategoryEntity;
import io.github.vikie1.whatsoftware.entity.NestedCategoryEntity;
import io.github.vikie1.whatsoftware.entity.SoftwareEntity;
import io.github.vikie1.whatsoftware.entity.TypeEntity;
import io.github.vikie1.whatsoftware.pojo.DeriveEntityFromPojo;
import io.github.vikie1.whatsoftware.pojo.SoftwareAttributesPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    public void postSoftwareDetails(SoftwareAttributesPojo softwareAttributes) {
//        if (softwareAttributes.isNested()) {
//            nestedCategoryService.addNestedCategory(DeriveEntityFromPojo.constructCategory(softwareAttributes).getNestedCategory());
//        }
//        else categoryService.addCategory(DeriveEntityFromPojo.constructCategory(softwareAttributes).getCategory());
//        typeService.addType(DeriveEntityFromPojo.constructTypeEntity(softwareAttributes));
        softwareService.addSoftware(DeriveEntityFromPojo.constructSoftwareEntity(softwareAttributes));
    }

    //PUT Request
    public void putFullSoftwareDetailsUpdate(SoftwareAttributesPojo softwareAttributesPojo) {
        try {
            softwareService.updateSoftware(DeriveEntityFromPojo.constructSoftwareEntity(softwareAttributesPojo));
            if (softwareAttributesPojo.isNested())
                nestedCategoryService.updateNestedCategory(DeriveEntityFromPojo.constructCategory(softwareAttributesPojo).getNestedCategory());
            else
                categoryService.updateCategory(DeriveEntityFromPojo.constructCategory(softwareAttributesPojo).getCategory());
        } catch (
                SoftwareService.SoftwareNotFoundException |
                        NestedCategoryService.NestedCategoryNotFoundException | CategoryService.CategoryNotFoundException e) {
            e.printStackTrace();
        }
    }

    //GET Requests
    public HashMap<String, List<SoftwareEntity>> getSoftwareByCategory(String category) {
        HashMap<String, List<SoftwareEntity>> typeEntityHashMap = new HashMap<>();
        List<SoftwareEntity> entityList;
        entityList = new ArrayList<>(softwareService.getSoftwareByCategory(categoryService.getCategory(category)));
        typeEntityHashMap.put("list", entityList);
        return typeEntityHashMap;
    }
    public HashMap<String, List<TypeEntity>> getByType(String category){
        HashMap<String, List<TypeEntity>> typeEntityHashMap = new HashMap<>();
        List<TypeEntity> entityList = new ArrayList<>();
        try {
            if (categoryService.isNested(category)) entityList.addAll(typeService.getAllByNestedCategory(nestedCategoryService.getNestedCategory(category)));
            else entityList.addAll(typeService.getAllByCategory(categoryService.getCategory(category)));
        } catch (CategoryService.CategoryNotFoundException e) {
            e.printStackTrace();
        }
        typeEntityHashMap.put(category, entityList);
        return typeEntityHashMap;
    }
}