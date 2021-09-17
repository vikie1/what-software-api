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
    public List<String> getAllCategories(){ return new ArrayList<String>(categoryRepository.findAllDistinctCatName()); }
    public CategoryEntity getCategory(String category) {
        if (!categoryRepository.existsByCatNameAllIgnoreCase(category)) return null;
        return categoryRepository.findByCatNameAllIgnoreCase(category);
    }
    public List<CategoryEntity> getCategories(String category) { return categoryRepository.findByCatNameAllIgnoreCase(category); }
    //public List<CategoryEntity> getAllSoftwareByName(String software){ return new ArrayList<CategoryEntity>(categoryRepository.findAllBySoftwareAllIgnoreCase(software)); }
    public List<CategoryEntity> getAllByNestedCategory(String nestedCategory){
        return new ArrayList<CategoryEntity>(categoryRepository.findAllByNestedCategoryAllIgnoreCase(nestedCategory));
    }
//    public List<CategoryEntity> getCategoriesBySoftwareName(String software){
//        CategoryEntity category = categoryRepository.findBySoftwareAllIgnoreCase(software);
//        return new ArrayList<CategoryEntity>(categoryRepository.findAllByCatNameAllIgnoreCase(category.getCatName()));
//    }
    public List<CategoryEntity> getCategoriesByNestedCategory(String nestedCategory){
        CategoryEntity category = categoryRepository.findByNestedCategoryAllIgnoreCase(nestedCategory);
        return new ArrayList<CategoryEntity>(categoryRepository.findByCatNameAllIgnoreCase(category.getCatName()));
    }
    public boolean isNested(String catName) throws CategoryNotFoundException {
        if (categoryRepository.existsByNestedCategoryAllIgnoreCase(catName)) return true;
        else if (categoryRepository.existsByCatNameAllIgnoreCase(catName)) return false;
        else throw new CategoryNotFoundException("Category " + catName + " Does not exist");
    }

    //Update
    public void updateCategory(CategoryEntity newCategory) throws CategoryNotFoundException {
        CategoryEntity oldCategory;
        if (categoryRepository.existsByNestedCategoryAllIgnoreCase(newCategory.getNestedCategory())){
            oldCategory = categoryRepository.findByNestedCategoryAllIgnoreCase(newCategory.getNestedCategory());
            newCategory.setId(oldCategory.getId());
//        }else if(categoryRepository.existsBySoftwareAllIgnoreCase(newCategory.getSoftware())){
//            oldCategory = categoryRepository.findBySoftwareAllIgnoreCase(newCategory.getSoftware());
//            newCategory.setId(oldCategory.getId());
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
    //public void deleteBySoftware(String software){ categoryRepository.deleteBySoftwareAllIgnoreCase(software);}

    static class CategoryNotFoundException extends Exception{
        CategoryNotFoundException(String errorMessage){
            super(errorMessage);
        }
    }
}
