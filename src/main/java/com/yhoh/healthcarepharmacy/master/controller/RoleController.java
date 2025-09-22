package com.yhoh.healthcarepharmacy.master.controller;

import com.yhoh.healthcarepharmacy.master.dto.RoleRequest;
import com.yhoh.healthcarepharmacy.master.dto.RoleResponse;
import com.yhoh.healthcarepharmacy.master.dto.PermissionResponse;
import com.yhoh.healthcarepharmacy.master.service.RoleService;
import com.yhoh.healthcarepharmacy.master.service.PermissionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;
    private final PermissionService permissionService;

    public RoleController(RoleService roleService, PermissionService permissionService) {
        this.roleService = roleService;
        this.permissionService = permissionService;
    }

    @GetMapping
    public String listRoles(Model model) {
        List<RoleResponse> roles = roleService.getAllRoles();
        model.addAttribute("roles", roles);
        model.addAttribute("page", "roles"); // for sidebar active menu
        model.addAttribute("body", "role-list.jsp"); // include in layout.jsp
        return "layout";
    }

    // 📌 Show create form
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        List<PermissionResponse> permissions = permissionService.getAllPermissions();
        model.addAttribute("role", new RoleResponse()); // empty object
        model.addAttribute("permissions", permissions);
        model.addAttribute("page", "roles");
        model.addAttribute("body", "role-form.jsp");
        return "layout";
    }

    @PostMapping
    public String createRole(@ModelAttribute RoleRequest roleRequest) {
        roleService.createRole(roleRequest);
        return "redirect:/roles";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        RoleResponse role = roleService.getRoleById(id);
        List<PermissionResponse> permissions = permissionService.getAllPermissions();
        model.addAttribute("role", role);
        model.addAttribute("permissions", permissions);
        model.addAttribute("page", "roles");
        model.addAttribute("body", "role-form.jsp");
        return "layout";
    }

    @PostMapping("/update/{id}")
    public String updateRole(@PathVariable String id, @ModelAttribute RoleRequest roleRequest) {
        roleService.updateRole(id, roleRequest);
        return "redirect:/roles";
    }

    @GetMapping("/delete/{id}")
    public String deleteRole(@PathVariable String id) {
        roleService.deleteRole(id);
        return "redirect:/roles";
    }
}