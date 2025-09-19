package com.yhoh.healthcarepharmacy.master.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yhoh.healthcarepharmacy.master.dto.BranchRequest;
import com.yhoh.healthcarepharmacy.master.dto.BranchResponse;
import com.yhoh.healthcarepharmacy.master.service.BranchService;

import jakarta.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/branches")
public class BranchController {
	
	private final BranchService service;
	
	public BranchController(BranchService service) {
		this.service=service;
	}

	@GetMapping
	public String listBranch(Model model,HttpServletRequest request) {
		List<BranchResponse> branches = service.getAllBranches();

		System.out.println("Branches found: " + branches.size());
	    model.addAttribute("pageTitle", "Branches");
	    model.addAttribute("body", "branch-list.jsp"); 
	    model.addAttribute("branches", branches);
        
        return "layout";
	}
	
	@GetMapping("/createBranch")
	public String createForm(Model model) {
		model.addAttribute("pageTitle", "Create Branch");
        model.addAttribute("body", "branch-form.jsp");
        model.addAttribute("branch", new BranchRequest()); // empty form object
        model.addAttribute("isEdit", false); 
        return "layout";
	}
	
	@PostMapping("/save")
	public String saveBranch(@ModelAttribute("branch") BranchRequest request) {
		
		service.createBranch(request);
		return "redirect:/branches";
	}
	
	@GetMapping("/edit/{id}")
	public String editForm(@PathVariable UUID id,Model model) {
		
		BranchResponse branch = service.getBranchById(id);

        model.addAttribute("pageTitle", "Edit Branch");
        model.addAttribute("body", "branch-form.jsp");
        model.addAttribute("branch", branch);
        model.addAttribute("isEdit", true);
        
        return "layout";
	}
	
	@PostMapping("/update/{id}")
    public String updateBranch(@PathVariable UUID id, @ModelAttribute BranchRequest request) {
        service.updateBranch(id, request);
        return "redirect:/branches";
    }

    @GetMapping("/delete/{id}")
    public String deleteBranch(@PathVariable UUID id) {
        service.deleteBranch(id);
        return "redirect:/branches";
    }
}
