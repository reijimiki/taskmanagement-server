package com.task.management.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.task.management.entity.TaskDetail;

@Transactional
@Repository
public interface TaskDetailRepository extends JpaRepository<TaskDetail, Integer> {
	TaskDetail findTasksByTaskId(int taskId);

	@Modifying
	@Query(value = "update TaskDetail t set t.taskName=:task_name, t.genre=:genre, t.memo=:memo, t.priority=:priority, t.periodDate=:period_date, t.updateDate=:update_date where t.taskId=:task_id")
	void updateTaskDetail(@Param("task_id") int task_id, @Param("task_name") String task_name, @Param("genre") int genre, @Param("memo") String memo, @Param("priority") int priority, @Param("period_date") Date periodDate, @Param("update_date") Date updateDate);
}
