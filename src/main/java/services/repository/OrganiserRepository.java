package services.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import services.models.Exhibition;
import services.models.Organiser;

@Repository
public interface OrganiserRepository extends CrudRepository<Organiser, String> {

}