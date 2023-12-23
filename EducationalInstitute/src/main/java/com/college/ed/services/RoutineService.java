package com.college.ed.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public int saveRoutine(RoutineRequest routineRequest) {
        validateAndConvertRequest(routineRequest);

        // Create and save the Routine entity
        Routine routine = convertRequestToEntity(routineRequest);
        routineRepository.save(routine);

        return routine.getRoutineId(); 
    }

    private void validateAndConvertRequest(RoutineRequest routineRequest) {
         //Validate Request fields
        if (routineRequest.getStartTime() == null || routineRequest.getEndTime() == null ||
            routineRequest.getRoutineDate() == null) {
            throw new ValidationException("Invalid routine data");
        }
    }

    private Routine convertRequestToEntity(RoutineRequest routineRequest) {
        Routine routine = new Routine();
        routine.setStartTime(routineRequest.getStartTime());
        routine.setEndTime(routineRequest.getEndTime());
        routine.setRoutineDate(routineRequest.getRoutineDate());

        // Set the referenced Teacher and Group
        Teacher teacher = teacherRepository.findById(routineRequest.getTeacher_id())
                .orElseThrow(() -> new NotFoundException("Teacher not found"));
        routine.setTeacher(teacher);

        Group group = groupRepository.findById(routineRequest.getGroup_id())
                .orElseThrow(() -> new NotFoundException("Group not found"));
        routine.setGroup(group);

        return routine;
    }
}
    	