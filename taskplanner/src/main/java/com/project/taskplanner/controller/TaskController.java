package com.project.taskplanner.controller;

import com.project.taskplanner.entity.TaskModel;
import com.project.taskplanner.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {
	
	@Autowired
	TaskService service;
	
    @PostMapping(path = "/create")
    public void create(@RequestBody TaskModel taskModel){
    	taskModel.setStatus("CREATED");
        service.saveTask(taskModel);
    }
    
    @PostMapping(path = "/update")
    public void update(@RequestBody TaskModel taskModel){
        service.saveTask(taskModel);
    }
    
    @PostMapping(path = "/assign/{id}")
    public void assign(@PathVariable int id, @RequestBody String name){
        service.assignTask(id,name);
    }
    @GetMapping(path = "/search/{id}")
    public TaskModel GetTask(@PathVariable("id") int taskid){
        return service.fetchTask(taskid);
    }
    @GetMapping(path = "/searchAll")
    public List<TaskModel> GetAllTasks(){
        return service.fetchAllTasks();
    }
}
