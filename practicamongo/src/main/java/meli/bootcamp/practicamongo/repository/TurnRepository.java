package meli.bootcamp.practicamongo.repository;

import meli.bootcamp.practicamongo.model.Turn;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurnRepository extends MongoRepository<Turn, String> {


    @Query("{}")
    List<Turn> getTurns();

    List<Turn> getTurnByDoctorLastName(String lastName);

    @Query("{doctor:{lastName: ?0}")
    List<Turn> getTurnByDoctorLastName1(String lastName);


    @Query("{doctor:{lastName: :#{#lastName}}}")
    List<Turn> getTurnByDoctorLastName2(String lastName);

    List<Turn> getTurnByStatus(String status);

    @Query("{status: ?0}")
    List<Turn> getTurnByStatus1(String status);

}
