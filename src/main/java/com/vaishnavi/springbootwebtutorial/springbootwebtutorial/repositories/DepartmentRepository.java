package com.vaishnavi.springbootwebtutorial.springbootwebtutorial.repositories;

import com.vaishnavi.springbootwebtutorial.springbootwebtutorial.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

//    1)JpaRepository<DeptEntity, Long>:
//
//   This is the base interface provided by Spring Data JPA.
//    DeptEntity: Specifies the entity class to be managed by this repository.
//            Long: The data type of the primary key (id) in DeptEntity.
//
//    2)Why Interface and Not a Class?
//
//    Spring Data JPA provides a mechanism to implement this interface automatically at runtime.
//    This avoids boilerplate code for standard CRUD operations.
}
