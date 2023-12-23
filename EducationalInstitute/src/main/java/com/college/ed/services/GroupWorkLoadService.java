package com.college.ed.services;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.ed.exception_handling.ValidationException;
import com.college.ed.model.Group;
import com.college.ed.model.Routine;
import com.college.ed.repository.GroupRepository;
import com.college.ed.repository.RoutineRepository;

@Service
public class GroupWorkLoadService {

    @Autowired
    private RoutineRepository routineRepository;
    
    @Autowired
    private GroupRepository groupRepository;

    public double calculateTotalWorkHours(int groupId) {
        validateGroupId(groupId);

        // Retrieve routines for group
        List<Routine> routines = routineRepository.findByGroupId(groupId);

        // Calculate total work hours
        double totalWorkHours = calculateTotalWorkHours(routines);

        return totalWorkHours;
    }

    private void validateGroupId(int groupId) {

        // Check if the referenced Group exists
        Optional<Group> optionalGroup = groupRepository.findById(groupId);
        Group group = optionalGroup.orElseThrow(() -> new ValidationException("Group not found"));
    }

    private double calculateTotalWorkHours(List<Routine> routines) {
        double totalWorkHours = 0;

        for (Routine routine : routines) {
            totalWorkHours += calculateWorkHours(routine.getStartTime(), routine.getEndTime());
        }

        return totalWorkHours;
    }

    private double calculateWorkHours(LocalTime startTime, LocalTime endTime) {
    	// Calculate the duration between startTime and endTime
        Duration duration = Duration.between(startTime, endTime);

        // Convert the duration to hours as a double
        double workHours = duration.toMinutes() / 60.0;

        return workHours;
    }
}
