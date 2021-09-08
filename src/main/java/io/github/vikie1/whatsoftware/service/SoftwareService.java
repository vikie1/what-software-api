package io.github.vikie1.whatsoftware.service;

import io.github.vikie1.whatsoftware.entity.SoftwareEntity;
import io.github.vikie1.whatsoftware.repository.SoftwareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoftwareService {

    @Autowired
    SoftwareRepository softwareRepository;

    //Create
    public void addSoftware(SoftwareEntity softwareEntity) { softwareRepository.save(softwareEntity); }

    //Read
    public SoftwareEntity getById(Long id){ return softwareRepository.getById(id); }
    public SoftwareEntity getBySoftwareName(String name) { return softwareRepository.findByNameAllIgnoreCase(name); }

    //Update
    public void updateSoftware(SoftwareEntity newSoftwareEntity) throws SoftwareNotFoundException {
        SoftwareEntity oldSoftwareEntity;
        if (softwareRepository.existsByName(newSoftwareEntity.getName())){
            oldSoftwareEntity = softwareRepository.findByNameAllIgnoreCase(newSoftwareEntity.getName());
            newSoftwareEntity.setId(oldSoftwareEntity.getId());
        } else throw new SoftwareNotFoundException("Software : " + newSoftwareEntity.getName() + "Does Not Exist" );
        softwareRepository.save(newSoftwareEntity);
    }

    //Delete
    public void delete(SoftwareEntity software){ softwareRepository.delete(software); }
    public void clearSoftware(){ softwareRepository.deleteAll(); }
    public void deleteByName(String name){ softwareRepository.deleteByName(name); }

    static class SoftwareNotFoundException extends Exception{
        SoftwareNotFoundException(String exceptionMessage){ super(exceptionMessage); }
    }
}
