package com.example.hakaton.repository;

import com.example.hakaton.entity.FormGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormGradeRepository extends JpaRepository<FormGrade, Long> {
}
