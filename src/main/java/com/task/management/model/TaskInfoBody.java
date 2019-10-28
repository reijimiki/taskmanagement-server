package com.task.management.model;

import java.util.Date;

public class TaskInfoBody {
	private int taskId;
	private int taskState;
	private String taskName;
	private int genre;
	private String memo;
	private int priority;
	private Date periodeDate;

	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public int getTaskState() {
		return taskState;
	}
	public void setTaskState(int taskSatate) {
		this.taskState = taskSatate;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public int getGenre() {
		return genre;
	}
	public void setGenre(int genre) {
		this.genre = genre;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public Date getPeriodeDate() {
		return periodeDate;
	}
	public void setPeriodeDate(Date periodeDate) {
		this.periodeDate = periodeDate;
	}
}
