package com.task.management.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.task.management.logic.DateLogic;
import com.task.management.model.UpdateRequestBody;
import com.task.management.repository.TaskDetailRepository;
import com.task.management.repository.TasksRepository;
import com.task.management.service.TaskUpdateService;

@Service
public class TaskUpdateServiceImpl implements TaskUpdateService {
	@Autowired
	private TasksRepository tasksRepository;

	@Autowired
	private TaskDetailRepository taskDetailRepository;

	@Autowired
	private DateLogic dateLogic;

	@Override
	@Transactional
	public boolean updateTask(UpdateRequestBody updateRequestBody) {
		// タスクテーブル更新
		tasksRepository.updateTasks(Integer.parseInt(updateRequestBody.getTaskId()),
				Integer.parseInt(updateRequestBody.getTaskState()), 0);

		Date periodDate = new Date();
		periodDate = dateLogic.getPeriodeDate(updateRequestBody.getPeriodeDateYear(),
				updateRequestBody.getPeriodeDateMonth(),
				updateRequestBody.getPeriodeDateDay());
		Date today = new Date();
		// タスク詳細更新
		taskDetailRepository.updateTaskDetail(Integer.parseInt(updateRequestBody.getTaskId()),
				updateRequestBody.getTaskName(),
				Integer.parseInt(updateRequestBody.getGenre()),
				updateRequestBody.getMemo(),
				Integer.parseInt(updateRequestBody.getPriority()),
				periodDate, today);
		return true;
	}

}
