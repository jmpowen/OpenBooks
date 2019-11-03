package com.example.business.data.controller;

import com.example.business.data.entities.CharityVolunteers;
import com.example.business.data.services.CharityVolunteersService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/volunteer")
@CrossOrigin(origins="*")
@OpenAPIDefinition
public class CharityVolunteerController {

    @Autowired
    CharityVolunteersService charityVolunteersService;

    //THIS CLASS NEEDS MORE WORK

    //we have to keys for this table TODO
    /*
    @GetMapping(path = "/{charity_id}/{volunteers_id}")
    @ResponseBody
    public Optional<Volunteers> getVolunteersById(@PathVariable int donation_id, @PathVariable int volunteers_id) {
        return volunteersService.getEntityByID(donation_id);
    }
    */

    @GetMapping(path = "/all")
    public Iterable<CharityVolunteers> getAllVolunteers() {
        return charityVolunteersService.getAllEntities();
    }

    @PostMapping(path = "/create")
    @ResponseBody
    public ResponseEntity<?> createVolunteers(@RequestBody CharityVolunteers newVolunteers) {
        return charityVolunteersService.createEntity(newVolunteers, newVolunteers.getVolunteer_id());
    }

    @DeleteMapping(path = "/delete/{volunteer_id}")
    @ResponseBody
    public ResponseEntity<?> deleteVolunteer(@PathVariable int volunteer_id) {
        return charityVolunteersService.deleteEntityById(volunteer_id);
    }

    @PutMapping(path = "/edit/{volunteer_id}")
    @ResponseBody
    public ResponseEntity<?>  editVolunteer(@RequestBody CharityVolunteers newVolunteersInfo, @PathVariable int volunteer_id) {
        return charityVolunteersService.editEntity(newVolunteersInfo, volunteer_id);
    }

}
