package services;

import services.models.Exhibition;
import services.repository.ExhibitionRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExhibitionService implements IExhibitionService {
    @Autowired
    private ExhibitionRepository repository;

    @Override
    public List<Exhibition> findAll() {
        return (List<Exhibition>) repository.findAll();
    }

    @Override
    public Exhibition save(Exhibition exhibitionForSave) {
        return repository.save(exhibitionForSave);
    }

    @Override
    public Exhibition getById(String id) throws NotFoundException {
        Optional<Exhibition> tempExhibition = repository.findById(id);
        if (tempExhibition.isPresent())
            return repository.findById(id).get();
        else
            throw new NotFoundException(String.format("Exhibition with id %s does not exist", id));
    }

    @Override
    public void deleteById(String id) throws NotFoundException {
        repository.delete(getById(id));
    }
}