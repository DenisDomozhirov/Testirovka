package com.yourpackage.budgetapp.controller;

import com.yourpackage.budgetapp.model.Budget;
import com.yourpackage.budgetapp.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BudgetWebController {
    private final BudgetRepository budgetRepository;

    @Autowired
    public BudgetWebController(BudgetRepository budgetRepository){
        this.budgetRepository = budgetRepository;
    }

    @GetMapping("/web/budgets")
    public String listBudgets(Model model){
        model.addAttribute("budgets", budgetRepository.findAll());
        return "budgets";
    }

    @GetMapping("/web/budgets/add")
    public String addBudgetFrom(Model model){
        model.addAttribute("budget", new Budget());
        return "add-budget";
    }

    @PostMapping("/web/budgets")
    public String saveBudget(Budget budget){
        budgetRepository.save(budget);
        return "redirect:/web/budgets";
    }

}
