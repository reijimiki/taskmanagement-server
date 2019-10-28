package com.task.management.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.task.management.entity.Task;
import com.task.management.entity.TaskPK;

@Transactional
@Repository
public interface TasksRepository extends JpaRepository<Task, TaskPK> {
	@Query("select t from Task t where t.userId = :user_id and t.taskState <> 9 and t.deleteFlg <> 1")
	List<Task> findTasksByUserId(@Param("user_id")int user_id);

	@Query("select t from Task t where t.userId = :user_id and t.taskState = 9 and t.deleteFlg <> 1")
	List<Task> findDoneTasksByUserId(@Param("user_id")int user_id);

	@Query(value = "select LAST_INSERT_ID()", nativeQuery = true)
	List<BigInteger> getLastIncrement();

	Task findTasksByTaskId(int taskId);



	@Modifying
	@Query(value = "update Task t set t.taskState=:task_state, t.deleteFlg=:delete_flg where t.taskId = :task_id")
	void updateTasks(@Param("task_id") int taskId, @Param("task_state") int taskState, @Param("delete_flg") int deleteFlg);
}
