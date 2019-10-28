package com.task.management.service.impl;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.task.management.entity.Task;
import com.task.management.entity.TaskDetail;
import com.task.management.model.RegisterRequestBody;
import com.task.management.repository.TaskDetailRepository;
import com.task.management.repository.TasksRepository;
import com.task.management.service.TaskRegisterService;

@Service
public class TaskRegisterServiceImpl implements TaskRegisterService {
	@Autowired
	private TasksRepository tasksRepository;
	@Autowired
	private TaskDetailRepository taskDetailRepository;

	@Override
	@Transactional
	public boolean registerTask(RegisterRequestBody registerRequestBody) {
		Task task = new Task();
		task = createTask(registerRequestBody);
		tasksRepository.save(task);
		TaskDetail taskDetail = new TaskDetail();
		List<BigInteger> list  = new ArrayList<BigInteger>();
		list = tasksRepository.getLastIncrement();
		BigInteger bigInt = list.get(0);
		int num = bigInt.intValue();
		taskDetail = createTaskDetail(num, registerRequestBody);
		taskDetailRepository.save(taskDetail);
		return true;
	}

	private Task createTask(RegisterRequestBody registerRequestBody) {
		Task task = new Task();
		task.setUserId(1);
		task.setDeleteFlg(0);
		task.setTaskState(0);
		return task;
	}

	private TaskDetail createTaskDetail(int taskId, RegisterRequestBody registerRequestBody) {
		TaskDetail taskDetail = new TaskDetail();
		taskDetail.setTaskId(taskId);
		taskDetail.setTaskName(registerRequestBody.getTaskName());
		taskDetail.setPeriodDate(getPeriodeDate(registerRequestBody.getPeriodeDateYear(), registerRequestBody.getPeriodeDateMonth(), registerRequestBody.getPeriodeDateDay()));
		taskDetail.setGenre(stringParseInt(registerRequestBody.getGenre()));
		taskDetail.setPriority(stringParseInt(registerRequestBody.getPriority()));
		taskDetail.setMemo(registerRequestBody.getMemo());
		Calendar cl = Calendar.getInstance();
		Date today = new Date();
		today = cl.getTime();
		taskDetail.setCreateDate(today);
		taskDetail.setUpdateDate(null);
		return taskDetail;
	}

	private int stringParseInt(String str) {
		if (StringUtils.isEmpty(str)) {
			return 0;
		}
		return Integer.parseInt(str);
	}

	private Date getPeriodeDate(String dateYear, String dateMonth, String dateDay) {
		Date periodeDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			periodeDate = sdf.parse(dateYear + "/" + dateMonth + "/" + dateDay + " 00:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 return periodeDate;
	}
}
