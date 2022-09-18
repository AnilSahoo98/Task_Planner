package com.project.taskplanner.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.project.taskplanner.entity.TaskModel;
import com.project.taskplanner.repository.TaskRepository;

@Component
@Service
public class TaskService {

	@Autowired
	TaskRepository repo;
	
	public void saveTask(TaskModel taskModel) {
		repo.save(taskModel);
	}

	public TaskModel fetchTask(int taskid) {
		TaskModel taskModel=repo.findById(taskid).get();
		return taskModel;
	}

	public void assignTask(int id, String name) {
		TaskModel taskModel=repo.findById(id).get();
		taskModel.setAssignedTo(name);
		taskModel.setStatus("ASSIGNED");
		repo.save(taskModel);
	}

	public List<TaskModel> fetchAllTasks() {
		List<TaskModel> list=new ArrayList<TaskModel>();
		repo.findAll().forEach(b->list.add(b));;
		return list;
	}
}
