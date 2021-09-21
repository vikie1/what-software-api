package io.github.vikie1.whatsoftware.service;

import io.github.vikie1.whatsoftware.entity.CategoryEntity;
import io.github.vikie1.whatsoftware.entity.TypeEntity;
import io.github.vikie1.whatsoftware.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeService {

    @Autowired
    TypeRepository typeRepository;
    @Autowired
    CategoryService categoryService;

    //Create
    public void addType(TypeEntity type){
        CategoryEntity givenCategory = type.getCategoryEntity();
        CategoryEntity neededCategory = categoryService.getCategory(givenCategory.getCatName());
        if (neededCategory != null) type.setCategoryEntity(neededCategory);
        else {
            categoryService.addCategory(givenCategory);
            addType(type);
        }
        typeRepository.save(type);
    }
    public void addTypeFromRawData(String type, CategoryEntity category, boolean isNested){
        typeRepository.save( new TypeEntity(type, category, isNested));
    }

    //Read
    public List<TypeEntity> getAllByCategory(CategoryEntity categoryEntity){
        return new ArrayList<TypeEntity>( typeRepository.findAllByCategoryEntity(categoryEntity));
    }
    public TypeEntity getType(String type){
        if (!typeRepository.existsByTypeAllIgnoreCase(type)) return null;
        return typeRepository.findByTypeAllIgnoreCase(type);
    }

}
