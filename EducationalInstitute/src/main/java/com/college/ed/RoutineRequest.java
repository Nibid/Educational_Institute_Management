package com.college.ed;

import java.time.LocalDate;
import java.time.LocalTime;

public class RoutineRequest {
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate routineDate;
    private int teacher_id;
    private int group_id;

    // Default constructor
    public RoutineRequest() {
    }

    // Parameterized constructor
    public RoutineRequest(LocalTime startTime, LocalTime endTime, LocalDate routineDate, int teacher_id, int group_id) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.routineDate = routineDate;
        this.teacher_id = teacher_id;
        this.group_id = group_id;
    }

    // Getters and setters

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public LocalDate getRoutineDate() {
        return routineDate;
    }

    public void setRoutineDate(LocalDate routineDate) {
        this.routineDate = routineDate;
    }

    public int getTeacherID() {
        return teacher_id;
    }

    public void setTeacherID(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getGroupID() {
        return group_id;
    }

    public void setGroupID(int group_id) {
        this.group_id = group_id;
    }
}
