package com.upt.cti.sma_android_project;

public class Model {

    private String task, taskDescription, id, date;

    public Model(){

    }

    public Model(String taskName, String taskDescription, String id, String date) {
        this.task = taskName;
        this.taskDescription = taskDescription;
        this.id = id;
        this.date = date;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
