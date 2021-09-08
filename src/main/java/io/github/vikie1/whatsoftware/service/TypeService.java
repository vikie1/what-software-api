package io.github.vikie1.whatsoftware.service;

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

    //Create
    public void addType(TypeEntity type){ typeRepository.save(type); }

    //Read
    public TypeEntity getTypeById(Long id){ return typeRepository.getById(id); }
    public List<TypeEntity> getAllByType(String type){ return new ArrayList<TypeEntity>( typeRepository.findAllByTypeAllIgnoreCase(type)); }
    public List<TypeEntity> getAllSoftwareName(String software){
        TypeEntity type = typeRepository.findBySoftwareAllIgnoreCase(software);
        return new ArrayList<TypeEntity>(typeRepository.findAllByTypeAllIgnoreCase(type.getType()));
    }

    //Update
    public void updateType(TypeEntity newType) throws TypeNotFoundException {
        TypeEntity oldType;
        if (typeRepository.existsBySoftwareAllIgnoreCase(newType.getSoftware())){
            oldType = typeRepository.findBySoftwareAllIgnoreCase(newType.getSoftware());
            newType.setId(oldType.getId());
        }else throw new TypeNotFoundException("No Type Found For Software : " + newType.getSoftware());
        typeRepository.save(newType);
    }

    static class TypeNotFoundException extends Exception{
        TypeNotFoundException(String exceptionMessage){ super(exceptionMessage); }
    }
}
