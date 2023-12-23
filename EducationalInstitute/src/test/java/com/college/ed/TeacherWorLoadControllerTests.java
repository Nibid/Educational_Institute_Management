package com.college.ed;

import com.college.ed.exception_handling.NotFoundException;
import com.college.ed.services.TeacherWorkLoadService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.time.LocalDate;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class TeacherWorkloadControllerTest {

    @MockBean
    private TeacherWorkLoadService teacherWorkloadService;

    @Test
    void calculateTotalWorkHours_validData() throws Exception {
        // Arrange
        String teacherName = "John Doe";
        LocalDate startDate = LocalDate.now().minusDays(7);
        LocalDate endDate = LocalDate.now();

        when(teacherWorkloadService.calculateTotalWorkHours(startDate, endDate, teacherName)).thenReturn(25.0);

    }

    @Test
    void calculateTotalWorkHours_invalidTeacherName() throws Exception {
        // Arrange
        String invalidTeacherName = "NonexistentTeacher";
        LocalDate startDate = LocalDate.now().minusDays(7);
        LocalDate endDate = LocalDate.now();

        when(teacherWorkloadService.calculateTotalWorkHours(startDate, endDate, invalidTeacherName))
                .thenThrow(new NotFoundException("Teacher not found"));

    }

    @Test
    void calculateTotalWorkHours_noRoutinesFound() throws Exception {
        // Arrange
        String teacherName = "John Doe";
        LocalDate startDate = LocalDate.now().minusDays(7);
        LocalDate endDate = LocalDate.now();

        when(teacherWorkloadService.calculateTotalWorkHours(startDate, endDate, teacherName)).thenReturn(0.0);

    }

}
