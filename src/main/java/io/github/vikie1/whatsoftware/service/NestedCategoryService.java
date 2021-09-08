package io.github.vikie1.whatsoftware.service;

import io.github.vikie1.whatsoftware.entity.NestedCategoryEntity;
import io.github.vikie1.whatsoftware.repository.NestedCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NestedCategoryService {

    @Autowired
    NestedCategoryRepository nestedCategoryRepository;

    //Create
    public void addNestedCategory(NestedCategoryEntity nestedCategory){ nestedCategoryRepository.save(nestedCategory); }

    //Read
    public List<NestedCategoryEntity> getAllByNestedCategory(String nestedCategory){
        return new ArrayList<NestedCategoryEntity>(nestedCategoryRepository.findAllByCatNameAllIgnoreCase(nestedCategory));
    }
    public List<NestedCategoryEntity> getByParentCategory(String parentCategory){
        return new ArrayList<NestedCategoryEntity>(nestedCategoryRepository.findAllByParentCategoryAllIgnoreCase(parentCategory));
    }
    public List<NestedCategoryEntity> getBySoftwareName(String software){
        NestedCategoryEntity nestedCategory = nestedCategoryRepository.findBySoftwareAllIgnoreCase(software);
        return new ArrayList<NestedCategoryEntity>(nestedCategoryRepository.findAllByCatNameAllIgnoreCase(nestedCategory.getCatName()));
    }
    public List<NestedCategoryEntity> getAllNestedNestedCategory(String nestedCategory){
        NestedCategoryEntity nestedCategoryEntity = nestedCategoryRepository.findByNestedCategoryAllIgnoreCase(nestedCategory);
        return new ArrayList<NestedCategoryEntity>(nestedCategoryRepository.findAllByCatNameAllIgnoreCase(nestedCategoryEntity.getNestedCategory()));
    }

    //Update
    public void updateNestedCategory(NestedCategoryEntity newNestedCategory) throws NestedCategoryNotFoundException {
        NestedCategoryEntity oldNestedCategory;
        if (nestedCategoryRepository.existsBySoftwareAllIgnoreCase(newNestedCategory.getSoftware())){
            oldNestedCategory = nestedCategoryRepository.findBySoftwareAllIgnoreCase(newNestedCategory.getSoftware());
            newNestedCategory.setId(oldNestedCategory.getId());
        } else throw new NestedCategoryNotFoundException(
                "NestedCategory Not Found For Software : "
                + newNestedCategory.getSoftware()
        );
        nestedCategoryRepository.save(newNestedCategory);
    }

    //Delete
    public void delete(NestedCategoryEntity nestedCategory){ nestedCategoryRepository.delete(nestedCategory); }
    public void clear(){ nestedCategoryRepository.deleteAll(); }
    public void deleteBySoftware(String software){ nestedCategoryRepository.deleteBySoftwareAllIgnoreCase(software); }

    static class NestedCategoryNotFoundException extends Exception{
        NestedCategoryNotFoundException(String exceptionMessage){ super(exceptionMessage); }
    }
}
