package io.github.vikie1.whatsoftware.service;

import io.github.vikie1.whatsoftware.entity.CategoryEntity;
import io.github.vikie1.whatsoftware.entity.NestedCategoryEntity;
import io.github.vikie1.whatsoftware.entity.TypeEntity;
import io.github.vikie1.whatsoftware.pojo.CategoryEntitiesAbstraction;
import io.github.vikie1.whatsoftware.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeService {

    @Autowired
    TypeRepository typeRepository;

    //Create
    public void addType(TypeEntity type){ typeRepository.save(type); }
    public void addTypeFromRawData(String type, CategoryEntitiesAbstraction category, boolean isNested){
        typeRepository.save( new TypeEntity(type, category, isNested));
    }

    //Read
    public List<TypeEntity> getAllByNestedCategory(NestedCategoryEntity nestedCategory){
        return new ArrayList<TypeEntity> ( typeRepository.findAllByNestedCategoryEntity(nestedCategory));
    }
    public List<TypeEntity> getAllByCategory(CategoryEntity categoryEntity){
        return new ArrayList<TypeEntity>( typeRepository.findAllByCategoryEntity(categoryEntity));
    }

}
