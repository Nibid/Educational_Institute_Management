package com.college.ed;

import com.college.ed.exception_handling.NotFoundException;
import com.college.ed.services.GroupWorkLoadService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class GroupWorkloadControllerTest {

    @MockBean
    private GroupWorkLoadService groupWorkloadService;

    @Test
    void calculateTotalWorkHours_validData() throws Exception {
        // Arrange
        int groupId = 1;

        when(groupWorkloadService.calculateTotalWorkHours(groupId)).thenReturn(10.5);

    }

    @Test
    void calculateTotalWorkHours_invalidGroupId() throws Exception {
        // Arrange
        int invalidGroupId = 99;

        when(groupWorkloadService.calculateTotalWorkHours(invalidGroupId))
                .thenThrow(new NotFoundException("Group not found"));

    }

    @Test
    void calculateTotalWorkHours_noRoutinesFound() throws Exception {
        // Arrange
        int groupId = 1;

        when(groupWorkloadService.calculateTotalWorkHours(groupId)).thenReturn(0.0);

    }

}
