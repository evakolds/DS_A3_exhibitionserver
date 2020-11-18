package services.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import services.models.Exhibition;

@Repository
public interface ExhibitionRepository extends CrudRepository<Exhibition, String> {

}