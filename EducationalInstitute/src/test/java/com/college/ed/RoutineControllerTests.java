package com.college.ed;

import com.college.ed.services.RoutineService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class RoutineControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RoutineService routineService;

    @Test
    void saveRoutine_validData() throws Exception {
        // Arrange
        RoutineRequest routineRequest = new RoutineRequest();
        routineRequest.setStartTime(LocalTime.of(8, 0));
        routineRequest.setEndTime(LocalTime.of(12, 0));
        routineRequest.setRoutineDate(LocalDate.now());
        routineRequest.setTeacher_id(1);
        routineRequest.setGroup_id(1);

        // Act
        ResultActions result = mockMvc.perform(post("/api/routines")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(routineRequest)));

        // Assert
        result.andExpect(status().isOk());
    }

    @Test
    void saveRoutine_invalidData() throws Exception {
        // Arrange
    	// Invalid data with missing fields
        RoutineRequest routineRequest = new RoutineRequest();

        // Act
        ResultActions result = mockMvc.perform(post("/api/routines")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(routineRequest)));

        // Assert
        result.andExpect(status().isBadRequest());

    }
}
