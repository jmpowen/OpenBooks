package com.example.business.data.controller;

import com.example.business.data.entities.Charity;
import com.example.business.data.services.CharityService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/charity")
@CrossOrigin(origins="*")
@OpenAPIDefinition
public class CharityController {

    @Autowired
    CharityService charityService;

    @GetMapping(path = "/{charity_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Optional<Charity> getCharityById(@PathVariable int charity_id) {
        return charityService.getEntityByID(charity_id);
    }

    @GetMapping(path = "/all")
    public Iterable<Charity> getAllCharities() {
        return charityService.getAllEntities();
    }

    @PostMapping(path = "/create")
    @ResponseBody
    public ResponseEntity<?> createCharity(@RequestBody Charity newCharity) {
        return charityService.createEntity(newCharity, newCharity.getCharity_id());
    }

    @DeleteMapping(path = "/delete/{charity_id}")
    @ResponseBody
    public ResponseEntity<?> deleteCharity(@PathVariable int charity_id) {
        return charityService.deleteEntityById(charity_id);
    }

    @PutMapping(path = "/edit/{charity_id}")
    @ResponseBody
    public ResponseEntity<?>  editCharity(@RequestBody Charity newCharityInfo, @PathVariable int charity_id) {
        return charityService.editEntity(newCharityInfo, charity_id);
    }

}
