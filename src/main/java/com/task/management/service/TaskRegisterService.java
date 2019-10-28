package com.task.management.service;

import com.task.management.model.RegisterRequestBody;

public interface TaskRegisterService {
	boolean registerTask(RegisterRequestBody registerRequestBody);
}
