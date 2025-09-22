package com.yhoh.healthcarepharmacy.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.yhoh.healthcarepharmacy.employee.dto.EmployeeRequest;
import com.yhoh.healthcarepharmacy.employee.dto.EmployeeResponse;
import com.yhoh.healthcarepharmacy.employee.service.EmployeeService;
import com.yhoh.healthcarepharmacy.master.service.BranchService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final BranchService branchService;

    public EmployeeController(EmployeeService employeeService, BranchService branchService) {
        this.employeeService = employeeService;
        this.branchService = branchService;
    }

    // List all employees
    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("page", "employees");
        model.addAttribute("body", "/WEB-INF/views/employee-list.jsp");
        return "layout";
    }

    // Show create employee form
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("branches", branchService.getAllBranches());
        model.addAttribute("isEdit", false);
        model.addAttribute("employee", new EmployeeRequest());
        model.addAttribute("page", "employees");
        model.addAttribute("body", "/WEB-INF/views/employee-form.jsp");
        return "layout";
    }

    // Save new employee
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute EmployeeRequest dto) {
        employeeService.saveEmployee(dto);
        return "redirect:/employees";
    }

    // Show edit employee form
    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable String id, Model model) {
        // Fetch EmployeeResponse DTO
        EmployeeResponse dto = employeeService.getEmployeeById(id);

        model.addAttribute("employee", dto);
        model.addAttribute("branches", branchService.getAllBranches());
        model.addAttribute("isEdit", true);
        model.addAttribute("page", "employees");
        model.addAttribute("body", "/WEB-INF/views/employee-form.jsp");
        return "layout";
    }

    // Update employee
    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable String id, @ModelAttribute EmployeeRequest dto) {
        employeeService.updateEmployee(id, dto);
        return "redirect:/employees";
    }

    // Delete employee
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}