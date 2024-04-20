package com.example.hakaton.repository;

import com.example.hakaton.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

@Repository
@CrossOrigin(origins = "*",
        methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE },
        maxAge = 3600)
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
