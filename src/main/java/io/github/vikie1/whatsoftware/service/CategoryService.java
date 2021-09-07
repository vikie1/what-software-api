package io.github.vikie1.whatsoftware.service;

import io.github.vikie1.whatsoftware.entity.CategoryEntity;
import io.github.vikie1.whatsoftware.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    //Create
    public void addCategory(CategoryEntity categoryEntity){ categoryRepository.save(categoryEntity); }

    //Read
    public List<CategoryEntity> getAllCategories(){ return new ArrayList<CategoryEntity>(categoryRepository.findAll()); }
    public List<CategoryEntity> getAllByCategory(String category) { return new ArrayList<CategoryEntity>(categoryRepository.findAllByCatNameAllIgnoreCase(category)); }
    public List<CategoryEntity> getAllBySoftwareName(String software){ return new ArrayList<CategoryEntity>(categoryRepository.findAllBySoftwareAllIgnoreCase(software)); }
    public List<CategoryEntity> getAllByNestedCategory(String nestedCategory){
        return new ArrayList<CategoryEntity>(categoryRepository.findAllByNestedCategoryAllIgnoreCase(nestedCategory));
    }

    //Update
    public void updateCategory(CategoryEntity newCategory) throws CategoryNotFoundException {
        CategoryEntity oldCategory;
        if (categoryRepository.existsByNestedCategoryAllIgnoreCase(newCategory.getNestedCategory())){
            oldCategory = categoryRepository.findByNestedCategoryAllIgnoreCase(newCategory.getNestedCategory());
            newCategory.setId(oldCategory.getId());
        }else if(categoryRepository.existsBySoftwareAllIgnoreCase(newCategory.getSoftware())){
            oldCategory = categoryRepository.findBySoftwareAllIgnoreCase(newCategory.getSoftware());
            newCategory.setId(oldCategory.getId());
        }else throw new CategoryNotFoundException(
                "Category for Software : " + newCategory.getNestedCategory()
                        + " of nestedCategory : " + newCategory.getNestedCategory()
                        + "Does Not Exist"
        );
        categoryRepository.save(newCategory);
    }

    //Delete
    public void deleteCategory(CategoryEntity category){ categoryRepository.delete(category); }
    public void clearCategories(){ categoryRepository.deleteAll(); }
    public void deleteById(Long id){ categoryRepository.deleteById(id); }
    public void deleteBySoftware(String software){ categoryRepository.deleteBySoftwareAllIgnoreCase(software);}

    static class CategoryNotFoundException extends Exception{
        CategoryNotFoundException(String errorMessage){
            super(errorMessage);
        }
    }
}
