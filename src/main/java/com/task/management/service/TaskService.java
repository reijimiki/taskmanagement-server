package com.task.management.service;

import java.util.List;

import com.task.management.entity.TaskDetail;
import com.task.management.model.TaskInfoBody;

public interface TaskService {
	List<TaskDetail> getTaskList(int userId);

	List<TaskDetail> getDoneTaskList(int userId);

	TaskInfoBody getTaskInfo(int taskId);
}
