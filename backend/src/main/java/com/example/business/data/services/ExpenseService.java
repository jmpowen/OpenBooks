package com.example.business.data.services;

import com.example.business.data.entities.Expense;
import com.example.business.data.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService extends AbstractService<Expense, Integer> {

    @Autowired
    ExpenseRepository expenseRepository;


    public List<Expense> getExpensesForCharity(int charity_id){
        return expenseRepository.getExpenseByCharity(charity_id);
    }

    public List<Expense> getExpensesForCharity2(int charity_id){
        List<Expense> result = new ArrayList<Expense>();



        return null;
    }

    //todo
}
