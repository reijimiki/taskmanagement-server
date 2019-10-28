package com.task.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(TaskPK.class)
@Table(name="tasks")
public class Task {
	// ユーザID
	@Id
	@Column(name="user_id")
	private int userId;
	// タスクid
	@Id
	@Column(name="task_id")
	private int taskId;
	// タスク状態
	@Column(name="task_state")
	private int taskState;
	// 削除フラグ
	@Column(name="delete_flg")
	private int deleteFlg;

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public int getTaskState() {
		return taskState;
	}
	public void setTaskState(int taskState) {
		this.taskState = taskState;
	}
	public int getDeleteFlg() {
		return deleteFlg;
	}
	public void setDeleteFlg(int deleteFlg) {
		this.deleteFlg = deleteFlg;
	}
}
