package com.example.business.data.controller;

import com.example.business.data.entities.Donation;
import com.example.business.data.services.DonationService;
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
@RequestMapping(value = "/donation")
@OpenAPIDefinition
public class DonationController {

    @Autowired
    DonationService donationService;

    @GetMapping(path = "/{donation_id}")
    @ResponseBody
    public Optional<Donation> getDonationById(@PathVariable int donation_id) {
        return donationService.getEntityByID(donation_id);
    }

    @GetMapping(path = "/all")
    public Iterable<Donation> getAllDonations() {
        return donationService.getAllEntities();
    }

    @PostMapping(path = "/create")
    @ResponseBody
    public ResponseEntity<?> createDonation(@RequestBody Donation newDonation) {
        return donationService.createEntity(newDonation, newDonation.getDonation_id());
    }

    @DeleteMapping(path = "/delete/{donation_id}")
    @ResponseBody
    public ResponseEntity<?> deleteDonation(@PathVariable int donation_id) {
        return donationService.deleteEntityById(donation_id);
    }

    @PutMapping(path = "/edit/{donation_id}")
    @ResponseBody
    public ResponseEntity<?>  editDonation(@RequestBody Donation newDonationInfo, @PathVariable int donation_id) {
        return donationService.editEntity(newDonationInfo, donation_id);
    }

}
