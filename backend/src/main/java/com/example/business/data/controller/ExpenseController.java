package com.example.business.data.controller;

import com.example.business.data.entities.Expense;
import com.example.business.data.services.ExpenseService;
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

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/expense")
@CrossOrigin(origins="*")
@OpenAPIDefinition
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @GetMapping(path = "/{expense_id}")
    @ResponseBody
    public Optional<Expense> getExpenseById(@PathVariable int expense_id) {
        return expenseService.getEntityByID(expense_id);
    }

    @GetMapping(path = "/all")
    public Iterable<Expense> getAllDonations() {
        return expenseService.getAllEntities();
    }

    @PostMapping(path = "/create")
    @ResponseBody
    public ResponseEntity<?> createExpense(@RequestBody Expense newExpense) {
        return expenseService.createEntity(newExpense, newExpense.getExpense_id());
    }

    @DeleteMapping(path = "/delete/{expense_id}")
    @ResponseBody
    public ResponseEntity<?> deleteExpense(@PathVariable int expense_id) {
        return expenseService.deleteEntityById(expense_id);
    }

    @PutMapping(path = "/edit/{expense_id}")
    @ResponseBody
    public ResponseEntity<?>  editExpense(@RequestBody Expense newExpenseInfo, @PathVariable int expense_id) {
        return expenseService.editEntity(newExpenseInfo, expense_id);
    }

    @RequestMapping(path="/charity/{charity_id}")
    @ResponseBody
    public List<Expense> getAllExpensesForACharity(@PathVariable int charity_id){
        return expenseService.getExpensesForCharity(charity_id);
    }


}