package com.example.business.data.repositories;

import com.example.business.data.entities.Donation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepository extends PagingAndSortingRepository<Donation, Integer> {

    @Query(value= " SELECT * "
                + " FROM donation "
                + " WHERE donor_id = ?1", nativeQuery = true)
    Page<Donation> getDonationListByUser(String user_email, Pageable pageable);

    @Query(value =" SELECT * "
                + " FROM donation "
                + " WHERE charity_id = ?1", nativeQuery = true)
    Page<Donation> getDonationListByCharity(int charity_id, Pageable pageable);
}
