package com.college.ed.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.ed.model.Routine;
import com.college.ed.model.Teacher;

public interface RoutineRepository extends JpaRepository<Routine,Long>{

	List<Routine> findByTeacherAndRoutineDateBetween(Teacher teacher, LocalDate startDate, LocalDate endDate);

	List<Routine> findByGroupId(Long groupId);

}
