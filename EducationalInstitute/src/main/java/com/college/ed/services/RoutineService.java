package com.college.ed.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.college.ed.RoutineRequest;
import com.college.ed.exception_handling.NotFoundException;
import com.college.ed.exception_handling.ValidationException;
import com.college.ed.model.Group;
import com.college.ed.model.Routine;
import com.college.ed.model.Teacher;
import com.college.ed.repository.GroupRepository;
import com.college.ed.repository.RoutineRepository;
import com.college.ed.repository.TeacherRepository;

@Service
public class RoutineService {

    @Autowired
    private RoutineRepository routineRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private GroupRepository groupRepository;

    public Long saveRoutine(RoutineRequest routineRequest) {
        validateAndConvertRequest(routineRequest);

        // Now, you can create and save the Routine entity
        Routine routine = convertRequestToEntity(routineRequest);
        routineRepository.save(routine);

        return routine.getRoutineId();
    }

    private void validateAndConvertRequest(RoutineRequest routineRequest) {
        // Validate Request fields (you can add more validation as needed)
        if (routineRequest.getStartTime() == null || routineRequest.getEndTime() == null ||
            routineRequest.getRoutineDate() == null || routineRequest.getTeacherID() == null ||
            routineRequest.getGroupID() == null) {
            throw new ValidationException("Invalid routine data");
        }

        // Check if the referenced Teacher and Group exist
        Teacher teacher = teacherRepository.findById(routineRequest.getTeacherID())
                .orElseThrow(() -> new NotFoundException("Teacher not found"));

        Group group = groupRepository.findById(routineRequest.getGroupID())
                .orElseThrow(() -> new NotFoundException("Group not found"));
    }

    private Routine convertRequestToEntity(RoutineRequest routineRequest) {
        Routine routine = new Routine();
        routine.setStartTime(routineRequest.getStartTime());
        routine.setEndTime(routineRequest.getEndTime());
        routine.setRoutineDate(routineRequest.getRoutineDate());

        // Set the referenced Teacher and Group
        Teacher teacher = teacherRepository.findById(routineRequest.getTeacherID())
                .orElseThrow(() -> new NotFoundException("Teacher not found"));
        routine.setTeacher(teacher);

        Group group = groupRepository.findById(routineRequest.getGroupID())
                .orElseThrow(() -> new NotFoundException("Group not found"));
        routine.setGroup(group);

        return routine;
    }
}
    	