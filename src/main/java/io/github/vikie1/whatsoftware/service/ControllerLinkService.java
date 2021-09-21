package io.github.vikie1.whatsoftware.service;

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
            categoryService.updateCategory(DeriveEntityFromPojo.createCategory(softwareAttributesPojo));
        } catch (
                SoftwareService.SoftwareNotFoundException | CategoryService.CategoryNotFoundException e) {
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
        List<TypeEntity> entityList = new ArrayList<>(typeService.getAllByCategory(categoryService.getCategory(category)));
        typeEntityHashMap.put(category, entityList);
        return typeEntityHashMap;
    }
}