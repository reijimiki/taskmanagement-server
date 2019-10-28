package com.task.management.model;

public class UpdateRequestBody {
	private String taskId;
	private String taskState;
	private String taskName;
	private String periodeDateYear;
	private String periodeDateMonth;
	private String periodeDateDay;
	private String genre;
	private String priority;
	private String memo;


	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getTaskState() {
		return taskState;
	}
	public void setTaskState(String taskState) {
		this.taskState = taskState;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getPeriodeDateYear() {
		return periodeDateYear;
	}
	public void setPeriodeDateYear(String periodeDateYear) {
		this.periodeDateYear = periodeDateYear;
	}
	public String getPeriodeDateMonth() {
		return periodeDateMonth;
	}
	public void setPeriodeDateMonth(String periodeDateMonth) {
		this.periodeDateMonth = periodeDateMonth;
	}
	public String getPeriodeDateDay() {
		return periodeDateDay;
	}
	public void setPeriodeDateDay(String periodeDateDay) {
		this.periodeDateDay = periodeDateDay;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
}
