package com.example.business.data.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;


/**
 * The bulk of the backend business logic. All of the service classes do the some functions,
 * this abstract class cuts down on the repetitive functions by using generics.
 * @author Will
 *
 * @param <E> The DAO
 * @param <K> The type of id this DAO uses.
 */
@Repository
public abstract class AbstractService<E, K> {

    @Autowired
    private CrudRepository<E, K> repo;

    /**
     * Used by response entities to specific the header.
     */
    private HttpHeaders headers = new HttpHeaders();

    /**
     * Empty Constructor to init the HttpHeaders content type.
     */
    public AbstractService() {
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    /**
     * Gets a specific entity by id in the DB
     * @param id
     * @return a specific entity by it's id
     */
    public Optional<E> getEntityByID(K id) {
        return repo.findById(id);
    }

    /**
     * Finds all Entities of this kind in the repo
     * @return a list of all entities in DB
     */
    public Iterable<E> getAllEntities(){
        return repo.findAll();
    }

    /**
     * Creates an Entity with the entity itself and the id of the entity.
     * @param newEntity
     * @param id
     * @return a response entity that informs the client of their transaction results.
     */
    public ResponseEntity<?> createEntity(E newEntity, K id){
        String className = newEntity.getClass().getSimpleName();
        HttpStatus resultingStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        try {
            if(repo.existsById(id)) {
                throw new IllegalArgumentException();
            }
            resultingStatus = HttpStatus.OK;
            repo.save(newEntity);
        }catch (IllegalArgumentException e) {
            resultingStatus = HttpStatus.BAD_REQUEST;
        }catch (Exception e) {
        }
        return new ResponseEntity<Object>(className, headers, resultingStatus);
    }

    public ResponseEntity<?> saveNewEntity(E entity){
        String className = entity.getClass().getSimpleName();
        HttpStatus resultingStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        try {
            repo.save(entity);
            resultingStatus = HttpStatus.OK;
        }catch (IllegalArgumentException e) {
            resultingStatus = HttpStatus.BAD_REQUEST;
        }catch (Exception e) {
        }
        return new ResponseEntity<Object>(className, headers, resultingStatus);
    }

    /**
     * Delets an Entity in the DB by it's id
     * @param id
     * @return a response entity that informs the client of their transaction results.
     */
    public ResponseEntity<?> deleteEntityById(K id){
        HttpStatus resultingStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        String className = "";
        try {
            if(!repo.existsById(id)) {
                throw new IllegalArgumentException();
            }
            className = repo.findById(id).get().getClass().getSimpleName();
            repo.deleteById(id);
            resultingStatus = HttpStatus.OK;
        }catch (IllegalArgumentException e) {
            resultingStatus = HttpStatus.BAD_REQUEST;
        }catch (Exception e) {
        }
        return new ResponseEntity<Object>(className, headers, resultingStatus);
    }

    /**
     * Editing an entity can only be done if the entity's id already exists in the DB.
     * @param entityToEdit
     * @param id
     * @return a response entity that informs the client of their transaction results.
     */
    public ResponseEntity<?> editEntity(E entityToEdit, K id){
        HttpStatus resultingStatus;
        String className = entityToEdit.getClass().getSimpleName();
        try {
            if(repo.existsById(id)) {
                repo.save(entityToEdit);
                resultingStatus = HttpStatus.OK;
            }else {
                resultingStatus = HttpStatus.BAD_REQUEST;
            }
        }catch (Exception e) {
            resultingStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Object>(className, headers, resultingStatus);
    }
}