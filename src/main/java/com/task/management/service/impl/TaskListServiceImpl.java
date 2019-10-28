package com.task.management.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.management.entity.Task;
import com.task.management.entity.TaskDetail;
import com.task.management.model.TaskInfoBody;
import com.task.management.repository.TaskDetailRepository;
import com.task.management.repository.TasksRepository;
import com.task.management.service.TaskService;

@Service
public class TaskListServiceImpl implements TaskService {
	@Autowired
	private TasksRepository tasksRepository;
	@Autowired
	private TaskDetailRepository taskDetailRepository;

	@Override
	public List<TaskDetail> getTaskList(int userId) {
		List<Task> taskList = new ArrayList<Task>();
		taskList = tasksRepository.findTasksByUserId(userId);
		List<TaskDetail> taskDetails = new ArrayList<TaskDetail>();
		for (Task task : taskList) {
			int id = task.getTaskId();
			TaskDetail taskDetail = new TaskDetail();
			taskDetail = taskDetailRepository.findTasksByTaskId(id);
			taskDetails.add(taskDetail);
		}
		return taskDetails;
	}

	@Override
	public List<TaskDetail> getDoneTaskList(int userId) {
		List<Task> taskList = new ArrayList<Task>();
		taskList = tasksRepository.findDoneTasksByUserId(userId);
		List<TaskDetail> taskDetails = new ArrayList<TaskDetail>();
		for (Task task : taskList) {
			int id = task.getTaskId();
			TaskDetail taskDetail = new TaskDetail();
			taskDetail = taskDetailRepository.findTasksByTaskId(id);
			taskDetails.add(taskDetail);
		}
		return taskDetails;
	}

	@Override
	public TaskInfoBody getTaskInfo(int taskId) {
		Task task = tasksRepository.findTasksByTaskId(taskId);
		TaskDetail taskDetail = taskDetailRepository.findTasksByTaskId(taskId);

		return createTaskInfoBody(task, taskDetail);
	}

	public TaskInfoBody createTaskInfoBody(Task task, TaskDetail taskDetail) {
		TaskInfoBody taskInfoBody = new TaskInfoBody();
		taskInfoBody.setTaskId(task.getTaskId());
		taskInfoBody.setTaskState(task.getTaskState());
		taskInfoBody.setTaskName(taskDetail.getTaskName());
		taskInfoBody.setGenre(taskDetail.getGenre());
		taskInfoBody.setPriority(taskDetail.getPriority());
		taskInfoBody.setMemo(taskDetail.getMemo());
		taskInfoBody.setPeriodeDate(taskDetail.getPeriodDate());
		return taskInfoBody;
	}
}
