package services;

import javassist.NotFoundException;
import services.models.Exhibition;

import java.util.List;

public interface IExhibitionService {
    List<Exhibition> findAll();

    Exhibition save(Exhibition exhibitionForSave);

    Exhibition getById(String id) throws NotFoundException;

    void deleteById(String id) throws NotFoundException;
}

