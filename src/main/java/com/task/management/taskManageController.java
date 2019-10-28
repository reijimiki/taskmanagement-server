package com.task.management;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.management.entity.Task;
import com.task.management.entity.TaskDetail;
import com.task.management.model.RegisterRequestBody;
import com.task.management.model.TaskInfoBody;
import com.task.management.model.UpdateRequestBody;
import com.task.management.service.TaskRegisterService;
import com.task.management.service.TaskService;
import com.task.management.service.TaskUpdateService;


@RestController
@RequestMapping(path="/api")
public class taskManageController {

	@Autowired
	private TaskService taskSerivce;

	@Autowired
	private TaskRegisterService taskRegisterService;

	@Autowired
	private TaskUpdateService taskUpdateService;

	@CrossOrigin()
	@RequestMapping(path="/task/get", method=RequestMethod.GET)
	@ResponseBody
	public List<TaskDetail> getTaskList() {
		// ログイン実装まで固定値
		int userId = 1;
		List<TaskDetail> list = taskSerivce.getTaskList(userId);
		return list;
	}

	@CrossOrigin()
	@RequestMapping(path="/donetask/get", method=RequestMethod.GET)
	@ResponseBody
	public List<TaskDetail> getDoneTaskList() {
		// ログイン実装まで固定値
		int userId = 1;
		List<TaskDetail> list = taskSerivce.getDoneTaskList(userId);
		return list;
	}

	@CrossOrigin()
	@RequestMapping(path="/taskinfo/get", method=RequestMethod.GET)
	@ResponseBody
	public TaskInfoBody getTaskInfo(@RequestParam("taskid") String taskId) {
		if (StringUtils.isEmpty(taskId)) {
			return null;
		};
		int id = Integer.parseInt(taskId);
		TaskInfoBody taskInfoBody = new TaskInfoBody();
		taskInfoBody = taskSerivce.getTaskInfo(id);
		return taskInfoBody;
	}

	@CrossOrigin()
	@RequestMapping(path="/task/put", method=RequestMethod.PUT)
	@ResponseBody
	public boolean updateTask(@RequestBody UpdateRequestBody updateRequestBody) {
		// 更新処理
		boolean result = false;
		result = taskUpdateService.updateTask(updateRequestBody);
		return result;
	}

	@CrossOrigin()
	@RequestMapping(path="/task/post", method=RequestMethod.POST)
	@ResponseBody
	public boolean registerTask(@RequestBody RegisterRequestBody registerRequestBody) {
		// 登録処理
		boolean result = false;
		result = taskRegisterService.registerTask(registerRequestBody);
		return result;
	}

	List<Task> createTaskList() {
		List<Task> tasklist = new ArrayList<Task>();

		for(int i=1; i<5; i++) {
//			Task task = new Task();
//			task.setTaskId(i);
//			task.setTaskName("タスク" + i);
//			task.setPriority("高");
//			task.setTaskPeriod("2019-04-30 00:00:00");
//			task.setGenre("private");
//			tasklist.add(task);
		}
		return tasklist;
	}
}
