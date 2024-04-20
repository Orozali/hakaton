package com.example.hakaton.repository;

import com.example.hakaton.entity.ExamGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamGradeRepository extends JpaRepository<ExamGrade, Long> {
}
