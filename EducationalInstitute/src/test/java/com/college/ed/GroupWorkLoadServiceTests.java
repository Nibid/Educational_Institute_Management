package com.college.ed;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.college.ed.exception_handling.NotFoundException;
import com.college.ed.model.Group;
import com.college.ed.model.Routine;
import com.college.ed.repository.GroupRepository;
import com.college.ed.repository.RoutineRepository;
import com.college.ed.services.GroupWorkLoadService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class GroupWorkloadServiceTest {

    @Mock
    private RoutineRepository routineRepository;

    @Mock
    private GroupRepository groupRepository;

    @InjectMocks
    private GroupWorkLoadService groupWorkloadService;

    @Test
    void calculateTotalWorkHours_validData() {
        // Arrange
        int groupId = 1;

        Group mockGroup = new Group();
        mockGroup.setGroupId(groupId);

        Routine mockRoutine = new Routine();
        mockRoutine.setStartTime(LocalTime.of(8, 0));
        mockRoutine.setEndTime(LocalTime.of(12, 0));
        mockRoutine.setGroup(mockGroup);
        mockRoutine.setRoutineDate(LocalDate.now());

        when(groupRepository.findById(groupId)).thenReturn(Optional.of(mockGroup));
        when(routineRepository.findByGroupId(groupId)).thenReturn(Collections.singletonList(mockRoutine));

        // Act
        double totalWorkHours = groupWorkloadService.calculateTotalWorkHours(groupId);

        // Assert
        assertEquals(4.0, totalWorkHours, 0.01); // Adjust based on your expected result
    }

    @Test
    void calculateTotalWorkHours_invalidGroupId() {
        // Arrange
        int invalidGroupId = 99;

        when(groupRepository.findById(invalidGroupId)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(NotFoundException.class,
                () -> groupWorkloadService.calculateTotalWorkHours(invalidGroupId));
    }

    @Test
    void calculateTotalWorkHours_noRoutinesFound() {
        // Arrange
        int groupId = 1;

        Group mockGroup = new Group();
        mockGroup.setGroupId(groupId);

        
        when(routineRepository.findByGroupId(groupId)).thenReturn(Collections.emptyList());

        // Act
        double totalWorkHours = groupWorkloadService.calculateTotalWorkHours(groupId);

        // Assert
        assertEquals(0.0, totalWorkHours, 0.01);
    }

}
