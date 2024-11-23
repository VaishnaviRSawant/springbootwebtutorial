package com.vaishnavi.springbootwebtutorial.springbootwebtutorial.services;

import com.vaishnavi.springbootwebtutorial.springbootwebtutorial.DTO.DepartmentDTO;
import com.vaishnavi.springbootwebtutorial.springbootwebtutorial.entities.DepartmentEntity;
import com.vaishnavi.springbootwebtutorial.springbootwebtutorial.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<DepartmentDTO> getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class));
    }

    public List<DepartmentDTO> getAllDepartments() {
        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
        return departmentEntities.stream()
                .map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class))
                .collect(Collectors.toList());
    }

    public DepartmentDTO createNewDepartment(DepartmentDTO inputDepartment) {
        DepartmentEntity toSaveEntity = modelMapper.map(inputDepartment, DepartmentEntity.class);
        DepartmentEntity savedDepartmentEntity = departmentRepository.save(toSaveEntity);
        return modelMapper.map(savedDepartmentEntity, DepartmentDTO.class);
    }

    public DepartmentDTO updateDepartmentById(Long id, DepartmentDTO departmentDTO) {
        DepartmentEntity departmentEntity = modelMapper.map(departmentDTO, DepartmentEntity.class);
        departmentEntity.setId(id);
        DepartmentEntity savedDepartmentEntity = departmentRepository.save(departmentEntity);
        return modelMapper.map(savedDepartmentEntity, DepartmentDTO.class);
    }

    public boolean isExistByDepartmentId(Long departmentId) {
        return departmentRepository.existsById(departmentId);
    }

    public boolean deleteDepartmentById(Long departmentId) {
        boolean exists = isExistByDepartmentId(departmentId);
        if (!exists) {
            return false;
        }
        departmentRepository.deleteById(departmentId);
        return true;
    }

    public DepartmentDTO updatePartialDepartmentById(Long departmentId, Map<String, Object> updates) {
        boolean exists = isExistByDepartmentId(departmentId);
        if (!exists) {
            return null;
        }
        DepartmentEntity departmentEntity = departmentRepository.findById(departmentId).get();
        updates.forEach((field, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.findRequiredField(DepartmentEntity.class, field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, departmentEntity, value);
        });
        DepartmentEntity updatedDepartmentEntity = departmentRepository.save(departmentEntity);
        return modelMapper.map(updatedDepartmentEntity, DepartmentDTO.class);
    }
}