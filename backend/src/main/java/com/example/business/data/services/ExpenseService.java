package com.example.business.data.services;

import com.example.business.data.entities.Expense;
import com.example.business.data.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService extends AbstractService<Expense, Integer> {

    ExpenseRepository expenseRepository;

    //todo
}
