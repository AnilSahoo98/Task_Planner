package com.project.taskplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.taskplanner.entity.TaskModel;

public interface TaskRepository extends JpaRepository<TaskModel, Integer> {

}
