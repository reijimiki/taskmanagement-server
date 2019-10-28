package com.task.management.service;

import com.task.management.model.UpdateRequestBody;

public interface TaskUpdateService {
	boolean updateTask(UpdateRequestBody updateRequestBody);
}
