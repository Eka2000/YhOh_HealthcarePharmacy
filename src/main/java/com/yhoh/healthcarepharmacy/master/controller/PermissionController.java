package com.yhoh.healthcarepharmacy.master.controller;

import com.yhoh.healthcarepharmacy.master.dto.PermissionRequest;
import com.yhoh.healthcarepharmacy.master.dto.PermissionResponse;
import com.yhoh.healthcarepharmacy.master.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/permissions")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    // ------------------- List all permissions -------------------
    @GetMapping
    public String listPermissions(Model model) {
        List<PermissionResponse> permissions = permissionService.getAllPermissions();
        model.addAttribute("permissions", permissions);
        model.addAttribute("page", "permissions");
        model.addAttribute("body", "permission-list.jsp");
        return "layout"; // main layout.jsp
    }

    // ------------------- Show form for new permission -------------------
    @GetMapping("/new")
    public String newPermission(Model model) {
        model.addAttribute("permission", new PermissionRequest());
        model.addAttribute("isEdit", false);
        model.addAttribute("page", "permissions");
        model.addAttribute("body", "permission-form.jsp");
        return "layout";
    }

    // ------------------- Save new permission -------------------
    @PostMapping("/save")
    public String savePermission(@ModelAttribute("permission") PermissionRequest permissionRequest) {
        permissionService.createPermission(permissionRequest);
        return "redirect:/permissions";
    }

    // ------------------- Show form to edit permission -------------------
    @GetMapping("/edit/{id}")
    public String editPermission(@PathVariable String id, Model model) {
        PermissionResponse permission = permissionService.getPermissionById(id);
        PermissionRequest request = new PermissionRequest();
        request.setName(permission.getName());

        model.addAttribute("permission", request);
        model.addAttribute("id", id);
        model.addAttribute("isEdit", true);
        model.addAttribute("page", "permissions");
        model.addAttribute("body", "permission-form.jsp");
        return "layout";
    }

    // ------------------- Update permission -------------------
    @PostMapping("/update/{id}")
    public String updatePermission(@PathVariable String id,
                                   @ModelAttribute("permission") PermissionRequest permissionRequest) {
        permissionService.updatePermission(id, permissionRequest);
        return "redirect:/permissions";
    }

    // ------------------- Delete permission -------------------
    @GetMapping("/delete/{id}")
    public String deletePermission(@PathVariable String id) {
        permissionService.deletePermission(id);
        return "redirect:/permissions";
    }
}