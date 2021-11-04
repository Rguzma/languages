package com.guzman.languages.repositories;
import com.guzman.languages.models.*;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


public interface LanguageRepository extends CrudRepository<Language, Long>{
    // this method retrieves all the books from the database
    List<Language> findAll();
//    // this method finds books with descriptions containing the search string
//    List<Language> findByCreator(String search);
//    // this method counts how many titles contain a certain string
//    Long countByNameContaining(String search);
//    // this method deletes a book that starts with a specific title
//    Long deleteByNameStartingWith(String search);
//	Optional<Language> findByIdentifier( Long id ); // SELECT * FROM hobbies WHERE identifier=id
//	Language save( Language language );
}
