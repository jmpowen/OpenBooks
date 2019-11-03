package com.example.business.data.repositories;

import com.example.business.data.entities.Donation;
import com.example.business.data.entities.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Integer>{

    //queries
    @Query(value= " SELECT * "
            + " FROM expense "
            + " WHERE charity_id = ?", nativeQuery = true)
    List<Expense> getExpenseByCharity(int charity_id);
}
