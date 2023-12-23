package com.college.ed;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.college.ed.exception_handling.NotFoundException;
import com.college.ed.exception_handling.ValidationException;
import com.college.ed.model.Teacher;
import com.college.ed.repository.RoutineRepository;
import com.college.ed.repository.TeacherRepository;
import com.college.ed.services.TeacherWorkLoadService;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class TeacherWorkLoadServiceTests {

    @Mock
    private RoutineRepository routineRepository;

    @Mock
    private TeacherRepository teacherRepository;

    @InjectMocks
    private TeacherWorkLoadService teacherWorkloadService;

    @Test
    void calculateTotalWorkHours_teacherNotFound() {
        // Arrange
        LocalDate startDate = LocalDate.now().minusDays(7);
        LocalDate endDate = LocalDate.now();
        String teacherName = "NonexistentTeacher";

        when(teacherRepository.findByTeacherName(teacherName)).thenReturn(null);

        // Act and Assert
        assertThrows(NotFoundException.class,
                () -> teacherWorkloadService.calculateTotalWorkHours(startDate, endDate, teacherName));
    }

    @Test
    void calculateTotalWorkHours_routinesNotFound() {
        // Arrange
        LocalDate startDate = LocalDate.now().minusDays(7);
        LocalDate endDate = LocalDate.now();
        String teacherName = "balen";

        Teacher mockTeacher = new Teacher();
        mockTeacher.setTeacherid(1);

        when(teacherRepository.findByTeacherName(teacherName)).thenReturn(mockTeacher);
        when(routineRepository.findByTeacherAndRoutineDateBetween(mockTeacher, startDate, endDate))
                .thenReturn(Collections.emptyList());

        // Act
        double totalWorkHours = teacherWorkloadService.calculateTotalWorkHours(startDate, endDate, teacherName);

        // Assert
        assertEquals(0.0, totalWorkHours, 0.01);
    }

    @Test
    void calculateTotalWorkHours_invalidDateRange() {
        // Arrange
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now().minusDays(7);
        String teacherName = "balen";

        // Act and Assert
        assertThrows(ValidationException.class,
                () -> teacherWorkloadService.calculateTotalWorkHours(startDate, endDate, teacherName));
    }

}
