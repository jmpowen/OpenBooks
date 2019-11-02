package com.example.business.data.controller;

import com.example.business.data.entities.Volunteers;
import com.example.business.data.services.VolunteersService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/volunteer")
@OpenAPIDefinition
public class VolunteerController {

    @Autowired
    VolunteersService volunteersService;


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
    public Iterable<Volunteers> getAllVolunteers() {
        return volunteersService.getAllEntities();
    }

    @PostMapping(path = "/create")
    @ResponseBody
    public ResponseEntity<?> createVolunteers(@RequestBody Volunteers newVolunteers) {
        return volunteersService.createEntity(newVolunteers, newVolunteers.getVolunteer_id());
    }

    @DeleteMapping(path = "/delete/{volunteer_id}")
    @ResponseBody
    public ResponseEntity<?> deleteVolunteer(@PathVariable int volunteer_id) {
        return volunteersService.deleteEntityById(volunteer_id);
    }

    @PutMapping(path = "/edit/{volunteer_id}")
    @ResponseBody
    public ResponseEntity<?>  editVolunteer(@RequestBody Volunteers newVolunteersInfo, @PathVariable int volunteer_id) {
        return volunteersService.editEntity(newVolunteersInfo, volunteer_id);
    }

}
