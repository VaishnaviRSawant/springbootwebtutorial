package com.vaishnavi.springbootwebtutorial.springbootwebtutorial.controller;

import com.vaishnavi.springbootwebtutorial.springbootwebtutorial.DTO.DepartmentDTO;
import com.vaishnavi.springbootwebtutorial.springbootwebtutorial.services.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        List<DepartmentDTO> departmentDTOs = departmentService.getAllDepartments();
        return ResponseEntity.ok(departmentDTOs);
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable(name = "departmentId") Long id) {
        Optional<DepartmentDTO> departmentDTO = departmentService.getDepartmentById(id);
        return departmentDTO
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createNewDepartment(@RequestBody DepartmentDTO inputDepartment) {
        DepartmentDTO savedDepartment = departmentService.createNewDepartment(inputDepartment);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @PutMapping("/{departmentId}")
    public ResponseEntity<DepartmentDTO> updateDepartmentById(
            @RequestBody DepartmentDTO departmentDTO,
            @PathVariable Long departmentId) {
        DepartmentDTO updatedDepartment = departmentService.updateDepartmentById(departmentId, departmentDTO);
        return ResponseEntity.ok(updatedDepartment);
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<Boolean> deleteDepartmentById(@PathVariable Long departmentId) {
        boolean gotDeleted = departmentService.deleteDepartmentById(departmentId);
        if (gotDeleted) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{departmentId}")
    public ResponseEntity<DepartmentDTO> updatePartialDepartmentById(
            @RequestBody Map<String, Object> updates,
            @PathVariable Long departmentId) {
        DepartmentDTO updatedDepartment = departmentService.updatePartialDepartmentById(departmentId, updates);
        if (updatedDepartment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedDepartment);
    }
}